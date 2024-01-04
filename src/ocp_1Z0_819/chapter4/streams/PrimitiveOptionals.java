package ocp_1Z0_819.chapter4.streams;

import java.util.*;
import java.util.stream.*;

public class PrimitiveOptionals {
    public static void main(String[] args) {
        // Difference between OptionalDouble and Optional<Double> is that the former one holds primitive type

        OptionalDouble optionalDouble = OptionalDouble.of(5.5/1.2);

        double value = optionalDouble.getAsDouble(); // there is no just get() method

        System.out.println(optionalDouble.stream().summaryStatistics());

        // stream() on optionalDouble returns DoubleStream

        value = optionalDouble.orElseGet(() -> Double.NaN); // DoubleSupplier instead of just Supplier<Double>

	// With streams

	LongStream streamOfLongs = LongStream.of(4L, 5L, 8L, 1L, 6L, 10L);
	OptionalLong minLong = streamOfLongs.min();
	System.out.println(minLong.getAsLong()); // 1 

	streamOfLongs = LongStream.of(4L, 5L, 8L, 1L, 6L, 10L);
	OptionalLong max = streamOfLongs.max();
	System.out.println(max.orElseGet(() -> -1L));

	DoubleStream streamOfDoubles = DoubleStream.of(2.67, 3, 2, 3.67);
	OptionalDouble myGpa = streamOfDoubles.average();
	System.out.println(myGpa.orElseGet(() -> Double.NaN));

	IntStream streamOfInts = IntStream.of(3, 4, 2, 3, 3);
	int sum = streamOfInts.sum();
	System.out.println(sum);
    }
}
