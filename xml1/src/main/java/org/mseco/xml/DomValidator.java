package org.mseco.xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import static java.lang.System.*;

public class DomValidator {
	
	// run the example
	public static void main(String[] args) {
		String schema = "/home/mseco/eclipse_workspace/xml/src/main/java/org/mseco/xml/gardenofeden.xsd";
		String xmlDoc = "/home/mseco/eclipse_workspace/xml/src/main/java/org/mseco/xml/gardenofeden.xml";
		
		String[] schemas = { schema };
		
		boolean valid = validate(xmlDoc, schemas);
		out.print("Valid? " + valid);
	}

	// do the work
	private static boolean validate( String xmlDoc, String... schemas) {	
				
		DocumentBuilder builder = createDocumentBuilder(schemas);
		ValidationHandler handler = new ValidationHandler();
		builder.setErrorHandler(handler);
		try {
			builder.parse(xmlDoc);
		} catch (SAXException se) {
			out.println("Validation Error: " + se.getMessage());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return handler.isValid();
	}


	private static final String SCHEMA_LANG_PROP = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	private static final String XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
	private static final String SCHEMA_SOURCE_PROP = "http://java.sun.com/xml/jaxp/properties/schemaSource";
	
	/**
	 * Convenience method sets up the validating factory and creates the
	 * builder.
	 */	
	
	private static DocumentBuilder createDocumentBuilder(
	            String...schemas) {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		factory.setValidating(true);
		factory.setAttribute(SCHEMA_LANG_PROP, XML_SCHEMA);
		/*
		 * The DOM parser built-in to Java SE 6 is not namespace-aware by default, so you must
set that property on the DocumentBuilderFactory. If you forget to set that, there’s no
show; any errors in validation will be blissfully overlooked, even if the handler is set.
For documents to be validated correctly, the schema for elements in the default name-
space must be declared.

		 * */
		factory.setAttribute(SCHEMA_SOURCE_PROP, schemas);
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}
		return builder;
	}
}

/**
 * This class gets notified by the parser in the event of a problem.
 */
class ValidationHandler extends DefaultHandler {
	private boolean valid = true;
	private SAXException se;

	/**
	 * The default implementation does nothing.
	 */
	@Override
	public void error(SAXParseException se) throws SAXException {
		this.se = se;
		valid = false;
		throw se;
	}

	/**
	 * The default implementation does nothing.
	 */
	@Override
	public void fatalError(SAXParseException se) throws SAXException {
		this.se = se;
		valid = false;
		throw se;
	}

	public boolean isValid() {
		return valid;
	}
}
