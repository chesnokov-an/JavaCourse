package org.example.chapter02.task04;

// 1) В Java все параметры передаются в метод по значению (нет передачи по указателю)
// 2) Integer устроен как неизменяемый (immutable). При переприсваивании создаётся новый объект.

public class Task04 {
    public static void swap(IntHolder holder1, IntHolder holder2) {
        int temp = holder1.value;
        holder1.value = holder2.value;
        holder2.value = temp;
    }

    static void main() {
        IntHolder a = new IntHolder(5);
        IntHolder b = new IntHolder(10);

        System.out.println(a.value + " " + b.value);
        swap(a, b);
        System.out.println(a.value + " " + b.value);
    }
}