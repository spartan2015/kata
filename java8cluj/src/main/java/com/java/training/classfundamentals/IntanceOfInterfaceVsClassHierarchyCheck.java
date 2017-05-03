package com.java.training.classfundamentals;

public class IntanceOfInterfaceVsClassHierarchyCheck {

	class A {
	}

	class A1 extends A {
	}

	class B {
	}

	interface I {
	}

	public void s() {

		A a1 = new A1();
		A1 a2 = new A1();

		boolean b1 = a2 instanceof A;
		boolean b2 = a2 instanceof A1;

		boolean b3 = a2 instanceof I; // even if there is nore relation between
										// A2 and interface this works at
										// compile cause there might be a
										// subclass that implements that
										// interface

	}

}
