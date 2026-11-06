package org.example.chapter08.task04;

import java.math.BigInteger;
import java.util.stream.Stream;

public class LinearCongruential {
    public static Stream<Long> randomStream(long a, long c, long m, long seed) {
        BigInteger multiplier = BigInteger.valueOf(a);
        BigInteger increment = BigInteger.valueOf(c);
        BigInteger modulus = BigInteger.valueOf(m);

        // a * x не помещается в long, поэтому вычисляем в BigInteger
        return Stream.iterate(BigInteger.valueOf(seed),
                        x -> x.multiply(multiplier).add(increment).mod(modulus))
                .map(BigInteger::longValue);
    }

    static void main() {
        Stream<Long> random = randomStream(25214903917L, 11, 1L << 48, 1);
        random.limit(10).forEach(System.out::println);
    }
}
