package org.example.chapter03.task01;

// record class, т.к. финальные поля, нужны геттеры и конструктор от всех аргументов
public record Employee(String name, double salary) implements Measurable {

    @Override
    public double getMeasure() {
        return salary;
    }

    public static double average(Measurable[] objects) {
        if (objects == null || objects.length == 0) return 0;
        double sum = 0;
        for (Measurable obj : objects) {
            sum += obj.getMeasure();
        }
        return sum / objects.length;
    }

    public static Measurable largest(Measurable[] objects) {
        if (objects == null || objects.length == 0) return null;
        Measurable max = objects[0];
        for (int i = 1; i < objects.length; i++) {
            if (objects[i].getMeasure() > max.getMeasure()) {
                max = objects[i];
            }
        }
        return max;
    }

    static void main() {
        Measurable[] employees = {
                new Employee("Иван", 85000),
                new Employee("Мария", 92000),
                new Employee("Петр", 78000)
        };
        double avgSalary = average(employees);
        System.out.printf("Средняя зарплата: %f%n", avgSalary);

        Measurable highest = largest(employees);
        if (highest != null) {
            Employee top = (Employee) highest;
            System.out.printf("Самая высокая зарплата: %f у %s\n", top.getMeasure(), top.name());
        }
    }
}