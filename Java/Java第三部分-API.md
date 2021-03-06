# 第一章 API

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
  new 类名称  
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

     `import Java.util.Random;`

  2. 第二步：创建

     `Random r = new Random()`

  3. 第三步：使用

     获取一个随机的int数字，范围是int所有范围：`nextInt()`

     获取一个随机的int数字，以参数限定范围：`nextInt(a)`范围：[0, a)，即0~(a-1)，参考数组索引。



# 第四章 ArrayList类

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

+ `public static String toString(Array)`：将参数数组变成字符串，按照默认格式：[元素1, 元素2, 元素3 ...]。w

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



# 第九章 抽象类

## 9.1 概述

如果父类当中的方法不确定如何进行方法体实现，这就是一个抽象方法。

![抽象方法](https://cdn.jsdelivr.net/gh/SalmonC/PicBed@main/1612869913823-1612869913794.png)

## 9.2 定义与使用

+ 抽象方法：加上`abstract`关键字，去掉大括号，直接分号结束。

  ```java
  public abstract void eat();
  ```

+ 抽象类：抽象方法所在的类必须是抽象类，在class之前写上abstract即可。

+ 使用：

  1. 不能直接创建new抽象类对象；

  2. 必须用一个子类来继承抽象父类；

  3. 子类必须覆盖重写抽象父类当中所有的抽象方法；

     覆盖重写（实现 implements）：去掉抽象方法的`abstract`，然后补上方法体。

## 9.3 注意事项

1. 抽象类**不能创建对象**；
2. 抽象类中，可以有构造方法，是供子类创建对象时，初始化父类成员用的；
3. 抽象类中，不一定包含抽象方法，但有抽象方法的一定是抽象类；
4. 抽象类的子类，必须重写抽象父类中**所有的**抽象方法，否则编译无法通过，除非子类也是抽象类。



# 第十章 接口(interface)

接口是一种公共的规范标准。

只要符合规范标准，就可以大家通用。



## 10.1 基本格式

+ 接口就是多个类的公共规范。

+ 接口是一种引用数据类型，最重要的内容就是其中的**抽象方法**。

+ 如何定义一个接口格式：

  ```java
  public interface 接口名称{
      接口内容;
  }
  ```

  备注：关键字class换成interface之后，编译生成的字节码文件仍然是 .java --> .class。

+ 如果是java7，那么接口中可以包含的内容有：
  1. 常量
  2. 抽象方法
+ 如果是java8，还可以**额外包含**有：
  3. 默认方法
  4. 静态方法
+ 如果是java9，还可以**额外包含**有：
  
  5. 私有方法



## 10.2 各种方法的定义与使用

### ①抽象方法(abstract)

在任何的java版本中，接口都能定义抽象方法。

格式：

```java
public abstract void 方法名();
```

注意事项：

1. 接口当中的抽象方法，修饰符必须是两个固定的关键字：`public`、`abstract`；
2. 这两个关键字修饰符，可以选择性地**省略**；
3. 方法的三要素（方法名、参数、返回值）可以随意定义。

使用

1. 接口不能直接使用，必须有一个“实现类”来“实现（implements)”该接口。

   格式：

   ```java
   public class 实现类名称 implements 接口名称{
       
   }
   ```

2. 接口的实现类必须覆盖重写接口中所有的抽象方法。

   实现：去掉`abstract`关键字，加上方法体大括号。

3. 创建实现类的对象，进行使用。不能直接new接口对象！

注意事项：

如果实现类并没有覆盖重写接口中所有的抽象方法，那么这个实现类必须是**抽象类**。



### ②默认方法(default)

从java8开始，接口里允许定义默认方法。

格式：

```java
public default 返回值类型 方法名称(参数列表){
    方法体;
}
```

备注：

接口当中的默认方法可以解决接口升级的问题，不用再去每个子类里实现。

使用

1. 默认方法会被实现类**继承**；

2. 接口的默认方法，可以通过接口实现类对象**直接调用**；

3. 接口的默认方法，也可以被接口实现类进行**覆盖重写**。

   

### ③静态方法(static)

从Java8开始，接口里允许定义静态方法。

格式：

```java
public static 返回值类型 方法名称(参数列表){
    方法体;
}
```

使用

1. 不能通过接口实现类的对象来调用接口中的静态方法（一个实现类可以实现多个接口）；
2. 正确用法：通过接口名称直接调用其中的静态方法。



### ④私有方法(private)

从Java9开始，接口里允许定义私有方法：

1. 普通私有方法：解决多个默认方法之间重复代码问题；

格式：

```java
private 返回值类型 方法名称(参数列表){
    方法体
}
```



1. 静态私有方法：解决多个静态方法之间重复代码问题；

```java
private static 返回值类型 方法名称(参数列表){
    方法体
}
```



## 10.3 常量的定义与使用

