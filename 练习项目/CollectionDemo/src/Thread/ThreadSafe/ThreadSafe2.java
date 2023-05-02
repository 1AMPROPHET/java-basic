package Thread.ThreadSafe;

public class ThreadSafe2 implements Runnable {
    int ticket = 0;

    public void run() {
        while (true) {
            if (method()) break;
        }
    }

    private synchronized boolean method() {
        if (ticket == 10000) {
            return true;
        } else {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ticket++;
            System.out.println(Thread.currentThread().getName() + " is selling " + ticket);
        }
        return false;
    }
}
