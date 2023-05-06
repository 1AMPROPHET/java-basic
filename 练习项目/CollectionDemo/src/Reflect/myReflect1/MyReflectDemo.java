package Reflect.myReflect1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

public class MyReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 1.获取class字节码文件对象
        Class<?> clazz = Class.forName("Reflect.myReflect1.Student");

        // 2.获取构造方法,public
//        Constructor<?>[] cons1 = clazz.getConstructors();
//        for (Constructor<?> con : cons1) {
//            System.out.println(con);
//        }
//
//        // 获取全部构造方法
//        Constructor<?>[] cons2 = clazz.getDeclaredConstructors();
//        for (Constructor<?> con : cons2) {
//            System.out.println(con);
//        }

        // 获取某一个
        Constructor<?> con1 = clazz.getDeclaredConstructor();
        System.out.println(con1);

        Constructor<?> con2 = clazz.getDeclaredConstructor(String.class);
        System.out.println(con2);

        Constructor<?> con3 = clazz.getDeclaredConstructor(String.class);
        System.out.println(con3);

        Constructor<?> con4 = clazz.getDeclaredConstructor(String.class, int.class);
        System.out.println(con4);

        int modifiers = con4.getModifiers();
        System.out.println(modifiers);

        Parameter[] parameters = con4.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }

        // 暴力反射，标识临时取消权限校验
        con4.setAccessible(true);
        Object stu = con4.newInstance("Wang", 26);
        System.out.println(stu);
    }
}
