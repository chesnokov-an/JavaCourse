package org.example.chapter07.task17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckedView {
    @SuppressWarnings({"rawtypes", "unchecked"})
    static void main() {
        List<String> strings = Collections.checkedList(new ArrayList<>(), String.class);

        // Проверяемое представление обнаруживает ошибку в момент вставки
        // и сообщает, элемент какого типа пытались добавить
        try {
            List raw = strings;
            raw.add(42);
        } catch (ClassCastException e) {
            System.out.println("Проверяемое представление: " + e.getMessage());
        }

        // Без проверки ошибка проявляется позже, при извлечении элемента:
        // "куча" уже загрязнена
        List rawList = new ArrayList<String>();
        rawList.add(42);
        try {
            String value = (String) rawList.get(0);
            System.out.println(value);
        } catch (ClassCastException e) {
            System.out.println("Обычный список: " + e.getMessage());
        }
    }
}
