# Collection

## Collection 基本方法

|方法名称|说明|
|-|-|
|public boolean add(E e)|把给定的对象添加到当前集合中|
|public void clear()|清空集合中所有的元素|
|public boolean remove(E e)|把给定的对象在当前结合中删除|
|public boolean contains(Object obj)|判断当前集合中是否包含给定的对象|
|public boolean isEmpty()|判断当前集合是否为空|
|public int size()|返回集合中元素的个数/集合的长度|

## 遍历方式

### 迭代器遍历

- Collection 集合获取迭代器

```java
// 返回迭代器对象，默认指向当前集合的0索引
Iterator<E> iterator()
```

- Iterator中的常用方法

```java
// 判断当前位置是否有元素，有元素返回true，没有元素返回false
boolean hasNext()

// 获取当前位置的元素，并将迭代器对象移向下一个位置
E next()
```

## 泛型

- 泛型：是JDK5中引入的特性，可以在编译阶段约束操作的数据类型，并进行检查
- 泛型的格式：<数据类型>
- 泛型的好处
  - 统一数据类型
  - 把运行时期的问题提前到了编译期间，避免了强制类型转换可能出吸纳的异常，因为在编译阶段类型就能确定下来

- 泛型的细节
  - 泛型中不能写基本数据类型
  - 指定泛型的具体类型后，传递数据时，可以传入该类类型或者子类型
  - 默认是Object类型

```java
public class MyArrayList<E> {

  Object[] obj = new Object[10];
  // E:表示不确定的类型，该类型在类名后面定义过了
  int size;

  public boolean adad(E e) {
    obj[size] = e;
    size++;
    return true;
  }

  public E get(int index) {
    return (E)obj[index];
  }
}
```

### 泛型方法

```java
public class ListUtil {
  private ListUtil() {

  }

  public static <E> void addAll(ArrayList<E> list, E e1, E e2) {
    list.add(e1);
    list.add(e2);
    list.add(e3);
    list.add(e4);
  }
}

public class Demo {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();

    listUtil.addAll(list, "111", "222", "333", "444");
  }
}
```

### 泛型的继承和通配符

- 泛型不具备继承性、但是数据具备继承性
- ? 也表示不确定的类型
- 可以进行类型的限定
  - ? extends E: 表示可以传递E 以及 E 所有的子类型
  - ? super E: 表示可以传递E 以及 E 所有的父类型