# Jenkins从零开始（二）- 常用插件及问题

[TOC]
## 问题
### 1. 启动Jenkis提示端口占用
![img](https://github.com/liuhea/DevNote/blob/master/jenkins/res/%E5%90%AF%E5%8A%A8Jenkis%E6%8F%90%E7%A4%BA%E7%AB%AF%E5%8F%A3%E5%8D%A0%E7%94%A8.png?raw=true)

解决：	
  1. 参考端口号：lsof -i tcp:port 将port换成被占用的端口(如：8086、8080) 
  2. 杀死占用端口的pid进程 kill PID（进程的PID，如2044）
  
### 2. Jenkis 可选插件为空
参考：[jenkins可选插件为空的解决方式](https://www.cnblogs.com/926xiuxiu/p/7766730.html)

打开一个新的tab，输入网址http://localhost:8080/pluginManager/advanced。打开后这里面最底下有个【升级站点】，把其中的链接改成http的就好了，http://updates.jenkins.io/update-center.json。 然后在服务列表中关闭jenkins，再启动，这样就能正常联网了。

### 3. error：SDK location not found.
![img](https://github.com/liuhea/DevNote/blob/master/jenkins/SDK%20location%20not%20found.png?raw=true)

**出现这种情况，需要分为两种情况**

- 可以使用管理员权限配置打包机器SDK路径
这个比较简单

![img](https://github.com/liuhea/DevNote/blob/master/jenkins/SDK%20location%20not%20found-reslove.png?raw=true)

- 无法使用管理员权限
> 如果公司统一CICD，即采用[master/slave模式](http://blog.csdn.net/rancherlabs/article/details/53665910)，可能有多个打包节点，这个时候可能自定义具体打包机器的SDK路径。

![img](https://github.com/liuhea/DevNote/blob/master/jenkins/SDK%20location%20not%20found-reslove2.png?raw=true)

另外这种模式需要选择具体打包机器，而本机打包，就没有这个选择。

![img](https://github.com/liuhea/DevNote/blob/master/jenkins/SDK%20location%20not%20found-label_expression.png?raw=true)

### 4. git clone 报错 
在Jenkins那机器生成id_rsa.pub公钥，添加到gitlab管理界面的ssh-keys处。


## 常用插件使用
>初次安装后，Jenkins很纯净，需要安装一些常用插件。

### 1. Git Parameter Plug-In 
 > Git管理，多分支构建 
 
 资料：[Jenkins 使用Git Parameter打包](https://yoyoyoky.github.io/2017/09/24/Jenkins-%E4%BD%BF%E7%94%A8Git-Parameter%E6%89%93%E5%8C%85/)

### 2. Role-based Authorization Strategy 
>用户管理(权限管理等)，[官网地址](https://plugins.jenkins.io/role-strategy)

资料：[Jenkins 不同角色不同视图及不同权限设置](http://blog.csdn.net/lipei1220/article/details/78623226)

我的设置如下：

![image](https://github.com/liuhea/DevNote/blob/master/jenkins/jenkins%20%E6%9D%83%E9%99%90%E7%AE%A1%E7%90%86%E8%AE%BE%E7%BD%AE.png?raw=true)

### 3. Dingding[钉钉] Plugin
>项目构建成功后，通知管理，[官网地址](https://plugins.jenkins.io/dingding-notifications)

### 4. Upload to pgyer
>[蒲公英上传插件](https://plugins.jenkins.io/upload-pgyer)，[蒲公英官网](https://www.pgyer.com/doc/view/jenkins)也提供了对应的命令行方式

### 5. description setter plugin
>生成二维码插件，[官网地址](https://plugins.jenkins.io/description-setter)

资料：[Jenkins-蒲公英二维码生成](http://note.youdao.com/noteshare?id=9332b439983bdd36845a3323f3d306ec)

### 6. Archive the artifacts
>配置-> 构建后操作 -> Archive the artifacts

在存档文件中输入需要存档的文件，多个文件以 “，”(逗号) 分割，同时也支持通配符。存档文件默认路径为 WORKSPACE ,我们可以用正则表达式去匹配需要存档的文件，我构建的产出包含一个二维码图片和apk，所以我需要取出多个文件，我的存放目录在 workspace\apk，存档文件写为 apk/*（如果只是取出apk，可以写成.apk ）,如下图
![img](https://github.com/liuhea/DevNote/blob/master/jenkins/Archive%20the%20artifacts.png?raw=true)

## 参考
1. [使用Jenkins搭建iOS/Android持续集成打包平台](http://blog.csdn.net/u011904605/article/details/54619549)