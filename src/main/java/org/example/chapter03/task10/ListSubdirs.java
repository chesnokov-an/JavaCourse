package org.example.chapter03.task10;

import java.io.File;
import java.io.FileFilter;

public class ListSubdirs {

    public static File[] listSubdirsLambda(File dir) {
        if (dir == null || !dir.isDirectory()) return new File[0];
        return dir.listFiles(pathname -> pathname.isDirectory());
    }

    public static File[] listSubdirsMethodRef(File dir) {
        if (dir == null || !dir.isDirectory()) return new File[0];
        return dir.listFiles(File::isDirectory);
    }

    public static File[] listSubdirsAnonymous(File dir) {
        if (dir == null || !dir.isDirectory()) return new File[0];
        return dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
    }

    static void main() {
        File dir = new File(".");

        System.out.println("---Лямбда---");
        for (File f : listSubdirsLambda(dir)) {
            System.out.println(f.getName());
        }

        System.out.println("---Ссылка на метод---");
        for (File f : listSubdirsMethodRef(dir)) {
            System.out.println(f.getName());
        }

        System.out.println("---Анонимный класс---");
        for (File f : listSubdirsAnonymous(dir)) {
            System.out.println(f.getName());
        }
    }
}