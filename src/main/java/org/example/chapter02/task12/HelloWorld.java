package org.example.chapter02.task12;

public class HelloWorld {
    static void main() {
        System.out.println("Hello, World!");
    }
}

// :~/JavaCourse/src/main/java/org/example/chapter02/task12$ javac HelloWorld.java
// файл класса в этом же каталоге

// ~/JavaCourse/src/main/java/org/example/chapter02/task12$ java HelloWorld
// Error: Could not find or load main class HelloWorld
// Caused by: java.lang.NoClassDefFoundError: HelloWorld (wrong name: org/example/chapter02/task12/HelloWorld)

// ~/JavaCourse/src/main/java/org/example/chapter02/task12$ javap HelloWorld
// Warning: File ./HelloWorld.class does not contain class HelloWorld
// Compiled from "HelloWorld.java"
// public class org.example.chapter02.task12.HelloWorld {
//   public org.example.chapter02.task12.HelloWorld();
//     static void main();
// }

// ~/JavaCourse/src/main/java/org/example/chapter02/task12$ javac -d . HelloWorld.java
// создался каталог org/example/chapter02/task12, соответствующий пакету, относительно указанного каталога