package org.example.chapter01.task07;

import org.example.chapter01.util.CorrectInput;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task07 {
    static void main(){
        int aInt, bInt;
        Scanner in = new Scanner(System.in);
        try {
            aInt = CorrectInput.readInt(in, "Enter a first number: ");
            bInt = CorrectInput.readInt(in, "Enter a second number: ");
        } catch(NoSuchElementException e){
            System.out.println(e.getMessage());
            return;
        }
        if((aInt < 0) || (bInt < 0) || (aInt > 65535) || (bInt > 65535)){
            System.out.println("Incorrect input");
            return;
        }
        short a = (short)aInt;
        short b = (short)bInt;

        int sum = ((a & 0xFFFF) + (b & 0xFFFF)) & 0xFFFF;
        int diff = ((a & 0xFFFF) - (b & 0xFFFF)) & 0xFFFF;
        int prod = ((a & 0xFFFF) * (b & 0xFFFF)) & 0xFFFF;
        int quot = ((a & 0xFFFF) / (b & 0xFFFF)) & 0xFFFF;
        int rem  = ((a & 0xFFFF) % (b & 0xFFFF)) & 0xFFFF;

        System.out.println("sum: " + sum);
        System.out.println("diff: " + diff);
        System.out.println("prod: " + prod);
        System.out.println("quot: " + quot);
        System.out.println("rem: " + rem);
    }
}
