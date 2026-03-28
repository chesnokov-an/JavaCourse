package org.example.chapter03.task08;

public class Greeter implements Runnable {
    private final int n;
    private final String target;

    public Greeter(int n, String target) {
        this.n = n;
        this.target = target;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.println("Hello, " + target);
        }
    }

    static void main() {
        Greeter greeter1 = new Greeter(5, "Alice");
        Greeter greeter2 = new Greeter(3, "Bob");

        Thread thread1 = new Thread(greeter1);
        Thread thread2 = new Thread(greeter2);

        thread1.start();
        thread2.start();
    }
}
