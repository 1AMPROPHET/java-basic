# ArrayList

## 构造方法(泛型)

```java
// JDK7 之前的写法
// 集合不能存储基本数据类型
ArrayList<String> list1 = new ArrayList<String>()

// JDK7 之后
ArrayList<String> list2 = new ArrayList<>();
```

## 添加元素

```java
ArrayList<String> list = new ArrayList<>();

list.add('aaa')；
```

## 删除元素

```java
ArrayList<String> list = new ArrayList<>();

boolean result = list.remove('aaa')
```
