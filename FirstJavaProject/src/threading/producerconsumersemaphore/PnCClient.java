package threading.producerconsumersemaphore;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;

public class PnCClient {
    public static void main(String[] args) {
        Semaphore prodSemaphore = new Semaphore(6);
        Semaphore cSemaphore = new Semaphore(0);


        Queue<Object> showCase = new ConcurrentLinkedDeque<>(); // shirt store.

        // multiple tasks for producer...
        ProducerTask p1 = new ProducerTask(showCase, 6, "p1", prodSemaphore, cSemaphore);
        ProducerTask p2 = new ProducerTask(showCase, 6, "p2", prodSemaphore, cSemaphore);
        ProducerTask p3 = new ProducerTask(showCase, 6, "p3", prodSemaphore, cSemaphore);

        // multiple tasks for consumer...
        ConsumerTask c1 = new ConsumerTask(showCase, 6, "c1", prodSemaphore, cSemaphore);
        ConsumerTask c2 = new ConsumerTask(showCase, 6, "c2", prodSemaphore, cSemaphore);
        ConsumerTask c3 = new ConsumerTask(showCase, 6, "c3", prodSemaphore, cSemaphore);
        ConsumerTask c4 = new ConsumerTask(showCase, 6, "c4", prodSemaphore, cSemaphore);
        ConsumerTask c5 = new ConsumerTask(showCase, 6, "c5", prodSemaphore, cSemaphore);
        ConsumerTask c6 = new ConsumerTask(showCase, 6, "c6", prodSemaphore, cSemaphore);

        Thread t1 = new Thread(p1);
        t1.start();
        Thread t2 = new Thread(p2);
        t2.start();
        Thread t3 = new Thread(p3);
        t3.start();

        Thread ct1 = new Thread(c1);
        ct1.start();
        Thread ct2 = new Thread(c2);
        ct2.start();
        Thread ct3 = new Thread(c3);
        ct3.start();
        Thread ct4 = new Thread(c4);
        ct4.start();
        Thread ct5 = new Thread(c5);
        ct5.start();
        Thread ct6 = new Thread(c6);
        ct6.start();


    }
}