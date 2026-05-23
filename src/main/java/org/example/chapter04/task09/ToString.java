package org.example.chapter04.task09;

import java.lang.reflect.Field;
import java.util.IdentityHashMap;

public class ToString {
    public static String toString(Object obj){
        return toString(obj, new IdentityHashMap<>());
    }

    private static String toString(Object obj, IdentityHashMap<Object, Object> visited){
        if(obj == null) return "null";
        Class<?> cl = obj.getClass();
        if(cl.isPrimitive() || cl == String.class ||
                Number.class.isAssignableFrom(cl) || cl == Boolean.class || cl == Character.class){
            return obj.toString();
        }
        if(visited.containsKey(obj)) return "...";
        visited.put(obj, null);

        StringBuilder sb = new StringBuilder();
        sb.append(cl.getSimpleName()).append("[");

        Field[] fields = cl.getDeclaredFields();
        for(int i = 0; i < fields.length; i++){
            fields[i].setAccessible(true);
            try{
                Object val = fields[i].get(obj);
                sb.append(fields[i].getName()).append("=");
                sb.append(toString(val, visited));
            }
            catch (IllegalAccessException e){
                sb.append("?");
            }
            if(i < fields.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    static void main(){
        class User {
            String info;
            public User(String info) { this.info = info; }
        }

        class Message {
            String body;
            User sender;
            Message self;
            Message(String body, User sender){
                this.body = body;
                this.sender = sender;
                self = this;
            }
        }
        Message m = new Message("Hi", new User("Sasha"));
        System.out.println(ToString.toString(m));
    }
}