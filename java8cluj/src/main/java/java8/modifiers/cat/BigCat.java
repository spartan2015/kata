package java8.modifiers.cat;

public class BigCat {

		
	public String name="BigCat";
	protected boolean hasFur = true;
	boolean hasPaws = true;
	private int id;
	
	static void ma(){
		BigCat bigCat = new BigCat();
		
		System.out.println(bigCat.id);
		System.out.println(bigCat.hasFur);
		System.out.println(bigCat.hasPaws);
		System.out.println(bigCat.name);
		
	}
	
}
