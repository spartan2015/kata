package client;

import java.io.IOException;

import springws.Card;
import springws.PokerHandType;

public interface PokerClient {
	  PokerHandType evaluateHand(Card[] cards)
	      throws IOException;
	}
