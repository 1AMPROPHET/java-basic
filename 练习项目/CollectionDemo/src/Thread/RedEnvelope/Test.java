package Thread.RedEnvelope;

public class Test {
    public static void main(String[] args) {
        /*
        微信中抢红包
        假设：100块，分成了三个红包，现在有5个人去抢
        其中，红包是共享数据
        5个人是5条线程
         */

        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();
        MyThread mt3 = new MyThread();
        MyThread mt4 = new MyThread();
        MyThread mt5 = new MyThread();

        mt1.setName("mt1");
        mt2.setName("mt2");
        mt3.setName("mt3");
        mt4.setName("mt4");
        mt5.setName("mt5");

        mt1.start();
        mt2.start();
        mt3.start();
        mt4.start();
        mt5.start();
    }
}
