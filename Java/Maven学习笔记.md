# 概述

## Maven的用途: 

1. 可以管理jar文件
2. 自动下载jar和它的文档, 源代码
3. 管理jar之间的依赖, a.jar需要b.jar, Maven会自动下载b.jar
4. 管理需要的jar版本
5. 编译程序, 把java编译为class
6. 测试代码是否正确
7. 打包文件, 形成jar文件或war文件
8. 部署项目



## 构建

+ 项目的构建: 面向过程, 完成项目的编译, 测试, 运行, 打包, 部署等

+ Maven支持的构建包括: 

  1. 清理: 把之前项目编译的东西删除, 为新的编译代码做准备

  2. 编译: 把源代码编译成可执行代码 java-class文件

     Maven可以批量把成千上百文件编译为class

     javac一次只能编译一个

  3. 测试: Maven可以执行测试程序代码, 验证功能是否正确

     Maven可以同时批量执行多个测试代码, 同时测试多个功能

  4. 报告: 生成测试结果的文件

  5. 打包: 把项目中所有class文件, 配置文件等资源放到一个压缩文件中. 

     这个压缩文件就是项目的结果文件, 通常java程序, 扩展名为`.jar`

     对于web应用, 扩展名是`.war`

  6. 安装: 把5中生成的文件安装到本地仓库

  7. 部署: 把程序安装好可以执行(这一步一般手工)



## Maven核心概念

1. POM : 一个文件, 名为pom.xml, 范围为项目对象模型

   Maven把一个项目当做一个模型使用, 可以控制Maven构建项目的过程, 管理jar依赖

2. 约定目录结构: Maven项目的目录和文件的位置都是规定的

3. 坐标: 一个唯一字符串, 用来表示资源. 

4. 依赖管理: 管理项目中可以使用的jar文件

5. 仓库管理(了解): 资源存放的位置

6. 生命周期(了解): Maven构建项目的过程就是一个项目的声明周期

7. 插件和目标(了解): 执行Maven构建的时候用的工具就是插件

8. 继承: 类似于java的继承

9. 聚合: 把好几个项目归纳到一起



# Maven核心概念

## 约定的目录结构

+ 约定是大家都遵循的一个规则

+ 每一个Maven项目在磁盘中都是一个文件夹

  ```bash
  Hello/
      -/src
      ------/main  			#放主程序
      ---------/java			#程序包和包中的java文件
      ---------/resources		#java程序中要用的配置文件
      ------/test  			#放测试程序代码和文件, 可以没有
      ---------/java			
      ---------/resources
      
      -/pom.xml				#Maven的核心文件, 必须有
  ```



+ 命令行`mvn compile` 遍历`src/main`目录下的所有Java文件, 第一次执行会从中央仓库进行大量下载

  1. 为什么要下载

     因为Maven执行的操作需要很多插件(java类--jar文件)完成

  2. 下了什么

     jar文件--插件

  3. 下到哪里

     默认repository文件夹`usr/SalmonC/.M2/repository`



## 仓库repository

+ 仓库是什么: 

  仓库是存放东西的, 存放Maven使用的jar和我们项目使用的jar

+ 仓库的分类

  1. 本地仓库: 个人计算机上的文件夹, 存放各种jar

  2. 远程仓库: 在互联网上, 使用网络才能使用

     + 中央仓库: 最权威, 所有开发人员都共享使用

       https:// repo.maven.apache.org

     + 中央仓库的镜像: 中央仓库的备份, 各大洲, 重要的城市都有镜像

     + 私服: 在公司内部, 在局域网中使用, 不对外

+ 仓库的使用: Maven仓库的使用不需要认为参与

  + 开发人员需要使用mysql驱动: 
    1. Maven首先查本地仓库
    2. 没有, 则查私服
    3. 访问中央仓库镜像
    4. 访问中央仓库



## 项目对象模型pom

