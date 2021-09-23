package com.filogics.lg.notification.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.filogix.lg.loan.service.dto.LoanDTO;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import software.amazon.awssdk.core.SdkBytes;
import software.amazon.awssdk.services.apigatewaymanagementapi.ApiGatewayManagementApiClient;
import software.amazon.awssdk.services.apigatewaymanagementapi.model.PostToConnectionRequest;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

@PowerMockIgnore({"jdk.internal.reflect.*", "javax.crypto.*"})
@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.filogics.lg.notification.service.*")
public class AwsWebsocketSubscriberTest {
    public static final String CONNECTION_ID = "connectionId";
    private AwsWebsocketSubscriber target = new AwsWebsocketSubscriber(CONNECTION_ID,"lender","event",
            LocalDateTime.now());

    @Mock
    private ApiGatewayManagementApiClient gatewayManagementApiClient;

    @Test
    @SneakyThrows
    public void shouldNotify(){
        mockStatic(AwsWebsocketSubscriber.class);
        when(AwsWebsocketSubscriber.getGatewayManagementApiClient()).thenReturn(gatewayManagementApiClient);

        LoanDTO dto = new LoanDTO();
        dto.setId("id");
        target.update(dto);

        ArgumentCaptor<PostToConnectionRequest> captor = ArgumentCaptor.forClass(PostToConnectionRequest.class);
        verify(gatewayManagementApiClient).postToConnection(captor.capture());
        assertEquals(CONNECTION_ID, captor.getValue().connectionId());
        assertEquals(SdkBytes.fromByteArray(new ObjectMapper().writeValueAsBytes(dto)), captor.getValue().data());

    }
}
