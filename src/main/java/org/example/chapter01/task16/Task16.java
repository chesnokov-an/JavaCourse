package org.example.chapter01.task16;

public class Task16 {
    public static double average(double value, double... values){
        double sum = value;
        for (double v : values) sum += v;
        return sum / (values.length + 1);
    }

    static void main() {
        System.out.println(average(3.0, 5.0, 8.0));
    }
}
