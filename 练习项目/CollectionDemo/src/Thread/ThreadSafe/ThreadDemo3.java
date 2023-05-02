package Thread.ThreadSafe;

public class ThreadDemo3 {
    public static void main(String[] args) {
        ThreadSafe3 ts1 = new ThreadSafe3();
        ThreadSafe3 ts2 = new ThreadSafe3();
        ThreadSafe3 ts3 = new ThreadSafe3();

        ts1.setName("ts1");
        ts2.setName("ts2");
        ts3.setName("ts3");

        ts1.start();
        ts2.start();
        ts3.start();
    }
}
