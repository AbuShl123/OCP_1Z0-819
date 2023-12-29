package ocp_1Z0_819.chapter4.built_in_func_interfaces;

import java.util.function.*;
import java.util.*;

public class PredicateExamples {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args_) {
		Predicate tester = o -> o.hashCode() > 100;
		
		BiPredicate tester2 = Object::equals;
		
		class Human {
			String name;
			Human(String name) {this.name = name;}
		}			
		
		Human h1 = new Human("Abu1");
		Human h2 = new Human("Abu2");

		
		System.out.println(tester.test(h1));

		System.out.println(tester2.test(h1, h2));

		Set<Human> unorderedHumans = new HashSet<>();

		unorderedHumans.add(h1);
		unorderedHumans.add(h2);
		unorderedHumans.add(new Human("Abu3"));

		System.out.println(tester2.test(h2, new ArrayList<>(unorderedHumans).get(2)));

		// helpful Predicate methods
	
		Predicate<Integer> largerThan20 = i -> i > 20;
		Predicate<Integer> lessThan40 =   i -> i < 40;

		Predicate<Integer> range = largerThan20.and(lessThan40);
		Predicate<Integer> equals20 = largerThan20.negate().and(((Predicate<Integer>)(i -> i < 20)).negate());
		
		Integer[] nums = {10, 34, 60, 20, 14, 20, 21, 45, 40, 30};

		for (Integer n : Arrays.asList(nums)) {
			System.out.println("range test for " + n + " = " + range.test(n));
			System.out.println("does 20 equals " + n + " = " + equals20.test(n));
			System.out.println('\n');
		}		
	}
}
