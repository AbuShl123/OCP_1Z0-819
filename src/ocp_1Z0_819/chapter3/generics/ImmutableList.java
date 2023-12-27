package ocp_1Z0_819.chapter3.generics;

import java.util.*;

public class ImmutableList {
	
	static class Bird {}
	static class Sparrow extends Bird {}

	public static void main(String[] args) {
		List<? extends Bird> birds = new ArrayList<>();
	
//		birds.add(new Bird()); // DOES NOT COMPILE
//		birds.add(new Sparrow());

		// when using unbounded or uppder-bounded generic types (? or ? extends type) the list is immutable
	}
    
}
