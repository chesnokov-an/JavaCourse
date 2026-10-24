package org.example.chapter06.task01;

public class LinkedStack<E> {
    private Node<E> head;

    private record Node<E>(E value, Node<E> next) {}

    public void push(E item) {
        head = new Node<>(item, head);
    }

    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        E value = head.value;
        head = head.next;
        return value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    static void main() {
        LinkedStack<String> stack = new LinkedStack<>();
        System.out.println("empty? " + stack.isEmpty());

        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println("empty? " + stack.isEmpty());

        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("pop: " + stack.pop());
        System.out.println("empty? " + stack.isEmpty());

        try {
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println("ex: " + e.getMessage());
        }
    }
}
