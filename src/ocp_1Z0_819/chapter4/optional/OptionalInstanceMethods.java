package ocp_1Z0_819.chapter4.optional;


import java.util.*;

public class OptionalInstanceMethods {
	public static void main(String[] args) {
		System.out.print("How much gold do you have buddy? \n- ");
		int userGold = new Scanner(System.in).nextInt();
		Optional<Sword> userSword = purchaseSword(userGold);

		userSword.ifPresent(System.out::println);

		User user = new User(userSword.orElse(new DefaultSword()));

		System.out.println("You purchased a " + user.sword);

		User user2 = new User(userSword.orElseGet(PoorSword::new));

		System.out.println("Your teammate gets a " + user2.sword);

		// using throw 

		System.out.println(userSword.orElseThrow(IllegalArgumentException::new)); // will throw exception if optional is empty
	}

	public static Optional<Sword> purchaseSword(double gold) {
		return gold >= 1340 ? Optional.of(new Sword()) : Optional.empty();
	}

	static class User {
		public Sword sword;
		public User(Sword sword) {this.sword = sword;}
	}

	static class Sword {
		public String toString() {return "Cool Sword";}
	}

	static class DefaultSword extends Sword {
		public String toString() {return "Default Sword";}
	}

	static class PoorSword extends DefaultSword {
		public String toString() {return "Poor Sword";}	
	}
}	
