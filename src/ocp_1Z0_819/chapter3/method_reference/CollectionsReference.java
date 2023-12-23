package ocp_1Z0_819.chapter3.method_reference;

import java.util.*;
import java.util.function.Consumer;

public class CollectionsReference {

	public static void main(String... args) {
		List<Integer> list = List.of(1, 9, 8, 2, 3, 5, 4, 7, 6);

		Consumer<List<Integer>> sorter1 = l -> Collections.sort(l);
		Consumer<List<Integer>> sorter2 = Collections::sort;

		Consumer<Integer> increaser = Utils::increase;
		increaser.accept(12);
	
//		Consumer<Long> longIncreaser = Utils::increase; // DOES NOT COMPILE
//		increaser.accept(12L); // DOES NOT COMPILE
	}
	static class Utils {
		static void increase(int i) {
			i = i + i;
			System.out.println("int is " + i);
		}

		static void increase(short s) {
			s = (short)(s + s);
			System.out.println("short is " + s);
		}
	}
}
