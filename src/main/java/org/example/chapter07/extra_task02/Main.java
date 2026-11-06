package org.example.chapter07.extra_task02;

public class Main {
    static void main() {
        demo(new ArrayRing<>());
        demo(new LinkedRing<>());
    }

    static void demo(Ring<String> ring) {
        ring.add("A");
        ring.add("B");
        ring.add("C");
        ring.add("D");

        RingIterator<String> iterator = ring.iterator();
        iterator.next();
        iterator.next();
        iterator.set("b");
        iterator.add("X");

        System.out.println(ring.getClass().getSimpleName() + ": " + ring);
        System.out.println("nextIndex = " + iterator.nextIndex()
                + ", previousIndex = " + iterator.previousIndex());

        iterator.next();
        iterator.remove();
        System.out.println("После remove: " + ring);

        while (iterator.hasPrevious()) {
            System.out.print(iterator.previous() + " ");
        }
        System.out.println();
    }
}
