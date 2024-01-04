package ocp_1Z0_819.chapter4.streams.advances_stream_flow;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class OtherCollectors {
    public static void main(String[] args) {
        // groupingBy()
        System.out.println("-".repeat(20) + "groupingBy()" + "-".repeat(20));
        var names = List.of("Abu", "John", "Kris", "Ali", "Jess", "Sam", "Anna", "Kevin");

        Map<Integer, List<String>> grouped = names.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(grouped);

        Map<Integer, Set<String>> grouped2 = names.stream().collect(
                Collectors.groupingBy(
                        String::length,
                        Collectors.toSet()));

        System.out.println(grouped2);

        TreeMap<Integer, TreeSet<String>> grouped3 = names.stream().collect(
                Collectors.groupingBy(
                        String::length,
                        TreeMap::new,
                        Collectors.toCollection(TreeSet::new)));

        System.out.println(grouped3);
        System.out.println();

        // partitioningBy()
        System.out.println("-".repeat(20) + "partitioningBy()" + "-".repeat(20));
        var ohMy = Stream.of("Cobra", "Night Owl", "Snake", "Polar Bear");

        Map<Boolean, List<String>> partitioned = ohMy.collect(Collectors.partitioningBy(s -> s.split(" ").length == 1));

        System.out.println(partitioned);
        System.out.println("Animals with one-word names: " + partitioned.get(true));
        System.out.println("Animals with multi-word names: " + partitioned.get(false));

        List<String> zooAnimals = List.of("Antelope", "Cobra", "Night Owl", "Snake", "Polar Bear", "Zebra");
        Map<Boolean, Set<String>> partitioned2 = zooAnimals.stream().collect(Collectors.partitioningBy(s -> s.split(" ").length == 1, Collectors.toSet()));
        System.out.println(partitioned2);

        Map<Boolean, Long> partitioned3 = zooAnimals.stream().collect(Collectors.partitioningBy(s -> s.length() <= 6, Collectors.counting()));
        Map<Boolean, Long> partitioned4 = zooAnimals.stream().collect(Collectors.partitioningBy(s -> s.length() <= 6, MyCollector.count()));

        System.out.println(partitioned3);
        System.out.println(partitioned4);
        System.out.println();

        // minBy() and maxBy()
        System.out.println("-".repeat(20) + "minBy() and maxBy()" + "-".repeat(20));
        // to find the smaller/largest elements according to some Comparator
        Optional<String> shortestName = zooAnimals.stream().collect(Collectors.minBy((s1, s2) -> s1.length() - s2.length()));
        Optional<String> longestName = zooAnimals.stream().collect(Collectors.maxBy((s1, s2) -> s1.length() - s2.length()));

        Optional<String> largestString = zooAnimals.stream().collect(Collectors.maxBy(String::compareTo));
        Optional<String> smallestString = zooAnimals.stream().collect(Collectors.minBy(String::compareTo));

        System.out.println("shortest by # of chars: " + shortestName);
        System.out.println("shortest by alphabetic: " + smallestString);
        System.out.println("longest by # of chars: " + longestName);
        System.out.println("longest by alphabetic: " + largestString);
        System.out.println();

        // mapping()
        System.out.println("-".repeat(20) + "mapping()" + "-".repeat(20));
        Map<Integer, Optional<Character>> map = zooAnimals.stream().collect(
                Collectors.groupingBy(
                        String::length,
                        Collectors.mapping(
                                s -> s.charAt(0),
                                Collectors.minBy(Comparator.comparingInt(a -> a))
                        )
                )
        );

        // both vars are equivalent:
        var something = zooAnimals.stream().collect(Collectors.mapping(s -> s.length(), Collectors.toList()));
        var nonething = zooAnimals.stream().map(String::length).collect(Collectors.toList());

        System.out.println(something); // same outputs
        System.out.println(nonething);
    }

    static class MyCollector {
        public static <T> Collector<T, long[], Long> count() {
            Supplier<long[]> supplier = () -> new long[1];
            BiConsumer<long[], T> accumulator = (arr, el) -> arr[0] += 1L;
            BinaryOperator<long[]> combiner = (a1, a2) -> { a1[0] = a1[0] + a2[0]; return a1; };
            Function<long[], Long> finisher = (arr) -> arr[0];

            return Collector.of(supplier, accumulator, combiner, finisher);
        }
    }
}
