package org.example.chapter01.task02;

import org.example.chapter01.correctInput;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class task02 {
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
            System.out.println((num > 0)
                    ? (num - 360 * (num / 360))
                    : (num) % 360 + 360);
            System.out.println(Math.floorMod(num, 360));
        }
    }
}
