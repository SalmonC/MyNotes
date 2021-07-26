# 常用总结

+ 使用`push() - pop() - peek()`的有 : `LinkedList`, `Stack`
+ LinkedList使用`push`的是当做栈使用, 加到队头; 使用`offer / add`的是当做链表或者队列使用, 加到队尾



# 栈Stack

## 构造方法

+ 只有空参构造

## 语法

+ 增删查: `push() - pop() - peek()`
  + push与add不同之处: push返回插入的数值, add返回boolean
+ 为空: `empty() / isEmpty()`

![](https://cdn.jsdelivr.net/gh/SalmonC/PicBed@main/1626801416435-1626801416420.png)



# LinkedList

+ 实现了双端队列`Deque`, 两端都可以进出
+ LinkedList使用`push`的是当做栈使用, 加到**队头**; 使用`offer / add`的是当做链表或者队列使用, 加到**队尾**



# 数组相关

## 数组拷贝

+ `Arrays.copyOf(int[] original, int newLength)`: 指定原数组和长度, 通过截断或填充, **返回值为新数组**
+ `System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)`
  + Object src : 原数组
  + int srcPos : 从元数据的起始位置开始
  + Object dest : 目标数组
  + int destPos : 目标数组的开始起始位置
  + int length  : 要copy的数组的长度

## Arrays

+ `Arrays.asList(T... a)` : 参数只能是**引用类型数组**, 可用于构建List
+ `Arrays.copyOfRange(T... a, int from, int to)`返回一个数组, 拷贝目标数组从`from`到`to`的全部数据(不含`to`, 可以位于索引之外), 新数组长度等于`from - to`, 不够的地方用0填充. 



# HashSet

+ `retainAll(Collection<?> C)` 求set的交集

  例: `setA.retainAll(setB)` : 修改`setA`, 使其只保留`setB`中也出现的函数(交集)

