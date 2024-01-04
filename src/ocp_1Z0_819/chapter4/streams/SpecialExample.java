package ocp_1Z0_819.chapter4.streams;

import java.util.Arrays;
import java.util.List;

public class SpecialExample {
    public static void main(String[] args) {

        var complexNumbers = List.of("1, 2, 3", "4, 5", "6, 7, 8, 9");

        var simpleNumbers = List.of("1", "2", "3", "4");

        System.out.println(simpleNumbers.stream().mapToInt(Integer::parseInt).sum());

        int sum = complexNumbers.stream()
                .flatMapToInt(str -> Arrays.stream(str.split(", ")).mapToInt(Integer::parseInt)) // IntStream.of(1, 2, 3), IntStream.of(4, 5), IntStream.of(6, 7, 8, 9)
                .sum();

        System.out.println(sum);

        /*
            The key difference between mapToInt and flatMapToInt:
                mapToInt requires you to provide it with a logic of how to convert each element of the original string to integer.
                        Therefore, the return type of the Function inside the mapToInt argument is int

                flatMapToInt requires you to provide it with a new IntStream of some elements. The method then flattens all those IntStreams into one large IntStream object and returns it
                        Therefore, the return type of the Function inside the mapToInt argument is IntStream


            Similarities between mapToInt and flatMapToInt:
                - both have return type - IntStream
         */
    }
}
