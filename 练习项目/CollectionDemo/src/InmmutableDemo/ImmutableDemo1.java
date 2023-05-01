package InmmutableDemo;

import java.util.Iterator;
import java.util.List;

public class ImmutableDemo1 {
    public static void main(String[] args) {
        // 不可变list集合
        List<String> list = List.of("Tom", "Jack", "Lucy", "Betty");

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));

        System.out.println("------------");

        for (String name : list) {
            System.out.println(name);
        }

        System.out.println("------------");

        Iterator<String> it = list.iterator();

        while (it.hasNext()) {
            String name = it.next();
            System.out.println(name);
        }

        System.out.println("-------------");
    }
}
