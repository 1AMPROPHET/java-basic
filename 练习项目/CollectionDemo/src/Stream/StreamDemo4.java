package Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamDemo4 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌-男-15", "周芷若-女-14", "张三丰-男-100", "赵敏-女-16", "张翠山-男-34");

        Map<String, Integer> map = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                /**
                 * toMap：参数一表示键的生成规则
                 *        参数二表示值的生成规则
                 *
                 *        参数一：
                 *          Function 泛型一：表示流中每个数据的类型
                 *                   泛型二：表示Map集合中键的数据类型
                 *
                 *          方法 apply 形参：依次表示流里面的每一个数据
                 *                    方法体：生成键的代码
                 *                    返回值：已经生成的键
                 *
                 *        参数二：
                 *          Function 泛型一：表示流中每个数据的类型
                 *                   泛型二：表示Map集合中值的数据类型
                 *
                 *          方法 apply 形参：依次表示流里面的每一个数据
                 *                    方法体：生成值的代码
                 *                    返回值：已经生成的值
                 */
                .collect(Collectors.toMap(new Function<String, String>() {
                    public String apply(String s) {
                        return s.split("-")[0];
                    }
                }, new Function<String, Integer>() {
                    public Integer apply(String s) {
                        return Integer.parseInt(s.split("-")[2]);
                    }
                }));
        System.out.println(map.toString());

        Map<String, Integer> map1 = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toMap(
                        s1 -> s1.split("-")[0],
                        s2 ->Integer.parseInt( s2.split("-")[2])
                ));
        System.out.println(map1);
    }
}
