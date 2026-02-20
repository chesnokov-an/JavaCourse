package org.example.chapter01.task08;

import java.util.Scanner;

public class Task08 {
    static void main(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        for(String subst : str.split(" ")){
            System.out.println(subst);
        }
    }
}
