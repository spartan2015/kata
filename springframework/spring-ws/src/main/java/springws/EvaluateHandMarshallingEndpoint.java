package springws;

import org.springframework.ws.server.endpoint.AbstractMarshallingPayloadEndpoint;

public class EvaluateHandMarshallingEndpoint extends
		AbstractMarshallingPayloadEndpoint {

	@Override
	protected Object invokeInternal(Object object) throws Exception {
		EvaluateHandRequest request = (EvaluateHandRequest) object;
		PokerHand pokerHand = new PokerHand();
		pokerHand.setCards(request.getHand());

		PokerHandType pokerHandType =

		pokerHandEvaluator.evaluateHand(pokerHand);
		return new EvaluateHandResponse(pokerHandType);

	}
	
	
	private PokerHandEvaluator pokerHandEvaluator;
	public void setPokerHandEvaluator(
	    PokerHandEvaluator pokerHandEvaluator) {
	  this.pokerHandEvaluator = pokerHandEvaluator;
	}

}
