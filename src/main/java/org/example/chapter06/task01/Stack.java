package org.example.chapter06.task01;

import java.util.ArrayList;

public class Stack<E> {
    private final ArrayList<E> elements = new ArrayList<>();

    public void push(E item) {
        elements.add(item);
    }

    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.removeLast();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    static void main() {
        Stack<String> stack = new Stack<>();
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