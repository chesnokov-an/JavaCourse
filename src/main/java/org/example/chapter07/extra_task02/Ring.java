package org.example.chapter07.extra_task02;

import java.util.Collection;

/**
 * Кольцо: коллекция с доступом по индексу.
 * add() добавляет элемент в конец, remove() удаляет самый старый элемент.
 * Итератор конечный и подчиняется обычным правилам Collection/ListIterator.
 */
public interface Ring<E> extends Collection<E> {
    @Override
    boolean add(E element);

    E remove();

    E get(int index);

    @Override
    RingIterator<E> iterator();
}
