package com.filogics.lg.notification;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.filogics.lg.notification.service.AwsWebsocketSubscriber;
import com.filogics.lg.notification.service.NotificationServiceFactory;
import com.filogics.lg.notification.service.Subscription;
import com.filogix.lg.trustore.S3TruststoreProvider;
import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Objects;

public class ConnectHandler implements RequestHandler<WebSocketConnectEvent, APIGatewayProxyResponseEvent> {

    {
        S3TruststoreProvider.setDefaultTrustStore();
    }
    @SneakyThrows
    @Override
    public APIGatewayProxyResponseEvent handleRequest(WebSocketConnectEvent event, Context context) {
        NotificationServiceFactory.getNotificationService().subscribe(
                getSubscription(event));
        return new APIGatewayProxyResponseEvent().withStatusCode(200).withBody("OK");
    }

    private Subscription getSubscription(WebSocketConnectEvent event) {
        Objects.requireNonNull(event);
        Objects.requireNonNull(event.getRequestContext().getConnectionId());
        Objects.requireNonNull(event.getQueryStringParameters());
        Objects.requireNonNull(event.getQueryStringParameters().getLender());
        Objects.requireNonNull(event.getQueryStringParameters().getEvent());
        return AwsWebsocketSubscriber.builder()
                .connectionId(event.getRequestContext().getConnectionId())
                .lender(event.getQueryStringParameters().getLender())
                .event(event.getQueryStringParameters().getEvent())
                .created(LocalDateTime.now(ZoneId.of("UTC")))
                .build();
    }
}
