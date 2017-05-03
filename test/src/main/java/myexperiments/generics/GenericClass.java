package myexperiments.generics;

public class GenericClass<T>{

	T ref;
	
	void setRef(T ref){
		this.ref = ref;
	}
	
	T getRef(){
		return ref;
	}
	
	public static void main(String[] args){
		GenericClass<Integer> integerHolder = new GenericClass<>();
		
		integerHolder.setRef(Integer.valueOf(1));
		Integer i = integerHolder.getRef();
	}
}
