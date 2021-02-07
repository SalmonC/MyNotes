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

## 应用

+ 用途：生成随机数字

+ 使用过程：也是三个步骤

  1. 第一步：导包

     `import java.util.Random;`

  2. 第二步：创建

     `Random r = new Random()`

  3. 第三步：使用

     获取一个随机的int数字，范围是int所有范围：`nextInt()`

     获取一个随机的int数字，以参数限定范围：`nextInt(a)`范围：[0, a)，即0~(a-1)，参考数组索引。



# 第四章 集合(ArrayList)类

数组长度不可以改变，但ArrayList集合可以。

## 泛型

+ 对于ArrayList，有一个<E>代表泛型。

+ 泛型：装在集合中的所有元素，全都是统一的什么类型，如：元素全都是String等。

  注意：泛型只能是引用类型，不能是基本类型。即只能储存地址值。

## 使用

+ 对于ArrayList来说，直接打印得到的不是地址值，而是内容；如果内容是空，打印出的是空的[ ]。

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



# 第五章 String类

API中说，`String`类代表字符串。 Java程序中的所有字符串文字（例如`"abc"` ）都被实现为此类的实例。

也就是说，程序当中所有双引号字符都是`String`类的对象。（即使没有new也是）



## 5.1 特点

1. 字符串是**常量**，内容永不可变。【重点】
2. 因为字符串不可改变，所以字符串可以共享使用。
3. 字符串效果上相当于char[ ]字符数组，但是底层原理是byte[ ]字节数组。



## 5.2 创建

常见3种构造方法，1种直接创建：

```java
//第一种构造方法，创建一个空白字符串，不含有任何内容
public String()

//第二种构造方法，根据字符数组的内容创建对应字符串
public String(char[] array)
    
//第三种构造方法
public String(byte[] array)
    
//直接创建
String str = "Hello"
```



## 5.3 常量池

+ 字符串常量池在**堆**中。
+ 程序中直接写上的双引号字符，就在字符串常量池中；`new`的字符串不在常量池中。

+ 对于基本类型，`==`是比较数值；对于引用类型，`==`是比较地址值。



## 5.4 常用方法

+ 比较字符串内容：

  1. ```java
     public boolean equals(Object obj)
     ```

     + 参数可以是任何**对象**，只有参数是字符串且相同，才会返回true；

     + equals具有对称性，即`a.equals(b)`和`b.equals(a)`效果一样；

     + 如果比较双方一个常量一个变量，推荐把常量字符串写在前面，如：

       推荐：`"abc".equals(str1)`

       不推荐：`str1.equals("abc")`

       因为变量为`null`时前者返回`false`，后者报错空指针异常`NullPointerException`

  2. ```java
     public boolean equalsIgnoreCase(String str)
     ```

     + 忽略大小写进行内容比较。

       

+ 获取相关

  ```java
  //获取字符串当中含有的字符个数，拿到字符串长度；
  public int length()
  
  //将当前字符串和参数字符串拼接为新的字符串，return；如果有null，会空指针异常
  public String concat(String str)
  
  //获取指定索引位置的单个字符
  public char charAt(int index)
  
  //查找参数字符串在本字符串中首次出现的索引位置，没有则返回-1值
  public int indexOf(String str)
  ```

  

+ 截取相关

  ```java
  // 截取从参数位置一直到字符串末尾，返回新字符串
  public String substring(int index)
  
  // 截取从begin开始，end结束，中间的字符串，[begin, end)，包含左边，不包含右边
  public String substring(int begin, int end)
      
  // 注意：截取之后原字符串不发生变化。
  ```

  

+ 转换相关

  ```java
  // 将当前字符串拆分成为字符数组，return
  public char[] toCharArray()
  
  // 获得当前字符串底层的字节数据
  public byte[] getBytes()
      
  // 将所有出现的老字符串(oldString)替换为新字符串(newString)，返回新的字符串
  // CharSequence意思是可以接受字符串类型，可以看做String
  public String replace(CharSequnce oldString, CharSequence newString)
  ```



+ 分隔

  ```java
  // 按照参数规则，将字符串切分成为若干部分
  public String[] split(String regex)
  ```

  + split方法参数是正则表达式(regex)，"."等符号需要`\\`进行转义



# 第六章 static静态关键字

## 6.1 static field

+ 使用了static关键字的内容不再属于对象自己，而是属于类，所以凡是属于本类的对象都共享同一份。
+ 给其中一个赋值，其他所有对象都会改变



## 6.2 static method

+ 使用方法
  1. 一旦使用static修饰成员方法，就成为了静态方法。
  2. 静态方法不属于对象，而是属于类。
  3. 如果没有static关键字，则必须先创建对象才能使用。
  4. 对于静态方法，可以通过对象名进行调用（不推荐），也可以通过**类名称**进行调用。
  5. 无论是**静态变量**还是**静态方法**，都推荐使用类名称进行调用。
  6. 对于**本类当中的*静态*方法**，可以省略类名称。

+ 注意事项
  1. 静态不能直接访问非静态：如静态方法不能直接访问成员变量，因为在内存中**先**有静态，**后**有非静态内容；
  2. 静态方法中不能用this：this代表当前对象，但静态方法和对象无关。
  3. 

## 6.3 静态代码块

+ 格式：

```java
public class 类名称{
    static{
        // 静态代码块内容
    }
}
```

+ 特点：当**第一次**用到本类，静态带麦克执行**唯一**的一次。
+ **静态内容总是优先于非静态**，静态代码块比构造方法优先执行。
+ 静态代码块的典型用途：用于一次性地对静态成员变量赋值。



# 第七章 Arrays类

Arrays是一个与数组相关的工具类，里面提供了大量的静态方法，用来实现数组常见的操作。

常用方法：

+ `public static String toString(Array)`：将参数数组变成字符串，按照默认格式：[元素1, 元素2, 元素3 ...]。

+ `public static void sort(Array)`：对数组元素进行排序，按照默认升序。

  ```java
  public static void main(String[] args){
      int[] array1 = {2, 1, 3, 5, 12};
      Arrays.sort(array1);
      System.out.println(Arrays.toString(array1)); //[1, 2, 3, 5, 12]
  }
  ```

  + 如果是数值，`sort`默认按照从小到大；
  + 如果输字母，默认按照字母升序；
  + 如果是自定义类型，那么这个自定义的类需要有Comparable或者Comparator接口的支持。



# 第八章 Math类

java.lang.Math 类是数学相关的工具类，里面有大量的静态方法，完成与数学运算相关的操作。

常用方法

+ `public static double abs(double num)`：获取绝对值。
+ `public static double ceil(double num)`：向上取整。
+ `public static double floor(double num)`：向下取整。
+ `public static long round(double num)`：四舍五入。
+ `Math.PI`：代表近似圆周率



