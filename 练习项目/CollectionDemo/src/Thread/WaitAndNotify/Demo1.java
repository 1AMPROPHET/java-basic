package Thread.WaitAndNotify;

import java.util.concurrent.ArrayBlockingQueue;

public class Demo1 {
    public static void main(String[] args) {
        /*
        需求：利用阻塞队列完成生产者和消费者（等待唤醒机制）的代码
        细节：生产者和消费者必须使用同一个阻塞队列
         */

        // 1. 创建阻塞队列
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

        // 2. 创建线程对象，并把阻塞队列传递过去
        Cook1 c = new Cook1(queue);
        Foodie1 f = new Foodie1(queue);

        // 3. 开启线程
        c.start();
        f.start();

    }
}
