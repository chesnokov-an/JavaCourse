package org.example.chapter03.task12;

import java.io.File;
import java.util.Arrays;

public class SortFiles {
    static void main() {
        File[] files = new File(".").listFiles();
        if (files != null) {
            Arrays.sort(files, (f1, f2) -> {
                if (f1.isDirectory() && !f2.isDirectory()) return -1;
                if (!f1.isDirectory() && f2.isDirectory()) return 1;
                return f1.getPath().compareTo(f2.getPath());
            });

            for (File f : files) {
                System.out.println((f.isDirectory() ? "dir " : "file ") + f.getName());
            }
        }
    }
}