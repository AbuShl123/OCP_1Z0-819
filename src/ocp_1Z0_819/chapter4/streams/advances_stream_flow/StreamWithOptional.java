package ocp_1Z0_819.chapter4.streams.advances_stream_flow;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class StreamWithOptional {
	public static void main(String[] args) {
		System.out.print("Guess the secret number: ");
		Optional<Integer> optional = Optional.of(new Scanner(System.in).nextInt());

		optional.<String>map(i -> "" + i).filter(s -> s.length() == 3).ifPresent(System.out::println);

		var opt = Optional.of("Beautiful world");

		Optional<Integer> length = opt.map(String::length);

		var text = Optional.of("Once upon a time, there was a huge frightening storm happened in year 1852, which hung over the area of a whole Caribbean Sea not even allowing a single submarine to make a pass through those gigantic and powerful sea waves");

		Optional<String[]> vocab = text.flatMap(Helper::reconstruct);
		Optional<Integer> wordCount = text.map(s -> s.split(" ").length);

		vocab.ifPresent(s -> System.out.println(Arrays.toString(s)));
		wordCount.ifPresent(System.out::println);	
	}

	static class Helper {
		static Optional<String[]> reconstruct(String str) {
			// get each char
			// remove duplicates 
			// return array
			BiFunction<TreeSet<String>, String, TreeSet<String>> accumulator = (container, element) -> {container.add(element); return container; };
			BinaryOperator<TreeSet<String>> combiner = (set1, set2) -> {set1.addAll(set2); return set1; };

			TreeSet<String> set = Stream.of(str).flatMap(s -> Arrays.stream(s.split(""))).reduce(new TreeSet<String>(), accumulator, combiner);

			String[] reconstructed = set.stream().toArray(String[]::new);

			return Optional.of(reconstructed);
		}
	}
}
