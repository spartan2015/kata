package client;

import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.transform.JDOMResult;
import org.jdom.transform.JDOMSource;
import org.springframework.ws.client.core.WebServiceTemplate;

import springws.Card;
import springws.PokerHandType;

public class TemplateBasedPokerClient implements PokerClient{

	@Override
	public PokerHandType evaluateHand(Card[] cards) throws IOException {
			
		
		Element requestElement =  new Element("EvaluateHandRequest");
		Namespace ns = Namespace.getNamespace("http://mseco/poker");		                                                 
		requestElement.setNamespace(ns);
		
		Document doc = new Document(requestElement);
		for(int i=0; i<cards.length; i++) {
		  Element cardElement = new Element("card");
		  Element suitElement = new Element("suit");
		  
		  suitElement.setText(cards[i].getSuit().toString());
		  Element faceElement = new Element("face");
		  faceElement.setText(cards[i].getFace().toString());
		  cardElement.addContent(suitElement);               
		  cardElement.addContent(faceElement);
		  doc.getRootElement().addContent(cardElement);
		}
		                                                  
		JDOMSource requestSource = new JDOMSource(doc);
		                                                  
		JDOMResult result = new JDOMResult();
		
		webServiceTemplate.sendSourceAndReceiveToResult(requestSource, result);
		
		Document resultDocument = result.getDocument();
		Element responseElement = resultDocument.getRootElement();
		 
		Element handNameElement = responseElement.getChild("handName", ns);
		
		return PokerHandType.valueOf(handNameElement.getText());

	}

	private WebServiceTemplate webServiceTemplate;
	public void setWebServiceTemplate(
	    WebServiceTemplate webServiceTemplate) {
	  this.webServiceTemplate = webServiceTemplate;
	}

}
