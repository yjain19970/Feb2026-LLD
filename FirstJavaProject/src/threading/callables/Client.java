package threading.callables;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //NumberGenerator numberGenerator = new NumberGenerator(10);
        //executorService.submit(numberGenerator);
        
     
        List<Integer> list = List.of(7, 3, 4, 1, 9, 8, 2, 6);
        // S1. Create ExecutorService
        //ExecutorService executorService = Executors.newFixedThreadPool(5);
        // it will try to reuse the existing threads if possible.

        // S2. Create Task for MergeSort
         long start = System.currentTimeMillis();
        System.out.println("Starting:" +start);
        MergeSorter mergeSorter = new MergeSorter(list, executorService);
        Future<List<Integer>> response =  executorService.submit(mergeSorter);
        System.out.println("Result: " + response.get());
        long endTime = System.currentTimeMillis(); 
        System.out.println("End:" + endTime);

        System.out.println("Total time:" + (endTime - start));

        executorService.shutdown();;
    }
}
