package ocp_1Z0_819.chapter3.sorting_data;

import java.util.*;

public class SortingNumbers {
	
	public static void main(String... args) {
		var list = new ArrayList<Integer>();
		
		for (int i = 1; i < 11; i++) 
			list.add(new Random().nextInt(51));

		System.out.println(list);
		
		Comparator<Integer> ascending = Integer::compare;

		Collections.sort(list, ascending);

		System.out.println(list);
	}
}
