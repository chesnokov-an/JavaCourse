package org.example.chapter01.task01;

import java.util.Scanner;
import org.example.chapter01.correctInput;
import java.util.NoSuchElementException;

public class task01 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean flag = false;
        int num = 0;
        try {
            num = correctInput.readInt(in, "Enter a number: ");
            flag = true;
        } catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        if(flag){
            System.out.println("bin: " + Integer.toString(num, 2));
            System.out.println("oct: " + Integer.toString(num, 8));
            System.out.println("hex: " + Integer.toString(num, 16));
            System.out.printf("reciprocal hex: %a", 1/(double)num);
        }
    }
}
