package org.example.chapter01.task01;

import java.util.Scanner;

public class task01 {
    public static void main(String[] args){
        int num = 0;
        boolean flag = false;
        Scanner in = new Scanner(System.in);
        while(!flag) {
            System.out.print("Enter a number: ");
            if (!in.hasNext()) {
                System.out.println("End of input");
                break;
            }
            if (in.hasNextInt()) {
                num = in.nextInt();
                flag = true;
            } else {
                System.out.println("Not a number entered");
                in.next();
            }
        }
        if(flag){
            System.out.println("bin: " + Integer.toString(num, 2));
            System.out.println("oct: " + Integer.toString(num, 8));
            System.out.println("hex: " + Integer.toString(num, 16));
            System.out.printf("reciprocal hex: %a", 1/(double)num);
        }
    }
}
