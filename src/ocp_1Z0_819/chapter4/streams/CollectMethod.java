package ocp_1Z0_819.chapter4.streams;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class CollectMethod {
	public static void main(String[] args) {
		var letters = List.of("w", "o", "l", "f!");
	
		StringBuilder word = letters.stream().collect(
						StringBuilder::new, // <-- where to collect? (Supplier)
						StringBuilder::append, // <-- how to collect? (Consumer)
						StringBuilder::append);	 // <-- useful for parallel streams
	
		System.out.println(word.toString());
		var set = letters.stream().<TreeSet<String>>collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
		System.out.println("TreeSet using first collect: " + set);

		// using Collectors
		TreeSet<?> treeSet = letters.stream().collect(Collectors.toCollection(TreeSet::new));
		System.out.println("TreeSet using Collectors: " + set);
		
		Stream<String> stream = Stream.of("w", "o", "l", "f!");
		Set<String> unorderedSet = stream.collect(Collectors.toSet());
		System.out.println("HashSet using Collectors: " + unorderedSet);

		// my own custom collectors
		System.out.println("=".repeat(20) + "My Collectors" + "=".repeat(20));
		var arrays = new ArrayHelper();

		String[] arr = letters.stream().<String[]>collect(
								() -> new String[letters.size()], 
								arrays::add,
								(array1, array2) -> {});
		System.out.println(Arrays.toString(arr));

		var numbers = List.of(12, 10, 0, 5, 2, 34);
		System.out.println(numbers);
		var arrIntegers = numbers.stream().<int[]>collect(
								() -> new int[numbers.size()],
								(array, element) -> arrays.add(array, element),
								(a1, a2) -> {});
		System.out.println(Arrays.toString(arrIntegers));

		int[] result = numbers.stream().collect(MyCollectors.toIntArray(numbers.size()));

		System.out.println(Arrays.toString(result));
	}
	
	static class MyCollectors {
		public static Collector<Integer, int[], int[]> toIntArray(int size) {
			var helper = new ArrayHelper();
			Supplier<int[]> supplier = () -> new int[size];
			BiConsumer<int[], Integer> accumulator = helper::add;
			BinaryOperator<int[]> combiner = ArrayHelper::combineInt;

			return Collector.<Integer, int[]>of(supplier, accumulator, combiner);
		}
	}

	static class ArrayHelper { 
		int count = 0;

		public <T, U extends T> void add(T[] array, U u) {
			if (count < array.length) array[count++] = u;
			else count = 0;
		}

		public void add(int[] array, int el) {
			if (count < array.length) array[count++] = el;
			else count = 0;
		} 

		public static int[] combineInt(int[] arr1, int[] arr2) {
			int[] combined = new int[arr1.length + arr2.length];
			int i = 0;
			for (int e : arr1) combined[i++] = e;
			for (int e : arr2) combined[i++] = e;

			return combined;
		}
	}
}
