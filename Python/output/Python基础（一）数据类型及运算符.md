# Python基础（一）- 数据类型及运算符

> 学习资料：[Python3基础教程](http://www.runoob.com/python3/python3-basic-syntax.html) 或[ 廖雪峰Python教程](https://www.liaoxuefeng.com/wiki/0014316089557264a6b348958f449949df42a6d3a2e542c000)

[TOC]

## Python2.x与3.x区别
目前，Python有两个版本，一个是2.x版，一个是3.x版，这两个版本是不兼容的。

<img src="https://github.com/liuhea/DevNote/blob/HEAD/python/python2%20%E4%B8%8Epython3.png?raw=true" width = "400" height = "300" alt="图片名称" align=center />

## 注释
> 使用#

## 数据类型

<img src="https://github.com/liuhea/DevNote/blob/04dbc58c8e8a6d887bd26e31c816f231a457f2d9/python/python%E4%B8%AD%E7%9A%84%E5%8F%98%E9%87%8F%E7%B1%BB%E5%9E%8B.png?raw=true" width = "400" height = "300" alt="图片名称" align=center />

## 变量

变量本身类型不固定的语言称之为动态语言，与之对应的是静态语言。静态语言在定义变量时必须指定变量类型，如果赋值的时候类型不匹配，就会报错。例如Java是静态语言，赋值语句如下（// 表示注释）：

静态语言：
```
int a = 123; // a是整数类型变量
a = "ABC"; // 错误：不能把字符串赋给整型变量
```
动态语言：

```
a = 123 # a是整数
print(a)
a = 'ABC' # a变为字符串
print(a)
```

## 运算符

### 算术运算符
	
运算符 | 描述 | 实例
---|---|---
\-	| 减	|得到负数或是一个数减去另一个数 a - b 输出结果 -10
\*	| 乘	|两个数相乘或是返回一个被重复若干次的字符串 a * b 输出结果 200
\/	| 除	|x除以y b / a 输出结果 2
\//	| 取整除|	返回商的整数部分 9//2 输出结果 4 , 9.0//2.0 输出结果 4.0
\%	| 取余|	返回除法的余数 b % a 输出结果 0
\**	| 幂	|返回x的y次幂 a**b 为10的20次方， 输出结果 100000000000000000000

### 赋值运算符

运算符 | 描述 | 实例
---|---|---
=	| 赋值运算符	|把=号右边的结果给左边的变量 num=1+2*3 结果num的值为7

### 复合运算符

运算符 | 描述 | 实例
---|---|---
+=	| 加法赋值运算符	|c += a 等效于 c = c + a
-=	| 减法赋值运算符	|c -= a 等效于 c = c - a
*=	| 乘法赋值运算符	|c *= a 等效于 c = c * a
/=	| 除法赋值运算符|	c /= a 等效于 c = c / a
%=	| 取模赋值运算符	|c %= a 等效于 c = c % a
**=	| 幂赋值运算符|	c **= a 等效于 c = c ** a
//=	| 取整除赋值运算符|	c //= a 等效于 c = c // a

**优先级问题：复合运算符优先级低**
```
In [1]: a=3
#a=a*(4+3)=21
In [2]: a*=4+3  

```
### 比较（关系）运算符

运算符 | 描述 | 实例
---|---|---
==	|检查两个操作数的值是否相等，如果是则条件变为真。|	如a=3,b=3则（a == b) 为 true.
!=|	检查两个操作数的值是否相等，如果值不相等，则条件变为真。|	如a=1,b=3则(a != b) 为 true.
<>	|检查两个操作数的值是否相等，如果值不相等，则条件变为真。|	如a=1,b=3则(a <> b) 为 true。这个类似于 != 运算符
\>	|检查左操作数的值是否大于右操作数的值，如果是，则条件成立。	|如a=7,b=3则(a > b) 为 true.
\<	|检查左操作数的值是否小于右操作数的值，如果是，则条件成立。	|如a=7,b=3则(a < b) 为 false.
\>=	|检查左操作数的值是否大于或等于右操作数的值，如果是，则条件成立。	|如a=3,b=3则(a >= b) 为 true.
<=	|检查左操作数的值是否小于或等于右操作数的值，如果是，则条件成立。	|如a=3,b=3则(a <= b) 为 true.

