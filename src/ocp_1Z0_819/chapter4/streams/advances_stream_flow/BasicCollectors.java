package ocp_1Z0_819.chapter4.streams.advances_stream_flow;

import java.util.*;
import java.util.stream.*;

public class BasicCollectors {
	public static void main(String[] args) {
		// joining()
		System.out.println("*".repeat(20) + "joining()" + "*".repeat(20));

		var subjects = Stream.of("Programming I", "Calculus I", "Physics I", "History");
		String courses = subjects.collect(Collectors.joining(", "));
		System.out.println(courses);

		System.out.println("\n");
		
		// averagingInt()
		System.out.println("*".repeat(20) + "averagingInt()" + "*".repeat(20));
		
		var animals = Stream.of("Monkey", "Giraffe", "Elephant");

		double averageOfLengths = animals.collect(Collectors.averagingInt(streamElement -> streamElement.length()));	// accepts ToIntFunction	
		System.out.println(averageOfLengths);
		System.out.println("\n");

		// toCollection()
		System.out.println("*".repeat(20) + "toCollection()" + "*".repeat(20));
		TreeSet<?> treeSet = Stream.of("Abu", "John",  "Sam").collect(Collectors.toCollection(TreeSet::new));
		System.out.println(treeSet);
		System.out.println("\n");

		// toMap()
		System.out.println("*".repeat(20) + "toMap()" + "*".repeat(20));
		Stream<String> words = Stream.of("Lion", "Zebra", "Tiger", "Elephant");
		Map<?, ?> wordToLen = words.collect(Collectors.toMap( s -> s, s -> s.length())); 
		// first function -> how to create a key from a stream element
		// second function -> how to create a value from a stream element
		System.out.println(wordToLen);

		animals = Stream.of("Lion", "Tiger", "Zebra", "Bear", "Giraffe", "Elephant");
		Map<Integer, String> lenToWord = animals.collect(Collectors.toMap(String::length, v->v, (s1, s2) -> s1 + "," + s2));
		// first and second functions are the same
		// third function -> some animals have the same length. third function defines what to do with both values, in case when two keys are similar
		System.out.println(lenToWord);
		System.out.println(lenToWord.getClass()); // HashMap, but it's not guaranteed 

		animals = Stream.of("Lion", "Tiger", "Zebra", "Bear", "Giraffe", "Elephant");
		var treeMap = animals.collect(Collectors.toMap(k->k, String::length, (s1, s2) -> s1, TreeMap::new));
		// fourth function -> which implementation of Map to create specifically? 
		System.out.println(treeMap);
		System.out.println(treeMap.getClass()); // TreeMap 		
	}
}
