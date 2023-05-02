package Thread.WaitAndNotify;

import java.util.concurrent.ArrayBlockingQueue;

public class Foodie1 extends Thread {
    ArrayBlockingQueue<String> queue;
    public Foodie1(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        while (true) {
            try {
                String food = queue.take();
                System.out.println(food);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
