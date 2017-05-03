package client;

import java.io.IOException;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import springws.Card;
import springws.EvaluateHandRequest;
import springws.EvaluateHandResponse;
import springws.PokerHandType;

public class PokerServiceGateway extends WebServiceGatewaySupport implements
		PokerClient {

	@Override
	public PokerHandType evaluateHand(Card[] cards) throws IOException {
		EvaluateHandRequest request = new EvaluateHandRequest();
		request.setHand(cards);
		EvaluateHandResponse response = (EvaluateHandResponse) getWebServiceTemplate()
				.marshalSendAndReceive(request);
		return response.getPokerHand();

	}

}
