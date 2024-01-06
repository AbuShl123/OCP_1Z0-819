package ocp_1Z0_819.chapter4.streams.advances_stream_flow;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class Collectors2 {
	public static void main(String[] args) {
		// averaging
		var stream = Stream.of (14, 23, 10, 12, 15, 16);
		double avg = stream.collect(Collectors.averagingDouble(i -> i));

		System.out.println(avg);

		Stream<String> strs = Stream.of("Home", "House", "Hello", "Good");
		double avgLen = strs.collect(Collectors.averagingInt(s -> s.length()));

		System.out.println(avgLen);

		List<Integer> numbers = new ArrayList<>(List.of(56, 34, 76, 46, 23, 78, 66));

		// Summarizing
		DoubleSummaryStatistics doubleStats = numbers.stream().collect(Collectors.summarizingDouble(n -> n)); // The ToDoubleFunction in parameter defines: how to get a double from stream elements?
		System.out.println(doubleStats);

		IntSummaryStatistics intStats = numbers.stream().collect(Collectors.mapping(String::valueOf, Collectors.summarizingInt(s -> Integer.parseInt(s + "0"))));
		System.out.println(intStats);

		// partitioningBy

		List<String> words = List.of("Homeland", "Sea shores", "Weekend", "Vacation", "Inhabited island");

		Map<Boolean, List<int[]>> map = words.stream().collect(Collectors.partitioningBy(
				s -> s.split(" ").length > 1,
				Collectors.mapping(
						s -> Arrays.stream(s.split("")).mapToInt(e -> e.charAt(0)).toArray(),
						Collectors.toList()
				)));

		System.out.println(map);
	}
}
