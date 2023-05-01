package Thread;

public class ThreadDemo1 {
    public static void main(String[] args) {
        /*
        多线程第一种启动方式：
        1.自定义一个类继承Thread
        2.重写run方法
        3.创建子类的对象，并启动线程
         */
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        // 线程起名字
        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t1.start();
        t2.start();
    }
}
