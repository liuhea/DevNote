# Kotlin学习笔记(六)基本使用

[TOC]

## 1.let、apply、with、run使用
具体介绍：[Kotlin之let,apply,with,run函数区别](https://blog.csdn.net/guijiaoba/article/details/78975011)


![img](https://github.com/liuhea/DevNote/blob/master/Kotlin/res/kotlin-let_apply_run.png?raw=true)


```
fun testLet() {
    var data = mutableListOf<String>()
    with(data) {  add("44")}//this
    data?.run {   add("11-1")}//this 
    data?.apply { add("11-2") }//this
    run { data.add("22-1")}
    data?.also { it.add("33-1")}//it
    data?.let {it.add("33-2")}//it
    println(data)//[44, 11-1, 11-2, 22-1, 33-1, 33-2]
}

// apply返回T对象，run返回最后一个值
 val resultRun = "Hello World".run {
        println(this) // Hello World
        520
    }
    val resultApply = "Hello World".apply {
        println(this) //  Hello World
        520
    }

    println("resultRun=$resultRun |resultApply=$resultApply ")//resultRun=520 |resultApply=Hello World 
```

##  2.return语句
在Kotlin中，可以直接使用=符号来直接返回一个函数的值。但是函数体语句有没有大括号{}意义不同。
```
   val sum = fun(a: Int, b: Int) = a + b
   val sum2 = fun(a: Int, b: Int) = { a + b }

    println(sum(1, 3)) //4
    println(sum2(1, 3)) //() -> kotlin.Int
    println(sum2(1, 3).invoke())    //4
```
##  3.== 与===

- ==：结构相等(数值相等)
- ===：引用相等
```
 var a = String("aa".toCharArray())
    var b = String("aa".toCharArray())
    println(a == b)  // true
    println(a === b)   //false
```

## 4.map与flatMap的区别
- map：遍历每一个元素;
- flatMap：遍历每一个元素，并铺平元素;flatMap中的函数一定要返回一个Iterable，不然报错

```
var list =listOf(listOf(10,20),listOf(30,40),listOf(50,60))

var mapList = list.map{it->it.toString()} //[[10, 20], [30, 40], [50, 60]]
var flatMapList = list.flatMap{it->it.asIterable()}//[10, 20, 30, 40, 50, 60]

```
## 5. ::双冒号操作符

表示把一个方法当做一个参数，传递到另一个方法中进行使用，通俗的来讲就是引用一个方法。
```
listOf.forEach({println(it)})
listOf.forEach(::println) 
```
## 6. 双击退出应用

```
/**
* 双击退出应用
* a.minus(b) http://blog.csdn.net/love667767/article/details/72589260
*/
override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
    if (keyCode == KeyEvent.KEYCODE_BACK) {
        if (System.currentTimeMillis().minus(mExitTime) <= 3000) {
            finish()
            toast!!.cancel()
        } else {
            mExitTime = System.currentTimeMillis()
            toast = showToast("再按一次退出程序")
        }
        return true
    }
    return super.onKeyDown(keyCode, event)
}
```

## 7. lateinit 和 by lazy

> lateinit(var)和 lazy(val) 是 Kotlin 中的两种不同的延迟初始化技术。

* lazy 应用于单例模式(if-null-then-init-else-return)当且仅当变量被第一次调用的时候，委托方法才会执行。
* lateinit 则用于只能生命周期流程中进行获取或者初始化的变量，比如 Android 的 onCreate()，不能用在可空的属性  否则会导致 UninitializedPropertyAccessException。

* lazy{  ...  } 只能用在val类型, lateinit 只能用在var类型


```
val mLayoutContext:ViewGroup by lazy{findViewById(R.id.mLayoutContent) as ViewGroup}

lateinit var aa: String
```
* lateinit不能用在可空的属性上和java的基本类型上  否则会报错误 (lateinit 报错) 


```
lateinit var amount: Double // 报错
```
