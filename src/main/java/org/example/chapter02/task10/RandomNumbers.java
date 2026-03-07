package org.example.chapter02.task10;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumbers {
    private static final Random random = new Random();

    public static int randomElement(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return array[random.nextInt(array.length)];
    }

    public static int randomElement(ArrayList<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return list.get(random.nextInt(list.size()));
    }

    static void main() {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Случайный элемент массива: " + RandomNumbers.randomElement(numbers));

        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("Случайный элемент списка: " + RandomNumbers.randomElement(list));
    }
}
