# File

- File对象就表示一个路径，可以是文件的路径、也可以是文件夹的路径
- 路径可以存在，可以不存在

## 常见方法

|方法名称|说明|
|pubic File(String pathname)|根据文件路径创建文件对象|
|public File(String parent， String child)|根据父路径名字符串和子路径名字符串创建文件对象|
|public File(File parent，String child)|根据父路径对应文件对象和子路径名字符串创建文件对象|

- File 表示什么
  - File对象就表示一个路径，可以是文件的路径、也可以是文件夹的路径
  - 路径可以存在，可以不存在
- 绝对路径和相对路径是什么意思
  - 绝对路径是带盘符的
  - 相对路径不带盘符，默认到当前项目下去找
- File三种构造方法的作用
  - 如上
