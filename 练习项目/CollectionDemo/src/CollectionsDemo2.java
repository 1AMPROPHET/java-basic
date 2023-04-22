import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class CollectionsDemo2 {
    public static void main(String[] args) {
        // 班级有N个学生，要求：
        // 70%概率抽到男生，30%概率抽到女生

        // 创建集合
        ArrayList<Integer> list = new ArrayList<>();

        Collections.addAll(list, 1, 1, 1, 1, 1, 1, 1);
        Collections.addAll(list, 0, 0, 0);

        // 打乱
        Collections.shuffle(list);

        // 从list集合中随机抽取0，1
        Random r = new Random();
        int index = r.nextInt(list.size());
        int number = list.get(index);

        // 创建两个集合存男女生名字
        ArrayList<String> boyList = new ArrayList<>();
        ArrayList<String> girlList = new ArrayList<>();

        Collections.addAll(boyList, "Tom", "Jack", "Bill", "Harry", "Henry", "Peter", "Will");
        Collections.addAll(girlList, "Sophia", "Betty", "Angela", "Marry");

        if (number == 1) {
            int boyIndex = r.nextInt(boyList.size());
            String name = boyList.get(boyIndex);
            System.out.println(name);
        } else {
            int girlIndex = r.nextInt(girlList.size());
            String name = girlList.get(girlIndex);
            System.out.println(name);
        }
    }
}
