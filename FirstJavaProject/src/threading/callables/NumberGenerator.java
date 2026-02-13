package threading.callables;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class NumberGenerator implements Callable<Integer> {
    int input;
    public NumberGenerator(int i){
        this.input = i;
    }

    @Override
    public Integer call() throws Exception {
        return input;
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //Future<Integer> futureValue =  executorService.submit(numberGenerator); // Promise.
        NumberGenerator numberGenerator = new NumberGenerator(13);
       
        // Callable using Thread with FutureTask. 

        FutureTask<Integer> futureTask = new FutureTask<>(numberGenerator);
        Thread t = new Thread(futureTask);
        t.start();
        futureTask.get();

        for(int i=1;i<15;i++){
            NumberGenerator numberGeneratorI = new NumberGenerator(i);
            Future<Integer> fiFuture =  executorService.submit(numberGeneratorI);
            System.out.println("Number: " + fiFuture.get());
        }

        executorService.shutdown();
    }
}
