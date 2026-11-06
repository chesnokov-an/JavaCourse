package org.example.chapter06.extra;

import java.lang.reflect.Field;
import java.util.*;
import java.lang.instrument.Instrumentation;

public class ClassCollector {

    static class Person{}

    static class Manager extends Person {}

    Number number; // тестовые поля
    CharSequence text;
    List<String> names;
    Map<Person, List<? extends Person>> map;

    static Instrumentation inst;

    public static void premain(String args, Instrumentation i) {
        inst = i;
    }

    public static List<Class<?>> getClasses(Field f) {
        List<Class<?>> result = new ArrayList<>();
        Class<?> type = f.getType();

        if (inst == null) {
            throw new IllegalStateException("java agent не запущен");
        }

        for (Class<?> c : inst.getAllLoadedClasses()) {
            if (!c.isInterface()
                    && !c.isPrimitive()
                    && type.isAssignableFrom(c)) {
                result.add(c);
            }
        }
        result.sort(Comparator.comparing(Class::getName));
        return result;
    }

    public static void main(String[] args) throws Exception {
        String[] fields = {"number", "text", "names", "map"};
        Class<?> ignored = TestClass.class;
        for (String name : fields) {
            Field f = ClassCollector.class.getDeclaredField(name);
            System.out.println("\nПоле: " + name);
            for (Class<?> c : getClasses(f)) {
                System.out.println(c.getName());
            }
        }
    }

    static class TestClass implements Map<Person, List<? extends Person>>{
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean containsKey(Object key) {
            return false;
        }

        @Override
        public boolean containsValue(Object value) {
            return false;
        }

        @Override
        public List<? extends Person> get(Object key) {
            return List.of();
        }

        @Override
        public List<? extends Person> remove(Object key) {
            return List.of();
        }

        @Override
        public void clear() {

        }

        @Override
        public Set<Person> keySet() {
            return Set.of();
        }

        @Override
        public Collection<List<? extends Person>> values() {
            return List.of();
        }

        @Override
        public Set<Entry<Person, List<? extends Person>>> entrySet() {
            return Set.of();
        }

        @Override
        public void putAll(Map<? extends Person, ? extends List<? extends Person>> m) {

        }

        @Override
        public List<? extends Person> put(Person key, List<? extends Person> value) {
            return List.of();
        }
    }
}

// javac -d out ClassCollector.java
// jar cfm app.jar MANIFEST.MF -C out .
// java -javaagent:app.jar -jar app.jar