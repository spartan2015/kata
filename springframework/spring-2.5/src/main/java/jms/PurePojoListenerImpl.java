package jms;

public class PurePojoListenerImpl implements PurePojoListener{
	public void process(String s){
		System.out.println(s);
	}
}
