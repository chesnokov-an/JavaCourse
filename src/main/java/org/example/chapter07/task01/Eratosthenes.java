package org.example.chapter07.task01;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Eratosthenes {
    public static Set<Integer> sieveHashSet(int n) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            numbers.add(i);
        }

        // s перебирается по возрастанию, поэтому это и есть поиск наименьшего элемента
        for (int s = 2; s * s <= n; s++) {
            if (numbers.contains(s)) {
                for (int multiple = s * s; multiple <= n; multiple += s) {
                    numbers.remove(multiple);
                }
            }
        }
        return numbers;
    }

    public static BitSet sieveBitSet(int n) {
        BitSet primes = new BitSet(n + 1);
        if (n >= 2) {
            primes.set(2, n + 1);
        }

        // nextSetBit() каждый раз находит наименьший оставшийся элемент
        for (int s = primes.nextSetBit(2); s != -1 && s * s <= n; s = primes.nextSetBit(s + 1)) {
            for (int multiple = s * s; multiple <= n; multiple += s) {
                primes.clear(multiple);
            }
        }
        return primes;
    }

    static void main() {
        int n = 100;
        Set<Integer> hashPrimes = sieveHashSet(n);
        BitSet bitPrimes = sieveBitSet(n);

        System.out.println("Простые числа до " + n + ":");
        System.out.println(new TreeSet<>(hashPrimes));

        System.out.println("Количество: " + hashPrimes.size() + " / " + bitPrimes.cardinality());

        boolean same = hashPrimes.size() == bitPrimes.cardinality();
        for (int prime : hashPrimes) {
            if (!bitPrimes.get(prime)) {
                same = false;
            }
        }
        System.out.println("Результаты совпадают: " + same);
    }
}
