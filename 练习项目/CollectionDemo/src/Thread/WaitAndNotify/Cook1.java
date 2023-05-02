package Thread.WaitAndNotify;

import java.util.concurrent.ArrayBlockingQueue;

public class Cook1 extends Thread {
    ArrayBlockingQueue<String> queue;
    public Cook1(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run() {
        while (true) {
            try {
                queue.put("noodle");
                // 因为此处打印语句在锁的外层，打印台打印会有偏差，实际上没有问题
                System.out.println("Cook cooked noodle");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
