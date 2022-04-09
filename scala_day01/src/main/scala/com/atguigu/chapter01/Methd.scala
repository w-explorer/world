package com.atguigu.chapter01

/**
 * @author wencheng
 * @create 2022/2/10 9:24
 */
object Methd {

  def main(args: Array[String]): Unit = {
    val s1 = "abc"
    val s2 = new String("abc")
    println(s1 == s2)
    println(s1.eq(s2))
  }
}
