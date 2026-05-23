package org.example.chapter04.task11;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Task11{
    static void main() throws Exception {
        Field outField = System.class.getDeclaredField("out");
        outField.setAccessible(true);
        Object out = outField.get(null);

        Method printlnMethod = out.getClass().getMethod("println", String.class);

        printlnMethod.invoke(out, "Hello, World");
    }
}