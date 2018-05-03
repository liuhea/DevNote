# Groovy学习
> Groovy是一种基于JVM虚拟机的动态语言,groovy完全兼容java,又在java的基础上增加了很多动态类型和灵活的特性，比如闭包，DSL等。

[TOC]

## 使用assert查错

新建build.gradle

```
def version=12
assert version == 12
version++
assert version == 12
```

报错日志如下：

```
➜  Desktop gradle build.gradle
Parallel execution with configuration on demand is an incubating feature.

FAILURE: Build failed with an exception.

* Where:
Build file '/Users/liuhe/Desktop/build.gradle' line: 4

* What went wrong:
A problem occurred evaluating root project 'Desktop'.
> assert version == 12
         |       |
         13      false

```

## 可选类型定义
Goovy不强制你显示声明变量类型、方法参数或者返回类型。使用def进行简单标识（==也可以不写==），作为java.lang.Object的一个占位符。

如果一个方法没有返回值，则应该声明void而不是def作为返回类型。

## 可选的括号
在Groovy中如果方法签名需要至少一个参数的话，则方法调用可以省略括号。

```
​class ProjectVersion {
    Integer major
    Integer minor
    
    ProjectVersion(Integer major,Integer minor){
        this.major = major
        this.minor = minor
    }
}

def initProjectVersion(major,minor){
    new ProjectVersion(major, minor)
}

initProjectVersion(1,2)
initProjectVersion 1,2

println('Groovy is awesome')
println 'Groovy is awesome'
​
```
## 字符串
1. 单引号：通常用来创建出等效于Java的String类型。
2. 双引号（GString）：比单引号强大，可以插值到变量或表达式中，通过美元符号（$）和花括号来表示。

```
println('Hello ${initProjectVersion(1,2).major}') // Hello ${initProjectVersion(1,2).major}
println("Hello ${initProjectVersion(1,2).major}") // Hello 1​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​​
```

3. 三个双引号：通常用来赋值长文本或者格式化（如多行SQL语句）

```
myString3 = """
 This is 
 a 
 multiline
 String
"""
```

## 集合API
### List

```
def buildTools = ['Ant','Maven']
buildTools.each{it-> println(it)} // it -> 可以省略
// 输出：[Ant, Maven]

buildTools << 'Gradle' // 左移运算符表示向List中添加一个新元素
// 输出：[Ant, Maven, Gradle]
```

### Map
> 默认实现java.lang.LinkedHashMap。

```
def inceptionYears = ['Ant':2000,"Maven":2004]​​
inceptionYears.each{buildTool,year -> 
    println "$buildTool was first released in $year"
}
//Ant was first released in 2000
//Maven was first released in 2004​​​​​​​​​​​​​​​​​​​

inceptionYears['Ant'] = 2009 //赋值操作
//Ant was first released in 2009
```

## 命名参数
在定义一个类时，如果不暴露一个构造器来初始化其中的属性，而是直接new ProjectVersion(major, minor)，可能会报错如下：

```
groovy.lang.GroovyRuntimeException: Could not find matching constructor for: ProjectVersion(java.lang.Integer, java.lang.Integer)
	at Script1.initProjectVersion(Script1.groovy:9)
	at Script1$initProjectVersion.callCurrent(Unknown Source)
	at Script1.run(Script1.groovy:12)
```

Groovy提供一个更加方便的方式来设置属性值，叫命名参数。这种机制首先调用类的默认构造器，然后为每个参数调用相应的setter方法。
```
​class ProjectVersion {
    Integer major
    Integer minor
    
    //ProjectVersion(Integer major,Integer minor){
    //    this.major = major
    //    this.minor = minor
    //}
}

def initProjectVersion(major,minor){
    new ProjectVersion(major:major, minor:minor)
}

```

## 闭包
> 闭包是一个类型为groovy.lang.Closure的代码块，与其他语言类似，可以赋值给变量或者作为参数传递给方法，并且像普通方法一样被调用。
1. 隐式闭包参数（it）

```
class ProjectVersion {    
    Integer major
    Integer minor
}

def incrementMajorProjectVersion={
    it.major++ 
}

ProjectVersion projectVersion= new ProjectVersion(major:1, minor:10)
incrementMajorProjectVersion(projectVersion) // major:2

```
2. 显示闭包参数

Groovy类型是可选的，所以下边的ProjectVersion version中的ProjectVersion可以省略。
另外，Groovy也没有限定闭包可以指定的参数数量。
```
// 参数加括号，报语法错误
def incrementMajorProjectVersion={ ProjectVersion version ->
    version.major++ 
    println(version.major) //2
}

ProjectVersion projectVersion= new ProjectVersion(major:1, minor:10)
incrementMajorProjectVersion(projectVersion) 

// 多个参数
def incrementMajorProjectVersion={ version, tempVar->
    version.major++ 
    println("version.major=${version.major}  tempVar=${tempVar}") //version.major=2  tempVar=3}

incrementMajorProjectVersion(projectVersion,3) 
```

**注意：当显示参数加括号时，会报错。**

```
def incrementMajorProjectVersion={ (ProjectVersion version) ->
    version.major++ 
    println("version.major=${version.major}") //version.major=2  tempVar=3
}
```

```
startup failed:
Script1.groovy: 7: unexpected token: ProjectVersion @ line 7, column 37.
   def incrementMajorProjectVersion={ (ProjectVersion version) ->
                                       ^

1 error
```

3. 闭包返回值

闭包总会有一个返回值。返回值是闭包的最后一条语句（如果没有显示的return），或者可执行的return语句的值。如果闭包的最后一条语句没有值，就返回null。

```
class ProjectVersion {        
    Integer major
    Integer minor
}

ProjectVersion projectVersion= new ProjectVersion(major:1, minor:10)
def minorVersion={projectVersion.minor}
println(minorVersion()) // 10

```
4. 闭包委托
闭包代码在委托的闭包上执行。默认的，这个委托就是闭包的所有者。

```
class ProjectVersion {        
    Integer major
    Integer minor

    // ProjectVersion 的内部方法用闭包作为参数
    void increment(Closure closure){
        // 只处理委托引用
        closure.resolveStrategy=Closure.DELEGATE_ONLY
        // 设置闭包的委托
        closure.delegate=this
        closure()
    }
}

ProjectVersion projectVersion= new ProjectVersion(major:1, minor:10)
// 调用ProjectVersion实例的方法，其内部执行了一个闭包
projectVersion.increment{
    major+=1 
    println(major) // 2
}
```

## 在Gradle构建脚本中使用Groovy

Gradle构建脚本就是合法的Groovy脚本。

```
apply plugin:'java' // 调用Project的apply方法，参数是一个键值对的Map
version='0.1' // 通过调用Project的setter方法为项目设置版本属性
repositories{ //调用Project的repositores方法，并传递一个闭包参数
    mavenCentral() // 调用闭包委托的mavenCentral()方法
}

dependencies{
    compile 'commons-codec:commons-code:1.6'//调用闭包委托的对象compile方法，省略括号
}
```

## 关键字

```
as, assert, break, case, catch,
class, const, continue, def,
default, do, else, enum, extends,
false, finally, for, got, if, 
implements, import, in, 
instanceof, interface, new，null,
package, return, super,
switch, this, throw, throws,
trait, true, try, while.
```



