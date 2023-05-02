package Thread.ThreadSafe;

public class ThreadDemo2 {
    public static void main(String[] args) {

        ThreadSafe2 ts = new ThreadSafe2();

        Thread t1 = new Thread(ts);
        Thread t2 = new Thread(ts);
        Thread t3 = new Thread(ts);

        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");

        t1.start();
        t2.start();
        t3.start();
    }
}
