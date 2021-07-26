# MySQL基础

# 第一章 概述

## 1.1 为什么使用MySQL

文件存储不适合查询, 可以用管理软件(数据库)管理数据, 便于查询

+ 实现数据持久化存储

+ 方便管理查询

+ 术语

  + **DB (Database) 数据库**: 保存了一系列有组织的数据

  + **DBMS (Database Management System) 数据库管理系统**: 用于创建和操作数据库(增删改查)

    ​	常见DBMS: MySQL / Oracle(贵) / DB2(适合海量数据) / SqlServer(只能Windows)

  + **SQL (Structure Query Language) 结构化查询语言**: 专门用于与数据库通信的语言

+ SQL优点
  1. 几乎所有DMBS都支持SQL, 但各有特色
  2. 简单易学
  3. 强有力, 可以进行非常复杂和高级的数据库操作

## 1.2 DB概述

+ 特点
  1. 将数据放到表中, 表再放到库中
  2. 一库多表, 表名唯一
  3. 表具有特性, 特性定义类数据在表中如何存储, 类似java中的"类"
  4. 表由列组成, 一般把列称为**字段**, 每一个字段类似java中的"属性"
  5. 表中每一行类似于java中的对象

+ DBMS分两类
  1. 基于共享文件系统的DBMS(Access)
  2. 基于客户机----服务器的DBMS(MySQL / Oracle / SqlServer)



## 1.3 SQL语言分类

