package com.filogics.lg.notification.repository;

import com.filogics.lg.notification.service.AwsWebsocketSubscriber;
import com.filogix.repository.MongoRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;

import static com.filogics.lg.notification.repository.SubscriptionRepositoryImpl.NOTIFICATION_COLLECTION;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SubscriptionRepositoryImplTest {

    @Mock
    private MongoRepository mongoRepository;
    @Mock
    private MongoDatabase mongoDatabase;
    @Mock
    private MongoCollection mongoCollection;
    @InjectMocks
    private final SubscriptionRepositoryImpl target = new SubscriptionRepositoryImpl();

    @Before
    public void before() {
        when(mongoRepository.getDatabase()).thenReturn(mongoDatabase);
        when(mongoDatabase.getCollection(NOTIFICATION_COLLECTION)).thenReturn(mongoCollection);
    }

    @Test
    public void shouldSaveSubscription() {
        String connectionId = "connect";
        String lender = "lender";
        String event = "event";

        target.save(new AwsWebsocketSubscriber(connectionId, lender, event, LocalDateTime.now()));

        verify(mongoDatabase).getCollection(NOTIFICATION_COLLECTION);
        ArgumentCaptor<Document> argument = ArgumentCaptor.forClass(Document.class);
        verify(mongoCollection).insertOne(argument.capture());
        assertEquals(connectionId, argument.getValue().get("connectionId"));
    }

    @Test
    public void shouldRemoveSubscription() {
        String connectionId = "connect";
        String lender = "lender";
        String event = "event";

        target.remove(new AwsWebsocketSubscriber(connectionId, lender, event, LocalDateTime.now()));

        Document document = new Document();
        document.put("connectionId", connectionId);

        verify(mongoDatabase,times(2)).getCollection(NOTIFICATION_COLLECTION);
        verify(mongoCollection).deleteOne(eq(document));
        verify(mongoCollection).deleteMany(any());
    }

}
