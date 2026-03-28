package org.example.chapter03.task14;

import org.example.chapter03.task01.Employee;
import java.util.Arrays;
import java.util.Comparator;

public class EmployeeSort {
    static void main() {
        Employee[] employees = {
                new Employee("Alice", 5000),
                new Employee("Bob", 4000),
                new Employee("Charlie", 5000),
                new Employee("David", 4500)
        };

        // Сортировка по возрастанию зарплаты, затем по имени
        Comparator<Employee> bySalary = Comparator.comparingDouble(Employee::salary);
        Comparator<Employee> byName = Comparator.comparing(Employee::name);
        Comparator<Employee> salaryThenName = bySalary.thenComparing(byName);

        Arrays.sort(employees, salaryThenName);
        for (Employee e : employees) System.out.println(e);
        System.out.println("---------------------");

        // Сортировка в обратном порядке (убывание зарплаты, затем убывание имени)
        Comparator<Employee> reverse = salaryThenName.reversed();
        Arrays.sort(employees, reverse);
        for (Employee e : employees) System.out.println(e);
    }
}
