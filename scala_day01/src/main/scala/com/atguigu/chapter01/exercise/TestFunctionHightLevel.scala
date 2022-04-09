package com.atguigu.chapter01.exercise

/**
 * @author wencheng
 * @create 2022/2/23 16:19
 */
object TestFunctionHightLevel {

  def main(args: Array[String]): Unit = {
    val v = f1(Array(1,2,3),x => x*x)
    println(v.mkString(","))


    f2(Array(1,2,3),_*_)

    println(f3(3))
  }

  def f1(arr :Array[Int],op : Int => Int) ={
    for (elem <- arr) yield op(elem)
  }


  def f2(arr : Array[Int],op : (Int,Int) => Int): Unit ={
    var count =  0
    for (elem <- arr){
        count += op(elem,elem)
    }
    println(count)
  }


  def f3(int: Int): Int ={
    if(int == 1){
      int
    } else {
      int*f3(int -1)
    }
  }



}
