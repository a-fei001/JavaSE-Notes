package com.shuyuan.learn;

/**
 * @author A_fei
 */

import java.util.Scanner;

/**
 * 函数重载
 */
//与函数返回值无关，只与函数参数有关
//多个方法在同一个类中
/*public class java01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 15;
        int b = 15;
        System.out.println(compare(a,b));
        System.out.println(compare((byte)a,(byte)b));
        System.out.println(compare((short)a,(short)b));
        System.out.println(compare(10L,15L));
    }
    public static boolean compare(int a,int b){
        return a==b;
    }
    public static boolean compare(byte a,byte b){
        return a==b;
    }
    public static boolean compare(short a,short b){
        return a==b;
    }
    public static boolean compare(long a,long b){
        return a==b;
    }
}*/

/**
 * 引用类型和普通类型
 */
//普通类型开在栈上，
// int a =10; int b =a;这个赋给b的就是a的值，
//改动b，和a其中的值没关系

//引用类型开在堆上，比如数组这里
//int []a = {1,2,3};
//int []b = a;
//栈上存的是其在堆上的地址，因此
//赋给b的是a数组在堆上的地址，所以，
//改动b数组的值的话，a数组的值也会跟着变

/**
 * 二维数组
 */
//1.写法和普通数组差不多
//2.开动态二维数组，没赋值的地方默认为0
/*public class java01 {
    public static void main(String[] args) {
        int[][] a={{2,3,4},{4,5,6,7}};
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(a[1][3]);
        System.out.println(a[0]);*///取第一行元素的地址
        /*int[][] a = new int[10][10];
       for(int i=0;i<10;i++){
           for(int j=0;j<10;j++){
               a[i][j] = i+j;
           }
       }
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }*/
  /*  }
}*/
//行数列数
/*public class java01 {
    public static void main(String[] args) {
        int[][] a = new int[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 10; j++) {
                a[i][j] = i + j;
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(a.length);//行数
        System.out.println(a[0].length);//列数
        System.out.println(a[2].length);//列数
        //java二维数组不能忽略行数
        //C语言不能忽略列数
        int[][] a2 =new int[3][3];
        a2[0][0] = 10;
        for(int i=0;i<a2.length;i++){
            for(int j = 0;j<a2[i].length;j++){
                System.out.print(a2[i][j]+" ");
            }
        }
        int[][] a1 = new int[4][5];
        System.out.println(a1[0][0]);
    }
}*/
//特殊情况和用法
/*public class java01 {
    public static void main(String[] args) {
        //特殊创建写法1
        int[][] a = new int[2][];
        int[] a1 = new int[]{1, 2, 3, 4};
        int[] a2 = new int[]{5, 6, 7, 8, 9};
        a[0] = a1;
        a[1] = a2;
    }
}*/

