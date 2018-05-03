# Jenkins从零开始（一）搭建打包平台

Keywords：Mac、Jenkins 安装、git plugin、git clone

[TOC]

## 安装jenkins
前提：开发环境：mac ,已安装[Hombrew](https://brew.sh/)

```
➜  ~ brew instal jenkins
```
## 启动jenkins

```
➜  ~ jenkins start
......
Jenkins initial setup is required. An admin user has been created and a password generated.
Please use the following password to proceed to installation:

    1e398714de71476a82ef8c29a5591f0c //浏览器启动的admin 密码，首次安装启动会有这个日志，如果没有注意，后边登录会有点小麻烦
    
This may also be found at: /Users/liuhe/.jenkins/secrets/initialAdminPassword // jenkins密码存储的位置，丢失密码可以从此处找回
```

    浏览器输入：http://localhost:8080/
  ![image](https://github.com/liuhea/DevNote/blob/master/Jenkins/res/%E6%B5%8F%E8%A7%88%E5%99%A8%E6%89%93%E5%BC%80Jenkins.png?raw=true)
  
## 安装plugin
**安装成功后第一次启动，会出现引导页，引导提示你安装必要的插件，大体如下（下图是管理页面截图）**

![image](https://github.com/liuhea/DevNote/blob/master/Jenkins/res/Jenkis%E7%AE%A1%E7%90%86%E9%A1%B5%E9%9D%A2.png?raw=true)

**可选插件-包含各个平台相关插件,安装必要插件 如git plugin**。

![image](https://github.com/liuhea/DevNote/blob/master/Jenkins/res/Jenkins%E6%8F%92%E4%BB%B6%E5%AE%89%E8%A3%85%E9%A1%B5%E9%9D%A2.png?raw=true)

## 构建项目（New Item）
**进入jenkins首页，创建项目。**

![image](https://github.com/liuhea/DevNote/blob/master/Jenkins/res/Jenkins%E9%A6%96%E9%A1%B5.png?raw=true)

![image](https://github.com/liuhea/DevNote/blob/master/Jenkins/res/%E6%96%B0%E5%BB%BA%E9%A1%B9%E7%9B%AE%20git%20clone.png?raw=true)

**从github或者gitlab clone代码**

![image](https://github.com/liuhea/DevNote/blob/master/Jenkins/res/%E6%96%B0%E5%BB%BA%E9%A1%B9%E7%9B%AE%20git%20clone.png?raw=true)

## 简单配置（不重要）
### 端口号临时修改
临时修改端口号比较简单，只是重启Jenkins的话会发现启动的还是8080端口，临时修改方法如下，找到jenkins war文件位置，执行（假如我要修改为8088）：
```
➜  ~ java -jar /Applications/Jenkins/jenkins.war  --httpPort=8088
Running from: /Applications/Jenkins/jenkins.war
webroot: $user.home/.jenkins
```


## 参考
（1） [使用Jenkins配置Git+Maven的自动化构建](http://blog.csdn.net/xlgen157387/article/details/50353317)

（2）[使用Jenkins搭建iOS/Android持续集成打包平台](http://debugtalk.com/post/iOS-Android-Packing-with-Jenkins/)
  