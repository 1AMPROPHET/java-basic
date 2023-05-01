package Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        /*
         *  定义一个集合，并添加一些整数，1，2，3，4，5，6，7
         *  过滤奇数，只留下偶数
         *  并将结果保存下来
         */

        ArrayList<Integer> list = new ArrayList<>();

        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> newList = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());

        System.out.println(newList);

        /*
            创建一个ArrayList集合，并添加以下字符串
            “zhangsan,23”
            “lisi,24”
            “wangwu,25
            保留年龄大于等于24岁的人，并将结果收集到map中
         */
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "zhangsan,23", "lisi,24", "wangwu,25");

        Map<String, Integer> newList1 = list1.stream()
                .filter(s -> Integer.parseInt(s.split(",")[1]) >= 24)
                .collect(Collectors.toMap(
                        s -> s.split(",")[0],
                        s -> Integer.parseInt(s.split(",")[1])
                ));
        System.out.println(newList1);
    }
}
