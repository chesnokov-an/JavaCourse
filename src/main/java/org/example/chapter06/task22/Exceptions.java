package org.example.chapter06.task22;

import java.util.concurrent.Callable;

public class Exceptions {
    public static <V, T extends Throwable> V doWork(Callable<V> c, Class<T> exClass) throws T {
        try {
            return c.call();
        } catch (Throwable realEx) {
            T ex;
            try {
                ex = exClass.getDeclaredConstructor().newInstance();
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("can't construct " + exClass.getName(), e);
            }
            ex.initCause(realEx);
            throw ex;
        }
    }

    static void main() {
        try {
            String ok = doWork(() -> "всё хорошо", RuntimeException.class);
            System.out.println(ok);
        } catch (Throwable t) {
            System.out.println("Ошибка: " + t);
        }

        try {
            doWork(() -> {
                throw new java.io.IOException("файл не найден");
            }, RuntimeException.class);
        } catch (Throwable t) {
            System.out.println("Тип: " + t.getClass().getSimpleName());
            System.out.println("Причина: " + t.getCause());
        }
    }
}