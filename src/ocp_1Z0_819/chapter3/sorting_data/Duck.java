package ocp_1Z0_819.chapter3.sorting_data;

import java.util.*;

public class Duck implements Comparable<Duck> {
	
	private String name;
	private int weight;

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public Duck(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return name;
	}	

	@Override
	public int compareTo(Duck d) {
		return d.name.compareTo(this.name); // using compareTo() method of string object -> soring descending
	}

	public static void main(String[] sss) {
		var ducks = new ArrayList<Duck>();
		ducks.add(new Duck("Duckling", 6));
		ducks.add(new Duck("Nemo", 10));
		ducks.add(new Duck("Antonio", 7));

		Collections.sort(ducks);

		System.out.println(ducks);

		// now using comparator 

		Comparator<Duck> byWeight = new Comparator<>() {
			@Override
			public int compare(Duck d1, Duck d2) {
				return d1.weight - d2.weight;
			}	
		};

		Collections.sort(ducks, byWeight);

		System.out.println(ducks);

		Collections.sort(ducks, (d1, d2) -> d1.name.compareTo(d2.name));

		System.out.println(ducks);

		Comparator<Duck> byWeight2 = Comparator.comparing((d) -> { return (int) d.getWeight();});

		byWeight2 = Comparator.comparing(Duck::getWeight);
		
		Collections.sort(ducks, byWeight2);
	}
}
