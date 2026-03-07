package org.example.chapter02.task16;

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

    public class Iterator {
        private Node current = head;

        public boolean hasNext() {
            return current != null;
        }

        public String next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            String data = current.data;
            current = current.next;
            return data;
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

        Queue.Iterator it = queue.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\nУдаляем элементы:");
        System.out.println("Удалён: " + queue.remove());
        System.out.println("Удалён: " + queue.remove());
        System.out.println("Удалён: " + queue.remove());
        System.out.println("Очередь пуста? " + queue.isEmpty());
    }
}

// Node должен быть статическим:
// - Узлы не нуждаются в доступе к внешнему классу Queue

// Итератору нужен доступ к полю head конкретного экземпляра Queue