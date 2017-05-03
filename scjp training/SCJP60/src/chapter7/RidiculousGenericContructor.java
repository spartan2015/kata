package chapter7;

public class RidiculousGenericContructor {

	<RidiculousGenericContructor> RidiculousGenericContructor(RidiculousGenericContructor arg){
		// guess what: the name of the contructor and it's parameters have nothing to do with the 
		// generic type since generic types are parsed as a last resort.
	}
	
}
