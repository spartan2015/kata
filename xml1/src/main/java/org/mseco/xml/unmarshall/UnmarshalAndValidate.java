package org.mseco.xml.unmarshall;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import com.soacookbook.ns.russiandoll.Book;

public class UnmarshalAndValidate {

	private static final String SCHEMA = "/home/mseco/eclipse_workspace/xml/src/main/java/org/mseco/xml/russiandoll.xsd";
	
	public static void main(String[] args) throws Exception {
		JAXBContext ctx = JAXBContext.newInstance(Book.class);		
		
		Marshaller m = ctx.createMarshaller();
		Unmarshaller um = ctx.createUnmarshaller();
		
		// create instance of schema
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		
		Schema schema = factory.newSchema(new StreamSource(new File(SCHEMA)));
		
		// set schema for validation
		um.setSchema(schema);
		
		// unmarshall
		JAXBElement<Book> b = um.unmarshal(new StreamSource(new StringReader(getBookXml())),Book.class);
		
		Book book = b.getValue();
		
		System.out.println(book.getTitle());
		
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		m.marshal(book, bos);
		System.out.println(bos.toString());
		
	}

	
	private static String getBookXml(){
		return "<b:book xmlns:b=\"http://ns.soacookbook.com/russiandoll\">" +
				"<title>My Book</title>" +
				"<author>Vasile Irimia</author>" +
				"<category>IT SOA</category>" +
				"<price>10.20</price>" +
				"</b:book>";
	}
}