接口当中也可以定义“成员变量”，但是必须使用 `public static final`三个关键字进行修饰。

从效果上看，这其实就是接口的【常量】。

格式：

```java
public static final 数据类型 常量名称 = 数据值;
```

注意：

1. 使用`final`关键字，说明不可改变。

2. 接口当中常量可以省略`public static final`三个关键字，不写也会触发。
3. 接口当中的常量必须进行赋值，不能不赋值。
4. 接口当中的常量，名字要用完全大写，多个单词用 "_" 连接。（推荐命名规则）



## 10.4 注意事项

1. 接口不能有静态代码块或者构造方法；

2. 一个类的直接父类是唯一的，但一个类可以同时实现多个接口，

   格式：

   ```java
   public class 类名 implements 接口1, 接口2, ...{
       
   }
   ```

3. 如果实现类实现的接口中有重复的抽象方法，只需要覆盖重写一次；

4. 如果实现类没有覆盖重写所有抽象方法，实现类必须是抽象类；

5. 如果实现类实现的接口中有重复的默认方法，那么实现类一定要对冲突的默认方法进行**覆盖重写**；

6. 一个类如果直接父类的方法，和接口中的默认方法产生了冲突，优先用父类的方法。



## 10.5 接口间的多继承

1. 类与类之间是但继承的，直接父类只有一个；
2. 类与接口直接是多实现的。一个类可以实现多个接口；
3. 接口与接口之间是**多继承**的。

注意事项：

1. 多个父接口之间的抽象方法可以重复；
2. 多个父接口之间的默认方法不可重复，需要重写，且带着default关键字。



# 第十一章 final关键字

final关键字代表最终、**不可改变**的。

final的4种常见用法：

1. 可以用来修饰一个类
2. 可以用来修饰一个方法
3. 可以用来修饰一个局部变量
4. 可以用来修饰一个成员变量



## 11.1 修饰类

 final关键词用来修饰一个类时：

- 格式：

   ```java
   public final class 类名称{}
   ```

- 含义：当前类不能有任何**子类**

- 注意：一个类如果是final，那么其中所有成员方法都无法覆盖重写，



## 11.2 修饰方法

+ 含义：final修饰方法时，该方法**不能被覆盖重写**。

+ 格式：

```java
public final 返回值类型 方法名称(参数列表){}
```

+ 注意：对于类和方法来说，final关键字和abstract关键字不能同时使用，因为矛盾。



## 11.3 修饰局部变量

+ 含义：final修饰局部变量时，该变量不能进行更改。

+ 格式：可以直接赋值，也可以先创建再赋值；

```java
int final num = xxx;
//或者
int final num;
num = xxx;
```

+ 注意事项：

  对于基本类型来说，不可变说的是变量当中的数据不可变；

  对于引用类型来说，不可变说的是**地址值**不可变。



## 11.4 修饰成员变量

- 含义：final修饰成员变量时，该变量不能进行更改。
- 注意：
  1. 由于成员变量具有默认值，所以用了final之后必须手动赋值，不会再给默认值；
  2. 对于使用final的成员变量，要么使用直接赋值，要么通过构造方法赋值；
  3. 必须保证**所有重载方法**都会对成员变量进行赋值；



# 第十二章 权限修饰符

Java中有四种权限修饰符：

|              | public | protected | (default) | private |
| ------------ | :----: | :-------: | :-------: | :-----: |
| 同一个类     |   ✔️    |     ✔️     |     ✔️     |    ✔️    |
| 同一个包     |   ✔️    |     ✔️     |     ✔️     |    ❌    |
| 不同包子类   |   ✔️    |     ✔️     |     ❌     |    ❌    |
| 不同包非子类 |   ✔️    |     ❌     |     ❌     |    ❌    |

注：子包不算同一个包



# 第十三章 内部类

如果一个事物的内部包含另一个事物，那么这就是一个类内部包含另一个类（内部类）。

例如：身体和心脏的关系、汽车和发动机的关系。

内部类分为**成员内部类**和**局部内部类**（含匿名内部类）。



## 13.1 成员内部类

+ 成员内部类的定义格式：

```java
修饰符 class 外部类名称{
    修饰符 class 内部类名称{
        ...
    }
}
```

+ 注意：内用外，随意访问；外用内，需要内部类对象。

+ 使用：

  1. 间接方式：在外部类的方法中，使用内部类；main只是调用外部类的方法。

  2. 直接方式：公式：

     ```java
     类名称 对象名 = new 类名称; //正常方式
     外部类名称.内部类名称 对象名 = new 外部类名称().new 内部类名称();
     ```

