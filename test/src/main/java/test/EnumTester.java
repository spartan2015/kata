package test;

public class EnumTester {
	
	public static void main(String[] args) {

		for(Cafea cafea : Cafea.values()){
			System.out.println(cafea + " " + cafea.getSize() + " " + cafea.getLid());
		}
		

	}

}
