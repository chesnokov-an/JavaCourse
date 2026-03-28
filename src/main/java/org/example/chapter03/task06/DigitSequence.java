package org.example.chapter03.task06;

import java.util.Iterator;

public class DigitSequence implements Iterator<Integer> {
    private int current = 0;

    @Override
    public boolean hasNext() {
        int max = 9;
        return current <= max;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        return current++;
    }

    @Override
    public void remove() {}

    static void main() {
        // Старый способ: while + hasNext/next
        System.out.println("Перебор через hasNext/next:");
        DigitSequence ds = new DigitSequence();
        while (ds.hasNext()) {
            System.out.print(ds.next() + " ");
        }
        System.out.println();

        // Новый способ (Java 8+): forEachRemaining
        System.out.println("Перебор через forEachRemaining:");
        DigitSequence ds2 = new DigitSequence();
        ds2.forEachRemaining(System.out::print);
        System.out.println();

        // Проверим remove
        DigitSequence ds3 = new DigitSequence();
        ds3.next();
        ds3.remove();
        System.out.println("remove() вызван без ошибок");
    }
}

/*

В Java 8 в интерфейс Iterator были добавлены default-методы forEachRemaining и remove =>
класс, реализующий интерфейс, может их не переопределять — они уже имеют реализацию по умолчанию.

Если скомпилировать DigitSequence в Java 7, поместить в JAR и запустить в Java 8, всё будет работать.
Виртуальная машина Java 8 загрузит класс, и при вызове hasNext() и next() будет использоваться код из класса,
а при вызове forEachRemaining() — реализация по умолчанию из интерфейса.

Метод forEachRemaining() работает корректно,
так как его реализация по умолчанию использует hasNext() и next() класса.

При вызове remove() будет выполняться наша пустая реализация, а не default-метод из интерфейса, т.к. мы переопределили метод.
 */