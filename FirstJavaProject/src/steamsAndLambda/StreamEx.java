package steamsAndLambda;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class StreamEx {
    public static void main(String[] args) {
        
        /**
         * 
         *  WAY-1 : ANONYMOUS CLASSES.
         */
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String t) {
                System.out.println("Hehllo...." + t);
            }
        }; 
        con1.accept("Yash");


        /**
         * 
         *  WAY-2 : LAMBDAs.
         */       
        Consumer<String> con2 = (s) -> {
            System.out.println("Hello..." + s);
        };
        con2.accept("Abhishek!");



        BiConsumer<Integer,Integer> con3 = (x,y) -> {
            int sum = x+y;
            System.out.println("SUM is: "+ sum);
        };
        con3.accept(10, 30);


        BiFunction<Integer,Integer, Integer> bif = (x,y) -> {
                int sum = x+y;
                return sum;
        };
        int totalSum = bif.apply(1,2);

        /**
         * 
         * 
         * Runnables and creating threads...
         * 
         * 
         */

        
        //  Runnable....
        Runnable runnable = () -> {
            System.out.println("new Thread....");
        };
        Thread t1 = new Thread(runnable);
        t1.start();

        // enhanced runnable.
        new Thread(() -> System.out.println("new Thread....")).start();
    }
}
