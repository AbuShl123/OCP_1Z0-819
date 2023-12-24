package ocp_1Z0_819.chapter3.collections;

import java.util.*;

public class FactoryMethods {
	public static void main(String... args) {
		String[] array = new String[] {"a", "b", "c"};

		List<String> asList = Arrays.asList(array);
		List<String> of = List.of(array);
		List<String> copy = List.copyOf(asList);
	
		array[0] = "z";
		
		System.out.println("asList=" + asList); // [z, b, c]
		System.out.println("List.of=" + of); // [a, b, c]	
		System.out.println("List.copyOf=" + copy); // [a, b, c]

		asList.set(0, "x");

		System.out.println("After modifying aslist, array=" + Arrays.toString(array)); // [x, b, c]
		
//		copy.add("y"); UnsupportedOperationException at runtime
//		of.set(1, "x"); UnsupportedOperationException at runtime
	}	
}
