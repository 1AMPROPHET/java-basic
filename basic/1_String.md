# String

## String 对象

### 初始化

- String s = "xxx"；
- String s = new String()；

### 字符串比较

- boolean equals()；
- boolean equalsIgnoreCase()；

### 字符串的遍历

- public char charAt(int index)； 根据索引返回字符串
- public int length()； 返回字符串的长度

## StringBuilder 对象

### 初始化

- StringBuilder sb = new StringBuilder()；

### 添加元素

- sb.append()；

### 反转

- sb.reverse()；

### 长度

- sb.length()；

### 变回字符串

- String s = sb.toString()；

## StringJoiner

### 构造方法

- public StringJoiner(间隔符号)；
- public StringJoiner(间隔符号，开始符号，结束符号)；
