package ocp_1Z0_819.chapter3.generics;

import java.util.*;

public class GenericMethods {

    public static <T> void printList(List<T> list) {
        System.out.print("In the list: [");
        for (T t : list) {
            System.out.print(t + ", ");
        }
        System.out.println("]");
    }

    public static <T> T printObj(T t) {
        System.out.println(t);
        return t;
    }

    public static <T> int getHash(T t) {
        return t.hashCode();
    }

    private static class Shipper<T> {

        public <T> void anotherShip(T t) {
            System.out.println("Shipping different obj: " + t);
        }

        public static <T> void ship(T t) {
            if (t instanceof String[])
                System.out.println(Arrays.toString((String[]) t));
            else
                System.out.println("Shipping " + t);
        }

    }

    public static void main(String[] args) {
        Shipper.<String>ship("Tesla car");
        Shipper.<String[]>ship(new String[] {"IPhone X", "IPhone IX pro", "IPhone XII"});

        Shipper.ship(new HashMap<>(Map.of("Spray", 123141, "Balloon", 100231)));

        List<Number> numbers = new ArrayList<>(List.of(12, 13.4, 23, 203.2, 12313123L));

        printList(numbers);
    }
}
