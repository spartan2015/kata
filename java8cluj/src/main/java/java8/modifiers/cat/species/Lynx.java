package java8.modifiers.cat.species;

import java8.modifiers.cat.BigCat;

public class Lynx extends BigCat {

	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! PROTECTED ACCESS IN ANOTHER CLASS through an instance in a static
	public static void main(String[] args) {

		BigCat bigCat = new BigCat();
		// only public
		System.out.println(bigCat.name);

		// protected
		Lynx lynx = new Lynx();
		System.out.println(lynx.hasFur); // can access protected through an
											// instance of this class - would be
											// like accessing pa private of this
											// class inside this class

	}

	void instance() {
		System.out.println(hasFur); // only through inheritance on this instance
	}
}
