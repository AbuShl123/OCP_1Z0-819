package ocp_1Z0_819.chapter3.generics;

import java.util.*;
import java.io.*;

public class GenericPractices {
	static class A {}

	static class B extends A {}

	static <B extends A> B tricky(List<B> list) {
		A aInstance = new A();
//		B bInstance = new B(); // DOES NOT COMPILE
//		A obj = new B(); // DOES NOT COMPILE
		// B is not a class now, it's a type parameter. The type parameter B defined in the method hides the static class B

		GenericPractices.B bInstance = new GenericPractices.B(); // but we can access this way

		return list.size() > 0 ? list.get(0) : null;
	}

	static <T> T first(List<? extends T> list) {
		if (list.size() > 0) return list.get(0);
		else return null;
	}

	static <T> T second(List<? extends IOException> list) {
		// return list.get(0); DOES NOT COMPILE 
		return null;
	}

	static <T extends IOException> T third(List<T> list) {
		return list.get(0); // compiles
	}

	public static void main(String... args) {
		Exception exc = GenericPractices.<IOException>first(new ArrayList<FileNotFoundException>(List.of(new FileNotFoundException())));

		Object secondRes = second(List.of(new IOException()));
		Object thirdRes = third(List.of(new FileNotFoundException()));

		System.out.println(exc + "\n" + secondRes + "\n" + thirdRes);
	}

}
