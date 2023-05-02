package Thread.ThreadSafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafe3 extends Thread {
    static int ticket = 0;

    Lock lock = new ReentrantLock();

    public void run() {
        while (true) {
            lock.lock();
            try {
                if (ticket == 10000) {
                    break;
                } else {
                    Thread.sleep(1);
                    ticket++;
                    System.out.println(getName() + " is selling " + ticket);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
