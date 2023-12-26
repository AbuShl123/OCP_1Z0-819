package ocp_1Z0_819.chapter3.sorting_data;

import java.util.*;

public class Trees {
		
	static class Rabbit { 
		int id; 
		public Rabbit(int id) {
			this.id = id;
		}
	}
		
	public static void main(String... args) {
		TreeSet<Rabbit> rabbits = new TreeSet<>();

//		rabbits.add(new Rabbit(1234)); // DOES NOT COMPILE 

		rabbits = new TreeSet<>((r1, r2) -> r1.id - r2.id);

		rabbits.add(new Rabbit(1234)); // now compiles

		for (int i = 0; i < 10; i++) 
			rabbits.add(new Rabbit(new Random().nextInt(8999)+1000));

		rabbits.forEach((e) -> System.out.println("Rabbit " + e.id));
	}
}
