package ocp_1Z0_819.chapter4.built_in_func_interfaces;

import java.util.function.*;
public class FunctionExamples {
	public static void main(String[] args) {
		BiFunction<String, String, String> doS = String::concat;

		System.out.println(doS.apply("Abubakr ", "Shoaliyev"));
		
		Function<String, Integer> getLength = String::length;

		System.out.println(getLength.apply("It was a shiny warm day that didn't seem to foreshadow anything bad"));
		System.out.println();

		// helpful Function methods

		Function<Double, Double> sqrt = i -> { System.out.println("i=" + i + " sqrt=" + Math.sqrt(i)); return Math.sqrt(i); };
		Function<Integer, Double> pov2 = i -> { System.out.println("i=" + i + " pov2=" + (i*i)); return (double) (i*i); } ;

		Function<Integer, Double> module = sqrt.compose(pov2);

		int negativeNumber = -334;
		int positiveOne = (int) (double) module.apply(negativeNumber);

		System.out.println("output: " + positiveOne);

		Function<Integer, Double> module2 = pov2.andThen(sqrt);

		System.out.println("output: " + (int) (double) module2.apply(negativeNumber));

		System.out.println();
		System.out.println(negativeNumber);
	}
}