+ 同名变量访问：

  ```java
  // 如果出现了重名现象，那么格式是：外部类名称.this.外部类成员变量名
  public class Outter{
  
      int num = 10; // 外部类的成员变量
      
      public  class inner{
          int num = 20; // 内部类的成员变量
          
          public void methodInner(){
              int num = 30; // 内部方法的局部变量
              System.out.println(num); // 10
              System.out.println(this.num); // 20
              System.out.println(Outer.this.num); // 30
          }
      }
  }
  ```

  

## 13.2 局部内部类（包含匿名内部类）

+ 定义：如果一个类是定义在一个方法内部的，那么这就是一个局部内部类。

+ “局部”：只有当前所属的方法才能使用它，出了这个方法外面就不能用了。 

+ 定义格式：

  ```java
  修饰符 class 外部类名称{
  	修饰符 返回值类型 外部类方法名称(参数列表){
  		class 局部内部类名称{
              ...
          }
      }
  }
  ```

+ 注意：

  局部内部类，如果希望访问所在方法的局部变量，那么这个局部变量必须是**有效final的**（从 Java 8+开始，可以不写final，但只能赋值一次）

  原因：

  1. new出来的对象在堆内存中；
  2. 局部变量时跟着方法走的，在栈内存当中；
  3. 方法运行结束之后立刻出栈，局部变量立刻消失；
  4. 但new出来的对象会在堆当中持续存在，直到垃圾回收消失。

+ 小结一下类的权限修饰符
  1. 外部类：public、default
  2. 成员内部类：public、protected、default、private
  3. 局部内部类：什么都不能写

### **匿名内部类**

如果接口的实现类（或者父类的子类）只需要使用唯一的一次，那么这种情况下可以省略掉该类的定义，改为使用**匿名内部类**。

+ 定义格式：

  ```java
  接口名称 对象名 = new 接口名称(){
      覆盖重写所有抽象方法；
  }
  ```

+ 注意事项

  1. 匿名内部类在**创建对象**的时候，只能使用唯一一次；

  2. 匿名对象在**调用方法**的时候只能调用一次；

  3. 匿名内部类是省略了实现类或子类，但匿名对象是省略了对象名称。

     匿名内部类和匿名对象不是一回事！

+ 任何对象都可以作为类的成员变量

  + 一个类可以作为类的成员变量，参数为类的名称；
  + 一个接口可以作为类的成员变量，参数为接口的实现类。



# 第十四章 Object类

`java.lang.Object`类是Java语言中的根类，即所有类的父类。它中描述的所有方法子类都可以使用。在对象实例化的时候，最终找的父类就是 Object。

如果一个类没有指出extends父类，那默认继承Object类。

## `.toString`方法

返回该对象的字符串表示。

+ 可以重写以替换掉toString的作用。
+ 直接打印一个对象，会默认调用toString方法。

+ 看一个类是否重写了toString方法，直接打印这个类对应对象的名字即可：

  如果没有重写，打印出的就是对象的地址值；

  如果重写了，那么会按照重写的方法打印。



## `equals`方法

指示其他对象是否与此对象相等。

+ 源码：

  ```java
  public boolean equals(object obj){
      return (this == obj);
  }
  ```

  + 基本数据类型：比较的是值
  + 引用数据类型：比较的是地址值

+ 比较两个地址值没有意义，需要重写

+ 问题：

  隐含着一个多态，无法使用子类特有的内容；

  `Object obj = p2 = new Person(); `

  解决：向下转型（强转），然后比较两个对象的属性。



# 第十五章 Objects类

Objects是JDK7添加的工具类，提供了一些静态方法，多是null-sava（空指针安全的）或null-tolerant（容忍空指针的）。

+ Objects类的 equals方法：对两个对象进行比较，防止空指针异常



# 第十六章 日期时间类

## 16.1 Date类

java.util.Date类表示**特定的瞬间**，精确到毫秒。

### **毫秒值**的作用：可以对时间和日期进行计算

+ 2099-01-03到2088-01-01，中间一共有多少天

  可以把日期转换为毫秒进行计算，再把毫秒转换为日期

  把日期转换为毫秒：

  ​	当前的日期：2088-01-01

  ​	时间原点（0毫秒）：1970 年 1 月 1 日 00:00:00（英国格林威治 GMT）

  ​										1970 年 1 月 1 日 08:00:00（中国 CST）

  ​	就是计算当前日期到时间原点之间一共经历了多少毫秒

```java
System.out.println(System.currentTimeMills());#获取当前系统时间到原点经历了多少毫秒
```

### 构造方法

+ 空参构造：date()

  ```java
  Date date = new date();
  System.out.println(date);//不是地址值，是当前时间
  ```

  直接打印，内容为**当前时间**

+ 带参构造：date(long date)

  传递毫秒值，并转换为Date日期（+时间原点 CST）



### 常用方法

+ `long getTime()`：返回时间原点以来，此Date对象表示的毫秒数（相当于System.currentTimeMillis()方法）



## 16.2 DateFormat类

`java.text.DateFormat`对日期进行格式化的**抽象类**。

