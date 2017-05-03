package query;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.javabean.JavaBeanConverter;

@XStreamConverter(value=JavaBeanConverter.class)
public class Person {

	private String name11;
	private Person another;
	
	private Person another2;

	public Person getAnother() {
		return another;
	}

	public void setAnother(Person another) {
		this.another = another;
	}

	public String getName() {
		return name11;
	}

	public void setName(String name) {
		this.name11 = name;
	}

	public Person getAnother2() {
		return another2;
	}

	public void setAnother2(Person another2) {
		this.another2 = another2;
	}
	
	

}