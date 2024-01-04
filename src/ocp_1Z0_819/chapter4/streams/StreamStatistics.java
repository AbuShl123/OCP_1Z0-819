package ocp_1Z0_819.chapter4.streams;

import java.util.stream.*;
import java.util.*;

public class StreamStatistics {
	/*
		summaryStatistics() method returns a statistics object that provides quickly with simple stream characteristics
	
		statistics work only with primitive streams

		statistics hold the following info: 
			- min
			- max
			- average
			- sum
			- count (number of elements in the stream)
	*/

	public static void main(String... args) {
		IntStream ints = IntStream.rangeClosed(1, 20);

		IntSummaryStatistics stats = ints.summaryStatistics();

		int range = stats.getMax() - stats.getMin();

		System.out.println("The range of data set is " + range);
		System.out.println("The sum of numbers in the data set is " + stats.getSum());
		System.out.println("The average value in the data set is " + stats.getAverage());
		System.out.println("The count of numbers in the data set is " + stats.getCount());

		System.out.println("\nCan you guess the data set content?");
		
		System.out.print("Type any letter to reveal the data set content: ");
		new Scanner(System.in).next();

		System.out.println(Arrays.toString(IntStream.range(1, 21).toArray()));
	}
}
