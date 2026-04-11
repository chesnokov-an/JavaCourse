package org.example.chapter03;

import java.util.*;

class Person {
    private final String name;
    public Person(String name) { this.name = name; }
    public String getName() { return name; }
}

public class MethodReference {
    static void main() {
        List<Person> people = Arrays.asList(
                new Person("Charlie"),
                new Person("Alice"),
                new Person("Bob")
        );

        people.sort(Comparator.comparing(Person::getName));

        for (Person p : people) {
            System.out.println(p.getName());
        }
    }
}
