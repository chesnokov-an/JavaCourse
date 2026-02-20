package org.example.chapter01.task02;

import org.example.chapter01.util.CorrectInput;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task02 {
    static void main(){
        Scanner in = new Scanner(System.in);
        int num;
        try {
            num = CorrectInput.readInt(in, "Enter a number: ");
        } catch(NoSuchElementException e){
            System.out.println(e.getMessage());
            return;
        }
        System.out.println((num > 0)
                ? (num - 360 * (num / 360))
                : (num) % 360 + 360);
        System.out.println(Math.floorMod(num, 360));
    }
}
