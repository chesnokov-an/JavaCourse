package org.example.chapter03.method_reference;

import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReference {
    static class Person {
        String name;
        Person(String name) { this.name = name; }
        String getName() { return name; }
        static String getStaticName(Person p) { return p.name; }
    }

//    interface MyFunction {
//        String apply(Person p);
//    }
//
//    interface NameSupplier { String get(); }

    static void main() {
        Person obj = new Person("Sasha");

        // 1. Класс::МетодЭкземпляра
        // obj передаётся как получатель метода getName() ~ obj.getName()
        Function<Person, String> f1 = Person::getName;
        System.out.println(f1.apply(obj));

        // 2. Класс::СтатическийМетод
        // obj передаётся как явный аргумент в статический метод ~ Person.getStaticName(obj)
        Function<Person, String> f2 = Person::getStaticName;
        System.out.println(f2.apply(obj));

        // 3. Объект::МетодЭкземпляра
        // ~ obj.getName()
        Supplier<String> f3 = obj::getName;
        System.out.println(f3.get());
    }
}