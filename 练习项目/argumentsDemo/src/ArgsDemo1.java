public class ArgsDemo1 {
    public static void main(String[] args) {
        // 计算n个数的和
        int[] arr = {1,2,3,4,5,6,7};
        int sum = getSum(arr);
        System.out.println(sum);
    }

    public static int getSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }
}
