package ocp_1Z0_819.chapter1.functional_programming;

@FunctionalInterface // <-- adding this annotation is optional
interface Sprint {
   void sprint(int speed);
}

public class Example implements Sprint {
   public void sprint(int speed) {
	System.out.println("Animal is sprinting fast! " + speed);
   }

   public static void main(String[] args) {

   }
}