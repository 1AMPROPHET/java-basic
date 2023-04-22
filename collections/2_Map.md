# Map 常用的API

Map 是双列集合的顶层接口，他的功能是全部双列集合都可以继承使用的

## 常见API

|方法名称|说明|
|-|-|
|put(K key，V value)|添加元素|
|remove(Object key)|根据键删除键值对元素|
|void clear()|移除所有的键值对元素|
|boolean containsKey(Object key)|判断集合是否包含指定的键|
|boolean containsValue(Object value)|判断集合是否包含指定的值|
|boolean isEmpty()|判断集合是否为空|
|int size()|集合的长度，集合中键值对的个数|

- put 方法的细节
  - 添加：在添加数据的时候，如果键不存在，那么直接把键值对象添加到map集合中
  - 覆盖：如果键是存在的，那么会把键值对对象覆盖，会把覆盖的值返回

## 遍历方式

### 键找值

```java
Map<String, String> map = new HashMap();

map.put("1", "1");
map.put("2", "2");
map.put("3", "3");

// search by keys
Set<String> keys = map.keySet();

for (String key: keys) {
    String value = map.get(key);
    System.out.println(key + " = " + value);
}
```

### 所有键值对对象

```java
Map<String, String> map = new HashMap();

map.put("1", "1");
map.put("2", "2");
map.put("3", "3");

Set<Map.Entry<String, String>> entries = map.entrySet();

for (Map.Entry<String, String> entry : entries) {
    String key = entry.getKey();
    String value = entry.getValue();
    System.out.println(key + " = " + value);
}
```

### lambda 表达式遍历

```java
Map<String, String> map = new HashMap();

map.put("1", "1");
map.put("2", "2");
map.put("3", "3");

map.forEach(new BiConsumer<String, String>() {
    public void accept(String key, String value) {
      System.out.println(key + "=" + value)
    }
});

// lambda

map.forEach((String key, String value) -> {
    System.out.println(key + "=" + value);
});
```

## HashMap

### HashMap 的特点

- HashMap 是map里面的一个实现类
- 没有额外的方法
- 特点由键决定：无序、不重复、无所引
- HashMap 和 HashSet 底层原理是一模一样的，都是哈希表结构
  - HashMap 底层是哈希表结构的
  依赖 hashCode 方法和 equals 方法保证键的唯一
  - 如果键存储的是自定义对象，需要重写 hashCode 和 equals 方法
  - 如果值存储的是自定义对象，不需要重写

## LinkedHashMap

- 由键决定：有序、不重复、无索引
- 有须知保证存储和取出顺序相同
- 原理：底层结构依然是哈希表。只是每个键值对元素又额外多了一个双链表的机制记录存储的顺序。