package mastering.localization;

import static org.junit.Assert.assertEquals;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import org.junit.Test;

public class ResourceBundleExample {
	@Test
	public void test() {

		ResourceBundle rbUS = ResourceBundle.getBundle("Zoo", Locale.US);
		assertEquals("Good Day !", rbUS.getString("greeting"));
		ResourceBundle rbDe = ResourceBundle.getBundle("Zoo", Locale.GERMANY);
		assertEquals("Guten Tag !", rbDe.getString("greeting"));

		// searching the hierarchy
		assertEquals("Hello, {0}", rbDe.getString("helloByName")); // value is not in Zoo_en.properties but in Zoo.properties
		
		// see all key,value pairs in ResourceBundle
		Set<String> keys = rbUS.keySet();
		keys.stream().map(k -> k + " " + rbUS.getString(k)).forEach(System.out::println);

		Properties props = new Properties();
		rbUS.keySet().stream().forEach(k -> props.put(k, rbUS.getString(k)));
		props.getProperty("does not exist", "defaultValue");
		
		// handling message parameters
		String format = rbUS.getString("helloByName");
		String formatted = MessageFormat.format(format,"Tammy");
		System.out.println(formatted) ;

	}
}
