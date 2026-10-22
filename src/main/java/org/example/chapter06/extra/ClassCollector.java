package org.example.chapter06.extra;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.lang.instrument.Instrumentation;
import java.util.*;
import java.math.*;
import java.util.concurrent.atomic.*;

public class ClassCollector {

    static Instrumentation inst;

    Number number;
    CharSequence text;
    List<String> names;

    // Вызывается при запуске Java Agent
    public static void premain(String args, Instrumentation i) {
        inst = i;
    }

    public static List<Class<?>> getClasses(Field f) {
        List<Class<?>> result = new ArrayList<>();
        Class<?> type = f.getType();

        if (inst == null) {
            throw new IllegalStateException("Запустите программу с Java Agent");
        }

        for (Class<?> c : inst.getAllLoadedClasses()) {
            if (!c.isInterface()
                    && !c.isPrimitive()
                    && !Modifier.isAbstract(c.getModifiers())
                    && type.isAssignableFrom(c)) {
                result.add(c);
            }
        }
        result.sort((a, b) -> a.getName().compareTo(b.getName()));
        return result;
    }

    static void main() throws Exception {
        String[] fields = {"number", "text", "names"};
        for (String name : fields) {
            Field f = ClassCollector.class.getDeclaredField(name);
            System.out.println("\nПоле: " + name);
            for (Class<?> c : getClasses(f)) {
                System.out.println(c.getName());
            }
        }
    }
}

// javac -d out ClassCollector.java
// jar cfm app.jar MANIFEST.MF -C out .
// java -javaagent:app.jar -jar app.jar