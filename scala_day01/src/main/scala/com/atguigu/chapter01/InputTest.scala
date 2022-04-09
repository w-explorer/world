package com.atguigu.chapter01

import scala.io.StdIn

/**
 * @author wencheng
 * @create 2022/1/27 19:25
 */
object InputTest {

  def main(args: Array[String]): Unit = {
    println("input name:")
    var name = StdIn.readLine()

    print(name)
  }

}
