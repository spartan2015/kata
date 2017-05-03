package org.mseco.xml.parsing;

import java.io.FileOutputStream;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

public class WriteXmlWithStAX {

	private static final String REPAIR_NS = "javax.xml.stream.isRepairingNamespaces";
	private static final String NS = "http://ns.example.com/books";

	
	public static void main(String[] args) throws Exception{
		XMLOutputFactory factory = XMLOutputFactory.newInstance();
		factory.setProperty(REPAIR_NS, true);
		
		FileOutputStream fos = new FileOutputStream("result.xml");
		
		final XMLStreamWriter xsw = factory.createXMLStreamWriter(fos);
		xsw.setDefaultNamespace(NS);
		
		xsw.writeStartDocument("1.0");
		xsw.writeEndDocument();
		
		xsw.writeComment("Powered by StAX");
		
		xsw.writeStartElement("book");
		xsw.writeNamespace("b", NS);
		xsw.writeAttribute("sku", "111");
		
		xsw.writeStartElement(NS,"title");
		xsw.writeCharacters("Java SOA");
		xsw.writeEndElement();
		
		xsw.writeEndElement();

		xsw.flush();
		xsw.close();
		fos.close();
		
	}

}
