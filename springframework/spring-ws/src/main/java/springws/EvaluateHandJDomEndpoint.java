package springws;

import java.util.List;

import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.xpath.XPath;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.ws.server.endpoint.AbstractJDomPayloadEndpoint;

public class EvaluateHandJDomEndpoint extends AbstractJDomPayloadEndpoint
		implements InitializingBean {

	private Namespace namespace;
	private XPath cardsXPath;
	private XPath suitXPath;
	private XPath faceXPath;

	protected Element invokeInternal(Element element) throws Exception {

		Card cards[] = extractCardsFromRequest(element);

		PokerHand pokerHand = new PokerHand();

		pokerHand.setCards(cards);

		PokerHandType handType = pokerHandEvaluator.evaluateHand(pokerHand);

		return createResponse(handType);

	}

	private Element createResponse(PokerHandType handType) {
		Element responseElement = new Element("EvaluateHandResponse", namespace);

		responseElement.addContent(new Element("handName", namespace)
				.setText(handType.toString()));
		return responseElement;
	}

	private Card[] extractCardsFromRequest(Element element)
			throws JDOMException {
		Card[] cards = new Card[5];
		List cardElements = cardsXPath.selectNodes(element);
		for (int i = 0; i < cardElements.size(); i++) {
			Element cardElement = (Element) cardElements.get(i);
			Suit suit = Suit.valueOf(suitXPath.valueOf(cardElement));
			Face face = Face.valueOf(faceXPath.valueOf(cardElement));
			cards[i] = new Card();
			cards[i].setFace(face);
			cards[i].setSuit(suit);
		}
		return cards;
	}

	public void afterPropertiesSet() throws Exception {
		namespace = Namespace.getNamespace("poker",
				"http://www.springinaction.com/poker/schemas");
		cardsXPath = XPath.newInstance("/poker:EvaluateHandRequest/poker.card");
		cardsXPath.addNamespace(namespace);
		faceXPath = XPath.newInstance("poker:face");

		faceXPath.addNamespace(namespace);
		suitXPath = XPath.newInstance("poker:suit");
		suitXPath.addNamespace(namespace);

	}

	private PokerHandEvaluator pokerHandEvaluator;

	public void setPokerHandEvaluator(PokerHandEvaluator pokerHandEvaluator) {
		this.pokerHandEvaluator = pokerHandEvaluator;
	}

}
