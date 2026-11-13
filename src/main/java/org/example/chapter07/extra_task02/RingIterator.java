package org.example.chapter07.extra_task02;

import java.util.ListIterator;

/**
 * Полноценный итератор кольца: поддерживает все операции ListIterator.
 * next() и previous() на границах бросают NoSuchElementException,
 * как и положено по контракту ListIterator.
 */
public interface RingIterator<E> extends ListIterator<E> {}
