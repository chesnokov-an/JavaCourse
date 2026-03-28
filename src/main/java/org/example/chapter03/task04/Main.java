package org.example.chapter03.task04;

public class Main {
    static void main() {
        IntSequence seq = IntSequence.of(3, 1, 4, 1, 5, 9);
        while (seq.hasNext()) {
            System.out.print(seq.next() + " ");
        }
        System.out.println();

        IntSequence ones = IntSequence.constant(1);
        for (int i = 0; i < 10; i++) {
            System.out.print(ones.next() + " ");
        }
        System.out.println();

        IntSequence twos = IntSequence.constantLambda(2);
        for (int i = 0; i < 10; i++) {
            System.out.print(twos.next() + " ");
        }
        System.out.println();
    }
}
