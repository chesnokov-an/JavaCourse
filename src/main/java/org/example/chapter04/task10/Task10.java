package org.example.chapter04.task10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Task10 {
    static void main() {
        Class<?> cl = int[].class;
        while (cl != null) {
            for (Method m : cl.getDeclaredMethods()) {
                System.out.println(Modifier.toString(m.getModifiers()) + " " +
                        m.getReturnType().getCanonicalName() + " " +
                        m.getName());
            }
            cl = cl.getSuperclass();
        }
        System.out.println();

        try{
            Method cloneMethod = int[].class.getMethod("clone");
            System.out.println("clone найден:" + cloneMethod);
        }
        catch (NoSuchMethodException e) {
            System.out.println("clone не найден");
        }
    }
}
