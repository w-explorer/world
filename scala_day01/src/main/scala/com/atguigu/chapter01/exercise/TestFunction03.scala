package com.atguigu.chapter01.exercise

/**
 * @author wencheng
 * @create 2022/2/23 15:48
 */
object TestFunction03 {

  def main(args: Array[String]): Unit = {

    println(f1(sum))



    def f3()={
      println("f3")
      def f4() ={
        println("f4")
      }

      f4 _
    }
    f3()()
  }

  def f1(f: (Int,Int) =>Int): Int ={
    f(2,4)
  }

  def sum(a:Int,b:Int): Int ={
    a+b
  }

}
