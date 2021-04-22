+ ArrayList构建：new ArrayList<Integer>(Arrays.asList( , , ));
+ 可以通过`char - '0'`来把char转换成int
+ ArrayList转化为数组:`return merged.toArray(new int[merged.size()][]);`
+ 回溯时深拷贝path: `res.add(new ArrayList<>(path))`

+ 投票算法：
  1. 如果候选人不是maj 则 maj,会和其他非候选人一起反对 会反对候选人,所以候选人一定会下台(maj==0时发生换届选举)
  2. 如果候选人是maj , 则maj 会支持自己，其他候选人会反对，同样因为maj 票数超过一半，所以maj 一定会成功当选