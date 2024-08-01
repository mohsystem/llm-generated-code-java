package gtp4o.task92;

import java.util.concurrent.locks.ReentrantLock;

public class Task92_OPENAI_gpt_4o {
    private static int currentCounter = 0;
    private static final int maxCounter = 10;
    private static final ReentrantLock lock = new ReentrantLock();
    
    public static void main(String[] args) {
        int threadCount = 5;
        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(new CounterThread(), "Thread-" + (i+1));
            threads[i].start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class CounterThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (currentCounter <= maxCounter) {
                        System.out.println(Thread.currentThread().getName() + " accessing currentCounter: " + currentCounter);
                        currentCounter++;
                    } else {
                        break;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}