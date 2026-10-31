package org.example.chapter07.task18;

import java.util.Collections;
import java.util.List;

public class EmptyCollections {
    // EMPTY_LIST — константа сырого типа List, поэтому любое присваивание
    // параметризованному типу является непроверяемым (unchecked)
    @SuppressWarnings("unchecked")
    static void main() {
        List<String> fromConstant = Collections.EMPTY_LIST;
        List<Integer> alsoFromConstant = Collections.EMPTY_LIST;

        // emptyList() — обобщённый метод: тип выводится из контекста
        List<String> fromMethod = Collections.emptyList();
        List<Integer> alsoFromMethod = Collections.<Integer>emptyList();

        System.out.println("EMPTY_LIST: " + fromConstant + " / " + alsoFromConstant);
        System.out.println("emptyList(): " + fromMethod + " / " + alsoFromMethod);
        System.out.println("EMPTY_LIST — константа сырого типа List, поэтому присваивание требует unchecked-преобразования");
        System.out.println("emptyList() — обобщённый метод, тип параметра выводится компилятором");

        printStrings(Collections.emptyList());
    }

    static void printStrings(List<String> strings) {
        System.out.println("Получен список строк: " + strings);
    }
}
