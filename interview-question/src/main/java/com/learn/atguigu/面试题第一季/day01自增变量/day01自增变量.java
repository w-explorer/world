package com.learn.atguigu.面试题第一季.day01自增变量;

/**
 * @author wencheng
 * @create 2022/2/26 19:48
 */
public class day01自增变量 {

    /**
     * 赋值=， 最后运算
     * =右边，从左至右加载值，依次压入操作栈
     * 实际先算那个，看操作符的优先级
     * 自增、自减都是直接修改变量的值，不经过操作数栈 ;(i++ 先赋值在自增；++i先自增再赋值。)
     * 最后赋值之前，临时结果也是存储在操作栈中
     *
     * debug:
     *  可以通过查看编译后的字节指令查看详细的赋值步骤
     */
    public static void main(String[] args) {
        int i = 1;  //压入栈  i =1
        // 0 iconst_1
        // 1 istore_1


        i = i++;    //把I的值压入操作栈i=1； i变量自增+1 ；  把操作栈中的值赋给=左边
        // 2 iload_1
        // 3 iinc 1 by 1
        // 6 istore_1

        //i = 1；i 曾经=2
        int j = i++;  //把i的值压入操作栈；i变量自增+1  =2；把=左边操作栈中的值赋值给=右边j=1;  i=2
        int k = i + ++i * i++;// 加载i的值入操作栈  i=2;i变量自增+1；加载i的值为3；加载i的值为3；i自增+1 i=4;  2  +3*3=11
        System.out.println("i=" + i);//4
        System.out.println("j=" + j);//1
        System.out.println("k=" + k);//11
    }
}
