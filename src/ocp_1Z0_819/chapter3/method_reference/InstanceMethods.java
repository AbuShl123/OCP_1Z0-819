package ocp_1Z0_819.chapter3.method_reference;

import java.util.*;
import java.util.function.*;


public class InstanceMethods {

	public static void main(String[] args) {

		var sentence = new Scanner(System.in).next();

		Predicate<String> methodRef = sentence::startsWith;
		Predicate<String> lambda = s -> sentence.startsWith(s);
		
		List<String> strings = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");
		
		for (String s : strings) 
			System.out.println(s + " --> " + methodRef.test(s));

		Supplier<Integer> var = new Random()::nextInt;

		System.out.println(var.get());
	}
}
