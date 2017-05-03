package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class TestBean {

	public TestBean() {
		System.out.println("TestBean contructor" + getTest44());
	}

	private String str = "Hello !";

	private String test = "dyn-code";
	
	private String test2 = "ddd";
	
	private String test3 = "xxx";
	
	private String test4 = "nnnnn";
	
	private String test44 = "xsdsdasdasdadsdasda";
	
	private String theTrueTestIsHere = "The true test is here";
	
	private String lalaland ="lalaland";
	
	

	public String getLalaland() {
		return lalaland;
	}

	public void setLalaland(String lalaland) {
		this.lalaland = lalaland;
	}

	public String getTheTrueTestIsHere() {
		return theTrueTestIsHere;
	}

	public void setTheTrueTestIsHere(String theTrueTestIsHere) {
		this.theTrueTestIsHere = theTrueTestIsHere;
	}

	public String getTest44() {
		return test44;
	}

	public void setTest44(String test44) {
		this.test44 = test44;
	}

	public String getTest4() {
		return test4;
	}

	public void setTest4(String test4) {
		this.test4 = test4;
	}

	public String getTest3() {
		return test3;
	}

	public void setTest3(String test3) {
		this.test3 = test3;
	}

	public String getTest2() {
		return test2;
	}

	public void setTest2(String test2) {
		this.test2 = test2;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

}
