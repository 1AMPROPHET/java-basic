package Thread;

public class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 30; i++) {
            System.out.println(getName() + "Hello World");
        }
    }
}
