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
// Компилятор по сигнатуре функционального интерфейса определяет как вызывать метод:

//  Class::instanceMethod	        (obj, args...) -> obj.method(args...)
//  Class::staticMethod	            (args...) -> Class.method(args...)
//  obj::instanceMethod	            (args...) -> obj.method(args...)

// Class::method => первый аргумент становится this
// obj::method => this уже есть

// Из 4 Главы:

// super::instanceMethod            (args...) -> super.method(args...)

// Важно! super связан с this, поэтому такую ссылку нельзя использовать в static-методах
// Важно! тут нет динамического полиморфизма: super::instanceMethod всегда вызывает метод родителя,
// даже если в наследнике он @override