package ocp_1Z0_819.chapter3.generics;

import java.util.*;

public class BoundedGenericTypes {
	public static void main(String[] args) {
		List<?> x1 = new ArrayList<>();
		var x2 = new ArrayList<>();

		List<?> list = new ArrayList<String>();

//		list.add(1); DOES NOT COMPILE
//		list.add("Hey");

		x2.add("Hi");
		x2.add(4);

//		x1.add("Hi"); DOES NOT COMPILE
//		x1.add(4);

		System.out.println(total(new ArrayList<Number>(List.of(12, 5.6f, 3, 8.7, 12, 10, 9, 10101111L))));
	}

	public static double total(List<? extends Number> list) {
		double total = 0;
		for (Number n : list) {
			total = total + n.doubleValue();
		}
		return total;
	}
}
