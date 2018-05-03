
[vim学习文档](http://www.runoob.com/linux/linux-vim.html)

三种模式
1. 命令模式
2. 输入模式
3. 末行模式

常用命令

```
	h左 j下 k上 l右

	yy:复制 光标所在的这一行
	4yy:复制 光标所在行开始向下的4行

	p: 粘贴

	dd:剪切 光标所在的这一行
	2dd:剪切 光标所在行 向下 2行
	D:从当前的光标开始剪切，一直到行末
	d0:从当前的光标开始剪切，一直到行首
	x:删除当前的光标，每次只会删除一个
	X:删除当前光标前面的那个，每次只会删除一个
	
	u:撤销刚刚的操作
	ctrl+r:反撤销

	H:当前屏幕的上方
	M:当前屏幕的中间
	L:当前屏幕的下方

	ctrl+f--->向下翻一页代码
	ctrl+b--->向上翻一页代码

	ctrl+d--->向下翻半页代码
	ctrl+u--->向上翻半页代码

	20G:快速的定位到第2行代码
	G:快速的回到 整个代码的最后一行
	gg:快速回到 整个代码的第1行

	w:向后跳一个单词的长度，即调到下一个单词的开始处
	b:向前跳一个单词的长度，即调到上一个单词的开始处

	选中一片代码 
	v: 
	V:

	>>:向右移动代码
	<<:向左移动代码

	.:重复执行上一次的命令

	r:替换一个字符
	R:替换光标以及后面的字符

	shift+zz:相当于wq
```

	
末行模式:

```
	w:保存
	q:退出
	wq:保存并且推出
```

![vim键盘图](https://github.com/liuhea/DevNote/blob/master/Vim/res/vim%E9%94%AE%E7%9B%98%E5%9B%BE.gif?raw=true)


![vim快捷键](https://github.com/liuhea/DevNote/blob/master/Vim/res/vim.jpg?raw=true)