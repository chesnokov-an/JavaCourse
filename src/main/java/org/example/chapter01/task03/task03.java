package org.example.chapter01.task03;

import org.example.chapter01.correctInput;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class task03 {
    static void main() {
        int a, b, c;
        Scanner in = new Scanner(System.in);
        try {
            a = correctInput.readInt(in, "Enter a first number: ");
            b = correctInput.readInt(in, "Enter a first number: ");
            c = correctInput.readInt(in, "Enter a first number: ");
        } catch(NoSuchElementException e){
            System.out.println(e.getMessage());
            return;
        }
        if(a > b && a > c)  System.out.println(a);
        else if(b > a && b > c)  System.out.println(b);
        else System.out.println(c);
        System.out.println(Math.max(a, Math.max(b, c)));
    }
}
