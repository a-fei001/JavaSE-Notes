//package com.shuyuan.learn;
//
//import org.junit.*;
//
////测试类的写法也要尽量按照规范
//public class java02Test {
//    @Test
//    //方法必须是public 没有返回值，方法名必须以test开头
//    public void testPrintLengh() {
//        java02.printLength("hello world");
//        java02.printLength(null);
//    }
//
//    @Test
//    public void testPrintMaxIndex() {
//        System.out.println(java02.printMaxIndex("hello world"));
//        Integer i = java02.printMaxIndex(null);
//        System.out.println(i);
//        //断言
//        Assert.assertEquals("bug!!!",  -1, (long) i);
//    }
//
//    //注意before/after/beforeClass/afterClass的执行顺序
//    @Before
//    public void before(){
//        System.out.println("before");
//    }
//
//    @After
//    public void after(){
//        System.out.println("after");
//    }
//
//    @BeforeClass//静态方法
//    public static void beforeClass(){
//        System.out.println("beforeClass");
//    }
//
//    @AfterClass//静态方法
//    public static void afterClass(){
//        System.out.println("afterClass");
//    }
//}
