package Thread.ThreadSafe;

public class ThreadSafe1 extends Thread {
    static int ticket = 0;

    // 锁对象是唯一的
    static final Object obj = new Object();

    public void run() {
        while (true) {
            // 同步代码块
            synchronized (obj) {
                if (ticket < 10000) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket++;
                    System.out.println(getName() + " is Selling " + ticket + " now.");
                } else {
                    break;
                }
            }
        }
    }

}