### 逻辑运算符

运算符 | 逻辑表达式|描述 | 实例
---|---|---|---
and	|x and y|	布尔"与" - 如果 x 为 False，x and y 返回 False，否则它返回 y 的计算值。|	(a and b) 返回 20。
or	|x or y	|布尔"或" - 如果 x 是 True，它返回 True，否则它返回 y 的计算值。	|(a or b) 返回 10。
not	|not x|	布尔"非" - 如果 x 为 True，返回 False 。如果 x 为 False，它返回 True。|	not(a and b) 返回 False
		
## 其它

### 常用数据类型转换


函数|	说明
---|---
int(x [,base ])|	将x转换为一个整数
long(x [,base ])|	将x转换为一个长整数
float(x )	|将x转换到一个浮点数
complex(real [,imag ])|	创建一个复数
str(x )	|将对象 x 转换为字符串
repr(x )|	将对象 x 转换为表达式字符串
eval(str )|	用来计算在字符串中的有效Python表达式,并返回一个对象
tuple(s )|	将序列 s 转换为一个元组
list(s )|	将序列 s 转换为一个列表
chr(x )	|将一个整数转换为一个字符
unichr(x )|	将一个整数转换为Unicode字符
ord(x )	|将一个字符转换为它的整数值
hex(x )|	将一个整数转换为一个十六进制字符串
oct(x )	|将一个整数转换为一个八进制字符串

### print
> 默认换行

```
#使用end 使print不换行
print("*",end="") 
```
> pirnt输出多个变量

<img src="https://github.com/liuhea/DevNote/blob/d7097cd91b6da89d815f01380c4dfb1f2e7cb374/python/pirnt%E8%BE%93%E5%87%BA%E5%A4%9A%E4%B8%AA%E5%8F%98%E9%87%8F.png?raw=true" width = "400" height = "100" alt="pirnt输出多个变量" align=center />

### 字符串可以使用*做乘法

```
In [49]: name2= 10*'liuhe'
In [50]: name2
Out[50]: 'liuheliuheliuheliuheliuheliuheliuheliuheliuheliuhe'
```

### python没有大括号，多余的空格可能导致报错

<img src="https://github.com/liuhea/DevNote/blob/d7097cd91b6da89d815f01380c4dfb1f2e7cb374/python/python%E6%B2%A1%E6%9C%89%E5%A4%A7%E6%8B%AC%E5%8F%B7.png?raw=true" width = "400" height = "300" alt="python没有大括号" align=center />

### 关键字

```
>>> import keyword
>>> keyword.kwlist
['False', 'None', 'True', 'and', 'as', 'assert', 'break', 'class', 'continue', 'def', 'del', 'elif', 'else', 'except', 'finally', 'for', 'from', 'global', 'if', 'import', 'in', 'is', 'lambda', 'nonlocal', 'not', 'or', 'pass', 'raise', 'return', 'try', 'while', 'with', 'yield']
>>> 
```

### 帮助文档

> 通用帮助函数help()

**python模式下，命令行输入help()**

```
In [4]: help()

Welcome to Python 3.6's help utility!

If this is your first time using Python, you should definitely check out
the tutorial on the Internet at http://docs.python.org/3.6/tutorial/.

Enter the name of any module, keyword, or topic to get help on writing
Python programs and using Python modules.  To quit this help utility and
return to the interpreter, just type "quit".

To get a list of available modules, keywords, symbols, or topics, type
"modules", "keywords", "symbols", or "topics".  Each module also comes
with a one-line summary of what it does; to list the modules whose name
or summary contain a given string such as "spam", type "modules spam".

help> del # 要查询的关键字或者函数


```

**查询某一模块**

> 使用help(module_name)时首先需要import该模块

```
>>> import math
>>> help(math)
Help on built-in module math:

NAME
    math
MODULE REFERENCE
    ...
```
