package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.IntFunction;

public class StreamDemo3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰", "张翠山", "张良", "王二麻子", "谢广坤", "张无忌", "张无忌");

        list.stream().forEach(s -> System.out.println(s));

        long count = list.stream().count();
        System.out.println(count);

        Object[] arr = list.stream().toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });

        System.out.println(Arrays.toString(arr));

        String[] arr1 = list.stream().toArray(value -> new String[value]);
        System.out.println(Arrays.toString(arr1));
    }
}
