package org.mseco.xml.enumeration;

public class CreateJavaSourceFromSchema {
	public static void main(String[] args) throws Exception {
		// use the xjc tool from jdk
		Runtime.getRuntime().exec("xjc -verbose -d /home/mseco/eclipse_workspace/xml/src/main/java  /home/mseco/eclipse_workspace/xml/src/main/java/org/mseco/xml/enumeration/Suite.xsd");

	}
}