一般使用其子类`SimpleDateFormat`

+ 作用：格式化（日期 -> 文本）、解析（文本 -> 日期）



### DateFormat成员方法：

+ String format(Date date)

  按照指定的模式，把Date日期，格式化为符合模式的字符串。

+ Date parse(String source)

  把符合模式的字符串，解析为Date日期

### SimpleDateFormat

+ 构造方法

  + `SimpleDateFormat(String pattern)`

    用给定的模式和默认语言环境的日期格式符号构造SimpleDateFormat

  + 参数

    String pattern：传递指定的模式

  + 模式：区分大小写

    | 符号 | 含义 |
    | ---- | ---- |
    | y    | 年   |
    | M    | 月   |
    | d    | 日   |
    | H    | 时   |
    | m    | 分   |
    | s    | 秒   |

  + 注意：模式中的字母不能改变，连接模式的符号可以改变

    yyyy年MM月dd日 HH时mm分ss秒

    yyyy-MM-dd HH:mm:ss

    

## 16.3 Calendar类

java.util.Calendar日历类对Date类进行了很多替换，是一个**抽象类**。它提供了很多操作日历字段的方法。

+ 日历字段：YEAR、MONTH、DAY_OF_MONTH、HOUR等

+ 无法直接创建对象只用，

  常用创建方法：`Calendar rightNow = Calendar.getInstance()`

  `.getInstance()`返回了Calender类的子类对象：使用默认时区和语言环境获得一个日历。

  

### 常用方法

+ `public int get(int field)`：返回给定日历字段的值

  + int field：日历类的字段，可以使用Calendar类的静态成员变量获取。

+ `public void set(int field, int value)`：将给定的日历字段设置为给定值

  + 同时设置，有重载`(int YEAR, int MONTH, int DAY_OF_MONTH)`

+ `public abstract void add(int field, int amount)`：根据日历规则，为给定的日历字段添加或减去指定的时间量

  + int amount：增加减少的值

    正数：增加

    负数：减少

+ `public Date getTime()`：返回一个表示此Calendar时间值的Date对象



| 字段         | final int field | 含义         |
| ------------ | --------------- | ------------ |
| YEAR         | 1               | 年           |
| MONTH        | 2               | 月           |
| DATE         | 5               | 月中的某一天 |
| DAY_OF_MONTH | 5               | 月中的某一天 |
| HOUR         | 10              | 时           |
| MINUTE       | 12              | 分           |
| SECOND       | 13              | 秒           |

```java
psvm{
//get()
    Calendar c = Calendar.getInstance();
    int year = c.get(Calendar.YEAR); //year = 2021
    int month = c.get(Calendar.MONTH);//month = 2(西方月份0-11，东方月份1-12，此处为西方月份)
    
//add
    c.add(Calendar.YEAR, 2);//增加两年
    c.add(Canlendar.MONTH, -3);//减少两个月
    
//getTime()
    sout(c.getTime());//Thu Mar 11 17:33:14 CST 2021
}
```



# 第十七章 System类

java.lang.System类提供大量的静态方法。

常用方法：

+ `public static long currentTimeMillis()`：返回以**毫秒**为单位的当前时间
+ `public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)`将数组中指定数据拷贝到另一个数组中



## 17.1 currentTimeMillis

+ 可用于测试程序运行时长等：

```java
psvm{
    long s = System.currentTimeMillis();
    ...
    long e = System.currentTimeMillis();
    System.out.println("耗时" + (e-s) + "毫秒");
}
```



## 17.2 arraycopy

+ 作用：从源数组中复制n个元素，并**取代**目标数组中的n个元素（不会变长）
+ 参数：
  + src - 源数组（source）
  + srcPos - 源数组中的起始位置
  + dest - 目标数组（destination）
  + destPos - 目标数组中的起始位置
  + length - 要复制的元素数量

```java
psvm{
    int[] src = {1, 2, 3, 4, 5};
    int[] dest = {6, 7, 8, 9, 10};
    System.static.arraycopy(src, 0, dest, 0, 3);
    sout(Arrays.toString(dest)); //{1, 2, 3, 9, 10}
}
```



# 第十八章 StringBuilder

字符串是常量，不能更改，字符串的底层是一个被`final`修饰的数组；字符串缓冲区支持可变字符串。

```java
	String str = "abc"
// 等效于
    char data[] = {'a', 'b', 'c'};
	String str = new String(data);
```

进行字符串的相加，内存就会有**多个字符串**，占用空间多，效率低。



## 18.1 StringBuilder类

StringBuilder是字符串缓冲区，可以看成一个长度可变的字符串。

底层也是一个数组，但没有被final，初始容量为16，满了则增加16。

### 构造方法

+ `StringBuilder()`：构造一个不带任何字符的字符串生成器，初始容量为16；
+ `StringBuilder(String str)`：构造一个字符串生成器，初始化为指定内容。



