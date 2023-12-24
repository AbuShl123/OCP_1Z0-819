package ocp_1Z0_819.chapter3.method_reference;

import java.util.*;
import java.util.function.*;


public class InstanceMethods {

	public static void main(String[] args) {

		var sentence = new Scanner(System.in).next();

		Predicate<String> methodRef = sentence::startsWith;
		Predicate<String> lambda = s -> sentence.startsWith(s);
		
		List<String> strings = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");
		
		for (String s : strings) 
			System.out.println(s + " --> " + methodRef.test(s));

		Supplier<Integer> var = new Random()::nextInt;

		System.out.println(var.get());

		Predicate<String> selfChecker1 = String::isEmpty;
		Predicate<String> selfChecker2 = s -> s.isEmpty();

		BiPredicate<String, String> tester1 = String::startsWith;
		BiPredicate<String, String> tester2 = (s, p) -> s.startsWith(p);

		Supplier<List<Integer>> arrList1 = ArrayList::new;
		Supplier<List<Integer>> arrList2 = () -> new ArrayList<>();

		Function<Integer, List<Integer>> adv1 = ArrayList::new;
		Function<Integer, List<Integer>> adv2 = i -> new ArrayList<>(i);

		BiConsumer<ArrayList<Integer>, ArrayList<Integer>> combine = ArrayList::addAll;
		BiConsumer<ArrayList<Integer>, ArrayList<Integer>> lmCombine = (t, u) -> t.addAll(u);

		ArrayList<Integer> numbersSet1 = new ArrayList<>(List.of(1, 2, 3, 4));
		ArrayList<Integer> numbersSet2 = new ArrayList<>(List.of(5, 6, 7, 8, 9, 10));

		combine.accept(numbersSet1, numbersSet2);

		System.out.println(numbersSet1);
	}
}
