package ocp_1Z0_819.chapter3.collections;

import java.util.*;
import java.util.function.Function;

public class IteratingList {
	public static void main(String... args) {
		List<String> strs = List.of("Have", "Fun", "My", "Friends\n");

		Iterator<String> iter = strs.iterator();

		while (iter.hasNext()) {
			String str = iter.next();
			System.out.print(str + " ");
		}	

		Function<String, List<String>> listProducer = s -> List.of(s.split(""));

		List<String> alphabet = listProducer.apply("abcdefghijklmnopqrstuvwxyz");

		iter = alphabet.iterator();

		while (iter.hasNext()) {
			char ch = iter.next().charAt(0);
			System.out.print(ch + " ");
		}
	}
}
