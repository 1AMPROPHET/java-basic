import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<LiHuaCat> list1 = new ArrayList<>();
        ArrayList<PersianCat> list2 = new ArrayList<>();
        ArrayList<Teddy> list3 = new ArrayList<>();
        ArrayList<Husky> list4 = new ArrayList<>();

        keepCat(list1);
        keepCat(list2);
        keepDog(list3);
        keepDog(list4);

        keepPet(list1);
    }

    public static void keepCat(ArrayList<? extends Cat> list) {

    }

    public static void keepDog(ArrayList<? extends Dog> list) {

    }

    public static void keepPet(ArrayList<? extends Animal> list) {

    }
}