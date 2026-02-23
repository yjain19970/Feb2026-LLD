package threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Integer> arr = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int cores = Runtime.getRuntime().availableProcessors();


        List<Future<Long>> listOfFutureSums = new ArrayList<>();
        int div = arr.size()/cores;

        for(int i=0;i<=div;i++){
            /**
             * 
             * for each chunk, 
             * start: i*chunkSize
             * end: (i+1) * chunkSize
             * 
             * 
             */
            // How to determine the size of array. check and pass it. Also the start and the end.
            MultiThreadedSum multiThreadedSum = new MultiThreadedSum(null, 0, 0);
            listOfFutureSums.add(executorService.submit(multiThreadedSum));
        }

        long finalSum=0L;
        for(Future<Long> sum : listOfFutureSums){
            finalSum += sum.get();
        }

        System.out.println("Final sum: " + finalSum);
        
    }
}
