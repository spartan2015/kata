package beans.advanced.beans;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable("springBeanId")
public class ConfigurableClass {
	private String str;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
}
