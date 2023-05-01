package InmmutableDemo;

import java.util.Map;
import java.util.Set;

public class ImmutableDemo2 {
    public static void main(String[] args) {
        // 创建不可变Set 集合，要保证里面的数据的唯一性

        Set<String> set = Set.of("Tom", "Jack", "Lucy", "Betty");

        for (String name : set) {
            System.out.println(name);
        }

        Map<String, String> map = Map.of("1", "Tom", "2", "Jack", "3", "Lucy");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ": " + value);
        }

    }
}
