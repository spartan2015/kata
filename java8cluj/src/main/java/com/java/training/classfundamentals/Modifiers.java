package com.java.training.classfundamentals;

public class Modifiers {

	String value;
	public String publicValue;
	protected String protectedValue;
	private String privateValue;
	
	enum Default{}
	public enum Public{};
	protected enum Protected{Y,Z};
	private enum Private{ B,C};
	
	class DefaulClass{}
	public class PublicClass{}
	protected class ProtectedClass{}
	private class PrivateClass{}
	
	Modifiers(){
		//default access constructor
	}
	
	public Modifiers(String public1){
		//public access constructor
	}
	
	protected Modifiers(String s1, String s2){
		//protected access constructor
	}
	
	private Modifiers(String s1, int i1){
		//protected access constructor
	}
	
	static void defaultMethod(){}
	public static void publicMethod(){}
	protected static void protectedMethod(){}
	private static void privateMethod(){}
	
}
