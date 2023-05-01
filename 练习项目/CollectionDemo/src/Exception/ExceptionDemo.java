package Exception;

public class ExceptionDemo {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5};
        int[] arr = null;
        int max = 0;
        try {
            max = getMax(arr);
        } catch (NullPointerException e) {
            System.out.println("Null Pointer Exception");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index out of Bounds Exception");
        }
        System.out.println(max);
    }

    public static int getMax(int[] arr) throws NullPointerException, ArrayIndexOutOfBoundsException {
        if (arr == null) {
            // 手动创建一个异常，把这个异常交给方法的调用者处理
            throw new NullPointerException();
        }
        System.out.println("xxx");
        int max = arr[0];
        for (int i = 0; i < arr[i]; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
