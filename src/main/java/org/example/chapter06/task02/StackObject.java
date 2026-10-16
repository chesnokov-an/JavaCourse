package org.example.chapter06.task02;

public class StackObject<E> {
    private Object[] elements;
    private int size = 0;

    public StackObject(int initialCapacity) {
        elements = new Object[initialCapacity];
    }

    public void push(E item) {
        if (size == elements.length) {
            grow();
        }
        elements[size++] = item;
    }

    private void grow() {
        Object[] newArray = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, size);
        elements = newArray;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        E item = (E) elements[--size];
        elements[size] = null;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    static void main() {
        StackObject<String> stack = new StackObject<>(2);
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("empty? " + stack.isEmpty());
    }
}