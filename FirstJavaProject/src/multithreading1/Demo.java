package multithreading1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    
    public static void main(String[] args) {
        System.out.println("Thread:" + Thread.currentThread().getName());

        // Task-1: Print: Hello World using a new thread. 
        HelloWorldPrinterTask task = new HelloWorldPrinterTask();
        Thread t1 = new Thread(task);
        t1.start(); // start the thread. 
        // Task-2: Print numbers from 1-10; each independently in a new thread.
        System.out.println("EXECUTING TASK-2////");
        // for(int i=0;i<150000000;i++){
        //     NumberPrinterTask task2 = new NumberPrinterTask(i);
        //     Thread t2 = new Thread(task2);
        //     t2.start();
        // }




        // ThreadPool executor in Java


        // ExecutorService in java -- better way to create threads.

        ExecutorService executorService = 
            Executors.newFixedThreadPool(10);
            // This will always create fixed threads -- 10

        // This will not create a new thread everytime. 
        // This will check first, If their is a thread which is free,
        // it will reuse. else in worst case it will create.
        ExecutorService cachedExecutorService = 
            Executors.newCachedThreadPool();            

        // for(int i=0;i<50;i++){
        //     NumberPrinterTask task3 = new NumberPrinterTask(i);
        //     executorService.submit(task3);
        // } 

        System.out.println("Cached thread pool -----> ");
        for(int i=0;i<50;i++){
            NumberPrinterTask task3 = new NumberPrinterTask(i);
            cachedExecutorService.submit(task3);
        } 

        cachedExecutorService.shutdown();
    }
}
