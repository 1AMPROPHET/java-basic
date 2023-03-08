# lambda 表达式

```java
public class LambdaDemo {
  public static main(String[] args) {
    // 利用匿名内部类的形式去调用下面的方法
    // 调用一个方法的时候，如果方法的形参是一个接口，那么我们要传递这个接口的实现类对象
    // 如果实现类对象只要用到一次，就可以用匿名内部类的形式进行书写
    method(new Swim() {
      public void swimming() {
        System.out.println("swimming");
      }
    });


    method(() -> {
      System.out.println("swimming");
    });
  }

  public static void method(Swim s) {
    s.swimming();
  }
}

interface Swim {
  public abstract void swimming();
}
```

## Lambda 表达式的基本作用

- 简化函数式接口的匿名内部类的写法

## Lambda 表达式有什么使用前提

- 必须是接口的匿名内部类，接口中只能有一个抽象方法

## Lambda 的好处

- Lambda 是一个匿名函数，我们可以把Lambda表达式理解为是一段可以传递的代码，他可以写出更简洁，更灵活的代码，作为一种更紧凑的代码风格，使Java语言表达能力得到了提升

## Lambda 表达式的省略规则

- 参数类型可以省略不写
- 如果只有一个参数，参数类型可以省略，同时（）也可以省略
- 如果Lambda表达式的方法体只有一行，大括号、分号return可以省略不写，需要同时省略

```java
public class LambdaDemo1 {
  public static void main(String[] args) {
    Integer[] arr = {1, 2, 3, 4, 5};
    // Arrays.sort(arr, new Comparator<Integer>() {
    //   public int compare(Integer o1, Integer o2) {
    //     return o1 - o2;
    //   }
    // })

    Arrays.sort(arr, (Integer o1, Integer o2) -> {
      return o1 - o2;
    });

    // 省略
    Arrays.sort(arr, (o1, o2) -> o1 - o2);
  }
}
```