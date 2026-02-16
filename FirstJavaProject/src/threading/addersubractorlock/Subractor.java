package threading.addersubractorlock;

import java.util.concurrent.locks.Lock;

public class Subractor implements Runnable{
    private Count count;
    private Lock lock;

    public Subractor(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        System.out.print("Subractor: Taken lock, thread: " + Thread.currentThread().getName());
        for (int i = 0; i < 100000; i++) {
            count.value -= 1;
        }
        lock.unlock();
        System.out.print("Subractor: Released lock, thread: " + Thread.currentThread().getName());

    }
}
