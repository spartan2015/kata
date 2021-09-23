package com.filogics.lg.notification;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.filogics.lg.notification.service.NotificationServiceFactory;
import com.filogics.lg.notification.service.SubscriptionEvent;
import com.filogix.lg.trustore.S3TruststoreProvider;

public class SendNotificationHandler implements RequestHandler<SNSEvent, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();
    {
        S3TruststoreProvider.setDefaultTrustStore();
    }
    @Override
    public String handleRequest(SNSEvent snsEvent, Context context) {
        snsEvent.getRecords().stream().forEach(record -> {
            try {
                NotificationServiceFactory.getNotificationService().notify(
                        objectMapper.readValue(record.getSNS().getMessage(), SubscriptionEvent.class));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
        return null;
    }
}
