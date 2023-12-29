package ocp_1Z0_819.chapter4.built_in_func_interfaces;

import java.util.function.*;

public class UnaryBinaryExamples {
	public static void main(String[] args) {
		UnaryOperator<String> un1 = s -> s.toUpperCase();
		un1 			  = String::toUpperCase;

		System.out.println(un1.apply("that's an uppercase"));

		BinaryOperator<String> bn1 = String::concat;

		System.out.println(bn1.apply("baby ", "chick"));


		UnaryOperator<Double> sqrt = Math::sqrt; 

		System.out.println(sqrt.apply(81.0));
	}
}
