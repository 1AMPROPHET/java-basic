package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Stream;

public class StreamDemo1 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("张无忌");
        list1.add("周芷若");
        list1.add("张三丰");
        list1.add("赵敏");

        // 把所有以 张 开头的元素存储到新集合中
        // 把所有 张 开头，长度为3的元素在存储到新集合中
        // 遍历打印
        list1.stream().filter(name -> name.startsWith("张")).filter(name -> name.length() == 3).forEach(name -> System.out.println(name));

        // 单列集合获取Stream流
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "a", "b", "c", "d");

        // 获取Stream流。将集合放在流水线上
        list.stream().forEach(s -> System.out.println(s));

        // 双列集合
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("1", 1);
        hm.put("2", 2);
        hm.put("3", 3);
        hm.put("4", 4);

        hm.keySet().stream().forEach(s -> System.out.println(s));

        hm.entrySet().stream().forEach(s -> System.out.println(s));

        // 数组
        int[] arr = {1,2,3,4,5,6};

        Arrays.stream(arr).forEach(n -> System.out.println(n));
    }
}
