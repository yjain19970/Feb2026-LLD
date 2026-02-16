package threading.producerconsumersync;

import java.util.Queue;

public class ConsumerTask implements Runnable {
    private Queue<Object> q;
    private int maxSize;
    private String name;

    public ConsumerTask(Queue<Object> q, int maxSize, String name) {
        this.q = q;
        this.maxSize = maxSize;
        this.name = name;
    }

    @Override
    public void run() {
        while(true){
            synchronized (q){
                if(q.size() >0){
                    System.out.println("Name of the task:" + name + " before remove form the queue, size"+ q.size());
                    q.remove(); // when am trying to remove.. it gives me
                }
            }
        }
    }
}