+ Maven环境搭建好后, 所有的操作都是关于pom.xml的
+ pom.xml 内容: 
  + **modelVersion**: Maven模型的版本, 对应Maven2和Maven3, 它只能是4.0.0
  + **groupID: 组织ID**, 一般是公司域名的倒写, 如com.baidu.appolo等, 防止重名
  + **artifactID 项目名称**: 也是模块名称, 对于groupID中项目的子项目
  + **version 版本号**: 自定义, 一般使用三维数字标识, 如`1.1.0`. 特殊: 如果项目还在开发中, 不是稳定的, 通常在版本后带上`-SNAPSHOT`
    + groupID, artifactID, version三个元素合在一起, 称为坐标, 可以在互联网上唯一标识一个项目
    + [MVN中央仓库](https://mvnrepository.com/): 可以根据groupID和artifactID搜索各种资源
  + packaging: 打包后压缩文件的扩展名, 可以不写, 默认是`.jar`或`.war`
  + **dependencies和dependency 依赖**: 项目中要使用的各种驱动说明, 类似java中的`import()`
  + **properties 配置属性**
  + **build**: Maven在进行项目构建时一些配置信息, 如编译java代码使用的java版本等



## 坐标gav

+ groupID, artifactID, version
+ 需要特别指出的是, **项目在仓库中的位置是由坐标来决定的**: groupeid、artifactid和 version决定项目在仓库中的路径, artifactid和 version决定jar包的名称。



## 依赖dependency

+ pom中写入依赖后, 会根据依赖坐标从本地仓库进行搜索, 本地没有就找远程仓库



# Maven常用命令

+ ` mvn clean`: 清理, 会删除原来编译和测试的目录, 即target目录, 但已经install到仓库里的不会删除
+ `mvn compile`: 编译主程序, 在当前目录下生成target, 里面放编译后的字节码文件(class和resources文件都会放)
+ `mvn test-compile` 编译测试程序, 同主程序(测试程序使用`Junit`)
+ `mvn test` 测试, 会生成一个目录`surefire-reports`, 保存测试结果
+ `mvn package` 打包主程序, 会编译, 编译测试, 测试, 按照pom.xml的配置生成jar包或者war包, 包内只放`/src/main`的内容, 不放test的
+ `mvn install` 安装主程序pom.xml的坐标保存到本地仓库
+ `mvn deploy` 部署主程序, 会打包, 按照本工程坐标保存到本地库, 还会保存到私服仓库/web容器中

+ 执行每个命令的时候, 会把这个名字之前的命令都执行一遍



# 在Idea中使用Maven

1. idea内置了Maven, 但一般不使用这个, 使用自己安装的, 需要覆盖默认设置

   Settings --> Build, Ex... --> Build Tools --> Maven

2. 快速使用Maven生命周期/插件:

   点击界面最右侧Maven小字, 选择包, 直接双击插件即可

3. 导入项目至Maven中: 

   1. 选择工程结构(`cmd + ;`), 点击加号



# 依赖管理

## Scope依赖范围

+ scope表示依赖在Maven构建项目的哪些阶段起作用

+ scope的值有: `compile`, `test`, `provided`, 

  + 默认是`compile`,  在compile之后的所有流程都会需要
  + `test`是在只执行test测试时需要, 如junit
  + `provided` 提供者, 在程序编译/测试时会用到, 但打包/安装时不需要提供该插件的jar包, 如servlet.jar

  ![](https://cdn.jsdelivr.net/gh/SalmonC/PicBed@main/1627384882465-1627384882456.png)

  

# Maven常用设置

## 使用设置

+ 在pom文件中的`<properties>...</properties>`中设置



## 全局变量

1. 在properties中通过自定义标签声明变量(标签名就是变量名)

2. 在pom.xml文件中其他位置, 使用${标签名} 使用变量的值

3. 自定义全局变量一般是定义**依赖的版本号**, 当项目中要使用多个相同的版本号, 先使用全局变量定义, 再使用${变量名}, 方便统一, 改一个地方, 其他都改了

   ```html
   <!--定义-->
   <springversion>5.2.0</springversion>
   <!--使用-->
   <version>${springversion}</version>
   ```

   

## 资源插件

+ 作用: 默认没有使用resources插件时, 编译会把`src/main/resources` 目录中文件拷贝到`target/classes` 目录中, 对于`src/main/java`目录下的非java文件不处理, 不拷贝到`target/classes` 目录中
+ 我们程序有需要把一些文件放在`src/main/java`目录中, 如果执行java时需要用到这些文件, 就要告诉Maven需要把这些文件一同拷贝到`target/classes`目录中, resources插件可以实现