package java8.modifiers.cat;

import org.junit.Test;

public class MethodLocalClassesCanAccessEffectivelyFinal {

	@Test
	public void t11(){
		
		final String configuredOkFileEnding = "OK";
        String okFileName = "CD_IUCCA.txt.OK";
        
        String configuredName = okFileName.substring(0, okFileName.lastIndexOf(configuredOkFileEnding)-1);
        
        System.out.println("/" + configuredName);
	}
	
	public void t(){
		// effectively final was introduced in java 8
		int a = 1;
		
		class A{
			void t(){
				int b = a;
			}
		}
		
	}
}
