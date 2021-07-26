+ ArrayList构建：new ArrayList<Integer>(Arrays.asList( , , )); 如果传入数组, 只能是引用类型数组

+ 可以通过`char - '0'`来把char按字面数字转换成int

+ ArrayList转化为数组:`return merged.toArray(new int[merged.size()]);`

+ 回溯时深拷贝path: `res.add(new ArrayList<>(path))`

+ 数组转化为集合: `new List/Set<>(Arrays.asList(arr))`

+ 投票算法：
  1. 如果候选人不是maj 则 maj,会和其他非候选人一起反对 会反对候选人,所以候选人一定会下台(maj==0时发生换届选举)
  2. 如果候选人是maj , 则maj 会支持自己，其他候选人会反对，同样因为maj 票数超过一半，所以maj 一定会成功当选
  
+ 三元运算符, " : "两边会提升为同一类型

  ```java
  Object o1 = true ? new Integer(1) : new Double(2.0) //1.0
  ```

+ `println()`中数组如果是char, 输出内容, 其他输出地址值

+ 抽象类和接口的异同

  相同: 

  1. 不能实例化
  2. 都可以包含抽象方法

  不同点: 

  1. 抽象类可以构造器, 也可以没有
  2. 接口JDK8可以定义静态方法和默认方法, 9可以定义私有方法
  3. 类只能单继承, 接口多继承
  4. 类与接口: 多实现
  
+ String题常用方法

  + 替代空格(剑指offer No.2)
    1. String[] strs = s.split(' ');
    2. s.replaceAll(" ", "%20");



+ 二叉树
  + 遍历方式
    + 前序遍历(DLR): 根左右
    + 中序遍历(LDR): 左根右
    + 后序遍历(LRD): 左右根
  + 重要题目: jz62*



+ 排序

  + [快排](https://blog.csdn.net/shujuelin/article/details/82423852): 选中基准数, 双指针, 从两端向中间, 把比基准小的换到前面, 比基准大的换到后面, 最后放入基准. 右边先动, 保证指针相遇在比基准小的数字上. 

    ![快排](https://img-blog.csdn.net/20150810110155861)




# 辗转相除法

用于求最大公约数

```java
int gcd(int a, int b){ //b是小数/余数
    return b != 0 ? gcd(b, a%b) : a;
}
```





# 前缀和问题

+ 适用于求数组中连续子数组是否满足条件
+ 如:
  + lc523 连续子数组和
  + lc525 连续数组



# 背包问题

+ 题目: 背包容量M, 单个物体重量Wi, 最多放多少?
+ 方法: 动态规划
  + `dp[i][j]` : 对于前 i 个物体, 容量 j 的背包最多放多少
  + `dp[i][j] = Math.max(dp[i - 1][j] , dp[i - 1] [j - Wi] + Wi);`: 考虑是否放入当前物体, 取较大情况



# 错题集

牛客 剑指52 剑指64

- LeetCode 1449

