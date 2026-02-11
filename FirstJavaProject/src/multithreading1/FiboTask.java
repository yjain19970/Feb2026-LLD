package multithreading1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class FiboTask implements Callable<Integer> {
    private int n;
    private ExecutorService executorService;

    public FiboTask(int n, ExecutorService executorService) {
        this.n = n;
        this.executorService  = executorService;
    }


    @Override
    public Integer call() throws Exception {
        if(n<=1){
            return n;
        }
        Future<Integer> n1 = executorService.submit(new FiboTask(n-1, executorService)); // Separate thread...
        Future<Integer> n2 = executorService.submit(new FiboTask(n-2, executorService)); // Separate thread...
        Integer n3 = n1.get();
        Integer n4 = n2.get();
        return n3 + n4;
    }
    
}
