package org.example.chapter01.task15;

import org.example.chapter01.util.CorrectInput;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task15 {
    static void main() {
        int n;
        Scanner scanner = new Scanner(System.in);
        try{
            n = CorrectInput.readInt(scanner, " Enter n: ");
        } catch(NoSuchElementException e){
            System.out.println(e.getMessage());
            return;
        }
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>(i + 1);
            row.add(1);
            for (int j = 1; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                    continue;
                }
                row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
            }
            triangle.add(row);
        }
        for (ArrayList<Integer> row : triangle) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
