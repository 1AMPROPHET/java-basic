package Exception;

import java.util.Scanner;

public class ExceptionTest {
    public static void main(String[] args) {
        // 录入女朋友的姓名和年龄
        // 姓名长度在3-10之间
        // 年龄范围为18-40岁
        // 超出这个范围不能赋值，需要重新录入，一直到录入正确为止
        // 需要考虑用户在键盘录入时的所有情况
        // 比如：录入年龄超出范围，录入了abc等情况
        Scanner sc = new Scanner(System.in);
        GirlFriend gf = new GirlFriend();

        while (true) {
            try {
                System.out.println("Please enter your girlfriend's name: ");
                String name = sc.nextLine();
                gf.setName(name);
                System.out.println("Please enter your girlfriend's age");
                String ageStr = sc.nextLine();
                int age = Integer.parseInt(ageStr);
                gf.setAge(age);
                break;
            } catch (NumberFormatException | NameFormatException | AgeOutOfBoundsException e) {
                e.printStackTrace();
            }
        }

        System.out.println(gf);
    }
}
