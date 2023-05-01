package Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionDemo1 {
    public static void main(String[] args) {
        /*
        - 引用处必须是函数式接口
        - 被引用方法必须已经存在
        - 被引用方法的形参和返回值需要跟抽象方法一致
        - 被引用方法的功能要满足当前需求
         */

        Integer[] arr = {5, 2, 1, 4, 6, 9, 0, 7, 3, 8};

        // Function::subtraction表示引用FunctionDemo中的subtraction方法
        Arrays.sort(arr, FunctionDemo1::subtraction);

        System.out.println(Arrays.toString(arr));

        // 引用静态方法
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "1", "2", "3", "4", "5");

        list.stream().map(Integer::parseInt).forEach(System.out::println);

        // 引用成员方法
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "张无忌", "周芷若", "赵敏", "张强", "张三丰", "张翠山", "张良", "王二麻子", "谢广坤");

        // 引用了StringOperation中的stringJudge方法
        list1.stream()
                .filter(new StringOperation()::stringJudge)
                .forEach(System.out::println);

        // 成员方法如果在本类中，静态类中没有this，需要构造本类对象,父类用super
        list1.stream()
                .filter(new FunctionDemo1()::stringJudge)
                .forEach(System.out::println);

        // 引用构造方法
        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2, "张无忌,15", "周芷若,14", "张三丰,100", "赵敏,16", "张翠山,34");

//        List<Student> newList = list2.stream().map(new Function<String, Student>() {
//            @Override
//            public Student apply(String s) {
//                String[] arr = s.split(",");
//                String name = arr[0];
//                int age = Integer.parseInt(arr[1]);
//                return new Student(name, age);
//            }
//        }).collect(Collectors.toList());

        List<Student> newList = list2.stream().map(Student::new).collect(Collectors.toList());

        System.out.println(newList);

        // 类名引用成员方法
        ArrayList<String> list3 = new ArrayList<>();
        Collections.addAll(list3, "aaa", "bbb", "ccc", "ddd");

        // 变成大写
        list3.stream().map(String::toUpperCase).forEach(System.out::println);

        // 数组的构造方法
        ArrayList<Integer> list4 = new ArrayList<>();
        Collections.addAll(list4, 1, 2, 3, 4, 5);

        Integer[] newArr = list4.toArray(Integer[]::new);

        System.out.println(Arrays.toString(newArr));

    }

    public static int subtraction(int num1, int num2) {
        return num2 - num1;
    }

    public boolean stringJudge(String s) {
        return s.startsWith("张") && s.length() == 3;
    }
}
