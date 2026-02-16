package threading.producerconsumersync;

import java.util.Queue;

public class ProducerTask implements Runnable {
    private Queue<Object> showCase;
    private int maxSize;
    private String name; // this is the threadName.

    public ProducerTask(Queue<Object> q, int maxSize, String name) {
        this.showCase = q;
        this.maxSize = maxSize;
        this.name = name;
    }

    @Override
    public void run() {
        /**
         * X _ X _ X _
         * maxSize = 6
         *
         */
        while(true){
            synchronized (showCase){
                if(showCase.size() < maxSize){
                    System.out.println("Name of the task:" + name + " adding inside the queue, before size"+ showCase.size());
                    showCase.add(new Object());
                }
            }
        }
    }
}
