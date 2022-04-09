package com.atguigu.chapter01


/**
 * @author wencheng
 * @create 2022/1/27 17:12
 */
object Grammar {

  def main(args: Array[String]): Unit = {
//    val a: Int = 10
//    val b: Int = 10
//    val res: Int = a + b
//    println(res)
//
//
//    var name = "tom"
    var age = 18
    age = 20
//
//    val tel = 20

    var person = new Person()

    person.name ="tom"
    System.out.println(person.name)
    System.out.println("name=%s",person.name)

    testMethod()

    val s1 =
      """
         |select
         |name,
         |age
         |from user
         |where name="$person.name" and age=${age+2}
      """.stripMargin
    println(s1)
  }

  def testMethod(): Unit ={
    print("hello scala method")
  }
}
