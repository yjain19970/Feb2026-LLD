package threading.producerconsumersemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ConsumerTask implements Runnable {
    private Queue<Object> q;
    private int maxSize;
    private String name;
    private Semaphore pSemaphore;
    private Semaphore cSemaphore;
    

    public ConsumerTask(Queue<Object> q, int maxSize, String name,Semaphore pSemaphore, Semaphore cSemaphore) {
        this.q = q;
        this.maxSize = maxSize;
        this.name = name;
        this.pSemaphore= pSemaphore;
        this.cSemaphore = cSemaphore;
    }

    @Override
    public void run() {
        while(true){
            // S1.
            try {
                cSemaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // S2.
                if(q.size() >0){
                    System.out.println("Name of the task:" + name + " before remove form the queue, size"+ q.size());
                    q.remove(); // when am trying to remove.. it gives me
                }
            // S3.
            pSemaphore.release();
        }
    }
}
