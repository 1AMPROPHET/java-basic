package Thread.ThreadSafe;

public class ThreadDemo1 {
    public static void main(String[] args) {
        ThreadSafe1 ts1 = new ThreadSafe1();
        ThreadSafe1 ts2 = new ThreadSafe1();
        ThreadSafe1 ts3 = new ThreadSafe1();

        ts1.setName("ts1");
        ts2.setName("ts2");
        ts3.setName("ts3");

        ts1.start();
        ts2.start();
        ts3.start();
    }
}
