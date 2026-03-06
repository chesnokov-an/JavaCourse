package org.example.chapter02.task01;

import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.Scanner;

public class Task01 {
    static void main() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите месяц (1-12): ");
        int month = in.nextInt();
        System.out.print("Введите год: ");
        int year = in.nextInt();

        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

        LocalDate date = LocalDate.of(year, month, 1);
        DayOfWeek weekday = date.getDayOfWeek();
        int offset = weekday.getValue() % 7;

        for (int i = 0; i < offset; i++) {
            System.out.print("    ");
        }

        while (date.getMonthValue() == month) {
            System.out.printf("%4d", date.getDayOfMonth());
            date = date.plusDays(1);
            if ((offset + date.getDayOfMonth() - 1) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}