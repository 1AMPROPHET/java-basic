public class argsDemo2 {
    public static void main(String[] args) {
        // 可变参数
        int sum = getSum(1,2,3,4,5,6);
        System.out.println(sum);
    }

    public static int getSum(int... args) {
        int sum = 0;
        for (int i : args) {
            sum += i;
        }
        return sum
    }
}
