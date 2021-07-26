# Git概述

+ 项目版本控制系统
+ 应用最广泛, 最适用于中小项目
+ 一般origin代表远程仓库, master代表本地



# Git基本操作

![](https://cdn.jsdelivr.net/gh/SalmonC/PicBed@main/1627286601589-1627286601543.png)

+ 本地仓库同步至GitHub (push)

  1. Stage all changes(`git add`)
  2. Stage files/changes to commit(`git commit`)
  3. push (`git push origin master`)

+ 从GitHub同步至本地 (pull)

  1. 直接pull即可

+ 不同人的操作合并 (merge)

  1. 会出现分叉branch

     ![](https://cdn.jsdelivr.net/gh/SalmonC/PicBed@main/1627286880919-1627286880837.png)

  2. 多种方式: 

     + pull, Git会自动将两个修改合并(都保留)

       如果不同的提交出现冲突, Git会pull失败, 需要手动处理



![](https://cdn.jsdelivr.net/gh/SalmonC/PicBed@main/1627287151573-1627287151494.png)



# 进阶操作

+ `- amend`: 用于修改提交, 在提交时勾选amend, 
  + 该操作不会创建新的提交, 而是修改上一个提交
  + 最好不要对远程服务器进行amend
+ Branch: 可用来把实验功能和软件发布版本区分开
  + 普通提交默认提交到master分支
  + 可以创建新分支, 并切换分支来控制提交到哪里
  + ![](https://cdn.jsdelivr.net/gh/SalmonC/PicBed@main/1627287561282-1627287561273.png)
  + 合并: 切换到master分支, 在test分支上点右键, merge into master, 如果fail则手动修改

+ Stash 暂存: 
  + 和Stage功能完全不同
  + Stash之后, 源代码会恢复成修改前的状态, 未保存代码单独放在Stashes分区
  + 需要恢复暂存代码, 可以用`pop`功能
  + 可以在其它版本下进行`pop`, 所以stash功能可以用来在不同的分支下移动修改
+ Rebase 变基: 和merge相似, 但不同
  + 会将整个分支嫁接在另一个分支上(从分支根部截断, 全部接在另一个分支最后)
  + 变基得到的提交历史不会出现分叉, 看起来很简洁
  + 被减下来的代码, 其基底从之前的分叉处, 变成了另一个分支的最末尾, 所以叫变基
+ CheckOut 签出: 
  + 用途: 查看早期源代码, 回退到之前版本等
  + GitKraken中右键, 选择commit
+ Undoing 撤销
  + 点击最上面的Undo, 撤销上一次提交(任意操作)
  + 同理, Redo可以Undo Undo
  + 和amend一样, 尽量不要尝试修改服务器提交历史
+ Revert 撤销
  + 原理: 针对某次提交, 执行相反的操作, 使代码变成提交前的状态
  + 这也是一次新提交, 不会修改提交历史, 可以对远程服务器执行
+ ![](https://cdn.jsdelivr.net/gh/SalmonC/PicBed@main/1627288787680-1627288787653.png)



# 同步至GitHub Repository

+ 第一步：提出更改，添加到暂缓区

```
git add -A  //提交所有变化

git add -u  //提交被修改(modified)和被删除(deleted)文件，不包括新文件(new)

git add .  //提交新文件(new)和被修改(modified)文件，不包括被删除(deleted)文件
```

+ 第二步：实际提交改动

```
git commit -m "代码提交信息"
```

+ 第三步：推送改动

```
git push origin master
git push origin master -f //和本地冲突，则强制覆盖
```



