package org.example.chapter03.task15;

import org.example.chapter03.task04.IntSequence;
import java.util.random.RandomGenerator;

public class NestedClassDemo {
    private static final RandomGenerator generator = RandomGenerator.getDefault();

    private record RandomSequence(int low, int high) implements IntSequence {
        @Override
            public int next() {
                return low + generator.nextInt(high - low + 1);
            }
        }

    public static IntSequence randomInts(int low, int high) {
        return new RandomSequence(low, high);
    }

    static void main() {
        IntSequence rand = randomInts(1, 6);
        for (int i = 0; i < 10; i++) {
            System.out.println(rand.next());
        }
    }
}
