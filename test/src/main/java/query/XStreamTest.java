package query;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.javabean.JavaBeanConverter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.mapper.DefaultMapper;

public class XStreamTest {
		
	@Test
	public void t(){
		XStream xstream = new XStream(new StaxDriver());
		//xstream.registerConverter(new JavaBeanConverter(new DefaultMapper(this.getClass().getClassLoader())),1000);
		xstream.autodetectAnnotations(true);
		
		Person person = new Person();
		person.setName("x123");
		
		Person person2 = new Person();
		person2.setName("second");
		
		person.setAnother(person2);
		person.setAnother2(person2);
		
		System.out.println(xstream.toXML(person));
						
		Person p = (Person)xstream.fromXML("<?xml version=\"1.0\" ?><query.Person><another><name></name></another><another2 reference=\"../another\"></another2><name></name></query.Person>");
		//assertEquals("des",p.getName());
	}
}
