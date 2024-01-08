package ocp_1Z0_819.chapter5.assertions;

import java.util.function.*;

public class AssertionSyntaxPractice {
	public static void main(String[] args) {
		String name = "Hobbit";
		assert name.equals("Hobbit"): "Name validation failed";

		Supplier<Boolean> trues = () -> true;

		assert trues.get();

		int number = 12;

		assert number == 12;
	}
}
