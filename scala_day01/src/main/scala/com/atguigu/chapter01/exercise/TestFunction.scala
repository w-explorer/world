package com.atguigu.chapter01.exercise

/**
 * @author wencheng
 * @create 2022/2/23 15:15
 */
object TestFunction {

  def main(args: Array[String]): Unit = {
    //可变参数
    def str(string: String*): Unit ={
      println(string)

//      if(string isInstanceOf C){
//
//      }
    }

    str("1","2","3")
    str("1")

    // (2)如果参数列表中存在多个参数，那么可变参数一般放置在最后
    def test2( name : String, s: String* ): Unit = {
      println(name + "," + s)
    }
    test2("jinlian", "dalang","22222")


    def test3( name : String = "tom",age : Int = 18): Unit ={
      println(s"$name, $age")
    }

    test3()


    // 一般情况下，将有默认值的参数放置在参数列表的后面
    def test4( sex : String = "男", name : String ): Unit = {
      println(s"$name, $sex")
    }
    //（4）带名参数
    test4(name="ximenqing")


   def test5  = (x:String) => println(x)

    test5("李四")
  }

}
