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
git push origin master -F //和本地冲突，则强制覆盖
```
