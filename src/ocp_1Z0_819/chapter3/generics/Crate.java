package ocp_1Z0_819.chapter3.generics;


public class Crate<T> {
	T contents;
	
	public void packCrate(T contents) {
		this.contents = contents;
	}

	public T emptyCrate() {
		Object obj = new Object();
		return contents;
	}
}

class Robot {}

interface Shippable<T> {
	void ship(T t);
}

class RobotShippableCrate implements Shippable<Robot> {
	public void ship(Robot t) {
		System.out.println("Shipping " + t);
	}
}

class AbstractShippableCrate<T> implements Shippable<T> {
	public void ship(T t) {
		System.out.println("Shipping " + t);
	}
}