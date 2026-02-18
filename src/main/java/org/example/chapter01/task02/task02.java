package org.example.chapter01.task02;

import java.util.Scanner;

public class task02 {
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
            System.out.println((num > 0)
                    ? (num - 360 * (num / 360))
                    : (num) % 360 + 360);
            System.out.println(Math.floorMod(num, 360));
        }
    }
}
