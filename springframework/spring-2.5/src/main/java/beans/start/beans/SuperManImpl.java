package beans.start.beans;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SuperManImpl implements SuperMan {

	private SuperPower superPower;
	
	public SuperManImpl(){}
	
	public SuperManImpl(SuperPower sp){
		superPower = sp;
	}
	
	public void doSuperThing() {
		superPower.doSuperThing();	
		System.out.println(list);
		System.out.println(set);
		System.out.println(map);
	}

	public void setSuperPower(SuperPower sp) {
		superPower = sp;		
	}
	
	private List<String> list;
	private Set<String> set;
	private Map<String,String> map;
	private Properties props;
	
	public void setList(List<String> list) {
		this.list = list;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}	
	
	public void setProps(Properties props){
		this.props = props;
	}
}
