package org.example.chapter03.MyComparator;

import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

@FunctionalInterface
public interface MyComparatorLambda<T> {

    // отрицательное число, если o1 < o2; ноль, если o1 == o2; положительное, если o1 > o2
    int compare(T o1, T o2);

    // ==================== DEFAULT-МЕТОДЫ ====================

    default MyComparatorLambda<T> reversed() {
        return (o1, o2) -> compare(o2, o1);
    }

    default MyComparatorLambda<T> thenComparing(MyComparatorLambda<? super T> other) {
        return (o1, o2) -> {
            int res = this.compare(o1, o2);
            return (res != 0) ? res : other.compare(o1, o2);
        };
    }

    default <U> MyComparatorLambda<T> thenComparing(
            Function<? super T, ? extends U> keyExtractor,
            MyComparatorLambda<? super U> keyComparator) {
        return thenComparing(comparing(keyExtractor, keyComparator));
    }

    default <U extends Comparable<? super U>> MyComparatorLambda<T> thenComparing(
            Function<? super T, ? extends U> keyExtractor) {
        return thenComparing(comparing(keyExtractor));
    }

    default MyComparatorLambda<T> thenComparingInt(ToIntFunction<? super T> keyExtractor) {
        return thenComparing(comparingInt(keyExtractor));
    }

    default MyComparatorLambda<T> thenComparingLong(ToLongFunction<? super T> keyExtractor) {
        return thenComparing(comparingLong(keyExtractor));
    }

    default MyComparatorLambda<T> thenComparingDouble(ToDoubleFunction<? super T> keyExtractor) {
        return thenComparing(comparingDouble(keyExtractor));
    }

    // ==================== STATIC-МЕТОДЫ ====================

    static <T, U> MyComparatorLambda<T> comparing(
            Function<? super T, ? extends U> keyExtractor,
            MyComparatorLambda<? super U> keyComparator) {
        return (o1, o2) -> keyComparator.compare(keyExtractor.apply(o1), keyExtractor.apply(o2));
    }

    static <T, U extends Comparable<? super U>> MyComparatorLambda<T> comparing(
            Function<? super T, ? extends U> keyExtractor) {
        return comparing(keyExtractor, naturalOrder());
    }

    static <T> MyComparatorLambda<T> comparingInt(ToIntFunction<? super T> keyExtractor) {
        return (o1, o2) -> Integer.compare(keyExtractor.applyAsInt(o1), keyExtractor.applyAsInt(o2));
    }

    static <T> MyComparatorLambda<T> comparingLong(ToLongFunction<? super T> keyExtractor) {
        return (o1, o2) -> Long.compare(keyExtractor.applyAsLong(o1), keyExtractor.applyAsLong(o2));
    }

    static <T> MyComparatorLambda<T> comparingDouble(ToDoubleFunction<? super T> keyExtractor) {
        return (o1, o2) -> Double.compare(keyExtractor.applyAsDouble(o1), keyExtractor.applyAsDouble(o2));
    }

    static <T extends Comparable<? super T>> MyComparatorLambda<T> naturalOrder() {
        return (o1, o2) -> o1.compareTo(o2);
    }

    static <T extends Comparable<? super T>> MyComparatorLambda<T> reverseOrder() {
        return (o1, o2) -> o2.compareTo(o1);
    }

    static <T> MyComparatorLambda<T> nullsFirst(MyComparatorLambda<? super T> comparator) {
        return (o1, o2) -> {
            if (o1 == null && o2 == null) return 0;
            if (o1 == null) return -1;
            if (o2 == null) return 1;
            return comparator.compare(o1, o2);
        };
    }

    static <T> MyComparatorLambda<T> nullsLast(MyComparatorLambda<? super T> comparator) {
        return (o1, o2) -> {
            if (o1 == null && o2 == null) return 0;
            if (o1 == null) return 1;
            if (o2 == null) return -1;
            return comparator.compare(o1, o2);
        };
    }
}