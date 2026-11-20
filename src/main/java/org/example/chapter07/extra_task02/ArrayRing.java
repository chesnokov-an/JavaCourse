package org.example.chapter07.extra_task02;

import java.util.AbstractCollection;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ArrayRing<E> extends AbstractCollection<E> implements Ring<E> {
    private Object[] elements = new Object[10];
    private int head; // индекс самого старого элемента
    private int size;

    @Override
    public boolean add(E element) {
        insertAt(size, element);
        return true;
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
    public RingIterator<E> iterator() {
        return new Itr(false);
    }

    @Override
    public RingIterator<E> ringIterator() {
        return new Itr(true);
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
        private final boolean cyclic;
        private int cursor;
        private int lastReturned = -1;

        Itr(boolean cyclic) {
            this.cyclic = cyclic;
        }

        @Override
        public boolean hasNext() {
            return cyclic ? size > 0 : cursor < size;
        }

        @Override
        public E next() {
            if (size == 0) {
                throw new NoSuchElementException();
            }
            if (cursor == size) {
                if (!cyclic) {
                    throw new NoSuchElementException();
                }
                cursor = 0;
            }
            E element = elementAt(cursor);
            lastReturned = cursor;
            cursor++;
            return element;
        }

        @Override
        public boolean hasPrevious() {
            return cyclic ? size > 0 : cursor > 0;
        }

        @Override
        public E previous() {
            if (size == 0) {
                throw new NoSuchElementException();
            }
            if (cursor == 0) {
                if (!cyclic) {
                    throw new NoSuchElementException();
                }
                cursor = size;
            }
            lastReturned = --cursor;
            return elementAt(cursor);
        }

        @Override
        public int nextIndex() {
            if (size == 0) {
                return 0;
            }
            return cyclic ? cursor % size : cursor;
        }

        @Override
        public int previousIndex() {
            if (size == 0) {
                return -1;
            }
            return cyclic ? (cursor - 1 + size) % size : cursor - 1;
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
