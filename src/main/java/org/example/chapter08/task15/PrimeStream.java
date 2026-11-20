package org.example.chapter08.task15;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimeStream {
    public static List<BigInteger> findPrimes(int count, int digits, boolean parallel) {
        BigInteger start = BigInteger.TEN.pow(digits - 1).add(BigInteger.ONE);
        Stream<BigInteger> candidates = LongStream.range(0, Long.MAX_VALUE)
                .mapToObj(i -> start.add(BigInteger.TWO.multiply(BigInteger.valueOf(i))));
        if (parallel) {
            // unordered позволяет не сохранять порядок и эффективно распараллелить limit()
            candidates = candidates.parallel().unordered();
        }
        return candidates.filter(number -> number.isProbablePrime(100))
                         .limit(count)
                         .toList();
    }

    private static void measure(boolean parallel) {
        long start = System.currentTimeMillis();
        List<BigInteger> primes = findPrimes(500, 50, parallel);
        long elapsed = System.currentTimeMillis() - start;

        System.out.println((parallel ? "параллельно" : "последовательно") + ": " + elapsed + " мс");
    }

    static void main() {
        measure(false);
        measure(true);
    }
}
