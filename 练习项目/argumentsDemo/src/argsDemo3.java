public class argsDemo3 {
    // 可变参数小细节
    // 在方法的形参中只能写一个可变参数

    // 在方法的形参当中，如果除了可变参数以外，还有其他的形参，那么可变参数要卸载最后
    public static void main(String[] args) {
        getSum(1,2,3,4,5,6);
    }

    public static int getSum(int a, int ...args) {
        return 0;
    }
}
