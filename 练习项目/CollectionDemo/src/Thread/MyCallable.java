package Thread;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum = sum + i;
        }
        return sum;
    }
}
