package com.atguigu.chapter01

import scala.util.control.Breaks

/**
 * @author wencheng
 * @create 2022/2/21 16:18
 */
object Loop {

  def main(args: Array[String]): Unit = {
//    for (i <- 1 until  5+1){
//      println("次数"+i)
//    }
    breaksMethod()
  }

  def exceptionMethod(): Unit ={
      for (i <- 1 to 10){
        if(i == 3 ){
          throw new RuntimeException("异常中止");
        }
        println(i)
      }
  }

  def breaksMethod(): Unit ={
//    Breaks.breakable(
//      for (i <- 1 to 10){
//        println(i)
//        if(i==2) Breaks.break()
//      }
//    )
    for (elem <- 1 to 10) {
      if (elem % 2 == 1) {
        println(elem)
      } else {
        println("continue")
      }
    }
  }

}
