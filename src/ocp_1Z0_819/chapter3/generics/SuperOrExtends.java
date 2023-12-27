package ocp_1Z0_819.chapter3.generics;

import java.util.*;
import java.io.*;

public class SuperOrExtends {

	static class Animal {}
	
	static class Bird extends Animal {}

	static class Owl extends Bird {}
	
	static class Sparrow extends Bird {}
	
	public static void upperBound(List<? extends Animal> animals) {
//		animals.add(new Animal()); DOES NOT COMPILE
//		animals.add(new Owl()); DOES NOT COMPILE

		// the type of the list can be List<Animal> or can be List<Bird>. Everything is possible, and we can't be sure that new Animal() or new Owl() will be allowed 

		// Even new Owl() fails, because we can't be sure that there is no class that extends Owl

		if (animals.size() > 0) animals.remove(1);
	}


	public static void lowerBound(List<? super Owl> birds) {
		birds.add(new Owl()); 
		// we can add 'new Owl()', because we know, that the type of the list will at least be Owl, and then maybe parents of Owl
		// Ex: If the type of the list is --> List<Bird> --> then 'new Owl()' can be stored in Bird
		
//		birds.add(new Animal());  // DOES NOT COMPILE
		// It is possible that the list will be of type: List<Owl>, which means that 'new Animal()' can't fit in Owl

		birds.remove(1);
	}

	public static void main(String[] args) {
		List<Bird> birds = new ArrayList<>(List.of(new Bird(), new Owl()));

		List<? super IOException> exceptions = new ArrayList<Exception>();
		exceptions.add(new IOException());

//		exceptions.add(new Exception()); // DOES NOT COMPILE: the same situation as in the line 30

		exceptions.add(new FileNotFoundException());

		List<? super Bird> list = new ArrayList<Animal>(); // if we replace with new ArrayList<Owl>() is won't compile
		list.add(new Owl());
		list.add(new Bird()); // however we can add an owl
//		list.add(new Animal()); // DOES NOT COMPILE

		list.remove(1); // we can remove
	}
}
