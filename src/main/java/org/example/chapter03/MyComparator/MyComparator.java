package org.example.chapter03.MyComparator;

import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public abstract class MyComparator<T> {

    // отрицательное число, если o1 < o2; ноль, если o1 == o2; положительное, если o1 > o2
    public abstract int compare(T o1, T o2);

    public MyComparator<T> reversed() {
        return new MyComparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return MyComparator.this.compare(o2, o1);
            }
        };
    }

    public MyComparator<T> thenComparing(MyComparator<? super T> other) {
        return new MyComparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                int res = MyComparator.this.compare(o1, o2);
                return (res != 0) ? res : other.compare(o1, o2);
            }
        };
    }

    public <U> MyComparator<T> thenComparing(Function<? super T, ? extends U> keyExtractor, MyComparator<? super U> keyComparator) {
        return thenComparing(comparing(keyExtractor, keyComparator));
    }

    public <U extends Comparable<? super U>> MyComparator<T> thenComparing(Function<? super T, ? extends U> keyExtractor) {
        return thenComparing(comparing(keyExtractor));
    }

    public MyComparator<T> thenComparingInt(ToIntFunction<? super T> keyExtractor) {
        return thenComparing(comparingInt(keyExtractor));
    }

    public MyComparator<T> thenComparingLong(ToLongFunction<? super T> keyExtractor) {
        return thenComparing(comparingLong(keyExtractor));
    }

    public MyComparator<T> thenComparingDouble(ToDoubleFunction<? super T> keyExtractor) {
        return thenComparing(comparingDouble(keyExtractor));
    }

    public static <T, U> MyComparator<T> comparing(Function<? super T, ? extends U> keyExtractor,MyComparator<? super U> keyComparator) {
        return new MyComparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return keyComparator.compare(keyExtractor.apply(o1), keyExtractor.apply(o2));
            }
        };
    }

    public static <T, U extends Comparable<? super U>> MyComparator<T> comparing(Function<? super T, ? extends U> keyExtractor) {
        return comparing(keyExtractor, naturalOrder());
    }

    public static <T> MyComparator<T> comparingInt(ToIntFunction<? super T> keyExtractor) {
        return new MyComparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return Integer.compare(keyExtractor.applyAsInt(o1), keyExtractor.applyAsInt(o2));
            }
        };
    }

    public static <T> MyComparator<T> comparingLong(ToLongFunction<? super T> keyExtractor) {
        return new MyComparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return Long.compare(keyExtractor.applyAsLong(o1), keyExtractor.applyAsLong(o2));
            }
        };
    }

    public static <T> MyComparator<T> comparingDouble(ToDoubleFunction<? super T> keyExtractor) {
        return new MyComparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return Double.compare(keyExtractor.applyAsDouble(o1), keyExtractor.applyAsDouble(o2));
            }
        };
    }

    public static <T extends Comparable<? super T>> MyComparator<T> naturalOrder() {
        return new MyComparator<T>() {
            @Override
            public int compare(T o1, T o2) { return o1.compareTo(o2); }
        };
    }

    public static <T extends Comparable<? super T>> MyComparator<T> reverseOrder() {
        return new MyComparator<T>() {
            @Override
            public int compare(T o1, T o2) { return o2.compareTo(o1); }
        };
    }

    public static <T> MyComparator<T> nullsFirst(MyComparator<? super T> comparator) {
        return new MyComparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1 == null && o2 == null) return 0;
                if (o1 == null) return -1;
                if (o2 == null) return 1;
                return comparator.compare(o1, o2);
            }
        };
    }

    public static <T> MyComparator<T> nullsLast(MyComparator<? super T> comparator) {
        return new MyComparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1 == null && o2 == null) return 0;
                if (o1 == null) return 1;
                if (o2 == null) return -1;
                return comparator.compare(o1, o2);
            }
        };
    }
}
