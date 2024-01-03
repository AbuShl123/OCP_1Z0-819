package ocp_1Z0_819.chapter4.streams;

import java.util.*;
import java.util.stream.*;

public class CreatingInfiniteStreams {
	public static void main(String... args) {
		Stream<Integer> randoms = Stream.generate(() -> new Random().nextInt());

//		randoms.forEach(System.out::println);	// prints random numbers infinitely 

		Stream<Integer> oddNumbers = Stream.iterate(1, n -> n+2);
//		oddNumbers.forEach(System.out::println); // prints all the odd numbers infinitely 

		Stream<Long> halfRombs = Stream.<Long>iterate(1L, n -> {
			if (n > 10000000000000000L) n = 1L;	
			sleep(50L);	
			return n*10L;
		}); 
		
		halfRombs.forEach(System.out::println); 

		Stream<Integer> oddNumbersUnder100 = Stream.iterate(1, 
								    n -> n < 100, // continues iteration as long as this predicate is true
								    n -> n + 2);

//		oddNumbersUnder100.forEach(System.out::println);		
	}

	static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
