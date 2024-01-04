package ocp_1Z0_819.chapter4.streams;

import java.util.stream.*;
import java.util.*;
public class IntermediateOperations {
	
	public static void main(String[] args) {
		// filter() ---> removes any elements that do not satisfy the Predicate 
		Stream<String> stream = Stream.of("me ", "him ", "and ", "her ", "you ", "those ", "only ", "they ");

		stream.filter(s -> s.matches("[mayo].*"))
			.forEach(System.out::print);
		System.out.println();

		// distinct() ---> removes duplicates. Calls equals() to compare
		var words = List.of("home", "land", "ocean", "home");
		words.stream().distinct().forEach(System.out::print);
		System.out.println();

		// skip() and limit()
		Stream<Integer> endlessNums = Stream.iterate(0, n -> n+2);
		
		endlessNums.skip(10) // skipping first 5 elements
			.limit(2) // limiting to two elemnts only 
			.forEach(System.out::print);
		System.out.println();

		// map() ---> returns a new stream of different type from an old stream. Is for transforming data
		List<String> strs = new ArrayList<>(List.of("Hi", "", "", "World", "s", "?"));
		List<?> lens = strs.stream().map(String::length).collect(Collectors.toList());
		System.out.println(lens);

		// flatMap() ---> takes a function that returns another stream 
		var birds = List.of("Sparow", "Owl");
		var mammals = List.of("Cow", "Cat", "Giraffe");
		var empty = List.<String>of();
	
		ArrayList<String> shortAnimals = Stream.of(birds, mammals, empty).flatMap(List::stream).filter(s -> s.length()==3).collect(Collectors.toCollection(ArrayList::new));

		System.out.println(shortAnimals);

		// sorted()
		Stream<String> chain = Stream.of("grizzly-", "brown bear-");
		chain.sorted(Comparator.reverseOrder()).forEach(System.out::print);
		System.out.println();
		
		Stream<String> keys = Stream.of("Helicopter-", "K52", "Attack ");
		String gender = keys.sorted((s1, s2) -> s1.compareTo(s2)).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
		System.out.printf("My gender is %s\n", gender);

		// peek()	--> just to peek an element
		var electronics = List.of("monitor ", "ipad ", "telephone ", "iphone ", "iwatch ");
		long appleDevices = electronics.stream().filter(s -> s.startsWith("i")).peek(System.out::print).count();
		System.out.println("\n"+appleDevices);
	}

}
