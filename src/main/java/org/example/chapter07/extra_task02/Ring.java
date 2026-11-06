package org.example.chapter07.extra_task02;

/**
 * Неограниченное кольцо: элементы хранятся в порядке добавления,
 * remove() удаляет самый старый, iterator() — полноценный ListIterator.
 */
public interface Ring<E> extends Iterable<E> {
    void add(E element);

    E remove();

    E get(int index);

    int size();

    boolean isEmpty();

    @Override
    RingIterator<E> iterator();
}
