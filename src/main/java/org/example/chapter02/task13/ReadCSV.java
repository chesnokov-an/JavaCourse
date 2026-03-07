package org.example.chapter02.task13;

import com.opencsv.CSVReader;
import java.io.FileReader;

public class ReadCSV {
    static void main() throws Exception {
        String fileName = "src/main/java/org/example/chapter02/task13/example.csv";

        CSVReader reader = new CSVReader(new FileReader(fileName));

        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            for (String value : nextLine) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        reader.close();
    }
}
