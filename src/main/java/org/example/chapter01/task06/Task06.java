package org.example.chapter01.task06;

import java.math.BigInteger;

public class Task06 {
    BigInteger fact(BigInteger n){
        if(n.equals(BigInteger.ONE)) return n;
        return (n.multiply(fact(n.subtract(BigInteger.ONE))));
    }

    static void main(){
        Task06 solution = new Task06();
        System.out.println(solution.fact(BigInteger.valueOf(1000)));
    }
}
