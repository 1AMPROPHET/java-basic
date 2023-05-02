package Thread.WaitAndNotify;

public class Foodie extends Thread {
    public void run() {
        /*
        1. 循环
        2. 同步代码块
        3. 判断共享数据是否到了末尾（到了）
        4. 判断是都到了末尾（没到）
         */
        while (true) {
            synchronized (Desk.lock) {
                if (Desk.count == 0) {
                    break;
                } else {
                    // 先判断桌子上是都有面条，没有就等待，有就吃
                    // 吃完后，唤醒厨师继续做
                    // 总数-1
                    // 修改桌子状态
                    if (Desk.foodFlag == 0) {
                        // 让当前线程跟锁进行绑定
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        Desk.count--;

                        System.out.println("Customer is eating, can still eat " + Desk.count);

                        // 唤醒厨师继续做
                        Desk.lock.notifyAll();

                        Desk.foodFlag = 0;
                    }
                }
            }
        }
    }
}
