package xml;

import java.io.StringReader;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.junit.Test;
import org.xml.sax.InputSource;

public class StringXml {

	@Test
	public void t() throws Exception {

		String xpath = "//version";
		String xmlString = "<version>1.0</version>";
		XPath xPath = XPathFactory.newInstance().newXPath();
		System.out.println(xPath.evaluate(xpath, new InputSource(new StringReader(xmlString))));

	}

}
