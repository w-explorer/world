package com.atguigu.chapter01.exercise

/**
 * @author wencheng
 * @create 2022/2/23 15:40
 */
object TestFunction02 {

  def main(args: Array[String]): Unit = {
    val f = foo()
    println(f)

    val f1 = foo _

    f1()

    var f2:()=>Int = foo

    println(f2)
  }

  def foo(): Int ={
    println("foo....")
    1
  }

}
