package com.atguigu.chapter01.exercise

/**
 * @author wencheng
 * @create 2022/2/23 15:59
 */
object TestFunction04 {

  def main(args: Array[String]): Unit = {
    // （3）标准函数调用
    val arr = operation(Array(1, 2, 3, 4), op)
    println(arr.mkString(","))

    //匿名函数

    val arr1 = operation(Array(1,2,3,4),(ele:Int)=>{ele+1})
    println(arr1.mkString("/"))


    println(f3(1, "", '0', (age, name, char) => {
      if (age == 0 && name.equals("") && char == '0') {
        false
      } else true
    }))

  }
  // （1）定义一个函数：参数包含数据和逻辑函数
  def operation(arr: Array[Int], op: Int => Int) = {
    for (elem <- arr) yield op(elem)
  }

  // （2）定义逻辑函数
  def op(ele: Int): Int = {
    ele + 1
  }



  def f3(age :Int,name :String,char: Char,op:(Int,String,Char)=>Boolean) ={
    op(age,name,char)
  }


}
