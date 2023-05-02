package Thread.RedEnvelope;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class MyThread extends Thread {
    static BigDecimal money = BigDecimal.valueOf(100);
    static int count = 3;

    // minimum award
    static final BigDecimal MIN = BigDecimal.valueOf(0.01);

    public void run() {
        synchronized (MyThread.class) {
            if (count == 0) {
                System.out.println(getName() + "没有抢到红包");
            } else {
                BigDecimal prize;
                if (count == 1) {
                    // 表示第一个红包最大金额满额，无需随机
                    prize = money;
                } else {
                    double bounds = money.subtract(BigDecimal.valueOf(count - 1).multiply(MIN)).doubleValue();
                    Random r = new Random();
                    prize = BigDecimal.valueOf(r.nextDouble(bounds));
//                    prize = Math.max(prize, MIN);
                }
                prize = prize.setScale(2, RoundingMode.HALF_UP);
                money = money.subtract(prize);
                count--;
                System.out.println(getName() + "抢到了" + prize + "元");
            }
        }
    }
}
