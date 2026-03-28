package org.example.chapter03.task09;
import org.example.chapter03.task08.Greeter;

public class TaskRunner {
    public static void runTogether(Runnable... tasks) {
        if (tasks == null) return;
        Thread[] threads = new Thread[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            (threads[i] = new Thread(tasks[i])).start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public static void runInOrder(Runnable... tasks) {
        if (tasks == null) return;
        for (Runnable task : tasks) {
            task.run();
        }
    }

    static void main() {
        Greeter task1 = new Greeter(3, "Alice");
        Greeter task2 = new Greeter(2, "Bob");
        Greeter task3 = new Greeter(1, "Charlie");

        System.out.println("runInOrder");
        TaskRunner.runInOrder(task1, task2, task3);
        // Вывод: сначала все приветствия для Alice (3 раза), потом для Bob (2), потом для Charlie (1)

        System.out.println("\nrunTogether");
        TaskRunner.runTogether(task1, task2, task3);
        // Вывод: сообщения могут перемешиваться, так как потоки выполняются одновременно
    }
}