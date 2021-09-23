package com.filogics.lg.notification.repository;

import com.filogics.lg.notification.service.AwsWebsocketSubscriber;
import com.filogics.lg.notification.service.Subscription;
import com.filogics.lg.notification.service.SubscriptionRepository;
import com.filogix.lg.util.TimerUtil;
import com.filogix.repository.MongoRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import lombok.Setter;
import org.bson.Document;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Logger;

import static com.mongodb.client.model.Filters.*;

class SubscriptionRepositoryImpl implements SubscriptionRepository {

    public static final String NOTIFICATION_COLLECTION = "PushNotificationSubscriptions";
    public static final String EVENT = "event";
    public static final String CONNECTION_ID = "connectionId";
    public static final String LENDER = "lender";
    public static final String CREATED = "created";
    private static final Logger logger = Logger.getLogger(SubscriptionRepositoryImpl.class.getSimpleName());
    @Setter
    private MongoRepository mongoRepository;

    @Override
    public void save(Subscription subscription) {
        Document registration = new Document("connectionId", subscription.getConnectionId());
        registration.put(LENDER, subscription.getLender());
        registration.put(EVENT, subscription.getEvent());
        registration.put(CREATED, subscription.getCreated());
        getCollection()
                .insertOne(registration);
    }

    @Override
    public void remove(Subscription subscription) {
        getCollection()
                .deleteOne(new Document(CONNECTION_ID, subscription.getConnectionId()));
        getCollection().deleteMany(lt(CREATED, LocalDateTime.now().minusHours(24)));
    }

    private MongoCollection<Document> getCollection() {
        return mongoRepository.getDatabase().getCollection(NOTIFICATION_COLLECTION);
    }

    @Override
    public List<Subscription> subscriptions(String lender, String event) {
        return TimerUtil.timed("SubscriptionRepositoryImpl.subscriptions", () -> {
            List<Subscription> result = new LinkedList<>();
            getCollection()
                    .find(and(new BasicDBObject(LENDER, lender), new BasicDBObject(EVENT, event)))
                    .forEach((Consumer<Document>) document ->
                            result.add(
                                    new AwsWebsocketSubscriber(
                                            document.getString(CONNECTION_ID),
                                            document.getString(LENDER),
                                            document.getString(EVENT),
                                            LocalDateTime.ofInstant(
                                                    document.getDate("created").toInstant(), ZoneId.of("GMT")))));
            logger.info(String.format("Found: %d subscriptions for lender: %s and event: %s ", result.size(), lender, event));
            return result;
        });
    }
}
