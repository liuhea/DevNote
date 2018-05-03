# GitBook的使用

## GitBook Editor

官方编辑器：https://legacy.gitbook.com/editor

![](https://github.com/liuhea/DevNote/blob/6cb2f733c874771382eafb055479c640c5708653/gitbook/GitBook%20Editor.png?raw=true)

## 命令行方式
> 如果不安装GitBook Editor，也可以使用GitBook,并且支持本地预览

```
$ npm install gitbook -g
```
电脑需安装 nodejs环境，以便能够使用 npm 来安装 gitbook。

基本使用，主要三个命令：

```
 gitbook init //初始化书籍目录
 gitbook serve //编译书籍,浏览器查看 http://localhost:4000/
 gitbook build // 导出书籍
```

**具体使用可参考：**
* [GitBook 简明教程](http://www.chengweiyang.cn/gitbook/)
* [GitBook使用](https://wuxiaolong.gitbooks.io/wuxiaolong/GitBookGuide.html)

## 插件的使用
> 新建一个 book.json 文件，可以配置网站信息、在 plugins 和 pluginsConfig 字段添加插件等。



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