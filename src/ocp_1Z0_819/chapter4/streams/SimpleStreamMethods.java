package ocp_1Z0_819.chapter4.streams;

import java.util.stream.*;
import java.util.function.*;
import java.util.*;

public class SimpleStreamMethods {
    public static void main(String[] args) {
        // count()
        System.out.println("=============count()=============");
        var animals = Stream.of("Monkey", "Elephant", "Giraffe");
        long c = animals.count();
        System.out.println(c);

        // min() max()
        System.out.println("=============min-max()=============");
        Stream<Integer> nns = Stream.of(12, 23, 19, 24);

        System.out.println(nns.count());
//	System.out.println(nns.min((n1, n2) -> n1-n2)); // this will give an exception, since the same stream cannot be reused more than once

        nns = Stream.of(1, 2, 34, 10, 23);
        var opt = nns.min((n1, n2) -> n1 - n2);
        opt.ifPresent(System.out::println);

        nns = Stream.of(12, 10, 11, 8, 9);
        var maxValue = nns.max((n1, n2) -> n1 - n2);
        maxValue.ifPresent(System.out::println);

        // findAny() findFirst()
        System.out.println("=============find-any-first()=============");
        var s = Stream.of("Sun", "Earth", "Mercury");
        Stream<String> infinite = Stream.<String>generate(() -> "chimp");

        s.findFirst().ifPresent(System.out::println);
        infinite.findFirst().ifPresent(System.out::println);
        Stream<Integer> infiniteNums = Stream.<Integer>generate(() -> (int) (double) Math.random());
        infiniteNums.findAny().ifPresent(System.out::println);

        // anyMatch() allMatch() noneMatch()
        System.out.println("=============any-all-none-Match()=============");
        var list = List.of("Krokodile", "Goat", "One");
        Predicate<String> condition = str -> Character.isLetter(str.charAt(0));

        System.out.println(list.stream().allMatch(condition)); // true
        System.out.println(list.stream().anyMatch(condition)); // true
        System.out.println(list.stream().noneMatch(condition)); // false

        System.out.println(List.of("1", "2", "3").stream().noneMatch(condition)); // true

        // note: it is not possbile to iterate through a stream using traditional for-loop, since Stream doesn't implement Iterable interface


        // reduce()
        System.out.println("=============reduce()=============");
        var letters = List.of("w", "o", "l", "f");

        String word = letters.stream().reduce("gray ", (container, element) -> container + element);
        System.out.println(word);

        word = letters.stream().reduce(" gray", (container, element) -> element + container);
        System.out.println(word);

        word = letters.stream().reduce("gray ", String::concat);
        System.out.println(word);

        word = letters.stream().reduce(" gray", (container, element) -> new StringBuilder(container).insert(container.length() - 5, element).toString());
        System.out.println(word);

        // multiply all the integers in a stream:
        var integers = List.<Integer>of(12, 13, 14, 15, 16, 17);
        int product = integers.stream().reduce(1, (container, element) -> container * element);
        System.out.println("The product of numbers in the list: " + integers + " is " + product);

        Stream<Integer> emptyStream = Stream.empty();
        int sum = emptyStream.reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        BinaryOperator<Integer> multiply = (a, b) -> a * b;

        var result = integers.stream().<Integer>reduce(multiply);    // Optional<Integer>
        System.out.println(result.getClass().getName() + " --> " + result.get());

        // reduce, third method signature

        var strings = List.of("w", "o", "l", "f", " is ", "gray!");

        // compute the number of chars:
        int length = strings.stream().<Integer>reduce(0, (i, str) -> i + str.length(), (i1, i2) -> i1 + i2);

        System.out.println(strings.stream().reduce("", String::concat) + " = " + length);

        length = strings.stream().<Integer>reduce(0,
                (i, str) -> {
                    int res = i + str.length();
                    System.out.print(res + " ");
                    return res;
                },
                (n1, n2) -> {
                    int res = n1 + n2;
                    System.out.print(res + "\n");
                    return res;
                });

        System.out.println(length);

        double average = integers.stream().<Double>reduce(0.0, (div, el) -> div += (double) el / integers.size(), Double::sum);

        System.out.println(average);
    }
}
