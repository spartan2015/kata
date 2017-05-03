class Coconut implements beans.advanced.scripting.beans.ICoconut{
	beans.advanced.scripting.beans.JavaLime lime;
	
	public void drinkThem(){
		println "groovy coconut trying to see if lime is injected:";
		println lime.getDescription();
	}
	
}