package ocp_1Z0_819.utils;

public class JavaUtils {

	private JavaUtils() {
	}

	public static void println() {
		System.out.println();
	}

	public static void println(Object o) {
		System.out.println(o);
	}

	public static void print(Object o) {
		System.out.print(o);
	}

	public static void printf(String s, Object... elements) {
		System.out.printf(s, elements);
	}	

}