package ocp_1Z0_819.chapter4.streams;

import java.util.Optional;
import java.util.function.*;
import java.util.stream.Collector;

public interface Temp<T> { // imagine that Temp is Stream ;)

    T reduce(T identity, BinaryOperator<T> accumulator);

    Optional<T> reduce (BinaryOperator<T> accumulator);

    <U> U reduce(U identity,
                 BiFunction<U, ? super T, U> accumulator,
                 BinaryOperator<U> combiner);

    <R> R collect(Supplier<R> supplier,
                  BiConsumer<R, ? super T> accumulator,
                  BiConsumer<R, R> combiner);

    <R, A> R collect(Collector<? super T, A, R> collector);
}
