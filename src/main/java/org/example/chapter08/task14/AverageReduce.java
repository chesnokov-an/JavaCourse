package org.example.chapter08.task14;

import java.util.stream.Stream;

public class AverageReduce {
    private record SumCount(double sum, long count) {
        SumCount add(double value) {
            return new SumCount(sum + value, count + 1);
        }

        SumCount add(SumCount other) {
            return new SumCount(sum + other.sum, count + other.count);
        }

        double average() {
            return count == 0 ? 0 : sum / count;
        }
    }

    public static double average(Stream<Double> stream) {
        return stream.reduce(
                        new SumCount(0, 0),
                        (result, value) -> result.add(value),
                        SumCount::add)
                .average();
    }

    static void main() {
        System.out.println(average(Stream.of(1.0, 2.0, 3.0, 4.0)));

        Stream<Double> values = Stream.of(1.0, 2.0, 3.0);
        double sum = values.reduce(0.0, Double::sum);
        System.out.println("Сумма: " + sum);

        // Поток одноразовый: после reduce() вызвать count() уже нельзя
        try {
            values.count();
        } catch (IllegalStateException e) {
            System.out.println("Повторное использование потока: " + e.getClass().getSimpleName());
        }
    }
}
