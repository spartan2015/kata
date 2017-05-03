package client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import springws.Card;
import springws.Face;
import springws.Suit;

public class Exec {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext("webservice-client.xml");
		PokerClient type1 = (PokerClient)c.getBean("templateBasedClient");
		PokerClient type2 = (PokerClient)c.getBean("marshallingTemplateBasedClient");
		PokerClient type3 = (PokerClient)c.getBean("pokerClientGateway");
		
		Card[] cards = new Card[1];
		cards[0] = new Card();
		cards[0].setFace(Face.ACE);
		cards[0].setSuit(Suit.CLUBS);
		
		//System.out.println(type1.evaluateHand(cards));
		System.out.println(type2.evaluateHand(cards));
		//System.out.println(type3.evaluateHand(cards));

	}

}
