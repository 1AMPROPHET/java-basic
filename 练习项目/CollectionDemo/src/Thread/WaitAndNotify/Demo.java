package Thread.WaitAndNotify;

public class Demo {
    public static void main(String[] args) {
        Cook c = new Cook();
        Foodie f = new Foodie();

        c.setName("Cook");
        f.setName("Foodie");

        c.start();
        f.start();
    }
}
