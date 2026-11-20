package org.example.chapter07.extra_task02;

import java.util.ListIterator;

/**
 * Итератор кольца. В обычном режиме (iterator()) он конечный, как требует Collection.
 * В режиме ringIterator() методы hasNext() и hasPrevious() всегда возвращают true,
 * а next() и previous() зациклены и никогда не бросают NoSuchElementException
 * (кроме пустого кольца).
 */
public interface RingIterator<E> extends ListIterator<E> {}
