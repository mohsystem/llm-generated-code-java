package gemini.task187;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.CyclicBarrier;

class H2O {
    private Semaphore hydrogenSemaphore;
    private Semaphore oxygenSemaphore;
    private CyclicBarrier barrier;

    public H2O() {
        hydrogenSemaphore = new Semaphore(2);
        oxygenSemaphore = new Semaphore(1);
        barrier = new CyclicBarrier(3);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSemaphore.acquire();
        try {
            barrier.await();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        } finally {
            hydrogenSemaphore.release();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSemaphore.acquire();
        try {
            barrier.await();
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        } finally {
            oxygenSemaphore.release();
        }
    }
}