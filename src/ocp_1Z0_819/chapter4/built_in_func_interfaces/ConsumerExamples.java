package ocp_1Z0_819.chapter4.built_in_func_interfaces;

import java.util.*;
import java.util.function.*;

public class ConsumerExamples {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		BiConsumer<String, Integer> fillMap = map::put;

		fillMap.accept("Me", 18);

		System.out.println(map);

		ArrayList<Integer> list = new ArrayList<>();
		Consumer<Integer> fillList = list::add;

		fillList.accept(102);

		System.out.println(list);

		// helpful Consumer methods

		Consumer<String> sLen = (s) -> System.out.print("Length: " + s.length());
		Consumer<String> sChars = (s) -> System.out.println(" | vocabulary: " + new HashSet<>(Arrays.asList(s.split(""))));

		Consumer<String> combined = sLen.andThen(sChars);
		String str = "Once upon a time, there was a queen and king who lived a long and peaceful life...";

		combined.accept(str);
	}
}
