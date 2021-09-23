package com.filogics.lg.notification.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.filogix.lg.loan.service.dto.LoanDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.SdkHttpConfigurationOption;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.services.apigatewaymanagementapi.ApiGatewayManagementApiClient;
import software.amazon.awssdk.services.apigatewaymanagementapi.model.PostToConnectionRequest;
import software.amazon.awssdk.utils.AttributeMap;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;

@Data
@Builder
@AllArgsConstructor
public class AwsWebsocketSubscriber implements Subscription {

    private static final Logger logger = Logger.getLogger(AwsWebsocketSubscriber.class.getSimpleName());
    public static final String WEBSOCKET_URI = "WEBSOCKET_URI";

    private static ApiGatewayManagementApiClient gatewayManagementApiClient;
    private static ObjectMapper objectMapper = new ObjectMapper();
    static {
        objectMapper.registerModule(new JavaTimeModule());
    }

    private String connectionId;
    private String lender;
    private String event;
    private LocalDateTime created = LocalDateTime.now(ZoneId.of("GMT"));

    static ApiGatewayManagementApiClient getGatewayManagementApiClient() {
        if (gatewayManagementApiClient == null) {
            SdkHttpClient httpClient = UrlConnectionHttpClient
                    .builder()
                    .buildWithDefaults(AttributeMap.builder()
                            .put(SdkHttpConfigurationOption.TRUST_ALL_CERTIFICATES, Boolean.TRUE)
                            .build());
            try {
                gatewayManagementApiClient = ApiGatewayManagementApiClient.builder().httpClient(httpClient)
                        .endpointOverride(new URI(System.getenv(WEBSOCKET_URI))).build();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
        return gatewayManagementApiClient;
    }

    public void update(LoanDTO lead) {
        try {
            logger.info(String.format("Notify subscriber %s of new Lead: %s", connectionId, lead.getLoanApplicationId()));
            getGatewayManagementApiClient().postToConnection(PostToConnectionRequest.builder()
                    .connectionId(connectionId)
                    .data(SdkBytes.fromByteArray(objectMapper.writeValueAsBytes(lead)))
                    .build());
        } catch (JsonProcessingException e) {
            logger.log(Level.WARNING, "Could not notify subscriber of event.", e);
        }
    }
}
