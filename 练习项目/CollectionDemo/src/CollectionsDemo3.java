import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CollectionsDemo3 {
    public static void main(String[] args) {

        // 不重复点名
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "Tom", "Jack", "Bill", "Harry", "Henry", "Peter", "Will");

        ArrayList<String> list2 = new ArrayList<>();
        int length = list1.size();

        Random r = new Random();

        for (int i = 0; i < length; i++) {
            int index = r.nextInt(list1.size());
            String name = list1.remove(index);
            list2.add(name);
            System.out.println(name);
        }

        // 点名完成后清空
        list1.addAll(list2);
        list2.clear();
    }
}
