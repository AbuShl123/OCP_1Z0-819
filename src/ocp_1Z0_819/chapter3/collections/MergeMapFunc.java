package ocp_1Z0_819.chapter3.collections;

import java.util.*;
import java.util.function.*;

public class MergeMapFunc {
	public static void main(String... args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");
		map.put(6, "six");
		map.put(7, null);
		map.put(8, "eight");
		map.put(9, "nine");
		map.put(10, "ten");
		
		System.out.println("Before: \n" + map);

		BiFunction<String, String, String> mapper = (v1, v2) -> {
			switch (v2) {
				case "1": return "first";
				case "2": return "second";
				case "3": return "third";
				case "": return v1 + "th";
				default: return v2;	
			}
		}; 


		for (int i : map.keySet()) {
			map.merge(i, "", mapper);
		}

		System.out.println("After: \n" + map);

		map.merge(11, "eleventh", mapper);
		
		System.out.println(map);


		BiFunction<String, String, String> deleter = (v1, v2) -> null;

		for (int i = 0; i <= 11; i++) {
			map.merge(i, "zero", deleter);
		}

		System.out.println(map);
	}
}
