package org.example.chapter03.task13;

public class RunnableCombinator {
    public static Runnable combine(Runnable... tasks) {
        return () -> {
            for (Runnable task : tasks) {
                if (task != null) {
                    task.run();
                }
            }
        };
    }

    static void main() {
        Runnable task1 = () -> System.out.println("Первый");
        Runnable task2 = () -> System.out.println("Второй");
        Runnable combined = combine(task1, task2);
        combined.run();
    }
}
