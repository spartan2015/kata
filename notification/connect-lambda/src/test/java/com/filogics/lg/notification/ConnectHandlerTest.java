package com.filogics.lg.notification;

import com.filogics.lg.notification.service.NotificationService;
import com.filogics.lg.notification.service.NotificationServiceFactory;
import com.filogics.lg.notification.service.Subscription;
import com.filogix.repository.MongoRepositoryFactory;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"jdk.internal.reflect.*","javax.crypto.*"})
@PrepareForTest(fullyQualifiedNames = "com.filogics.lg.notification.*")
public class ConnectHandlerTest {

    private ConnectHandler target = new ConnectHandler();
    @Mock
    private WebSocketConnectEvent event;
    @Mock
    private RequestContext context;
    @Mock
    private QueryStringParameters queryStringParameters;
    @Mock
    private NotificationService notificationService;

    @Test
    public void shouldConnect() {
        when(event.getRequestContext()).thenReturn(context);
        String connectionId = "connectionId";
        when(context.getConnectionId()).thenReturn(connectionId);
        when(event.getQueryStringParameters()).thenReturn(queryStringParameters);
        String lender = "lender";
        when(queryStringParameters.getLender()).thenReturn(lender);
        String eventString = "event";
        when(queryStringParameters.getEvent()).thenReturn(eventString);
        mockStatic(NotificationServiceFactory.class);
        when(NotificationServiceFactory.getNotificationService()).thenReturn(notificationService);

        target.handleRequest(event, null);

        ArgumentCaptor<Subscription> captor = ArgumentCaptor.forClass(Subscription.class);
        verify(notificationService).subscribe(captor.capture());
        assertEquals(connectionId, captor.getValue().getConnectionId());
        assertEquals(lender, captor.getValue().getLender());
        assertEquals(eventString, captor.getValue().getEvent());
    }

    @Test(expected = NullPointerException.class)
    public void shouldFailOnMissingLender() {
        when(event.getRequestContext()).thenReturn(context);
        String connectionId = "connectionId";
        when(context.getConnectionId()).thenReturn(connectionId);
        when(event.getQueryStringParameters()).thenReturn(queryStringParameters);
        when(queryStringParameters.getLender()).thenReturn(null);
        String eventString = "event";
        when(queryStringParameters.getEvent()).thenReturn(eventString);
        mockStatic(NotificationServiceFactory.class);
        when(NotificationServiceFactory.getNotificationService()).thenReturn(notificationService);

        target.handleRequest(event, null);
    }

    @Test(expected = NullPointerException.class)
    public void shouldFailOnMissingEvent() {
        when(event.getRequestContext()).thenReturn(context);
        String connectionId = "connectionId";
        when(context.getConnectionId()).thenReturn(connectionId);
        when(event.getQueryStringParameters()).thenReturn(queryStringParameters);
        String lender = "lender";
        when(queryStringParameters.getLender()).thenReturn(lender);
        when(queryStringParameters.getEvent()).thenReturn(null);
        mockStatic(NotificationServiceFactory.class);
        when(NotificationServiceFactory.getNotificationService()).thenReturn(notificationService);

        target.handleRequest(event, null);
    }
}
