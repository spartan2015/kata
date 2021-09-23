package com.filogics.lg.notification;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.filogics.lg.notification.service.AwsWebsocketSubscriber;
import com.filogics.lg.notification.service.NotificationServiceFactory;
import com.filogics.lg.notification.service.Subscription;
import com.filogix.lg.trustore.S3TruststoreProvider;

import java.util.Objects;

public class DisconnectHandler implements RequestHandler<WebSocketConnectEvent, APIGatewayProxyResponseEvent> {

    {
        S3TruststoreProvider.setDefaultTrustStore();
    }

    @Override
    public APIGatewayProxyResponseEvent handleRequest(WebSocketConnectEvent event, Context context) {
        NotificationServiceFactory.getNotificationService().unsubscribe(
                getSubscription(event));
        return new APIGatewayProxyResponseEvent().withStatusCode(200).withBody("OK");
    }

    private Subscription getSubscription(WebSocketConnectEvent event) {
        Objects.requireNonNull(event);
        Objects.requireNonNull(event.getRequestContext().getConnectionId());
        return AwsWebsocketSubscriber.builder().connectionId(event.getRequestContext().getConnectionId()).build();
    }
}
