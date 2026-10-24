package org.example.chapter06.task17;

public class Employee implements Comparable<Employee> {
    private final String name;
    private final double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.salary, other.salary);
    }

    static void main() {
        Employee a = new Employee("Alice", 5000);
        Employee b = new Employee("Bob", 4000);
        Comparable<Employee> c = a;
        System.out.println(c.compareTo(b)); // без мостового метода вызов через интерфейсную ссылку не нашёл бы нужный метод
    }
}

// javac Employee.java
// javap -c -p Employee

// public int compareTo(org.example.chapter06.task17.Employee);
// public int compareTo(java.lang.Object);