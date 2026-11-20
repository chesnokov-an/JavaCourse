package org.example.chapter07.extra_task02;

import java.util.AbstractCollection;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedRing<E> extends AbstractCollection<E> implements Ring<E> {
    private static class Node<E> {
        E value;
        Node<E> prev;
        Node<E> next;

        Node(E value) {
            this.value = value;
        }
    }

    private Node<E> head; // самый старый элемент
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
        return nodeAt(Objects.checkIndex(index, size)).value;
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
        Node<E> node = new Node<>(element);
        if (size == 0) {
            head = node;
            node.prev = node.next = node;
        } else {
            Node<E> next = index == size ? head : nodeAt(index);
            Node<E> prev = next.prev;
            prev.next = node;
            node.prev = prev;
            node.next = next;
            next.prev = node;
            if (index == 0) {
                head = node;
            }
        }
        size++;
    }

    private E removeAt(int index) {
        Node<E> node = nodeAt(index);
        E element = node.value;
        if (size == 1) {
            head = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            if (node == head) {
                head = node.next;
            }
        }
        node.value = null;
        node.prev = null;
        node.next = null;
        size--;
        return element;
    }

    private void setAt(int index, E element) {
        nodeAt(index).value = element;
    }

    private Node<E> nodeAt(int index) {
        if (index < size / 2) {
            Node<E> node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }
        Node<E> node = head.prev;
        for (int i = size - 1; i > index; i--) {
            node = node.prev;
        }
        return node;
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
            E element = nodeAt(cursor).value;
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
            return nodeAt(cursor).value;
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
            LinkedRing.this.removeAt(lastReturned);
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
            LinkedRing.this.setAt(lastReturned, element);
        }

        @Override
        public void add(E element) {
            LinkedRing.this.insertAt(cursor, element);
            cursor++;
            lastReturned = -1;
        }
    }
}