### 常用方法

常用方法有两个：

+ `public StringBuilder append()`：添加任意类型的字符串形式，并**返回当前对象自身**；

+ `public String toString()`：将当前StringBuilder对象转换为String对象。

  



# 第十九章 包装类

基本数据类型使用起来较方便，但没有对应的方法来操作数据。

可以使用包装类来装基本类型的数据，在类中定义方法，来操作基本数据。

| 基本类型 |    包装类     |
| :------: | :-----------: |
|   byte   |     Byte      |
|  short   |     Short     |
| **int**  |  **Integer**  |
|   long   |     Long      |
|  double  |    Double     |
| **char** | **Character** |
| boolean  |    Boolean    |



## 19.1 装箱与拆箱

+ 装箱：把基本类型的数据变成包装类

  + 构造方法(方法上有横线, 说明过时了)：

    `Integer(int value)`: 构造一个新的Integer对象,表示指定的int值;

    `Integer(String s)`: 表示String参数所指示的值;传递的字符串必须是基本类型的字符串(如"100"), 否则抛出异常`NumberFormatException`: 数字格式化异常

  + 静态方法:

    `static Integer valueOf(int i)`: 返回一个表示指定int值得Integer实例;

    `static Integer valueOf(String s)`

+ 拆箱: 把包装类变为基本类型的数据

  + 成员方法: 

    `int intValue()`以int类型返回Integer的值

```java
Integer in1 = Integer.valueOf(1);
int i = in1.intValue();
```



## 19.2 自动拆箱与自动装箱

JDK1.5之后出现的新特性. 

+ 自动装箱: 直接把int类型的整数赋给包装类

  `Integer in = 1;`

+ 自动拆箱: 

  `in = in + 2;`



## 19.3 基本类型与字符串类型的相互转换

+ 基本 -> 字符串

  1. 基本类型的值 + ""
  2. 包装类的静态方法`toString(参数)`, 不是Object类的`toString`方法, 重载
  3. String类的静态方法`valueOf(参数)`

+ 字符串 -> 基本

  使用包装类的静态方法`parseXXX("字符串")`

  ​	Integer类: `static int parseInt(String s)`等

```java
//基本 -> 字符串
String s1 = Integer.toString(100);
String s2 = String.valueOf(100);
    
//字符串 -> 基本
int i = Integer.parseInt(s1);
```







# 第四部分 数据结构

# 第一十章 Collection集合

## 1.1 集合概述

+ 集合: java中提供的一种容器,用来储存多个数据;

+ 数组长度**固定**, 集合长度**可变**; 

+ 数组存储**同一类型**的元素, 可以是**基本类型**;  集合存储的都是**对象**, 且对象类型可以不一致. 

  只能`ArrayList<Integer>`



## 1.2 集合框架

