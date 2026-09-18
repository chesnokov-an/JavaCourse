package org.example.chapter05.task08;

import java.util.concurrent.locks.ReentrantLock;

public class LockHelper {
    public static AutoCloseable lock(ReentrantLock lock) {
        lock.lock();
        return lock::unlock;
    }

    static void main() throws Exception {
        int counter = 0;
        final ReentrantLock lock = new ReentrantLock();
        try (AutoCloseable ignored = LockHelper.lock(lock)) {
            counter++;
            System.out.println("counter = " + counter);
        }
        System.out.println("Блокировка снята.");
    }
}
