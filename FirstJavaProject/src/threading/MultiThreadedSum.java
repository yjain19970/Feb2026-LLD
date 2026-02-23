package threading;

import java.util.List;
import java.util.concurrent.Callable;

public class MultiThreadedSum implements Callable<Long> {
    private List<Integer> arr;
    private int start;
    private int end;

    public MultiThreadedSum(List<Integer> arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    public Long call() throws Exception {
        Long sum = 0L;
        for(int i=start; i<end;i++ ){
            sum += arr.get(i);
        }

        return sum;
    }
    
}
