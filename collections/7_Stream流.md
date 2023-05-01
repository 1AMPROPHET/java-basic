# Stream 流

## Stream 流的作用

- 结合了lambda表达式，简化集合、数组的操作

## Stream 流的使用步骤

- 先得到一条Stream流，并把数据放上去
- 使用中间方法对流水线上的数据进行操作
- 使用终结方法对流水线上的数据进行操作

### 得到Stream流，并把数据放上去

|获取方式|方法名|说明|
|-|-|-|
|单列集合|`default Stream<E> stream()`|Collection中的默认方法|
|双列集合|无|无法直接使用stream流|
|数组|`public static<T> Stream<T> stream(T[] array)`|Arrays工具类中的静态方法|
|一堆零散数据|`public static<T> Stream<T> of(T... values)`|Stream 接口中的静态方法|

### Stream 流的中间方法

|名称|说明|
|-|-|
|`Stream<T> filter(Oredicate<? super T> predicate)`|过滤|
|`Stream<T> limit(long maxSize)`|获取前几个元素|
|`Stream<T> skip(long n)`|跳过前几个元素|
|`Stream<T> distinct()`|元素去重，依赖hashCode和equals方法|
|`static<T> Stream<T> concat(Stream a, Stream b)`|合并a和b两个流为一个流|
|`Stream<R> map(Function<T, R> mapper)`|转换流中的数据类型|

### Stream 流的终结方法

|名称|说明|
|`void forEach(Consumer action)`|遍历|
|`long count()`|统计|
|`toArray()`|收集流中的数据|
|`collect(Collector collector)`|收集流中的数据，放到集合中|

### Stream 流 收集方法 collect
