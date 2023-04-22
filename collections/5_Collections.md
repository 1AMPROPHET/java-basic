# Collections

- Collections 不是集合，而是集合的工具类

## Collections 常用API

|方法名称|说明|
|-|-|
|public static `<T>` boolean addAll(Collection `<T>` c, T... elements)|批量添加元素|
|public static void shuffle(List<?> list)|打乱List集合元素顺序|

```java
public class CollectionDemo1 {
  public static void main(String[] args) {
    // 创建集合对象
    ArrayList<String> list = new ArrayList<>;


    // 批量添加元素
    Collections.addAll(list, "abc", "dasd", "sgg");
    // 打印集合
    System.out.println(list);
  }
}
```