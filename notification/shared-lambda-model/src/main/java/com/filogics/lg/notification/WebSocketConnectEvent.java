package com.filogics.lg.notification;

import lombok.Data;

@Data
public class WebSocketConnectEvent {
    private QueryStringParameters queryStringParameters;
    private RequestContext requestContext;
}

@Data
class RequestContext{
    private String connectionId;
}

@Data
class QueryStringParameters {
    private String lender;
    private String event;
}
