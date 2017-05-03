package org.mseco.xml.jaxbannotations;

public class GenerateSchemaFromJava {
	public static void main(String... args) throws Exception{
		
		
		Runtime.getRuntime().exec("schemagen -d /home/mseco/eclipse_workspace/xml/src/main/java/org/mseco/xml/jaxbannotations Book.java");
		
	}
}
