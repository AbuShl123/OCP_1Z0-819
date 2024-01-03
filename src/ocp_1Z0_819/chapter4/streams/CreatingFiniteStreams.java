package ocp_1Z0_819.chapter4.streams;

import java.util.stream.*;
import java.util.*;

public class CreatingFiniteStreams {
	public static void main(String... args) {
		Stream<String> empty = Stream.empty();
		Stream<Integer> singleElement = Stream.of(1);
		Stream<Integer> fromArray = Stream.of(1, 2, 3, 4); // using varargs

		// collection provides a convenience way to create a stream

		var list = List.of("a", "b", "c");
		Stream<String> stringsStream = list.stream();

		// parallel stream
		Stream<String> parallelStrings = list.parallelStream();
	}
}
