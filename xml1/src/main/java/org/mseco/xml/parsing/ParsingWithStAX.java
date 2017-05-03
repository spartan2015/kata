package org.mseco.xml.parsing;

import java.io.InputStream;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

public class ParsingWithStAX {

	
	public static void main(String[] args) {
		// StAX Stream API for XML - the most efficient method of dealing with XML
		/**
		 DOM offers an easy-to-use API, and has an advantage over SAX and StAX in that it is
XPath-capable But it also forces you to read the entire document into memory

SAX, on the other hand, handles this problem by working as a “push” parser; that is,
events are generated for each structure the parser encounters within the document, and
the programmer can choose to deal with those he’s interested in. The disadvantage here
is that SAX will typically generate a lot of events that the programmer doesn’t care
about.

The StAX API gives you control akin to the Java I/O RandomAccessFile—you can skip
sections of the document, work with a subsection of the document, pause and resum
processing, or stop processing at any time. 

		 */
		cursorMethod();
		iteratorModel();
	}
	
	static void cursorMethod(){
		XMLInputFactory xif = XMLInputFactory.newInstance();
		// forward-only - most efficient way to read
		XMLStreamReader reader = null;
		final InputStream is = ParsingWithStAX.class.getResourceAsStream("/org/mseco/xml/parsing/catalog.xml");
		
		int eventType;
		String current = "";
		
		try{
			
			reader = xif.createXMLStreamReader(is);
			
			while(reader.hasNext()){
				//because this is Cursor, we get an integer token to next event
				eventType = reader.next();
				
				
				switch(eventType){
				case XMLEvent.START_ELEMENT:
					current = reader.getName().toString(); // name only on element
					printSkus(current,reader);
					break;
				case XMLEvent.CHARACTERS:
					findAuthors(current, reader);
					break;
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	static void printSkus(String current, XMLStreamReader reader){
		if (current.equals("book")){
			String k = reader.getAttributeName(0).toString();
			String v = reader.getAttributeValue(0).toString();
			System.out.println(k + " = " + v);
		}		
	}
	
	static void findAuthors(String current, XMLStreamReader reader){
		if (current.equals("author")){
			String v = reader.getText().trim();
			System.out.println("author: " + v);
		}
	}
	
	
	
	static void iteratorModel(){
		System.out.println("iteratorModel");
		XMLInputFactory xif = XMLInputFactory.newInstance();
		//forward-only - most efficient way of reading
		XMLEventReader reader = null;
		final InputStream is = ParsingWithStAX.class.getResourceAsStream("/org/mseco/xml/parsing/catalog.xml");
		
		try{
			
			reader = xif.createXMLEventReader(is);
			
			while(reader.hasNext()){
				XMLEvent e = reader.nextEvent();
				
				if (e.isStartElement()){
					e = e.asStartElement().getAttributeByName(new QName("sku"));
					
					if (e != null){
						System.out.println("sku: " + e);
					}
				}
			}
			
		}catch(XMLStreamException e){
			e.printStackTrace();
		}
	}
}
	