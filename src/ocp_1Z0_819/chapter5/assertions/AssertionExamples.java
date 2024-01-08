package ocp_1Z0_819.chapter5.assertions;

public class AssertionExamples {
	public static void main(String... args) {
		int numGuests = -5;

		assert numGuests > 0;
		
		System.out.println(numGuests);
	}
}
