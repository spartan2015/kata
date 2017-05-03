package org.mseco.xml;

import java.io.IOException;

public class SchemaToXML {
	public static void main(String[] args) throws IOException{
		/**
		 * download xig tool from http://xml-xig.sourceforge.net
		 * 
		 * sau in eclipse click dreapta pe xsd si alege generate -> xml
		 */
		Runtime.getRuntime().exec("java -jar xml-xig-0.1.1.jar MyBook.xsd Book Book.xig");
	}
}
