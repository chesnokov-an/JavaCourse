package org.example.chapter06.task05;

import java.util.Arrays;

public class Task05 {
    public static <T> T[] swap(int i, int j, T... values) {
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        return values;
    }

    static void main(){
//        Double[] result1 = swap(0, 1, 1.5, 2, 3);  // - не может вывести тип
//        Double[] result2 = Task05.<Double>swap(0, 1, 1.5, 2, 3);  // - не может принять integer, т.к. принимает double
        // для исправления надо привести инты к даблу

    }
}
