package ocp_1Z0_819.chapter3.collections;

import java.util.*;

public class CollectionMethods {
	public static void main(String... args) {
		Collection<Integer> numbers = new ArrayList<>();
		
		numbers.add(10);

		System.out.println(numbers.remove((Integer) 2));
		System.out.println(numbers.remove(2));

		System.out.println(numbers);

		System.out.println(numbers.isEmpty());

		Collection<String> strs = new ArrayList<>(List.of("Hey", "Hello", "", "Abu", "World"));

		strs.removeIf(String::isEmpty);

		System.out.println(strs);
	}
}
