package client;

import java.io.IOException;

import org.springframework.ws.client.core.WebServiceTemplate;

import springws.Card;
import springws.EvaluateHandRequest;
import springws.EvaluateHandResponse;
import springws.PokerHandType;

public class MarshallingPokerClient implements PokerClient {

	@Override
	public PokerHandType evaluateHand(Card[] cards) throws IOException {
		EvaluateHandRequest request = new EvaluateHandRequest();
		request.setHand(cards);

		EvaluateHandResponse response = (EvaluateHandResponse)

		webServiceTemplate.marshalSendAndReceive(request);

		return response.getPokerHand();
	}

	private WebServiceTemplate webServiceTemplate;

	public void setWebServiceTemplate(WebServiceTemplate webServiceTemplate) {
		this.webServiceTemplate = webServiceTemplate;
	}

}
