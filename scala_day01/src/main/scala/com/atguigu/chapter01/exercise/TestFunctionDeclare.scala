package com.atguigu.chapter01.exercise

/**
 * @author wencheng
 * @create 2022/2/23 15:12
 */
object TestFunctionDeclare {

  def main(args: Array[String]): Unit = {
    //无参数函数

    def test1(): Unit ={
      println("无参函数")
    }

    // 函数 5：多参，无返回值
    def test5(name:String, age:Int):Unit={
      println(s"$name,$age")
      println(name+","+age)
    }
    test5("dalang",40)
  }

}
