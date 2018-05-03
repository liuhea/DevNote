# GitBook的使用

## GitBook创建

### GitBook Editor

官方编辑器：[https://legacy.gitbook.com/editor](https://legacy.gitbook.com/editor)

![](https://github.com/liuhea/DevNote/blob/6cb2f733c874771382eafb055479c640c5708653/gitbook/GitBook Editor.png?raw=true)

### 命令行方式

> 如果不安装GitBook Editor，也可以使用GitBook,并且支持本地预览

```
$ npm install gitbook -g
```

电脑需安装 nodejs环境，以便能够使用 npm 来安装 gitbook。

基本使用，主要几个命令：

```
 gitbook init //初始化书籍目录
 gitbook serve //编译书籍,浏览器查看 http://localhost:4000/
 gitbook build // 导出书籍

 gitbook install // 安装插件
```

**具体使用可参考：**

* [GitBook 简明教程](http://www.chengweiyang.cn/gitbook/)
* [GitBook使用](https://wuxiaolong.gitbooks.io/wuxiaolong/GitBookGuide.html)

## 插件的使用

> GitBook除了一些默认设置外，我们也可以通过book.json进行个性化设置，如页面图标（如GitHub等），网站信息（个人信息等）等，具体如下。

以配置GitHub图片及跳转为例，新建一个 book.json 文件，增加plugins和pluginsConfig及其他配置信息，效果如下：

```
{
"author": "liuhe",
"description": "Liuhe's Book",
"plugins": ["github"],
"pluginsConfig":{
    "github": {
        "url": "https://github.com/liuhea"    
        }
    }
}
```

![](/GitBook/res/bookjson-github.png)

**常用插件说明：**

* [github](https://plugins.gitbook.com/plugin/github):在右上角显示 github 仓库的图标链接。
* [anchor-navigation](https://plugins.gitbook.com/plugin/anchor-navigation)：添加Toc到侧边悬浮导航以及回到顶部按钮
* [Prism](https://plugins.gitbook.com/plugin/prism):基于 Prism 的代码高亮。
* [donate](https://plugins.gitbook.com/plugin/donate):打赏

其它可参考[gitbook plugins官网](https://plugins.gitbook.com/)

