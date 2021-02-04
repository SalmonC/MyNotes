- [第一章 API](#----api)
  * [概述](#--)
  * [使用](#--)
- [第二章 Scanner类](#----scanner-)
  * [2.1 什么是Scanner类](#21----scanner-)
  * [2.2 引用类型的使用](#22--------)
  * [2.3 匿名对象](#23-----)
    + [概念](#--)
    + [应用](#--)
- [第三章 Random类](#----random-)
  * [3.1 Random类的使用](#31-random----)
- [第四章 集合(ArrayList)](#-------arraylist-)
  * [泛型](#--)
  * [使用](#---1)
    + [方法](#--)

<small><i><a href='http://ecotrust-canada.github.io/markdown-toc/'>Table of contents generated with markdown-toc</a></i></small>

# 第一章 API

## 概述

API(Application Programming Interface)，应用程序编程接口。Java API是JDK中提供给我们使用的类的说明文档。这些类将底层的代码实现封装了起来，我们只需要学习如何使用。

## 使用

打开JDK API文件，在索引中搜索想看的*类*，点击后主要查看3个内容：

1. 所在的包路径，写在标题上方；
2. 构造方法；
3. 方法摘要。



# 第二章 Scanner类

## 2.1 什么是Scanner类

一个可以解析基本类型和字符串的简单文本扫描器。可以实现键盘输入数据到程序当中。

## 2.2 引用类型的使用

+ 一般步骤：

  1. 第一步：导包
     如果需要使用的目标类和当前类位于同一个包，则可以省略导包。lung包不需要import。
     import 包路径.类名称;
  2. 第二步：创建
     类名称 对象名 = new 类名称();
     System.in代表从键盘进行输入

  3. 第三步：使用
     对象名.成员方法名()  

     获取键盘输入的一个int数字：int num = sc.nextInt();
     获取键盘输入的一个int数字：String str = sc.next();

## 2.3 匿名对象

### 概念

+  创建对象的标准格式：

  ```java
  类名称 对象名 = new 类名称();
  ```

+ 匿名对象：只有右边的对象，没有左边的名字和赋值运算符：

  ```java
  new 类名称();
  ```

+ 匿名对象只能使用唯一一次，再用时只能再创建新对象。如果有一个对象只需要使用一次，可以使用匿名对象。

### 应用

+ 匿名对象进行传参

  ```java
  public static void methodParam(Scanner sc){
    ...
  }
  ```

+ 匿名对象作为返回值

  ```java
  public static Scanner methodReturn(){
    return new Scanner(Systenm.in);
  }
  ```

  

# 第三章 Random类

## 3.1 Random类的使用

+ 用途：生成随机数字

+ 使用过程：也是三个步骤

  1. 第一步：导包

     `import java.util.Random;`

  2. 第二步：创建

     `Random r = new Random()`

  3. 第三步：使用

     获取一个随机的int数字，范围是int所有范围：`nextInt()`

     获取一个随机的int数字，以参数限定范围：`nextInt(a)`范围：[0, a)，即0~(a-1)，参考数组索引。



# 第四章 集合(ArrayList)

数组长度不可以改变，但ArrayList集合可以。

## 泛型

+ 对于ArrayList，有一个<E>代表泛型。

+ 泛型：装在集合中的所有元素，全都是统一的什么类型，如：元素全都是String等。

  注意：泛型只能是引用类型，不能是基本类型。即只能储存地址值。

## 使用

+ 对于ArrayList来说，直接打印得到的不是地址值，而是内容；如果内容是空，打印出的是空的[ ]。

### 方法

+ 常用方法：

|  方法   |     参数      |           返回值            |       作用       |
| :-----: | :-----------: | :-------------------------: | :--------------: |
|  .add   | E，与泛型一致 |    boolean，是否成功执行    |     添加内容     |
|  .get   | int，索引编号 | E，索引对应内容，与泛型一致 |     读取内容     |
| .remove | int，索引编号 | E，索引对应内容，与泛型一致 |  读取并删除内容  |
|  .size  |      无       |   int，集合包含的元素个数   | 获取集合尺寸长度 |

+ 对于ArrayList来说，add一定成功，返回值可用可不用；

+ 可用list.size遍历集合：

  ```java
  for (int i = 0; i < list.size(); I++){ // 也可直接用list.fori。注意不是list.length
    System.out.println(list.get(i));
  }
  ```

+ ArrayLIst只能储存地址值，如果需要储存基本类型数据，需要使用其包装类：

  | 基本类型 |    包装类     |
  | :------: | :-----------: |
  |   byte   |     Byte      |
  |  short   |     Short     |
  | **int**  |  **Integer**  |
  |   long   |     Long      |
  |  double  |    Double     |
  | **char** | **Character** |
  | boolean  |    Boolean    |

```java
ArrayList<Integer> list = new ArrayList<>();
list.add(100);
```



+ 从JDK 1.5+开始，支持自动装箱、自动拆箱：  
  + 自动装箱：基本类型-->引用类型
  + 自动拆箱：引用类型-->基本类型

