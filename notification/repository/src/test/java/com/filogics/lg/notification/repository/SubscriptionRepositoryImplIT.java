package com.filogics.lg.notification.repository;

import com.filogics.lg.notification.service.AwsWebsocketSubscriber;
import com.filogics.lg.notification.service.Subscription;
import com.filogix.repository.MongoRepositoryBase;
import com.filogix.repository.MongoRepositoryFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@PowerMockIgnore({"jdk.internal.reflect.*", "javax.crypto.*"})
@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.filogix.repository.*")
public class SubscriptionRepositoryImplIT extends MongoRepositoryBase {

    private SubscriptionRepositoryImpl target = new SubscriptionRepositoryImpl();
    private String lender = "2";
    private String event = "2";
    private String connectionId;

    @Before
    public void before(){
        super.before();
        target.setMongoRepository(MongoRepositoryFactory.getMongoRepository());
        connectionId = "a";
        target.save(new AwsWebsocketSubscriber(connectionId, lender, event, LocalDateTime.now().minusHours(25)));
    }
    @Test
    public void shouldFindSubscriptions(){
        List<Subscription> subscriptions = target.subscriptions(lender, event);
        assertNotNull(subscriptions);
        assertEquals(1, subscriptions.size());
        assertNotNull(subscriptions.get(0));
        Subscription subscription = subscriptions.get(0);
        assertEquals(lender, subscription.getLender());
        assertEquals(event, subscription.getEvent());
    }

    @Test
    public void shouldRemoveOlderThan24hSubscription(){
        AwsWebsocketSubscriber subscription = new AwsWebsocketSubscriber(connectionId, "asd", "test",
                LocalDateTime.now().minusHours(21));
        target.save(subscription);
        target.remove(new AwsWebsocketSubscriber("conn", "another unexisting one", "test",
                LocalDateTime.now().minusHours(21)) );

        assertEquals(Integer.valueOf(1), (Integer)target.subscriptions(lender, event).size());
    }
}
