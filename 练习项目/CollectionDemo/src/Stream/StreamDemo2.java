package Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        // 中间方法，返回新的Stream流，原来的Stream流只能使用一次，建议使用链式编程
        // 修改Stream流中的数据，不会影响原来集合或者数组中的数据

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰", "张翠山", "张良", "王二麻子", "谢广坤", "张无忌", "张无忌");

        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list, "Tom", "Jack");

        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(s -> System.out.println(s));

        list.stream().limit(6).skip(3).forEach(s -> System.out.println(s));

        list.stream().skip(3).limit(6).forEach(s -> System.out.println(s));

        list.stream().distinct().forEach(s -> System.out.println(s));

        Stream.concat(list.stream(), list1.stream()).forEach(s -> System.out.println(s));

        ArrayList<String> list2 = new ArrayList<>();

        Collections.addAll(list2, "Tom-1", "Jack-2", "Lucy-3", "Betty-4");

        list2.stream().map(new Function<String, Integer>() {
            public Integer apply(String s) {
                String[] arr = s.split("-");
                String ageString = arr[1];
                return Integer.parseInt(ageString);
            }
        }).forEach(s -> System.out.println(s));

        // lambda
        list2.stream().map(s -> Integer.parseInt(s.split("-")[1])).forEach(s -> System.out.println(s));


    }
}
