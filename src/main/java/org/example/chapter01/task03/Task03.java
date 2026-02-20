package org.example.chapter01.task03;

import org.example.chapter01.util.CorrectInput;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task03 {
    static void main() {
        int a, b, c;
        Scanner in = new Scanner(System.in);
        try {
            a = CorrectInput.readInt(in, "Enter a first number: ");
            b = CorrectInput.readInt(in, "Enter a second number: ");
            c = CorrectInput.readInt(in, "Enter a third number: ");
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
