package threading.multithreading1;

public class HelloWorldPrinterTask implements Runnable {

    @Override
    public void run() {
        // my business logic....
        System.out.println("hello world! Thread name: "+ 
            Thread.currentThread().getName()
        );
    }
    // Callables in java.
    
}
