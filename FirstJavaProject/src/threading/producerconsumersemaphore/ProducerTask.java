package threading.producerconsumersemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ProducerTask implements Runnable {
    private Queue<Object> showCase;
    private int maxSize;
    private String name; // this is the threadName.
    private Semaphore pSemaphore;
    private Semaphore cSemaphore;

    public ProducerTask(Queue<Object> q, int maxSize, String name,
         Semaphore pSemaphore, Semaphore cSemaphore) {
        this.showCase = q;
        this.maxSize = maxSize;
        this.name = name;
        this.pSemaphore = pSemaphore;
        this.cSemaphore = cSemaphore;
    }

    @Override
    public void run() {
        /**
         * X _ X _ X _
         * maxSize = 6
         *
         */
        while(true){
            // S1. 
            try {
                pSemaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // S2.
                if(showCase.size() < maxSize){
                    System.out.println("Name of the task:" + name + " adding inside the queue, before size"+ showCase.size());
                    showCase.add(new Object());
                }

            // S3. 
            cSemaphore.release();
        }
    }
}
