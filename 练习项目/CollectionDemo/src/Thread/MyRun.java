package Thread;

public class MyRun implements Runnable {
    public void run() {
        // 线程要实现的代码
        for (int i = 0; i < 30; i++) {
            // 先获取当前线程对象
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + "Hello World");
        }
    }
}
