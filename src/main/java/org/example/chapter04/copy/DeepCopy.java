package org.example.chapter04.copy;

import java.lang.reflect.Field;
import java.util.IdentityHashMap;

public class DeepCopy {
    public static Object copy(Object obj){
        return copy(obj, new IdentityHashMap<>());
    }

    private static Object copy(Object obj, IdentityHashMap<Object, Object> visited){
        if(obj == null) return null;

        Class<?> cl = obj.getClass();
        if (cl.isPrimitive() || cl == String.class || Number.class.isAssignableFrom(cl) || cl == Boolean.class) {
            return obj;
        }
        if (visited.containsKey(obj)) {
            return visited.get(obj);
        }

        try{
            var ctor = cl.getDeclaredConstructor();
            ctor.setAccessible(true);
            Object copy_obj = ctor.newInstance();

            visited.put(copy_obj, null);

            while(cl != null){
                for(Field field : cl.getDeclaredFields()){
                    field.setAccessible(true);
                    Object ordinal = field.get(obj);
                    Object copied = copy(ordinal, visited);
                    field.set(copy_obj, copied);
                }
                cl = cl.getSuperclass();
            }
            return copy_obj;
        }
        catch (Exception e){
            throw new RuntimeException("Не удалось скопировать объект " + obj.getClass().getName());
        }
    }

    static void main() {
        class User {
            private String info;
            User(String info){
                this.info = info;
            }
            public User() {}
        }

        class Message {
            private String body;
            private User sender;
            Message(String body, User sender){
                this.body = body;
                this.sender = sender;
            }
            public Message() {}
        }

        Message original = new Message("Hello, world", new User("Sasha"));
        Message clone = (Message) DeepCopy.copy(original);
        System.out.println(clone.sender.info + " - " + clone.body);
    }
}
