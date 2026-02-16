package threading.addersubractorlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        Count c = new Count(); // shared var
        Lock lock = new ReentrantLock(); // Lock Interface Impl.
        
        Adder adder = new Adder(c, lock);
        Subractor subractor = new Subractor(c, lock);

        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subractor);

        t1.start();
        t2.start();

        // till here code was MUX.

        t1.join(); // wait.
        t2.join(); // wait untill thread execution is completed.
        // they will wait till completion of t1 and t2.

        System.out.println("Value is:  " + c.value);

    }
}
