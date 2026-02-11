package multithreading1;

public class NumberPrinterTask implements Runnable {
    private int no;
    public NumberPrinterTask(int no) {
        this.no = no;
    }

    @Override
    public void run() {
        System.out.println("Printing number: "+ no + 
        "Thread name: " + Thread.currentThread().getName());
    }
}