- DQL(数据查询语言）:查询语句, 凡是select语句都是DQL。
- DML(数据操作语言）:insert delete update,对表当中的数据进行增删改。
- DDL(数据定义语言）:create drop alter,对表结构的增删改。
- TCL(事务控制语言）:commit提交事务, rollback回滚事务。（TCL中的T是Transaction)
- DCL(数据控制语言）:grant授权、revoke撤销权限等。



# 第二章 MySQL的使用

## 2.1 登录MySQL

+ 登录:

  1. 对于root用户(Windows): 直接打开客户端, 输入密码

  2. 推荐方式: 命令行, 输入`mysql -h [主机, 如localhost] -P [端口号 3306] -u [账户 root] -p[密码]`

     -p和密码之间**不能有空格,** 其他的可有可无; 如果是本机, 可以**省略-h -P**

+ 退出 : `exit` / ctrl+c



## 2.2 常见命令

+ 语法规范
  + 不区分大小写, 建议关键字大写, 表名/列名小写
  + 每条命令结尾用`;`或`\g`
  + 每条命令根据需要, 可以缩进或者换行
  + 注释
    1. 单行注释: `#注释文字`
    2. 单行注释: `-- 注释文字`注意有空格
    3. 多行注释: `/* */`
+ 常用命令

|                        命令                         |          作用          |
| :-------------------------------------------------: | :--------------------: |
|                  `show databases;`                  |  查看当前所有的数据库  |
|              `show tables from 库名;`               | 查看**指定库**的所有表 |
| `create table 表名(列名 列类型, 列名 列类型, ...);` |         创建表         |
|                     `use 库名;`                     |      打开指定的库      |
|                   `show tables;`                    | 查看**当前库**的所有表 |
|                 `select version()`                  |   查看当前服务器版本   |



# ----------------

# 第二部分 DQL语言

# 第一章 查询

## 1.1 普通查询

作用: 查询/过滤等

+ 用法: 

  ```MySQL
  SELECT
  	查询列表
  FROM
  	表名;
  
  /*
  查询列表可以是:
  1. 表中字段, 常量值, 表达式, 函数
  2. 查询结果是一个虚拟表格, 不是真实存在的
  */
  
  #1. 查询表中单个字段(列)
  select last_name FROM employees;
  
  #2. 查询多个字段, 逗号隔开, 顺序可以和原表不一致
  select last_name,salary,email FROM employees;
  
  #3. 查询所有字段, 使用*, 不足: 顺序与原始表一样
  select * FROM employees;
  
  -----------------------------
  #4. 查询常量值(不区分字符CHAR和字符串VARCHAR, 字符型/日期型都用单引号, 不是反引号)
  select 'John';
  
  #5. 查询表达式, 查询的是运算结果
  select 99*100;
  
  #6. 查询函数, 调用该函数, 得到返回值并显示
  select VERSION();
  ```

+ 着重号: \` , 用于区分字段和关键字, 用在字段外, 可以不加

+ 为字段起别名: 

  + 好处: 方便理解, 如果要查询字段有重名, 使用别名可以区分

  + 方式: 

    1. 使用`AS`, 如`SELECT 100%98 AS 结果;`
    2. 使用空格, 如`SELECT last_name 名, first_name 姓 FROM employees;`

    + 注: 如果别名有空格, 注释等, 建议加上**双引号**(单引号也行, 不推荐)

+ 去重: 在字段名前加关键字`DISTINCT`, 只能放在所有关键字最前面, 相当于把后面所有字段连在一起然后去重

  ```mysql
  mysql> select distinct deptno,job from emp;
  +--------+-----------+
  | deptno | job       |
  +--------+-----------+
  |     20 | CLERK     |
  |     30 | SALESMAN  |
  |     20 | MANAGER   |
  |     30 | MANAGER   |
  |     10 | MANAGER   |
  |     20 | ANALYST   |
  |     10 | PRESIDENT |
  |     30 | CLERK     |
  |     10 | CLERK     |
  +--------+-----------+
  ```

  

+ `+`号的作用: 只能作为运算符, 不能拼接

  + `select 100+90;`两个操作都作为数值, 做加法运算

  + `select `123`+90;`一方为字符型, 试图转换成数值

    转换成功, 加法运算

    转换失败, 则将字符型数组转化成0, 加法运算

  + 其中一方为null, 结果肯定为null

+ 拼接: `concat()`

  `select concat('a','b','c') AS 姓名 form employees;`

  + 最终返回值只有一列

  + 有null, 则拼接出来都是null, 可以使用`IFNULL(字段, 默认值)`

    ![](https://cdn.jsdelivr.net/gh/SalmonC/PicBed@main/1623844884901-1623844884853.png)

  + 区分`ISNULL()`: 如果括号内是NULL, 返回1, 否则返回0

## 1.2 条件查询

```mysql
select
	查询列表
from
	表名
where
	筛选条件;
```

筛选条件返回值为boolean, 同java

1. 条件运算符: `> < = !=或<>`, 注: 不等推荐用<>, 等于只有一个等号
2. 逻辑运算符: `and or not && || !`, 注: 推荐使用and等
3. 模糊查询: `like, between and, in ,is null`

+ 模糊查询

  1. `like`:

     + 一般个通配符搭配使用, 外面加引号

       % : 任意多个字符, 包含0

       _ : 任意单个字符

  ```mysql
  #查询第二个字符是'_'的名字
  SELECT
  		last_name
  FROM
  		employees
  WHERE
  		last_name LIKE '_\_%';  #转义符号 \
  		#或者用 ESCAPE 指定转义字符
  		last_name LIKE '_$_%' ESCAPE '$'; #将'$'指定为转义符号
  ```

  

  2. `between and`在...之间
     + 可以提高简洁度
     + 闭区间
     + 两个值不能颠倒顺序, 小的在前, 大的在后

  ```mysql
  #查询编号在100到120之间的员工信息
  SELECT
  		*
  FROM
  		employees
  WHERE
  		employee_id >= 100 AND employee_id <= 120;
  		#使用between and
  		employee_id BETWEEN 100 and 120; #完全等价,不能交换左右数据
  ```

  

  3. `in`: 判断字段的值是否属于in中某一项
     + 字段 in (枚举出所有满足的, 逗号隔开)
     + 枚举的值需要是同样类型(数值,字符)或兼容(可转换, 如'123' 和 123)
     + **不可以**使用通配符, 因为等价于'=', 而只有LIKE可以使用通配符

  ```mysql
  #查找工种是'IT_PORT','AD_VP','AD_PRES'的人的名字和工种
  SELECT
  		last_name,
  		job_id
  FROM
  		employees
  WHERE
  		job_id = 'IT_PORT' OR job_id = 'AD_VP' OR job_id = 'AD_PRES';
  		#使用in
  		job_id in('IT_PORT','AD_VP','AD_PRES')
  ```

  

+ `IS NULL` `IS NOT NULL`: `=`不能判断`NULL`, 需要把`=`改为`IS`, 把`<>`改为`IS NOT`

+ 安全等于 `<=>` : 可以判断`NULL` 和数据



```mysql
#测试题
#1. 
SELECT
		salary,
		last_name
FROM
		employees
WHERE
		commision_pct IS NULL AND salary < 18000;
		
#2.
SELECT
		*
FROM
		empl
WHERE
		job_id <> 'IT' OR salary = 12000;
```





## 1.3 排序查询

默认排序是按照原表排序

+ 语法: `ORDER BY 排序列表 [ASC(升序)|DESC(降序)]` : 以排序列表(某一字段)为依据, 进行排序, 默认ASC升序

+ 特点: 

  1. ASC升序, DESC降序, 不写默认升序
  2. `ORDER BY`子句中可以放单个字段, 多个字段, 表达式, 函数, 别名
  3. 子句一般放在查询语句最后, 仅有`LIMIT`子句在`ORDER BY`后面

  ```mysql
  #按工资从高到低降序排序
  SELECT
  		*
  FROM
  		employees
  ORDER BY
  		salary DESC;
  
  #按年薪高低降序(按表达式排序)
  SELECT
  		*,salary*12*(1+IFNULL(commison_psc,0)) 年薪
  FROM
  		employees
  ORDER BY
  		#salary*12*(1+IFNULL(commison_psc,0)) DESC;
  		#可以直接按别名排序
  		年薪 DESC;
  
  #按姓名长度(按函数排序)
  SELECT
  		LENGTH(last_name) 字节长度,last_name,salary
  FROM
  		employees
  ORDER BY
  		LENGTH(last_name) DESC;
  		
  #先按工资排序,后按员工编号排序(按多个字段排序)
  SELECT
  		*
  FROM
  		employees
  ORDER BY
  		salary ASC,employee_id DESC;
  ```

  

# 第二章 常见函数

+ 概念: 类似于java中的方法, 将逻辑语句封装, 对外暴露方法名

+ 好处: 

  1. 隐藏了实现细节
  2. 提高了代码重用性

+ 调用: `SELECT 函数名(实参列表) [FROM 表]`如果函数字段用到了表中数据, 加上FROM, 否则不加

+ 分类

  1. 单行函数

     `concat()`, `length()`, `ifnull()`等

  2. 分组函数, 用作统计, 又称为统计函数, 聚合函数, 组函数



## 2.1 单行函数

### 字符函数

+ `length(str)` 获取**字节**个数, 一个汉字占三个字节(UTF-8)

+ `concat(str...)`拼接 `SELECT CONCAT(last_name,'-','firs_name) FROM employees;`

+ `substr`或`substring `截取子串, **按字符**计算, 有四个重载, **索引从1开始**

  + `substr(str,pos)` 包含pos所在字符, 下同
  + `substr(str FROM pos)`
  + `substr(str,pos,len)`
  + `substr(str FROM pos FOR len)`

+ `instr(str, substr)` 返回子串第一次出现的索引, 没有就返回0

+ `upper(str)`  转换成大写

+ `lower (str)`转换成小写

+ `trim([指定字符 FROM]str)` 去前后指定的空格和字符, 没指定就去除空格, char需要用`''`包围

+ `ltrim` 去左边空格

+ `rtrim` 去右边空格

+ `replace(str,from_str,to_str)` 替换, 将from替换成to

+ `lpad(str,len,指定字符)` 左填充, 用指定字符往str左填充, 使总长度为len. 如果str比len长, 截取str的**前len个**字符; 如果填充后长度超过len, 尽量保留原str完整, 从后填充的字符中截取超过的部分. 

+ `rpad(str,len,指定字符)` 右填充,同lpad

  

### 数学函数

- `round` 四舍五入
  - `round(x) `对x取四舍五入
  - `round(x,D)` 对x四舍五入, 小数点后保留D位 1.567 -> 1.57
- `ceil(x)` 向上取整, >=x的最小整数
- `floor(x)` 向下取整
- `truncate(x,D)` 截断, x的小数点后保留D位. 
- `mod(a,b)` 等价于 a%b, a-a/b*b

### 日期函数: 参数类型为日期类型

+ `now()` 返回当前系统日期 + 时间 `2021-06-18 01:34:25`
+ `curdate()` 返回当前日期
+ `curtime()` 返回当前时间
+ 获取指定部分, 如年/月/日/时/分/秒
  + `select YEAR(NOW()) 年`
  + `select YEAR('1998-1-1')`
  + `select YEAR(hiredate) form employees`
  + `month()` 返回月份数字 `6`
  + `monthname()` 返回月份英文`June`
+ `str_to_date(str,'格式')`: 将字符串按规定格式转化为日期
  + 如`str_to_date('3-19-1999','%m-%d-%Y')`
+ `date_format(时间,格式)`: 将日期转换为字符串
  + `date_format(now(),'&y年%m月%d日');`
+ ![](https://cdn.jsdelivr.net/gh/SalmonC/PicBed@main/1623951957457-1623951957431.png)

### 其它函数(补充)

- `version()`当前版本
- `database()`当前数据库
- `user()`当前用户

### 流程控制函数

- `if`: if else 效果

  - `if(expr1,expr2,expr3)`

    expr1: 条件表达式, 成立返回expr2, 否则返回expr3

- `case` 使用一: switch case效果

  使用二: 类似if else if...

  ```mysql
  #使用一
  case 要判断的字段或表达式
  when 常量1 then 要显示的值1或语句1; #如果是值,不用加分号
  when 常量2 then ...
  else ...
  end
  
  #1. 查询员工工资,按部门号增加倍率
  SELECT salary 原始工资,department_id,
  CASE department_id
  WHEN 30 THEN salary*1.1
  When 40 THEN salary*1.2
  ELSE salary
  END AS 新工资
  FROM employees;
  
  #----------
  #使用二,CASE后面不加东西
  CASE
  WHEN 条件1 THEN ...
  WHEN 条件2 THEN ...
  ELSE ...
  END
  
  #2.查询工资,如果大于20000,显示A级别...
  SELECT salary,department_id,
  CASE
  WHEN salary > 20000 THEN 'A'
  WHEN salary > 15000 THEN 'B'
  WHEN salary > 10000 THEN 'C'
  ELSE 'D'
  END AS 级别
  FROM employees;
  ```



## 2.2 分组函数

+ 功能: 作为统计使用, 又称为分组函数/统计函数/组函数

+ 分类: sum 求和, avg 平均值, max 最大值, min 最小值, count 计算不为null个数

+ 简单使用

  `SELECT SUM(salary) 和,AVG(salary) 平均 FROM employees` : 只返回一个值

+ 五个分组函数支持的参数类型

  1. `sum,avg` : 数值型

     `max,min,count` : 数值型, 字符型, 日期型

  2. 以上分组函数都忽略null值

     count只计算非null的个数, sum不加null(否则答案为null), avg = sum / count

  3. 可以和`distinct` 搭配去重

     `SELECT SUM(DISTINCT salary) FROM employees`

+ `count` 函数的具体介绍

  + `SELECT COUNT(*) FROM employees` 统计表的行数(对象数)

    `SELECT COUNT(1) FROM employees` 同上

+ 和分组函数一同查询的字段有限制

  一般要求是`group by`后的字段, 其他不行

+ 分组函数不能直接出现在`WHERE`中, 因为`GROUP BY`在`WHERE`后面执行, 然后才是分组函数

### 分组查询

分组函数一般分组后查询, 使用group by分组

```mysql
#语法
SELECT 分组函数,列#(出现在GROUP BY 后面)
FROM 表
[WHERE 筛选条件]
GROUP BY 分组的列表
[ORDER BY 子句]
#注意: 查询列表比较特殊, 要求是分组函数和GROUP BY后出现的字段


SELECT department_id,AVG(salary) 部门平均工资
FROM employees
GROUP BY department_id
ORDER BY department_id;
```

+ 复杂筛选

  ```mysql
  #查询哪个部门员工个数>2, 添加分组后的筛选
  #使用HAVING函数, 对结果进行筛选
  SELECT COUNT(*),department_id
  FROM employees
  GROUP BY department_id
  HAVING COUNT(*)>2;
  
  #查询每个工种有奖金的员工的最高工资>12000的工种编号和最高工资
  SELECT job_id,MAX(salary)
  FROM employees
  WHERE commision_pct IS NOT NULL 
  GROUP BY job_id
  HAVING MAX(salary) > 12000
  ```

|            | 数据源     | 位置       | 关键字 |
| ---------- | ---------- | ---------- | ------ |
| 分组前筛选 | 原始表     | GROUP BY前 | WHERE  |
| 分组后筛选 | 分组后结果 | 后         | HAVING |

+ 分组函数做调节肯定是放在HAVING子句中
+ 能用`WHERE`分组前筛选的, 优先分组前

+ `GROUP BY`按表达式分组

  ```mysql
  GROUP BY LENGTH(last_name)
  ```

+ 按多个字段分组, 没有先后顺序

  ```mysql
  SELECT AVG(salary),department_id, job_id
  FROM employees
  GROUP BY department_id,jon_id;
  #只有department_id,job_id都一样才会是同一个组
  ```



# 第三章 连接查询

又叫多表查询, 用于查询来自于多个表的字段

## 3.1 笛卡尔乘积

+ 不加任何连接条件, 会出现笛卡尔乘积现象

  假设表1有m行, 表2有n行, 结果有m*n行, 这就是笛卡尔乘积

+ 解决方法: 添加连接条件

  ```mysql
  SELECT name,boyName 
  FROM boys,beauty
  WHERE beauty.boyfriend_id = boys.id;
  ```



## 3.2 分类

+ 按年代分类

  + sql92标准: 仅支持内连接

  + sql99标准(推荐): 支持内+外(左+右)+交叉

+ 按功能分类

  + 内连接
    + 等值连接
    + 非等值连接
    + 自连接
  + 外连接
    + 左外连接
    + 右外连接
    + 全外连接
  + 交叉连接

## 3.3 sql92标准(了解)

1. 等值连接

   ```mysql
   #查询员工名和对应部门名
   SELECT last_name,department_name
   FROM employees,departments
   WHERE employees.department_id = departments.department_id;
   ```

   + 可以用AS为表起别名,然后再用`别名.字段`, 起了别名之后, 查询的字段不能使用原表名限定

2. 非等值连接

   ```mysql
   SELECT salary,grade_level
   FROM employees e,job_grade g
   WHERE salary BETWEEN lowest_sal AND highest_sal
   ```

3. 自连接

   ```mysql
   #查询 员工名和上级的名称
   SELECT last_name,last_name manager_name
   FROM employees e, employees m
   WHERE e.manager_id = m.employee_id
   ```

   

## 3.4 sql99标准

### 语法

```mysql
SELECT 查询列表
FROM 表1 别名 [连接类型]
JOIN 表2 别名
ON 连接条件
[WHERE 筛选条件]
```

+ 连接类型
  + 内连接: inner(可以省略)
  + 左外: left [outer]
  + 右外: left [outer]
  + 全外: full [outer]
  + 交叉: cross

### 内连接

+ 语法

  ```mysql
  SELECT 查询列表
  FROM 表1 别名
  INNER JOIN 表2 别名
  ON 连接条件
  ```

+ 等值连接

  + 最大特点是: 条件是等量关系

  ```mysql
  #查询员工名, 部门名
  SELECT last_name,department_name
  FROM employees e
  INNER JOIN department d #inner可以省略, 但可读性下降
  ON e.'department_id' = d.'department_id';
  ```

+ 非等值连接

  + 最大的特点是：连接条件中的关系是非等量关系

+ 自连接

  + 最大的特点是：一张表看做两张表。自己连接自己
  + 可以是等值, 也可以是不等值

  ```mysql
  #员工的领导编号 = 领导的员工编号
  select 
  	a.ename as '员工名',b.ename as '领导名'
  from
  	emp a
  inner join
  	emp b
  on
  	a.mgr = b.empno;
  +--------+--------+
  | 员工名  | 领导名  |
  +--------+--------+
  | SMITH  | FORD   |
  | ALLEN  | BLAKE  |
  | WARD   | BLAKE  |
  | JONES  | KING   |
  | MARTIN | BLAKE  |
  | BLAKE  | KING   |
  | CLARK  | KING   |
  | SCOTT  | JONES  |
  | TURNER | BLAKE  |
  | ADAMS  | SCOTT  |
  | JAMES  | BLAKE  |
  | FORD   | JONES  |
  | MILLER | CLARK  |
  +--------+--------+
  ```

### 外连接(用的较多)

+ 外连接与内连接区别
  + **内连接**: 假设A表和B表进行连接, 使用内连接的话, 凡是A表和B表能够匹配上的记录查询出来, 这就是内连接。
    AB两张表没有主副之分, 两张表是**平等**的。
  + **外连接**: 假设A和B表进行连接, 使用外连接的话, AB两张表中有一张表是主表, 一张表是副表, **主要查询主表中的数据**, 捎带着查询副表, 当副表中的数据没有和主表中的数据匹配上, 副表**自动模拟出NULL**与之匹配。
+ 左外连接表示左边的是主表, 右外连接表示右边是主表
+ 左连接有右连接的写法, 右也有左的写法



## 3.5 多表连接

```mysql
select
e.ename,d.dname,s.grade
from
emp e
left join
dept d
on
e.deptno = d.deptno
left join
salgrade s
on
e.sal between s.losal and s.hisal;
#-----
select
e.ename,d.dname,s.grade
from
emp e
left join
dept d
left join
salgrade s
on
(e.sal between s.losal and s.hisal) and e.deptno = d.deptno;

#-----找出每一个员工的部门名称, 工资等级, 上级领导
select
e.ename 员工,d.dname 部门,s.grade 等级,m.ename 领导
from
emp e
left join
dept d
on
e.deptno = d.deptno
left join
salgrade s
on
e.sal between s.losal and s.hisal
left join
emp m
on
e.mgr = m.empno;
```



# 第四章 子查询

+ select语句中嵌套select语句, 被嵌套的select语句就是子查询

+ 可以出现在哪里?

  ```mysql
  select
  		..(select).
  from
  		..(select).
  where
  		..(select).
  ```

## 4.1 where后嵌套子查询

```mysql
#找出高于平均薪资的员工信息
select
*
from
emp
where
sal > (select avg(sal) from emp);
```



## 4.2 from后嵌套子查询

```mysql
#找出每个部门平均薪水的薪资等级
select
e.平均薪资,s.grade
from
(select avg(sal) 平均薪资 from emp group by deptno) e
join
salgrade s
where
e.平均薪资 between s.losal and s.hisal;

#找出每个部门员工薪水等级的平均值
select
deptno,avg(grade)
from
(select e.*,s.grade from emp e join salgrade s on e.sal between s.losal and s.hisal) t
group by
e.deptno;
	#不用当做临时表
select
e.deptno,avg(s.grade)
from
emp e
join
salgrade s
on
e.sal between s.losal and s.hisal
group by
e.deptno;
```



## 4.3 select后嵌套子查询

```mysql
select
e.ename,
(select d.dname from dept d where d.deptno = e.deptno) as dname
from emp e;
```



# 第五章 Union

+ 可以将查询结果集相加

  ```mysql
  #案例：找出工作岗位是SALESMAN和MANAGER的员工？
  #第一种：
  select ename,job from emp where job = 'MANAGER' or job = 'SALESMAN';
  
  #第二种：
  select ename,job from emp where job in('MANAGER','SALESMAN');
  +--------+----------+
  | ename  | job      |
  +--------+----------+
  | ALLEN  | SALESMAN |
  | WARD   | SALESMAN |
  | JONES  | MANAGER  |
  | MARTIN | SALESMAN |
  | BLAKE  | MANAGER  |
  | CLARK  | MANAGER  |
  | TURNER | SALESMAN |
  +--------+----------+
  
  #第三种：union
  select ename,job from emp where job = 'MANAGER'
  union
  select ename,job from emp where job = 'SALESMAN';
  +--------+----------+
  | ename  | job      |
  +--------+----------+
  | JONES  | MANAGER  |
  | BLAKE  | MANAGER  |
  | CLARK  | MANAGER  |
  | ALLEN  | SALESMAN |
  | WARD   | SALESMAN |
  | MARTIN | SALESMAN |
  | TURNER | SALESMAN |
  +--------+----------+
  
  #两张不相干的表中的数据拼接在一起显示？
  select ename from emp
  union
  select dname from dept;
  
  +------------+
  | ename      |
  +------------+
  | SMITH      |
  | ALLEN      |
  | WARD       |
  | JONES      |
  | MARTIN     |
  | BLAKE      |
  | CLARK      |
  | SCOTT      |
  | KING       |
  | TURNER     |
  | ADAMS      |
  | JAMES      |
  | FORD       |
  | MILLER     |
  | ACCOUNTING |
  | RESEARCH   |
  | SALES      |
  | OPERATIONS |
  +------------+
  
  /*
  mysql> select ename,sal from emp
      -> union
      -> select dname from dept;
  ERROR 1222 (21000): The used SELECT statements have a different number of columns
  */
  
  ```

  

# 第六章 Limit分页查询(重点)

+ 是mysql特有的, 其他数据库没有
+ limit取结果集中的部分数据

## 6.1 语法机制

+ `limit startIndex,length`: 从start开始, 取length个. 从0开始
+ `limit length`: 从0开始, 取length个



## 6.2 标准分页sql

每页显示pageSize条记录：
第pageNo页：(pageNo - 1) * pageSize, pageSize

pageSize是什么？是每页显示多少条记录
pageNo是什么？显示第几页

```java
// java代码
{
	int pageNo = 2; // 页码是2
	int pageSize = 10; // 每页显示10条
    
    limit (pageNo - 1) * pageSize, pageSize
}
```



# ---------------

# 第三部分 修改表

# 第一章 DDL增删表

### 建表语法格式

```mysql
create table 表名(
    字段名1 数据类型,
    字段名2 数据类型,
    字段名3 数据类型,
    ....
);

#可以在后面设置默认数值
	字段名n 数据类型 default 默认值
#如
	sex int(1) default 1
```

+ 表名在数据库中一般建议以`t_`或`tbl_`开始

  

### 数据类型

- int		整数型(java中的int)
- bigint	长整型(java中的long)
- float		浮点型(java中的float double)
- char		定长字符串(String)
- varchar	可变长字符串(StringBuffer/StringBuilder)
- date		日期类型 （对应Java中的`java.sql.Date`类型）
- BLOB		二进制大对象（存储图片、视频等流媒体信息)Binary Large OBject （对应java中的Object）
- CLOB		字符大对象（存储较大文本，比如，可以存储4G的字符串。） Character Large OBject（对应java中的Object）
  ......



### 删除表

`drop table if exsits 表名` : 删除该表



# 第二章 DML增删数据

## 2.1 insert

+ 语法格式

  ```mysql
  insert into 表名 (字段名1,字段名2,...) values(值1,值2,...)
  ```

  + 要求字段的数量和值的数量相同, 数据类型也要对应

  + 如果一个字段前后都没提到, 则自动插入默认值

    默认值可以在建表的时候设置, 没有设置则默认null

+ 可以简写:

  ```mysql
  insert into 表名 values(值1,值2,...)
  ```

  不指定字段名, 则需要把所有字段按顺序填写

+ 一次插入多行数据, 用逗号隔开

  ```mysql
  insert into 表名 (字段名1,字段名2,...) values(值1,值2,...), (字段名1,字段名2,...) values(值1,值2,...)
  ```

  

## 2.2 复制表

+ `AS`: 把原表某些字段查询结果复制为新表

  ```mysql
  create table 新表名 as select * from 原表名;
  ```

+ 把查询结果插入到表中, 不加AS, 要求字段数对应

  ```mysql
  insert into 表名 select * from 原表名;
  ```



## 2.3 修改数据

+ 语法格式

  ```mysql
  update 
  	表名
  set 
  	字段名1 = 值1,
  	字段名2 = 值2,
  	... 
  where
  	条件;
  ```

  + 不加`where`条件则修改所有内容



## 2.4 删除数据

+ 语法格式

  ```mysql
  delete from
  	表名
  where
  	条件;
  ```

  + 没有条件全部删除, 只剩表头

+ 删除大表

  + delete不会释放存储空间, 可以回滚, 但删除较慢
  + 如果表很大, 删除要很久
  + 可以使用表截断`truncate`, 快速删除, 只剩表头, **不能恢复**

  ```mysql
  truncate table 表名;
  ```

  

# ---------------

# 第四部分 约束

# 第一章 概述

+ 什么是约束

  约束在创建表时, 可以给表的字段添加相应的约束，添加约束的目的是为了保证表中数据的合法性、有效性、完整性。

+ 常见约束有哪些? 

  1. 非空约束(not null)：约束的字段不能为NULL
  2. 唯一约束(unique)：约束的字段不能重复
  3. 主键约束(primary key)：约束的字段既不能为NULL，也不能重复（简称PK）
  4. 外键约束(foreign key)：...（简称FK）
  5. 检查约束(check)：注意Oracle数据库有check约束，但是**mysql没有**，目前mysql不支持该约束。



# 第二章 非空约束

+ 在建表时后面加上`not null`

```mysql
create table t_user(
		id int,
		username varchar(255) not null,
		password varchar(255)
);
```

+ 如果有非空约束, 且没有默认值, 则insert的时候必须给值
+ `not null` 只有列级约束, 没有表级约束. 



# 第三章 唯一约束

+ 修饰的字段具有唯一性, 不能重复, 可以为null, null和null之间不重复. 

  ```mysql
  create table t_user(
          id int,
          username varchar(255) unique #列级约束
  );
  
  #给多个字段添加约束
  #表级约束: unique(),连在一起不重复就行
  create table t_user(
      id int, 
      usercode varchar(255),
      username varchar(255),
      unique(usercode,username) #多个字段联合起来添加1个约束unique 【表级约束】
  );
  
  #列级约束: 分别加unique, 分别都不重合
  create table t_user(
      id int, 
      usercode varchar(255) unique,
      username varchar(255) unique
  );
  #或者
  create table t_user(
      id int, 
      usercode varchar(255),
      username varchar(255),
      unique(usercode),
      unique(username)
  );
  ```

  

# 第四章 主键约束Primary Key

```mysql
create table t_user(
    id int primary key,
    username varchar(255)
);
#或者
create table t_user(
    id int,
    username varchar(255),
    primary key(id)
);
```



+ 主键约束: 该字段不能为空, 也不能重复
+ 一张表的主键约束只能有一个
+ 主键相关术语: 
  + 主键约束
  + 主键字段: 设置为主键的字段
  + 主键值: 主键中插入的值
+ 主键有什么用:
  + 设计三范式中, 第一范式就要求任何表都有主键
  + 主键作用: 主键值是该行记录在该表中的**唯一标识**
+ 主键分类: 
  + 根据主键字段数量划分: 
    1. 单一主键(常用) 
    2. 复合主键(**不建议用**, 违背三范式)
  + 根据主键性质划分: 
    1. 自然主键: 主键值和业务没有任何关系的自然数
    2. 业务主键(**不建议用**): 如银行卡卡号, 身份证号. 业务发生改变的时候, 主键值可能也要发生变化, 但有时候没法变化. 

### 主键自增(重要)

+ mysql提供主键自增, 从1开始, 每次+1

  ```mysql
  create table t_user(
      id int primary key auto_increment, #id字段自动维护一个自增的数字
      username varchar(255)
  );
  ```



# 第五章 外键约束

+ 相关术语

  + 外键约束(foreign key)
  + 外键字段
  + 外键值

+ 业务背景: 

  设计数据库表, 来维护学生和班级的信息

+ 不加外键约束, 可以随便写; 加上之后, 外键值必须来自某个字段

+ 父表与子表: A中字段引用B中字段, A为子表, B为父表

  创建表/添加数据: 先父后子

  删除表/删除数据: 先子后父

### 创建格式: 

`(创建子表时)foreign key(子表字段) references 父表名(父表字段)`

```mysql
#t_student中的classno字段引用t_class表中的cno字段，此时t_student表叫做子表。t_class表叫做父表。

create table t_class(
    cno int,
    cname varchar(255),
    primary key(cno)
);

create table t_student(
    sno int,
    sname varchar(255),
    classno int,
    primary key(sno),
    foreign key(classno) references t_class(cno)
);
```



### 插入数据

```mysql
#先插父类
insert into t_class values(101,'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx');
insert into t_class values(102,'yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy');

#再插子类
insert into t_student values(1,'zs1',101);
insert into t_student values(2,'zs2',101);
insert into t_student values(3,'zs3',102);

#如果插入父类没有的键, 报错
```



### 注意事项

+ 外键值可以为`null`
+ 外键可以`references` **主键或非主键**, 但一定是`unique`的, 否则可能指向多个对象



# ---------------

# 第五部分 存储引擎

描述的是表的存储方式. 

MySQL默认使用的存储引擎是innodb, 字符集是utf-8

# 第一章 什么是存储引擎

存储引擎这个名字只在mysql有.

每一个存储引擎都对应了一种不同的存储方式。每一个存储引擎都有优缺点, 需要选择合适的. 



# 第二章 常见存储引擎

### MyISAM引擎

+ 不支持事务

+ 是最常用的引擎, 但不是默认的

+ 用三个文件表示一个表

  1. xxx.frm（存储格式的文件, format）
  2. xxx.MYD（存储表中数据的文件）
  3. xxx.MYI（存储表中索引的文件）

+ 优缺点: 

  + 优点: 

    可被转换为压缩, 来节约空间; 可转换为只读表,来提升检索效率

  + 缺点

    不支持事务

### InnoDB引擎: 事务/安全

+ 默认引擎

+ 优缺点

  + 优点: 

    支持事务, 最**安全**, 还支持行级锁, 外键等

  + 不是最快的

+ 数据存储在tablespace逻辑空间中, 无法压缩, 无法只读

+ 在数据库崩溃后提供自动恢复机制. 

+ 支持级联删除和级联更新(不建议使用, 有子别删)

  + 级联删除: 外键中, 删除父的时候自动删除子
  + 级联更新: 更改父, 所有用父的子全部更改



### memory引擎

+ 缺点: 不支持事务; 所有数据和索引存在**内存**中, **容易丢失**
+ 优点: 速度非常快
+ 以前叫做heap引擎



```mysql
select
	e.ename,
	d.*
from
	(select deptno,max(sal) m from emp group by deptno) d
join
	emp e
on
	d.m = e.sal and d.deptno = e.deptno;
```



# ---------------

# 第六部分 事务Transaction

# 概述

事务: 一个事务是一个完整的业务逻辑单元, **不可再分**. 

如: 银行账户转账，从A账户向B账户转账10000.需要执行两条update语句：

```mysql
update t_act set balance = balance - 10000 where actno = 'act-001';
update t_act set balance = balance + 10000 where actno = 'act-002';
```

以上两条DML语句必须**同时成功，或者同时失败**，不允许出现一条成功，一条失败。

此时要使用数据库的**事务机制**. 



# 语句

+ 只有**DML**操作语句与事务相关: `insert delete update`

+ 因为它们这三个语句都是和数据库表当中的“数据”相关的。
  事务的存在是为了保证数据的完整性，安全性。

  

# 特性

事务的特性: 

事务包括四大特性：ACID

+ A: 原子性：事务是最小的工作单元，不可再分。
+ C: 一致性：事务必须保证多条DML语句同时成功或者同时失败。
+ I: 隔离性：事务A与事务B之间具有隔离。
+ D: 持久性：持久性说的是最终数据必须**持久化到硬盘文件中**，事务才算成功的结束。



# 原理

![image-20210621184141326](../../../../Pictures/PicBed/MDImage/image-20210621184141326.png)

+ 两条TCL语句: 
  + 提交: commit
  + 回滚: rollback
  + 保存点: savepoint, 可以回滚到保存点



# 隔离性

+ 事务隔离性存在隔离级别，**理论上**隔离级别包括4个：
  + 第一级别：**读未提交**（read uncommitted）
    对方事务还没有提交，我们当前事务可以读取到对方未提交的数据。
    读未提交存在脏读（Dirty Read）现象：表示读到了脏的数据。
  + 第二级别：**读已提交**（read committed）
    对方事务**提交之后的数据**我方可以读取到。
    这种隔离级别解决了: 脏读现象没有了。
    读已提交存在的问题是：**不可重复读**。			
  + 第三级别：**可重复读**（repeatable read）(mysql默认)
    这种隔离级别解决了：不可重复读问题。
    这种隔离级别存在的问题是：读取到的数据是**幻象**。
  + 第四级别：**序列化读/串行化读**（serializable） 
    解决了所有问题。
    不能多事务并行, 效率低。需要事务排队。

+ 脏读: 读到脏数据, 它不一定在硬盘上
+ 设置隔离级别: `set global transaction isolation level xxxxxx` , 修改之后所有用户要退出重新登录
+ 查看隔离级别: `select @@global.tx isolation`



# 事务的使用

+ mysql事务默认情况下是自动提交的。
  （什么是自动提交？只要执行任意一条DML语句则提交一次。）

+ 怎么关闭自动提交/开启事务？

  `start transaction;`

  每提交/回滚一次, 都要重新开启事务

+ 事务未提交时, 查询出来也是修改后的数据, 但是可以通过回滚来恢复

+ `rollback`不影响`auto_increment`, 自动生成的id可能不连续, 不用纠结是否连号



# ---------------

# 第七部分 索引

# 概述

+ 什么是索引? 

  索引就相当于一本书的**目录**，通过目录可以**快速的找到对应的资源**。
  在数据库方面，查询一张表的时候有两种检索方式：

  + 第一种方式：全表扫描
  + 第二种方式：根据索引检索（**效率很高**）

  索引是给**字段**添加的. 

+ 索引为什么可以提高效率? 

  其实最根本的原理是**缩小了扫描的范围**。

+ 索引虽然可以提高检索效率，但是**不能随意的添加索引**，因为索引也是数据库当中的对象，也需要数据库不断的维护。是有维护成本的。比如，表中的**数据经常被修改这样就不适合添加索引**，因为数据一旦修改，索引需要**重新排序**，进行维护。

+ 什么时候考虑添加索引? 

  1. 数据量庞大(根据客户需求, 线上环境)
  2. 该**字段**很少DML
  3. 该字段经常出现在`where`子句中

# 索引的使用

+ 注意: 主键和具有unique的字段会自动添加索引, 尽量根据主键检索

+ 查看sql语句的执行计划

  ```mysql
  mysql> explain select ename,sal from emp where sal = 5000;
  +----+-------------+-------+------+---------------+------+---------+------+------+-------------+
  | id | select_type | table | type | possible_keys | key  | key_len | ref  | rows | Extra       |
  +----+-------------+-------+------+---------------+------+---------+------+------+-------------+
  |  1 | SIMPLE      | emp   | ALL  | NULL          | NULL | NULL    | NULL |   14 | Using where |
  +----+-------------+-------+------+---------------+------+---------+------+------+-------------+
  
  # type:all 表明是全表扫描
  ```

+ 添加索引: 

  `create 索引名 on 表名(字段名)`

  `create index emp_sal_index on emp(sal);`

  type从ALL变成了ref, rows从14变成1

+ 删除索引

  `drop index 索引名 on 表名`

  `drop index emp_sal_index on emp`



# 索引实现原理

+ 索引底层采用的数据结构: B+树

+ 通过B Tree缩小扫描范围，底层索引进行了排序，分区，索引会携带数据在表中的“物理地址”，最终通过索引检索到数据之后，获取到关联的物理地址，通过物理地址定位表中的数据，效率是最高的。

+ 索引分类: 

  + 单一索引: 给一个字段加索引
  + 复合索引: 给多个字段联合加索引
  + 主键索引: 主键自动添加的索引
  + 唯一索引: 有unique字段自动添加的索引

+ 索引失效: 

  `select ename from emp where ename like '%A%'`

  模糊查询的时候, 第一个通配符用的百分号, 此时索引失效



# ---------------

# 第八部分 视图

+ 视图: 站在不同的角度去看到数据。（同一张表的数据，通过不同的角度去看待）。

+ 创建视图

  `create view 视图名 as select 字段 from 表名;`

+ 删除视图

  `drop view 视图名;`

+ 对视图的增删改查, 也会影响原表数据

+ 视图作用: 

  视图可以隐藏表的实现细节。保密级别较高的系统，数据库只对外提供相关的视图，java程序员只对视图对象进行CRUD。



# ---------------

# 导入导出数据库

+ 导出数据

  在**终端**(不要登录进去) cd到要导出目录, 执行

  `mysqldump learnfrombilibili -uroot -pxxxx`



# 数据库设计三范式

+ 什么是三范式? 

  设计**表**的依据. 按照三范式设计的表, 不会出现数据冗余

+ **第一范式**: 

  任何一张表都有**主键**, 并且每一个字段原子性不可再分

+ **第二范式**: 

  在第一范式基础上, 所有非主键字段**完全依赖**主键, 不能产生**部分依赖**. 

  多对多, 三张表, 关系表, 两外键

+ **第三范式**: 

  在第二范式基础上, 所有非主键**直接依赖**主键, 不能产生**传递依赖**. (如学生 -> 班级编号 -> 班级)

  一对多 两张表 多的表加外键

+ 实际开发中, 以满足客户需求为主, 有时会用冗余换取执行速度



# 一对一怎么设计

一对一有两种设计方式: 主键共享/外键唯一

```mysql
#一对一设计有两种方案：主键共享
t_user_login  用户登录表
id(pk)		username			password
--------------------------------------
1				zs					123
2				ls					456

t_user_detail 用户详细信息表
id(pk+fk)	realname	tel			....
--------------------------------------
1			张三		1111111111
2			李四		1111415621

#一对一设计有两种方案：外键唯一。(一对多 + 唯一性约束)
t_user_login  用户登录表
id(pk)		username		password
--------------------------------------
1			zs				123
2			ls				456

t_user_detail 用户详细信息表
id(pk)	  realname		tel		userid(fk+unique)....
--------------------------------------
1			张三		1111111111		2
2			李四		1111415621		1
```

