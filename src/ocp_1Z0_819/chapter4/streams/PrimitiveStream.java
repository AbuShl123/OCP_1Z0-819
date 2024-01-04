package ocp_1Z0_819.chapter4.streams;

import java.util.stream.*;
import java.util.*;

public class PrimitiveStream {
	public static void main(String... args) {

		// Primitive streams:
		// IntStream - used for int, short, byte and char
		// LongStream - used for long
		// DoubleStream - used for double and float

		IntStream intStream = IntStream.of(1, 2, 3);
		OptionalDouble avg = intStream.average();
		avg.ifPresent(System.out::println);

		List<Integer> numbers = List.of(5, 5, 3, 4, 5, 2, 4);

		System.out.println(numbers.stream().mapToInt(x -> x).sum());

		IntStream random = new Random().ints();
		random.limit(5).forEach(System.out::println);

		IntStream inRange = IntStream.range(1, 6);
		inRange.forEach(System.out::println);
		LongStream inRangeDouble = LongStream.range(1, 6);

		IntStream ids = IntStream.of(1491, 1932, 1231, 1943, 1482, 1882);
		var listOfToys = ids.mapToObj(Toy::new).collect(Collectors.toList());
		System.out.println(listOfToys);

		List<List<Integer>> listOfLists = List.of(List.of(1, 2), List.of(10, 20), List.of(30, 40));

		System.out.println(listOfLists.stream().flatMap(list -> list.stream()).flatMapToInt(el -> IntStream.of(el)).average());
		listOfLists.stream().flatMap(List::stream).flatMapToInt(IntStream::of).average().ifPresent(System.out::println);

		listOfToys.stream().flatMapToInt(toy -> IntStream.of(toy.id)).average().ifPresent(System.out::println);
		int[] toyIds = listOfToys.stream().mapToInt(Toy::getId).toArray();
		System.out.println(Arrays.toString(toyIds));

		int[] primitiveNumbers = {12, 41, 20, 24, 19, 50};
		List<Integer> listOfNumbers = Arrays.stream(primitiveNumbers).boxed().collect(Collectors.toList());
		
		// Arrays.stream(int[]) returns an IntStream instance 
		// Arrays.stream(long[]) similarly returns LongStream 

		int[] intArray = listOfNumbers.stream().mapToInt(x->x).toArray();
		System.out.println(Arrays.toString(intArray));
	}

	static class Toy {
		int id;

		Toy(int id) { this.id = id; }

		public String toString() { return "(Toy: #" + id + ")"; }

		int getId() { return id; }
	}
}
