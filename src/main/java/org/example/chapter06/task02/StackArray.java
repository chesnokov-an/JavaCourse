package org.example.chapter06.task02;

import java.lang.reflect.Array;

public class StackArray<E> {
    private E[] elements;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public StackArray(Class<E> cl, int initialCapacity) {
        // Array.newInstance создаёт массив нужного типа без предупреждений
        elements = (E[]) Array.newInstance(cl, initialCapacity);
    }

    public void push(E item) {
        if (size == elements.length) {
            grow();
        }
        elements[size++] = item;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        E[] newArray = (E[]) Array.newInstance(
                elements.getClass().getComponentType(),
                elements.length * 2);
        System.arraycopy(elements, 0, newArray, 0, size);
        elements = newArray;
    }

    public E pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        E item = elements[--size];
        elements[size] = null;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    static void main() {
        StackArray<String> stack = new StackArray<>(String.class, 2);
        stack.push("1");
        stack.push("2");
        stack.push("3");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("empty? " + stack.isEmpty());
    }
}