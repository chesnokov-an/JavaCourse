package org.example.chapter02.task11;

import static java.lang.System.out;
import static java.time.LocalDate.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Calendar {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        out.print("Введите месяц (1-12): ");
        int month = scanner.nextInt();
        out.print("Введите год: ");
        int year = scanner.nextInt();
        out.println(" Sun Mon Tue Wed Thu Fri Sat");

        LocalDate date = of(year, month, 1);
        DayOfWeek weekday = date.getDayOfWeek();
        int offset = weekday.getValue() % 7;

        for (int i = 0; i < offset; i++) {
            out.print("    ");
        }

        while (date.getMonthValue() == month) {
            out.printf("%4d", date.getDayOfMonth());
            date = date.plusDays(1);
            if ((offset + date.getDayOfMonth() - 1) % 7 == 0) {
                out.println();
            }
        }
        out.println();
    }
}
