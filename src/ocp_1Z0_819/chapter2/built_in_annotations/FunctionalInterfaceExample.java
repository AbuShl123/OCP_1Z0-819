package ocp_1Z0_819.chapter2.built_in_annotations;


public class FunctionalInterfaceExample {
	public static void main(String... args) {
		System.out.print("Compiles successfully");
	}
}


// @FunctionalInterface DOES NOT COMPILE
abstract class Reptile {
	abstract String getName();
}

// @FunctionalInterface interface Slimy {} DOES NOT COMPILE 

@FunctionalInterface interface Scaley {
	boolean isSnake();
}

// @FunctionalInterface DOES NOT COMPILE 
interface Rough extends Scaley {
	void checkType();
}

@FunctionalInterface interface Smooth extends Scaley {
	boolean equals(Object unused);
}

