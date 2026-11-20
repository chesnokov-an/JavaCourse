package org.example.chapter07.extra_task02;

import java.util.List;

public class Main {
    static void main() {
        demo(new ArrayRing<>());
        demo(new LinkedRing<>());
    }

    static void demo(Ring<String> ring) {
        String name = ring.getClass().getSimpleName();

        ring.addAll(List.of("A", "B", "C", "D"));
        System.out.println(name + ": " + ring);

        RingIterator<String> iterator = ring.ringIterator();
        iterator.next();            // A
        iterator.next();            // B
        iterator.set("b");
        iterator.add("X");          // A, b, X, C, D

        System.out.println("После set/add: " + ring);
        System.out.println("nextIndex = " + iterator.nextIndex()
                + ", previousIndex = " + iterator.previousIndex());

        for (int i = 0; i < 20; i++) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        for (int i = 0; i < 20; i++) {
            System.out.print(iterator.previous() + " ");
        }
        System.out.println();

        iterator.next();
        iterator.remove();
        System.out.println("После remove(): " + ring);

        System.out.println();
    }
}
