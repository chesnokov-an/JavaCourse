package org.example.chapter01.task01;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.lang.Exception;

public class task01 {
    public static void main(String[] args){
        int num = 0;
        boolean flag = false;
        while(!flag) {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter a number: ");
            try {
                num = in.nextInt();
                flag = true;
            } catch (InputMismatchException e) {
                System.out.println("Not a number entered");
            } catch (NoSuchElementException e) {
                break;
            } catch (Exception e) {
                System.out.println("Other problem");
                break;
            }
        }
        if(flag){
            System.out.println("bin: " + Integer.toString(num, 2));
            System.out.println("oct: " + Integer.toString(num, 8));
            System.out.println("hex: " + Integer.toString(num, 16));
        }
    }
}
