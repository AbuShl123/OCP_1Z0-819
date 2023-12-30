package ocp_1Z0_819.chapter4.optional;

import java.util.Optional;

public class SimpleOptional {
	public static void main(String[] args) {
		int myScores[] = {98, 77, 91, 100};
	
		var avg = average(myScores);
		var nonAvg = average();

		System.out.println(avg);
		System.out.println(nonAvg);

		Optional<Double> value = Optional.of(123.0);
	
		if (avg.isPresent()) System.out.println(avg.get());
//		System.out.println(nonAvg.get()); Produces NoSuchElementException 

		// OfNullable purpose
		
		Optional o = (myScores == null) ? Optional.empty() : Optional.of(myScores); 
		Optional o2 = Optional.ofNullable(myScores); // literally the same as the line above

		
	}

	public static Optional<Double> average(int... scores) {
		if (scores.length == 0) return Optional.empty();

		int sum = 0;
		for (int i : scores) sum += i;
	
		return Optional.of( (double) sum / scores.length);
	}
}
