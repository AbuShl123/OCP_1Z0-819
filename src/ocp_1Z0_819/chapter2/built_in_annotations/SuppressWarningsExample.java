package ocp_1Z0_819.chapter2.built_in_annotations;

import java.util.*;

public class SuppressWarningsExample {
		
	public static void main(String... args) {
		System.out.println("Compiles successfully");

		SuppressWarningsExample warning = new SuppressWarningsExample();

		warning.sumUp(2, 3);
	}

	@SuppressWarnings("deprecation")
	public void sumUp(int a, int b) {
		SuppressWarningsExample.add(a, b);
	}

	@SuppressWarnings("unchecked")
	public void sumUp() {
		SuppressWarningsExample.add(new ArrayList());
	}
	
	@Deprecated 
	static public int add(int a, int b) {
		return a+b;
	}

	static public int add(List<Integer>... numbers) {
		int sum = 0;

		for (List<Integer> list : numbers) {
			for (int num : list) {
				sum += num;
			}
		}

		return sum;
	}
}