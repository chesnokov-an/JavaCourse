package org.example.chapter01.task01;

import java.util.Scanner;
import org.example.chapter01.correctInput;
import java.util.NoSuchElementException;

public class task01 {
    static void main(){
        Scanner in = new Scanner(System.in);
        int num;
        try {
            num = correctInput.readInt(in, "Enter a number: ");
        } catch(NoSuchElementException e){
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("bin: " + Integer.toString(num, 2));
        System.out.println("oct: " + Integer.toString(num, 8));
        System.out.println("hex: " + Integer.toString(num, 16));
        System.out.printf("reciprocal hex: %a", 1/(double)num);
    }
}