![](https://cdn.jsdelivr.net/gh/SalmonC/PicBed@main/1615988093830-1615988093803.png)

集合框架的学习方式: 

+ 学习顶层接口/抽象类的共性方法, 所有子类都可以用
+ 使用底层: 顶层不是接口就是抽象类, 无法创建对象, 使用底层的子类创建对象使用. 



## 1.3 Collection常用功能

+ `public boolean add(E e)`: 向集合中添加对象
+ `public void clear()`: 清空集合中的元素
+ `public boolean remove(E e)`: 把给定的元素从集合中删除
+ `public boolean contains(E e)`: 判断集合中是否包含给定对象
+ `public boolean isEmpty`: 判断当前集合是否为空
+ `public int size()`: 返回集合中元素个数
+ `public Object[] toArray`: 把集合中元素存储到数组中



# 第二章 Iterator迭代器

## 2.1 Iterator接口

+ **迭代**: 即 Collection集合元素的通用获取方式。在取元素之前先要判断集合中有没有元素, 如果有, 就把这个元素取出来, 继续判断, 如果还有就再取出出来。一直把集合中的所有元素全部取出。这种取出方式专业术语称为迭代。

+ 两个常用方法:

  + `boolean hasNext()`: 判断集合有没有下一个元素, 有就返回true
  + `E next()`: 返回迭代的下一个元素

+ Iterator是一个接口, 无法直接使用, 获取实现类的方法比较特殊

  Collection接口中有一个方法叫做`Iterator<e> iterator()`: 返回在此Collection的元素上进行迭代的迭代器

+ **迭代器的使用步骤**: 

  1. 使用集合中的方法`iterator()`获取迭代器的实现类对象, 使用Iterator接口接受(多态)
  2. 使用Iterator接口中的方法hasNext判断还有没有下一个元素
  3. 使用Next取出集合中的下一个元素

  ```java
  Collection<String> coll = new ArrayList<>();
  coll.add("a");
  coll.add("b");
  coll.add("c");
  coll.add("d");
  coll.add("e");
  Iterator<String> it = coll.iterator();
  boolean b = it.hasNext()
  String s = it.next;
  //循环写法
  for(Iterator<String> it2 = coll.iterator(); it2.hasNext){}
  ```

  

## 2.2 增强for循环

内部原理: 迭代器

JDK1.5之后出现的新特性

`Collection extends Iterable<E>`: 所有的单列集合都可以使用增强for

`public interface Itrable<T>`实现这个接口的对象, 允许成为`foreach`语句的目标

格式:

```java
for(元素的数据类型 变量 : Collection集合or数组){
    代码;
}
```



# 第三章 泛型Generic

是一种未知的数据类型, 当不知道什么数据类型的时候可以使用泛型.

泛型也可以看成一个变量, 用来接收数据类型.

+ E e: Element 元素
+ T t: Type 类型

创建集合对象, 不使用泛型:

```java
ArrayList list = new ArrayList;
```

+ 好处: 不使用泛型, 默认的类型就是Object, 可以存储任意类型的数据, 可以不相同;

+ 坏处: 不安全, 会引发异常
  + 用Object obj取出元素,使用的是多态, 不能使用元素特有的方法(如length() )



使用泛型: 

+ 好处:
  1. 避免类型转换, 存储什么类型就取出什么类型
  2. 把运行期异常, 提升到了编译期
+ 弊端: 泛型是什么类型, 就只能存储什么类型的数据.

定义含有泛型的类: 在类名称后面加上<E>;

 

## 3.1 含有泛型的方法

+ 定义含有泛型的方法: 泛型定义在方法的修饰符和返回值类型之间

+ 格式: 

  ` 修饰符 <泛型,写什么都行> 返回值类型 方法名(参数列表(使用泛型) )`

  含有泛型的方法在调用方法的时候确定数据类型. 

```java
public <M> void method01(M m){
    sout(m);
}
```



## 3.2 含有泛型的接口

+ 定义:

`public interface GenericInterface<I>{} `

+ 实现:

  + 第一种实现方式: 定义接口的实现类, 实现接口, 指定接口的泛型

    `public class GenericInterfaceIpml1 implements GenericInterface<String>{}`

  + 第二种实现方式: 接口使用什么泛型, 实现类就使用什么泛型, 相当于定义了一个含有泛型的类



## 3.3 泛型的通配符

+ 泛型通配符: ?

  代表任意的数据类型

+ 使用方式:

  不能创建对象使用

  只能作为方法的参数使用

+ 高级使用----受限泛型

  + 上限限定格式: `类型名称<? extends E> 对象名称`代表使用的泛型只能是E类型的子类或本身
  + 下限限定格式:`类型名称<? super E> 对象名称`代表使用的泛型只能是E类型的父类或本身

# 第四章 数据结构

## 4.1 栈

特点: 先进后出, 入口和出口在集合两侧

+ 入栈/压栈: 存储元素到集合
+ 出栈/弹栈: 取出集合中元素

![](https://cdn.jsdelivr.net/gh/SalmonC/PicBed@main/1618151845480-1618151845447.png)

## 4.2 队列

特点: 先进先出, 入口和出口在两侧

![](https://cdn.jsdelivr.net/gh/SalmonC/PicBed@main/1618152241213-1618152241192.png)

## 4.3 数组

+ 特点: 
  + 查询快: 数组的地址连续, 通过首地址找到数组, 通过索引快速查找数组; 
  + 增删慢: 数组的长短固定,增删元素需要创建一个新数组. 



## 4.4 链表

+ 特点:
  + 查询慢: 地址不连续, 从头查询
  + 增删快: 增删元素对整体结构没有影响
+ 分类:
  + 单向链表: 不能保证元素顺序, 存储和取出顺序可能不同
  + 双向链表: 有一条链子专门记录元素顺序, 是**有序集合**



## 4.5 红黑树

+ 二叉树: 分支不超过两个
+ 排序树/查找树: 在二叉树的基础上, 元素有大小顺序: 左子树小, 右子树大
+ 平衡树: 任何节点的子树高度差的绝对值不超过1
+ 红黑树
  + 特点: 趋近于平衡树, **查询速度快**, 查询叶节点最大次数和最小次数不超过2倍
  + 约束条件: 
    + 节点可以是红色或黑色
    + 根节点为黑色
    + 叶节点(空节点)为黑色
    + 每个红色节点的子节点都是黑色
    + 任何一个节点到其每一个叶节点的所有路径上黑节点数量相同



# 第五章 List接口

java.util.List extends Collection

+ 三大特点: 
  1. 是一个有序集合
  2. 有索引
  3. 允许存储重复元素

+ 带索引的方法(特有方法):

  1. public void add
  2. public E get
  3. public E remove
  4. public E set : 替代指定位置的元素, 返回之前的元素

+ 遍历的三种方式:

  1. 普通的for循环

  2. 使用迭代器

     ```java
     Iterator<E> name = list.iterator();
     while(name.hasNext()){
         E e = name.next;
         sout(e);
     }
     ```

     

  3. 使用foreach



# 第六章 List的实现类

## 6.1 ArrayList集合

底层为数组实现, **此实现不是同步的(多线程, 速度快)**. 

如果查询较多, 可用ArrayList. 



## 6.2 LinkedList集合

底层为链表实现, 此实现不是同步的. 

+ 特殊方法: 
  + addFirst/Last
  + removeFirst/Last
  + getFirst/Last
  + pop: 等效于removeFirst
  + push: 等效于addFirst
+ 特点: 
  + 底层为链表结构, 查询慢, 增删快
  + 包含了大量操作收尾元素的方法
  + 注意: 使用LinkedList特有方法, 不能使用**多态**

## 6.3 vector集合(过时)

1.0版本所用单列集合为vector

底层实现为数组, 是同步的(单线程, 慢), 被ArrayList取代



# 第七章 set接口

+ 特点:
  1. 不允许存储重复元素
  2. 没有索引, 不能用for循环遍历

## 7.1 HashSet集合

由HashMap支持, 不保证迭代顺序恒久不变, 允许使用null元素

+ 特点: 
  1. 不允许存储重复元素
  2. 没有索引, 不能用普通for循环遍历
  3. 是一个无序集合, 存取顺序可能不一致
  4. 底层是Hash表结构(查询速度非常快)



## 7.2 HashMap哈希表

+ 哈希值: 十进制整数 int,由系统随机给出, 是**地址值**, 是一个逻辑地址, 不是实际存储的物理地址

+ Object方法: hashCode 返回对象的哈希值

+ String类重写了hashCode方法

+ JDK1.8 之前, 哈希表 = 数组 + 链表

  JDK1.8 之后, 哈希表 = 数组 + 红黑树(提高查询速度)

+ 初始容量16

+ 数组结构:把元素进行分组, 相同哈希值为一组;

  链表/红黑树结构: 把相同哈希值元素连接到一起.

+ 存储数据到集合中:

  + 先计算元素哈希值
  + 哈希冲突: **两个元素不同, 哈希值相同**. 如果存入的哈希值已有, 调用equals方法, 比较元素是否相同, 相同则不会存储后一个; 不同则发生哈希冲突, 挂在同一个位置. 

+ 不允许存储重复元素的原理: 
  + 如果存入的哈希值已有, 调用equals方法, 比较元素是否相同, 相同则不会存储后一个; 不同则发生哈希冲突, 挂在同一个位置. 
  + 前提: 存储的元素必须重写hashCode方法和equals方法

## 7.3 HashSet存储自定义元素

HashSet存储自定义类型元素时, 要保证元素唯一, 需要重写hashCode和equals方法. 



## 7.4 LinkedHashSet

java.util.LinkedHashSet集合 extends HashSet集合

HashSet的子类, 有序, 具有可预知的迭代顺序

+ 特点: 
  + 底层是一个哈希表(数组+链表/红黑树) + 链表(记录元素的存储顺序)
  + 有序, 不允许重复



## 7.5 可变参数

在JDK1.5之后,如果定义一个方法需要接受**多个参数**, 并且多个参数**类型一致**, 可以简化为: 

```java
修饰符 返回值类型 方法名(参数类型... 形参名){ }
// 完全等价于
修饰符 返回值类型 方法名(参数类型[] 形参名){ }
```

+ 原理: 
  + 底层是一个数组, 根据参数个数不同, 会创建不同长度的数组, 来存储这些参数
  + 传递参数的个数可以是 0, 1, 2, ...多个

```java
// 计算多个int类型的和
public static int add(int... arr){
// 传入的arr是一个数组
    int sum = 0;
    for(int i : arr){
        sum += i;
    }
    return sum;
}
```

+ 注意事项: 
  + 一个方法的参数列表只能有一个可变参数; 
  + 如果方法的参数有多个, 那么可变参数必须写在参数列表的末尾;
+ 可变参数的特殊写法(终极写法): `method(Object... obj)`



# 第八章 Collections

+ java.util.Collections是工具类, 用来对集合进行操作
+ 常用方法:
  + `public static <T> boolean addAll(Collection<T> c, T... elements)`: 往c集合中添加一些元素, 返回c
  + `public static void shuffle(List<?> list)`:打乱集合顺序
  + `public static <T> void sort(List<T> list)`: 将集合中元素按照默认规则排序
  + `public static <T> void sort(List<T> list, Comparator<? super T>)`: 将集合中元素按照指定规则排序

+ sort: 

  + 默认规则一般是升序排序: 123/abc

  + 对于自定义列表, 需要实现`Comparable`接口, 重写接口中的`compareTo`方法, 定义排序规则

    ```java
    public class Person implements Coparable<Person>{
        @Override
        public int compareTo(Person o){
            /* 
            返回0, 认为元素相同
            返回负值, this在前: this - o 升序
            返回正值, this在后: o - this 降序
            */
            return this.getAge() - o.getAge();//年龄升序
        }
    }
    ```

+ Comparable和Comparator的区别

  + Comparable: 自己(this)和别人(参数)比较, 自己需要实现Comparable接口, 重写compareTo方法
  + Comparator: 相当于用第三方来比较两个参数

  ```java
  Collections,sort(list, new Comparator<Integer>(){
      @Override // 重写比较规则
      public int compare(Integer o1, Integer o2){
          return o1 - o2; //升序
      }
  }){ // 匿名内部类
      
  }
  ```

  

# 第九章 Map集合

java.util.Map接口<K, V>, 是一个**双列集合**, Collection是**单列集合**. 

+ Map每次存储一对元素, K代表键, V代表值. 
+ key是唯一的, value可以重复
+ Key和Value的数据类型可以相同, 也可以不同
+ key和value一一对应



## 9.1 Map常用实现类

+ java.util.HashMap

  + 特点:

    + 底层是哈希表: 查询速度快

      JDK1.8之前: 数组+单向链表

      JDK1.8之后: 数组+单向链表/红黑树(链表长度超过8变成红黑树, 提高查询速度)

    + HashMap是无序集合, 存取顺序可能不一致

+ java.util.LinkedHashMap<K, V> extends HashMap

  + 特点:
    + 底层是哈希表+链表
    + 是一个有序集合, 存取顺序一致



## 9.2 Map常用方法

+ `public V put(K key, V v)`: 添加指定键值对. 如果key存在, 替换value, 返回原有value; 如果key不存在, 返回null. 
  + 注意: null赋值给int会**空指针异常**, 应用Integer. 
+ `get(Object key)`输入key, 返回value, 没有则返回null
+ `remove(Object key)`: 删除key键值对. key存在, 返回value; key不存在, 返回null
+ `containsKey(Object key)`: 返回是否存在key

## 9.3 遍历Map集合: 

+ 通过键找值方式

  1. 使用`keySet()`把Map集合中所有key取出来, 存储到Set集合中; 

  2. 使用迭代器遍历Set集合; 

  3. 通过`getKey()`获取value.

+ Map.Entry<K, V>: 在Map集合中有一个内部接口Entry, 

  + 作用: Map集合创建时, 会在Map集合中创建一个Entry对象, 用来记录键和值(键值对对象, 键与值的映射关系)

  1. `Set<Map.Entry<K, V>> entrySet()`: 把Map集合的多个Entry对象取出来, 存储到一个Set集合中
  2. 遍历Set集合, 获取每一个Entry对象
  3. Entry有两个方法: `getKey`/`getValue`



## 9.4 HashMap存储自定义类型键值

+ Map集合要保证key是唯一的: 
  + 作为key的元素必须重写hashCode方法和equals方法, 以保证key唯一



## 9.5 LinkedHashMap集合

+ 特点:
  + key不允许重复
  + 存取顺序一致(替换value值, key序号不变)



## 9.6 Hashable集合

+ 特点
  + 键和值都不允许为空
  + 最早期的双列集合(1.0, 其他为1.2)
  + 是同步的(单线程, 线程安全, 慢
  + 和vector集合一样, 被更先进的集合(HashMap)取代了
  + 其子类(Properties)依然在用, 唯一和IO流结合的集合



# 第十章 补充知识

## 10.1 JDK9对集合添加的优化

+ JDK9新特性:
  + List/Set/Map接口: 增加了一个静态方法of, 可以给集合一次性添加多个元素
  + static <E> List<E> of(E... elements)
  + 使用前提: 当集合中存储的元素个数已经确定了, 不再改变
+ 注意:
  + of()方法只适用于List/Set/Map接口, 不适用于接口的实现类
  + of()方法的返回值时一个不能改变的集合, 集合不能再使用add/put等方法添加元素
  + Set和Map接口在调用of方法的时候不能有重复的元素



## 10.2 Debug追踪

+ Debug调试程序:
  + 可以让代码逐行执行, 查看代码执行的过程, 调试程序中出现的bug
+ 使用方式:
  + 在行号的右边, 左键单击, 添加断点(每个方法的第一行, 哪里有bug添加到哪里)
  + 右键, 选择Debug执行程序
  + 程序会停留在添加的第一个断点处(不执行这一行)
+ 执行程序:
  + Step Over: 逐行执行程序 F8
  + Step Into: 进入方法中 F7
  + Step Out: 跳出方法 Shift + F8
  + Resume Program: 跳到下一个断点, 没有则结束程序 F9
  + Console: 切换到控制台