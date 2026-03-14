package org.example.chapter02.task16;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class Queue {
    private static class Node {
        String data;
        Node next;
        Node(String data) { this.data = data; }
    }

    private Node head;
    private Node tail;

    public void add(String item) {
        Node newNode = new Node(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public String remove() {
        if (head == null) return null;
        String data = head.data;
        head = head.next;
        if (head == null) tail = null;
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public class Iterator implements java.util.Iterator<String> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            String data = current.data;
            current = current.next;
            return data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override
        public void forEachRemaining(Consumer<? super String> action) {
            while (hasNext()) {
                action.accept(next());
            }
        }
    }

    public Iterator iterator() {
        return new Iterator();
    }

    static void main() {
        Queue queue = new Queue();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");

        Queue.Iterator it = queue.iterator();
        it.forEachRemaining(System.out::println);

        System.out.println("\nRemove elements:");
        System.out.println("Removed: " + queue.remove());
        System.out.println("Is queue empty? " + queue.isEmpty());

        Queue.Iterator it2 = queue.iterator();
        if (it2.hasNext()) it2.next();
        it2.forEachRemaining(s -> System.out.println("Stayed: " + s));
    }
}

// Node должен быть статическим:
// - Узлы не нуждаются в доступе к внешнему классу Queue

// Итератору нужен доступ к полю head конкретного экземпляра Queue