package org.example.chapter03.task11;

import java.io.File;

public class ListFilesByExtension {
    public static String[] getFilesWithExtension(File dir, String extension) {
        if (dir == null || !dir.isDirectory() || extension == null) {
            return new String[0];
        }
        // Захват переменной extension
        return dir.list((d, name) -> name.endsWith("." + extension));
    }

    static void main() {
        File currentDir = new File(".");
        String[] txtFiles = getFilesWithExtension(currentDir, "txt");
        System.out.println("Текстовые файлы:");
        for (String file : txtFiles) {
            System.out.println(file);
        }
    }
}
