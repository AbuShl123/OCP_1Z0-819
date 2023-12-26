package ocp_1Z0_819.chapter3.sorting_data;

import java.util.*;

public class Product implements Comparable<Product> {
	
	private int id;
	private String name;
	
	Product(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return id + "--" + name;
	}

	@Override
	public int hashCode() { return id; }
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Product)) return false;
		var other = (Product) o;
		return this.id == other.id;
	}
	
	@Override
	public int compareTo(Product p) {
		return this.name.compareTo(p.name);
	}

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();

		products.add(new Product(12314, "Watches UX Bronze"));
		products.add(new Product(12342, "Watches UX Bronze"));
		products.add(new Product(99923, "Watches UX Gold"));		

		Collections.sort(products);
	
		System.out.println(products);
	}	
}
