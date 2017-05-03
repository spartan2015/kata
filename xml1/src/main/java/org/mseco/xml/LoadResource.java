package org.mseco.xml;

import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.nio.CharBuffer;


/**
 * 
 *
 */
public class LoadResource 
{
    public static void main( String[] args ) throws Exception
    {    	
    	
    	BufferedInputStream bis = (BufferedInputStream)LoadResource.class.getResourceAsStream("schema.xsd");
    	InputStreamReader reader = new InputStreamReader(bis);
    	CharBuffer cb = CharBuffer.allocate(1000);
    	reader.read(cb);
    	
    	System.out.println(new String(cb.array()));
        
    }
    
}
