package org.example.chapter07.extra_task02;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.StringJoiner;

public class ArrayRing<E> implements Ring<E> {
    private Object[] elements = new Object[10];
    private int head; // индекс самого старого элемента
    private int size;

    @Override
    public void add(E element) {
        insertAt(size, element);
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Ring is empty");
        }
        return removeAt(0);
    }

    @Override
    public E get(int index) {
        return elementAt(Objects.checkIndex(index, size));
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public RingIterator<E> iterator() {
        return new Itr();
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ", "[", "]");
        for (E element : this) {
            result.add(String.valueOf(element));
        }
        return result.toString();
    }

    private void insertAt(int index, E element) {
        ensureCapacity();
        for (int i = size; i > index; i--) {
            elements[physicalIndex(i)] = elements[physicalIndex(i - 1)];
        }
        elements[physicalIndex(index)] = element;
        size++;
    }

    private E removeAt(int index) {
        E element = elementAt(index);
        for (int i = index; i < size - 1; i++) {
            elements[physicalIndex(i)] = elements[physicalIndex(i + 1)];
        }
        elements[physicalIndex(size - 1)] = null;
        size--;
        return element;
    }

    private void setAt(int index, E element) {
        elements[physicalIndex(index)] = element;
    }

    private void ensureCapacity() {
        if (size < elements.length) {
            return;
        }
        Object[] newElements = new Object[elements.length * 2];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[physicalIndex(i)];
        }
        elements = newElements;
        head = 0;
    }

    private int physicalIndex(int index) {
        return (head + index) % elements.length;
    }

    @SuppressWarnings("unchecked")
    private E elementAt(int index) {
        return (E) elements[physicalIndex(index)];
    }

    private class Itr implements RingIterator<E> {
        private int cursor;
        private int lastReturned = -1;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E element = elementAt(cursor);
            lastReturned = cursor;
            cursor++;
            return element;
        }

        @Override
        public boolean hasPrevious() {
            return cursor > 0;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            lastReturned = --cursor;
            return elementAt(cursor);
        }

        @Override
        public int nextIndex() {
            return cursor;
        }

        @Override
        public int previousIndex() {
            return cursor - 1;
        }

        @Override
        public void remove() {
            if (lastReturned < 0) {
                throw new IllegalStateException();
            }
            ArrayRing.this.removeAt(lastReturned);
            if (lastReturned < cursor) {
                cursor--;
            }
            lastReturned = -1;
        }

        @Override
        public void set(E element) {
            if (lastReturned < 0) {
                throw new IllegalStateException();
            }
            ArrayRing.this.setAt(lastReturned, element);
        }

        @Override
        public void add(E element) {
            ArrayRing.this.insertAt(cursor, element);
            cursor++;
            lastReturned = -1;
        }
    }
}
