package org.example.chapter05.task06;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Task06 {

    static void main() {
        Path path = Paths.get("src/main/java/org/example/chapter05/task05/input.txt");

        // Варик 1 - перехват исключения в операторе finally
        {
            BufferedReader in = null;
            try {
                in = Files.newBufferedReader(path, StandardCharsets.UTF_8);
                // Читать из in
            } catch (IOException ex) {
                System.err.println("IOException: " + ex.getMessage());
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        System.err.println("Ошибка при закрытии: " + e.getMessage());
                    }
                }
            }
        }

        // Варик 2 - внедрение блока операторов try/finally в блок операторов try/catch
        {
            try {
                BufferedReader in = Files.newBufferedReader(path, StandardCharsets.UTF_8);
                try {
                    // Читать из in
                } finally {
                    in.close();
                }
            } catch (IOException ex) {
                System.err.println("IOException: " + ex.getMessage());
            }
        }

        // Варик 3 - оператор try с ресурсами вместе с оператором catch
        {
            try (BufferedReader in = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
                // Читать из in
            } catch (IOException ex) {
                System.err.println("IOException: " + ex.getMessage());
            }
        }
    }

}
