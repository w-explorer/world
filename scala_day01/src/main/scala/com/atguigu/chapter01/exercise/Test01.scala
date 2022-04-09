package com.atguigu.chapter01.exercise

/**
 * @author wencheng
 * @create 2022/2/23 15:00
 */
object Test01 {

  def main(): Unit = {

  }

  def main(args: Array[String]): Unit = {
//    def sum(a: Int,b: Int): Int ={
//      a+b
//    }
//
//    println(sum(1, 2))
//
//    def str(string: String): Unit ={
//      println(string)
//    }
//
//    str("Hello method")
//
//
//    // (2)函数没有重载和重写的概念，程序报错
//    def test(): Unit ={
//      println("无参，无返回值")
//    }
//    test()


    //（3）Scala 中函数可以嵌套定义
    def test2(): Unit ={
      def test3(name:String):Unit={
        println("函数可以嵌套定义"+name)
      }
    }
    test2().->("HELN")

  }

}
