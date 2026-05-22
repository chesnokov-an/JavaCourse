package org.example.chapter04.proxy;

import java.lang.reflect.*;

public class ProxyExample {
    interface Sayeble {
        String say(String name);
    }

    interface Writeble {
        String write(String message);
    }

    static class HelloImpl implements Sayeble, Writeble {
        public String say(String name) {
            return "Привет, " + name + "!";
        }

        public String write(String message) {
            return "Сообщение: " + message + ".";
        }
    }

    static void main() {
        HelloImpl real = new HelloImpl();

        Object proxy = (Sayeble) Proxy.newProxyInstance(
                ProxyExample.class.getClassLoader(),
                real.getClass().getInterfaces(),
                (Object p, Method m, Object[] a) -> {
                    System.out.println("[ПРОКСИ] Вызван метод: " + m.getName());
                    Object result = m.invoke(real, a);
                    System.out.println("[ПРОКСИ] Результат: " + result);
                    return result;
                }
        );

//        System.out.println(proxy.say("Мир"));
//        System.out.println(proxy.write("Мир"));
    }
}