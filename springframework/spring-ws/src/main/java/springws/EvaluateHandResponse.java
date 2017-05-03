package springws;

public class EvaluateHandResponse {
	PokerHandType pokerHand;
	public EvaluateHandResponse(){}
	EvaluateHandResponse(PokerHandType pht){
		this.pokerHand = pht;
	}
	public PokerHandType getPokerHand() {
		return pokerHand;
	}
	public void setPokerHand(PokerHandType pokerHand) {
		this.pokerHand = pokerHand;
	}
}
