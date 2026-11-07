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

        return candidates
                .filter(number -> number.isProbablePrime(100))
                .limit(count)
                .toList();
    }

    private static long measure(int count, boolean parallel) {
        long start = System.currentTimeMillis();
        List<BigInteger> primes = findPrimes(count, 50, parallel);
        long elapsed = System.currentTimeMillis() - start;

        System.out.println((parallel ? "parallel" : "sequential") + ": "
                + elapsed + " мс, найдено " + primes.size() + " простых чисел");
        return elapsed;
    }

    static void main() {
        long sequential = measure(500, false);
        long parallel = measure(500, true);
    }
}
