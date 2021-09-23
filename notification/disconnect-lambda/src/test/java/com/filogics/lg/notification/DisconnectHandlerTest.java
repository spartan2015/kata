package com.filogics.lg.notification;

import com.filogics.lg.notification.service.NotificationService;
import com.filogics.lg.notification.service.NotificationServiceFactory;
import com.filogics.lg.notification.service.Subscription;
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
@PowerMockIgnore("jdk.internal.reflect.*")
@PrepareForTest(fullyQualifiedNames = "com.filogics.lg.notification.*")
public class DisconnectHandlerTest {

    private final DisconnectHandler target = new DisconnectHandler();
    @Mock
    private WebSocketConnectEvent event;
    @Mock
    private RequestContext context;
    @Mock
    private NotificationService notificationService;

    @Test
    public void shouldDisconnect() {
        when(event.getRequestContext()).thenReturn(context);
        String connectionId = "connectionId";
        when(context.getConnectionId()).thenReturn(connectionId);
        mockStatic(NotificationServiceFactory.class);
        when(NotificationServiceFactory.getNotificationService()).thenReturn(notificationService);

        target.handleRequest(event, null);

        ArgumentCaptor<Subscription> captor = ArgumentCaptor.forClass(Subscription.class);
        verify(notificationService).unsubscribe(captor.capture());
        assertEquals(connectionId, captor.getValue().getConnectionId());
    }
}
