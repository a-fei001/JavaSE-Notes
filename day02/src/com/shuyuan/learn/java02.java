package com.shuyuan.learn;

import EXERCISE.miniProject.mini13.MyArrayList;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.parsers.SAXParser;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//这段注释算是目录吧
/**
 * 1
 * 02  就近原则&this
 * <p>
 * 03  构造方法
 * <p>
 * 04标准的javabean类
 * <p>
 * 05 成员变量 & 局部变量
 * <p>
 * 02 String概述
 * <p>
 * 03 String的构造方法和内存分析
 * <p>
 * <p>
 * 04 String的比较
 * <p>
 * 10 StringBuilder基本操作
 * 11 StringJoiner
 * <p>
 * <p>
 * 12 字符串相关类的底层原理
 * <p>
 * 01 集合的基本使用   ArrayList
 * <p>
 * 01 static静态变量
 * <p>
 * 02 静态方法和工具类
 * <p>
 * 04  05继承
 * <p>
 * 06子类能继承父类的哪些内容
 * <p>
 * 07 继承中成员变量和成员方法的访问特点
 * * * * * 方法的重写
 * <p>
 * 08 继承中构造方法访问特点
 * * * * * this，super关键字
 * <p>
 * 09 多态
 * <p>
 * 10 多态中调用成员的特点
 * <p>
 * 11 多态的优势和弊端   instanceof关键字判断类型
 * <p>
 * 12 多态练习
 * <p>
 * 13 包 和 final
 * <p>
 * 14 权限修饰符 和 代码块
 * <p>
 * 15 抽象类和抽象方法
 * <p>
 * 16 接口
 * <p>
 * 17 接口的特点：成员特点和接口的各种关系
 * <p>
 * 18 综合案例
 * <p>
 * 19 接口中新增方法，接口应用，适配器设计模式
 * <p>
 * 20 内部类
 * <p>
 * 21 成员内部类
 * <p>
 * 22 静态内部类 和 和 局部内部类
 * <p>
 * 23 匿名内部类
 * <p>
 * 1 - 11
 * 大项目--拼图游戏
 * <p>
 * 01 常用API Math
 * <p>
 * 03 API System
 * <p>
 * 04 API Runtime
 * <p>
 * 05 Object
 * <p>
 * Objects
 * <p>
 * 07 BigInteger
 * <p>
 * 08 BigDecimal
 * <p>
 * 09 正则表达式
 * <p>
 * 12 爬虫
 * <p>
 * 13 带条件爬取  (非)贪婪爬取  正则表达式在字符串方法中的使用
 * <p>
 * 14 捕获分组 非捕获分组
 * <p>
 * 15 JDK7时间 Date
 * <p>
 * 16 JDK7时间 SimpleDateFormat
 * <p>
 * 17 JDK7时间 Calendar
 * <p>
 * 18 JDK8 新增时间相关类
 * <p>
 * 20 包装类
 * <p>
 * 常见算法 06 Arrays
 * <p>
 * 07 Lambda (JDK8)
 * <p>
 * 集合进阶 01
 * 单列集合顶层接口 Collection
 * <p>
 * 02 Collection 遍历
 * <p>
 * 03 List
 * <p>
 * 06 带着读 ArrayList 源代码 需要可以看
 * <p>
 * 07 LinkedList 带着读 LinkedList 源代码 需要可以看
 * <p>
 * 08 泛型
 * <p>
 * 09 泛型的通配符
 * <p>
 * 13 Set HashSet
 * <p>
 * 13 LinkedHashSet (extends HashSet)
 * <p>
 * 14 TreeSet
 * <p>
 * 15 TreeSet 比较器排序
 * <p>
 * 02 Map接口
 * <p>
 * 03 Map 遍历
 * <p>
 * 06 HashMap
 * <p>
 * 09 LinkedHashMap
 * <p>
 * 10 TreeMap
 * <p>
 * 19 可变参数
 * <p>
 * 20 Collections
 * <p>
 * 不可变集合
 * <p>
 * 02 Stream流
 * <p>
 * 01 方法引用概述
 * <p>
 * 02 引用静态方法
 * <p>
 * 03 引用类的成员方法
 * <p>
 * 05 引用构造方法
 * <p>
 * 06 类名引用成员方法
 * <p>
 * 07 引用数组的构造方法
 * <p>
 * 01 异常
 * <p>
 * 03 异常的两个作用
 * <p>
 * 04 异常的处理方式
 * <p>
 * 08 异常中的常见方法
 * <p>
 * 10 异常的使用场景
 * <p>
 * 11自定义异常
 * <p>
 * IO12 补 finally
 * <p>
 * 01 File 概述+构造方法
 * <p>
 * 02 File的成员方法 （判断 获取）
 * <p>
 * 03 File 的成员方法 （创建 删除）
 * <p>
 * 04 File的成员方法（遍历）
 * <p>
 * 01 IO流体系
 * <p>
 * 03 字节流 FileOutputStream
 * <p>
 * 07 IO 字节流 FileInputStream输入流
 * <p>
 * 09 文件拷贝
 * <p>
 * 09 文件拷贝的弊端和解决方法
 * <p>
 * 013 字符集详解
 * (ASCII GBK Unicode)
 * <p>
 * 16 编码和解码的方法
 * <p>
 * 17 字符流 FileReader
 * <p>
 * 19 字符流 FileWriter
 * <p>
 * 22 练习
 * <p>
 * 25 高级流--缓冲流(字节)--BufferedInputStream
 * --BufferedOutputStream
 * <p>
 * 28 高级流--缓冲流字符 --BufferedReader
 * --BufferedWriter
 * <p>
 * 缓冲流 - exercise
 * <p>
 * 32 转换流(字符流中) InputStreamReader
 * OutputStreamReader
 * <p>
 * 34 序列化流(字节流中) ObjectOutputStream
 * <p>
 * 35 反序列化流 ObjectInputStream
 * <p>
 * 37 序列化流 exercise
 * <p>
 * 38 字节打印流 PrintStream(字节流中)
 * (java占位符)//day02/src/EXERCISE/miniProject/mini21
 * <p>
 * 39 字符打印流 PrintWriter
 * <p>
 * 40 解压缩流 ZipInputStream (字节流)
 * <p>
 * 41 压缩流 ZipOutputStream (字节流)
 * <p>
 * 43 常用工具包 Commons-io
 * <p>
 * 44 常用工具包 hutool
 * <p>
 * 01 多线程
 * <p>
 * 03 多线程 Thread实现方式
 * <p>
 * 04 多线程 实现Runnable接口 的实现方式
 * <p>
 * 05 多线程 实现Callable接口 的实现方式
 * (可以获取多线程运行结果)
 * <p>
 * 06 多线程常用的成员方法
 * <p>
 * 07 线程优先级
 * <p>
 * 08 守护线程
 * <p>
 * 09 出让线程/礼让线程
 * <p>
 * 10 插入线程
 * <p>
 * 11 线程的生命周期
 * <p>
 * 12 线程的安全问题 同步代码块
 * <p>
 * 15 同步方法
 * <p>
 * 16 lock锁
 * <p>
 * 18 等待唤醒机制
 * <p>
 * 21 阻塞队列实现等待唤醒机制
 * <p>
 * 22 多线程的6种状态
 * <p>
 * 23 多线程拓展
 * <p>
 * 29 线程池
 * <p>
 * 30 自定义线程池
 * <p>
 * 31 最大并行数
 * <p>
 * 32 线程池多大合适？
 * <p>
 * <p>
 * <p>
 * 01初识网络编程
 * <p>
 * 05 InetAddress类的使用
 * <p>
 * 08 UDP协议 发送数据&接收数据
 * <p>
 * 11 UDP三种通信方式(单播 组播 广播)
 * <p>
 * 12 TCP协议 发送数据&接收数据
 * <p>
 * 15 三次握手协议 四次挥手协议
 * <p>
 * 01 反射
 * <p>
 * 02 获取class对象的三种方式
 * <p>
 * 03 反射获取构造方法
 * <p>
 * 04 反射获取成员变量
 * <p>
 * 05 反射获取成员方法
 * <p>
 * 01 动态代理
 * <p>
 * 补 01: 特殊文件-Propeties属性文件(.propeties)
 * <p>
 * 补02：特殊文件-XML文件
 * <p>
 * 补3：日志技术
 * <p>
 * 补4：JUnit单元测试
 * <p>
 * 补5：注解-自定义注解-元注解
 */
/*
  ; ->单行代码补全
ctrl+alt+v ->生成前方"类型+变量名="接收数
ctrl+逗号 ->代码格式化(重新设置代码格式)
 */
/*public class java02 {
    public static void main(String[] args) {
        GF g1 = new GF();
        System.out.println(g1.age);
        System.out.println(g1.genter);
        System.out.println(g1.name);
        g1.age = 18;
        g1.genter = "武装直升机";
        g1.name = "F-700";
        System.out.println(g1.age);
        System.out.println(g1.genter);
        System.out.println(g1.name);
        g1.eat();
        g1.sleep();
        g1.bb();
    }
}*/

/**02  就近原则&this
 *
 */
/*public class java02 {
    public static void main(String[] args) {
        GF g1 = new GF();
        g1.setage(12);
        System.out.println(g1.getage());
    }
}*/

/**03  构造方法
 *
 */
/*public class java02 {
    public static void main(String[] args) {
        GF g1 = new GF(18);
        g1.print();
        GF g2 = new GF();
        g2.set(21);
        g2.print();
*//*
* 构造方法的重载
如果自定义了带参构造方法，还要使用无参数构造方法，
* 就必须再写一个无参数构造方法
*//*
    }
}*/


/**04标准的javabean类
 *
 */
/*public class java02{
    public static void main(String[] args) {
*//*
1.见名知义+驼峰命名
2.成员变量用private修饰
3.至少提供两个构造方法（无参+全参）
4.每个成员变量对应一个get 一个set方法
 *//*
    }
}*/

/**05 成员变量 & 局部变量
 *
 */
/*public class java02 {
    int a;//成员变量->初始化为0 / null
    String b;//存于堆中

    //对象创建->存在  对象消失->消失
    //在整个类中有效
    public static void main(String[] args) {
        java02 j1 = new java02();
        System.out.println(j1.a);
        System.out.println(j1.b);
        int a1;//局部变量//存于栈中
        //System.out.println(a1);//没有默认初始化
    }
}*/


/**02 String概述
 *
 */
/*
String 类代表字符串。Java 程序中的所有字符串字面值（如 "abc" ）都作为此类的实例实现。
字符串是常量；它们的值在创建之后不能更改。字符串缓冲区支持可变的字符串。因为 String 对象是不可变的，所以可以共享。例如：
     String str = "abc";
 等效于：
     char data[] = {'a', 'b', 'c'};
     String str = new String(data);
 */
/*public class java02 {
    public static void main(String[] args) {
        //Sting 定义在java.lang包中，这个包是java的和核心包，所以使用String的时候不用导包
        //字符串的内容是不会改变的，它的对象在创建后就不会改变啦
        String s1 = "111";
        s1 = "222";//这个本质是创建了一个新的字符串，将它赋值给了s1
        System.out.println(s1);
    }
}*/


/**03 String的构造方法和内存分析
 *
 */

/*public class java02 {
    public static void main(String[] args) {
        //01
        String s1 = "abc";
        System.out.println(s1);
        //02 空白字符串对象
        String s2 = new String();
        System.out.println("a" + s2 + "a");
        //03
        String s3 = new String("bbb");
        System.out.println(s3);
        //04
        char[] c1 = {'a', 'b', 'c', 'd', 'e'};
        String s4 = new String(c1);
        System.out.println(s4);
        //05
        byte[] b1 = {97, 98, 99};
        String s5 = new String(b1);
        System.out.println(s5);
        //---------------------------------------
        //内存分析：
        String v1 = "abcd";
        String v2 = "abcd";
        //当使用双引号直接赋值时，系统会检查字符串在串池（堆的一部分）中是否存在
        //v1不存在，创建新的，v2的时候已经存在了，就直接把v1的"abcd"在串池中的地址，
        //赋值给v2，不在创建新的了
        //new出来的话，都是在堆中重新创建，不是像上面这样操作，不会复用
        //相比之下，第一种更省内存
    }
}*/


/**
 *04 String的比较
 */
/*public class java02{
    public static void main(String[] args) {
        //String（引用）类型的 "==" 比较的是地址值
        String s1 = "aaa";
        String s2 = "aaa";
        if(s1==s2){//s1,s2地址相同，记录的是串池中的同一个地址
            System.out.println("s1==s2");
        }
        String s3 = new String("aaa");
        if(s1!=s3){//s1,s3地址不同，s3记录的是堆中的地址
            System.out.println("s1!=s3");
        }

        //正常比较是否相等
        //equals-->不忽略大小写
        //equalsIgnoreCase-->忽略大小写（指英文）
        String ss1 = "awsl";
        String ss2 = new String("awsl");
        if(ss1.equals(ss2)){
            System.out.println("ss1==ss2");
        }
        String ss3 = new String("AwSL");
        if(ss1.equalsIgnoreCase(ss3)){
            System.out.println("ss1==ss3  忽略大小写");
        }
        if(!ss2.equals((s3))){
            System.out.println("ss2!=ss3  不忽略大小写");
        }
        //Scanner的情况
        // （Scanner输入是new出来的 用String里面的方法equals）
        Scanner sc = new Scanner(System.in);
        String data = sc.next();
        String d = "aaa";
        System.out.println(d==data);
    }
}*/


/**
 * 10 StringBuilder基本操作
 */
/*
StringBuilder 可以看成是一个容器，创建之后里面的内容是可变的。

String对象(常量)不变,String str ="a"+"b"+...+"z";
//每次相加都产生一个String对象，效率低下，所以有了StringBuilder

构造方法：
public StringBuilder()//空参构造
public StringBuilder(String str)//有参,先加一个str,后来的加str后面

常用方法：
public StringBuilder append(任意类型) //添加数据，返回对象本身-->O(1)
public StringBuilder reverse() //反转容器中内容
public int length() //获取元素个数
public String toString() //将StringBuilder转化为String
 */
/*public class java02 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("好的");
        System.out.println(sb);//打印出的是属性值，不是地址值

        sb.append(true);
        sb.append(6);
        sb.append(1.23);
        sb.append("haha");
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);

        System.out.println("元素个数：" + sb.length());

        String s = sb.toString();
        System.out.println(s);
    }
}*/
//链式编程:方法的连续调用
/*public class java02 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        //这一步用到链式编程的思想（C++不太行）
        sb.append("aaa").append("bbb").append("ccc");
        System.out.println(sb);
    }
}*/

/** 11 StringJoiner
 *
 */
/*
JDK8出现

构造方法：
public StringJoiner(间隔符号)
public StringJoiner(间隔符号,开始符号,结束符号)

常用方法：
public StringJoiner add(添加内容)
public int length()
public String toString
 */
/*public class java02{
    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner("|","{","}");
        //add只能参加String,可以 ' + "" '强制转换
        sj.add(111+"").add(222+"").add(333+"");
        System.out.println(sj);

        System.out.println("sj元素个数: "+sj.length());

        String s = sj.toString();
        System.out.println(s);
    }
}*/

/**
 * 12 字符串相关类的底层原理
 */
/*
----字符串拼接底层原理：
无变量参与：
String s1="a"+"b"+"c";//变成.class文件时被优化为String s1 ="abc";二者底层相同

有变量参与：
//一步加法最少创建两个对象(JDK8前)
String s1="a";
String s2=s1+"b";//== new StringBuilder().append(s1).append("b").toString();
String s3=s2+"c";//.toString底层等于是new了一个String对象
//默认先预估创建一个合适大小的数组,把拼接内容放数组中，形成新的字符串(JDK8后)
String s1="a";
String s2=s1+"b;
String s3=s2+"c";
String的字符串拼接很复杂，StringBuilder只创造一个StringBuilder对象，所有数据都往里面放，因此，StringBuilder拼接效率高
 */

/**
 * 01 集合的基本使用   ArrayList
 */
/*
集合存储的数据容量可以发生改变,
只能存储引用数据类型,存基本数据类型-->包装类
泛型的使用​,用于约束集合中存储元素的数据类型

# 构造方法
public ArrayList()	//创建一个空的集合对象
# 成员方法
public boolean add(要添加的元素)	//将指定的元素追加到此集合的末尾
public boolean remove(要删除的元素)	//删除指定元素,返回值表示是否删除成功
public E remove(int index)	//删除指定索引处的元素，返回被删除的元素
public E set(int index,E element)	//修改指定索引处的元素，返回被修改的元素
public E get(int index)	//返回指定索引处的元素
public int size()	//返回集合中的元素的个数
 */
/*public class java02 {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();//后面'<>'中String可写可不写
        //打印对象不是地址值，而是里面存储的数据，展示时会用'[]'包裹
        System.out.println(al);
        System.out.println();

        System.out.println(al.add("hello"));//固定返回true
        al.add("fuck");
        al.add("all");
        al.add("of");
        al.add("you");
        System.out.println(al);
        System.out.println();

        System.out.println(al.remove("fuck"));
        System.out.println(al.remove("fff"));
        System.out.println(al);
        System.out.println();

        String s1 = al.remove(2);
        System.out.println("删除了 " + s1);
        System.out.println(al);
        System.out.println();

        String s2 = al.set(0, "fucking");
        System.out.println("替换了 " + s2);
        System.out.println(al);
        System.out.println();

        String s3 = al.get(2);
        System.out.println("此时下标2位置的数据是：" + s3);
        System.out.println("集合长度为：" + al.size());
        System.out.println("遍历此时的集合：");
        for (int i = 0; i < al.size(); i++) {
            System.out.print(al.get(i) + " ");
        }
    }
}*/

/**
 * 01 static静态变量
 */
/*
静态变量及其访问:
static用来修饰的成员变量和成员方法，被static修饰的成员是属于类的是放在静态区中，
没有static修饰的成员变量和方法则是属于对象的.
所以静态成员变量在内存区域中也只存在一份。所有的对象都可以共享这个变量。

实例变量及其访问:
无static修饰的成员变量属于每个对象的， 这个成员变量叫实例变量，之前我们写成员变量就是实例成员变量。
需要注意的是：实例成员变量属于每个对象，必须创建类的对象才可以访问
 */
/*public class java02{
    public static void main(String[] args) {
        GF.teacher = "芙莉莲";//类名调用
        GF g1 = new GF("大喷菇",16);
        GF g2 = new GF("西红柿",15);
        g1.teacher = "老东西";//对象名调用
        System.out.println(g1.toString());
        System.out.println(g2.toString());
    }
}*/

/**
 * 02 静态方法和工具类
 */
/*
javabean类：描述事物 eg: Student Person Dog...
测试类：带有main方法，程序的入口
工具类：用来做事情的类

工具类：没有成员变量，不创建对象，构造方法用private修饰，方法定义为静态

静态方法及其访问:
有static修饰成员方法，说明这个成员方法是属于类的，这个成员方法称为类方法或者静态方法
因为类只有一个，所以静态方法在内存区域中也只存在一份。所有的对象都可以共享这个方法。
静态方法只能访问静态变量和静态方法，非静态变量可访问所有。
静态方法没有this关键字

实例方法及其访问:
无static修饰的成员方法属于每个对象的，这个成员方法也叫做实例方法。
需要注意的是：实例方法是属于每个对象，必须创建类的对象才可以访问。
 */

//工具类
/*public class java02 {
    public static void main(String[] args) {
        int[] a = {10, 20, 50, 34, 100};
        System.out.println(GF.printArr(a));
        System.out.println("average: " + GF.getAverage(a));
    }
}*/

/**
 * 04  05继承
 */
/*
继承-->不仅要有语法上的继承，还要有现实意义的继承
java只支持单继承，不支持多继承，但支持多层继承(C++支持多继承，一个孩子多个爹)
每个类都直接或间接继承于object类，虚拟机自动加的

继承关系复杂，一定要画图，自下而上画
代码则是自上而下写
子类只能访问父类中的非私有成员
 */
//代码在 --> miniProject.mini01

/**
 * 06子类能继承父类的哪些内容
 */
/*
          非私有     私有
构造方法：   不能      不能
成员变量：    能        能  ***
成员方法：    能       不能
父类私有成员变量继承下来，但是main和子类成员函数都无法使用，
但确实是继承下来了，在子类对象中开辟空间了。

成员函数的继承：查找某个对象的某个方法时，不是自下而上逐层查找，
而是采用了虚方法表来优化。虚方法表（非private 非final 非 static）
object类有5个虚方法
 */
//多个类写一个文件，这样写不太规范
/*public class java02 {
    public static void main(String[] args) {
        Son s1 = new Son();
        //报错，因为构造方法继承不了
        //Son s2 = new Son("张三", 12);//alt enter 编译器帮助修改~
    }
}

class Dad {
    private String name;
    int age;

    public Dad() {
    }

    public Dad(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Son extends Dad {
*//*    public Son(String s, int i) {
        this.name = s;
        this.age = i;
    }*//*

    public Son() {
    }
}*/

/**
 * 07 继承中成员变量和成员方法的访问特点
 * * * * * 方法的重写
 */
/*
成员变量和成员方法都满足就近原则，下面演示成员变量的
成员方法就近原则应用前，往往出现了方法的重写

方法的重写：1.方法声明一样 2.前加 @Override重写注解(注解给虚拟机看)
加上注解后如果有红色波浪线，表示语法错误
建议重写方法都加上@Override注解，让代码安全优雅

方法重写的本质：覆盖了虚方法表中原来的方法

方法重写的注意事项：
1.方法声明尽可能一样
2.子类访问权限必须大于等于父类(public > protected > 空着不写)
3.子类重写父类方法时，返回值类型小于等于父类(父类 > 子类)
4.只有添加到虚方法表的方法才能被重写(!!!)
 */
/*public class java02{
    public static void main(String[] args) {
        Son s1 = new Son();
        s1.showName();
        s1.eat();
    }
}

class Dad{
    String name = "Dad";
    public void eat(){
        System.out.println("白酒，下酒菜");
    }
}

class Son extends Dad{
    String name = "Son";
    public void showName(){
        System.out.println(name);
        String name = "666";
        System.out.println(name);//就近原则
        System.out.println(this.name);
        System.out.println(super.name);
    }
    @Override
    public void eat(){//方法重写
        System.out.println("干饭积极，吃得多");
    }
}*/

/**
 * 08 继承中构造方法访问特点
 * * * * * this，super关键字
 */

/*
基础知识：
父类中的构造方法不会被子类继承
子类中的所有构造方法默认先访问父类的无参构造，再执行自己(C++也这样)
这是为了保证使用子类前，父类数据已经初始化。

子类如何调用父类构造方法：
子类构造方法第一行默认是super()，不写也存在，且必须是第一行*/
/*public class java02 {
    public static void main(String[] args) {
        Son s1 = new Son();
        Son s2 = new Son("好大儿", 15);
    }
}

class Per {
    String name;
    int age;

    public Per() {
        System.out.println("父类无参构造");
    }

    public Per(String name, int age) {
        System.out.println("父类带参构造");
        this.name = name;
        this.age = age;
    }
}

class Son extends Per {
    public Son() {
        super();//调用父亲的无参构造
        System.out.println("子类无参构造");
    }

    public Son(String name, int age) {
        super(name, age);//调用父亲的带参构造
        System.out.println("子类带参构造");
    }
}*/

/*
this: 理解为一个局部变量，表示当前方法调用者的地址值
super: 代表父类存储空间
 */
//this, super 不太熟悉的操作
/*public class java02 {
    public static void main(String[] args) {
        Stu s1 = new Stu();
    }
}

class Stu {
    String name;
    int age;
    String school;

    public Stu() {
        //表示调用本类其他构造方法
        //虚拟机就不会添加super()了，因为this调用的构造函数里面有super()了
        this("憨憨", 18, "家里蹲");
    }

    public Stu(String name, int age, String school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }
}*/
//miniProject.mini02 相关练习

/**
 * 09 多态
 */
/*
发生前提：
1.有继承关系
2.父类引用指向子类对象
3.有方法重写
*/
//miniProject.mini03 相关代码

/**
 * 10 多态中调用成员的特点
 */
/*
变量调用：编译看左边，运行也看左边
方法调用：编译看左边，运行看右边
 */

/*public class java02 {
    public static void main(String[] args) {
        Animal d1 = new Dog();
        //编译看左边：Javac编译代码时，会看左边父类中有没有这个变量
        //如果有，编译成功，如果没有，编译失败
        //运行也看左边：java运行代码时，实际获取的是左边父类中成员变量的值
        System.out.println(d1.name);
        //编译看左边：Javac编译代码时，会看左边父类中有没有这个方法
        //如果有，编译成功，如果没有，编译失败
        //运行看右边，jav a运行代码时，实际上运行的是子类中的方法
        d1.show();
    }
}
class Animal {
    String name = "动物";

    public void show() {
        System.out.println("Animal----show方法");
    }
}

class Dog extends Animal {
    String name = "狗";

    public void show() {
        System.out.println("Dog----show方法");
    }
}

class Cat extends Animal {
    String name = "猫";

    public void show() {
        System.out.println("Cat----show方法");
    }
}*/

/**
 * 11 多态的优势和弊端   instanceof关键字判断类型
 */
//instanceof的作用是测试它左边的对象是否是它右边的类的实例，返回 boolean 的数据类型
//应该不能用来判断基本数据类型
/*public class java02{
    public static void main(String[] args) {
        Animal d1 = new Dog();
        d1.eat();
        //弊端：不能调用子类特有的功能，因为父类没这个方法
        //d1.work();//报错
        Dog d2 = (Dog) d1;//解决方法，强制类型转换
        d2.work();
        //Cat c1 = (Cat) d1;//报错，不能乱传

        //防止类型乱转的操作：
        if(d1 instanceof Dog){//判断d1的类型是否为Dog
            Dog d3 = (Dog) d1;//解决方法，强制类型转换
            d2.work();
        }else if(d1 instanceof Cat){
            Cat c2 = (Cat) d1;
            c2.work();
        }else{
            System.out.println("没有这类型，无法转换");
        }

        //新特性：(新写法 JDK14)
*//*        if(d1 instanceof Dog d){
            d.work();
        }else if(d1 instanceof Cat c){
            c.work();
        }else{
            System.out.println("没有这类型，无法转换");
        }*/
/*
    }
}

class Animal{
    public void eat(){
        System.out.println("干饭干饭");
    }
}

class Dog extends Animal{
    @Override
    public void eat(){
        System.out.println("狗啃骨头");
    }
    public void work(){
        System.out.println("狗看家");
    }
}

class Cat extends Animal{
    @Override
    public void eat(){
        System.out.println("猫吃老鼠");
    }
    public void work(){
        System.out.println("猫抓老鼠");
    }
}*/

/**
 * 12 多态练习
 */
//miniProject.mini04 相关代码


/**
 * 13 包 和 final
 */
/*
​ 包在操作系统中其实就是一个文件夹。包是用来分门别类的管理技术，
不同的技术类放在不同的包下，方便管理和维护。

包名的命名规范：
包名一般是公司域名的倒写。例如：黑马是www.itheima.com,包名就可以定义成com.itheima.技术名称。
包名必须用”.“连接。
包名的每个路径名必须是一个合法的标识符，而且不能是Java的关键字。

包名+类名 --> 全类名/全限定名
创建对象全类名写法：
com.shuyuan.learn.GF g1 = new com.shuyuan.learn.GF();
写法过于复杂，因此有了import导包 ：import + 全类名
import com.shuyuan.learn.GF
GF g1 = new GF();

使用同一包中的类，不用导包
使用java.lang包中的类时，不用导包
如果两个包中类名相同，就需要用全类名
 */
/*public class java02 {
    public static void main(String[] args) {
        Stu s1 = new Stu("王五", 15);
        s1.show();
        EXERCISE.miniProject.mini04.Person p1 =
                new EXERCISE.miniProject.mini04.Person("李思思", 20);
        System.out.println("姓名：" + p1.getName() + "\t年龄：" + p1.getAge());
    }
}

//或者程序上面加上import EXERCISE.miniProject.mini04.Person
class Stu extends EXERCISE.miniProject.mini04.Person {
    public Stu() {
    }

    public Stu(String name, int age) {
        super(name, age);
    }

    void show() {
        System.out.println("姓名：" + this.getName() + "\t年龄" + this.getAge());
    }
}*/

/*
final 关键字，表示修饰的内容不可变:
类：被修饰的类，不能被继承。
方法：被修饰的方法，不能被重写。
变量：被修饰的变量，有且仅能被赋值一次。

final修饰的变量是基本数据类型：变量存储数据值不能发生改变
final修饰的变量是引用数据类型：变量存储的地址值不变，对象内部可变

常量命名：
单个单词：全部大写
多个单词：全部大写，单词用下划线隔开
 */
/*public class java02 {
    public static void main(String[] args) {
        final int a = 10;//变成常量了
        System.out.println(a);
        //a = 10;//报错，final修饰后不能改变

        final int[] arr = {1, 2, 3};//引用数据类型
        //arr=new int[10];//报错，地址不能改变
        arr[0] = 10;
        System.out.println(arr[0]);//可以改变，输出10

        //引用数据类型
        final Dad d1 = new Dad("张三", 5);
        //d1=new Dad("灰太狼",25);//报错，地址不能改变
        d1.setName("灰太狼");
        d1.setAge(25);
        System.out.println(d1.getName() + "\t" + d1.getAge());
    }
}

//下方extends Dad报错，被修饰的方法不能被继承，
//这样里面所有的方法都无法被重写
//final class Dad{
class Dad {
    private String name;
    private int age;

    //用final修饰，子类@...报错，表示不能重写
    //public void final show(){}
    public void show() {
        System.out.println("父类的show方法");
    }

    public Dad(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Dad() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Son extends Dad {
    @Override
    public void show() {
        System.out.println("子类的show方法");
    }
}*/

/**
 * 14 权限修饰符 和 代码块
 */
/*
权限修饰符：
            同一个类中    同包不同类    不同包下的子类    不同包下的无关类
private         *
空着不写         *           *
protected       *           *             *
public          *           *             *                *

代码块：
局部代码块：
方法的大括号里面(在该区域执行完直接回收，是一种节约内存的思想)

构造代码块：
1.写在成员位置的代码块
2.作用：可以把多个构造方法中重复的代码提取出来
3.执行时机：我们在创建本类对象的时候会执行代码块在执行构造方法

静态代码块：   static{}
随类的加载而加载，自动触发，只执行一次
可用于程序执行之初 初始化数据
 */
/*public class java02 {
    public static void main(String[] args) {
        Stu s1 = new Stu();
        Stu s2 = new Stu("老赞", 99);
    }
}

class Stu {
    private String name;
    private int age;

    static {
        System.out.println("静态代码块执行力~");
    }

    {//构造代码块
        System.out.println("开始创建Stu对象了~");
    }//每个构造方法必定执行，不够灵活，用this()调用自己的构造，或者调用方法比较灵活

    public Stu() {
    }

    public Stu(String name, int age) {
        this.name = name;
        this.age = age;
    }
}*/

/**
 * 15 抽象类和抽象方法
 */
/*
抽象类：如果一个类中存在抽象方法，该类就必须被声明为抽象类

抽象类和抽象方法的注意事项：
1.抽象类不能实例化
2.抽象类不一定有抽象方法，有抽象方法的类一定是抽象类
3.可以有构造方法
4.抽象子类要么重写抽象父类中所有的抽象方法，要么还是抽象类
 */
/*public class java02{
    public static void main(String[] args) {

    }
}
abstract class Per{
    public abstract void work();
}*/


/**
 * 16 接口
 */
/*
1.接口就是一种规则
public interface 接口名{}//class -> interface
2.接口用关键字interface来定义
3.接口不能实例化
4.接口和类之间是实现关系，通过implements关键字表示
public class 类名 implements 接口名{}
5.接口的子类(实现类) 要么重写接口中所有的抽象方法，要么是抽象类

注：接口和类的实现关系，可以单实现，也可以多实现
   public class 类名 implements 接口名1,接口名2{}
实现类还可以在继承一个类的同时同时实现多个接口。
   public class 类名 extends 父类 implements 接口名1,接口名2{}
 */
//EXERCISE.miniProject.mini05

/**
 * 17 接口的特点：成员特点和接口的各种关系
 */
/*
成员变量：只能是常量
         默认修饰符：public static final
构造方法：没有
成员方法：只能是抽象方法（JDK7之前）
         默认修饰符：public abstract
*/

/*public class java02 {
    public static void main(String[] args) {
        System.out.println(Inter.a);//基本说明public static修饰
        //Inter.a = 20;//报错，说明final修饰
        Base b1 = new Base();
        b1.method();
    }
}

class Base implements Inter {
    @Override
    public void method() {
        System.out.println("method method~");
    }
}

interface Inter {
    int a = 10;
    void method();
}*/

/*
类和类的关系：继承关系，只能单继承，不能多继承，可以多层继承
类和接口的关系：类与接口之间的关系可以单实现，也可是多实现的，一个类可以同时实现多个接口。
（多个接口有重名的抽象方法，类中重写一个就行）
接口和接口的关系：继承关系，可以单继承，也可以多继承
（如果实现类实现了最下面的子接口，那么就需要重写所有的抽象方法）
 */
//EXERCISE.miniProject.mini06


/**
 * 18 综合案例
 */
//EXERCISE.miniProject.mini07

/**
 * 19 接口中新增方法，接口应用，适配器设计模式
 */

/*
JDK7前：接口只能定义抽象方法
JDK8新特性：接口可以定义有方法体的方法(默认，静态)
JDK9新特性：接口可以定义私有方法

JDK8 默认方法 -> 用于解决接口升级的问题
默认方法定义格式：
public default 返回值 方法名(参数列表){}
public default void show(){}
注意：1.默认方法不是抽象方法，不强制被重写，如果被重写，重写时去掉default关键字
2.public可以省略，default不能省略
3.如果实现了多个接口，多个接口存在相同名字的默认方法，子类必须对该方法重写

JDK8 静态方法
默认格式：
public static void show(){}
注意事项：
1.静态方法只能通过接口名调用，不能通过实现类名或者对象名调用
2.public可省略，static不能省
3.不支持重写,重写相当于类中的自己普通的静态成员函数,与接口的静态方法无关

JDK9 私有方法
语法格式：
默认：private void show(){}
静态：private static void method(){}
 */
/*
接口的应用：
1.接口表示规则，是行为的抽象，想让那个类实现那个行为，就让该类实现对应的接口就行了
2.当一个方法的参数是接口时，可以传递接口所有实现类的对象，这种方式称之为接口多态
 */
//EXERCISE.miniProject.mini08
/*
适配器设计模式：解决接口与接口之间的矛盾问题
 */
//EXERCISE.miniProject.mini09

/**
 * 20 内部类
 */
/*
类的5大成员：属性 方法 构造方法 代码块 内部类
class Out{//外部类
  String name;
  int age;
  class Int{//内部类
    double score;
    String grade;
  }
}
内部类表示的事物是外部类的一部分
内部类单独出现没有任何意义
**内部类可以直接访问外部类的成员，包括私有
**外部类访问内部类的成员，需要创建对象
 */

/**
 *21 成员内部类
 */
/*
内部类的分类:
按定义的位置来分
成员内部类，类定义在了成员位置 (类中方法外称为成员位置，无static修饰的内部类)
静态内部类，类定义在了成员位置 (类中方法外称为成员位置，有static修饰的内部类)
局部内部类，类定义在方法内
匿名内部类，没有名字的内部类，可以在方法中，也可以在类中方法外。
 */
/*
内部类：
1.写在成员位置，属于外部类的成员
2.可以被一些修饰符所修饰 private 默认 protected public static
3.在成员内部类中,JDK16之前不能定义静态变量，16之后才行

获取成员内部类对象：
1.外部直接创建成员内部类的对象
外部类.内部类 变量 = new 外部类（）.new 内部类（）;
2.在外部类中定义一个方法提供内部类的对象
 */
//EXERCISE.miniProject.mini10

/**
 *22 静态内部类 和 和 局部内部类
 */
/*
静态内部类：
内部类有static修饰
静态内部类也是内部类的一种
静态内部类只能访问外部类的静态变量和静态方法，如果想要访问需要创建外部类的对象

Outer.Inner oi = new Outer.Inner();
调用静态内部类中 非静态方法的格式：先创建对象，再调用
调用静态内部类中 静态方法的格式：Outer.Inner.show();
 */
/*
局部内部类：
1.将内部类定义在方法里面就是局部内部类，类似方法里面的局部变量
(不能用public之类的修饰，啥能修饰方法中的局部变量，啥能修饰他)
2.外界无法直接使用，需要在方法内部创建对象并使用
3.该类可以直接访问外部类的成员，也可以访问方法内的局部变量
 */
//EXERCISE.miniProject.mini10

/**
 * 23 匿名内部类
 */
/*
匿名内部类：隐含了名字的内部类 --> 等于是创建子类对象的简便写法
（因此可以广泛应用于多态之类的操作）
格式:
new 类名或者接口名() {
     重写(所有抽象)方法;
};
这个整体其实不是类，而是new出来的对象
 */
/*interface Swim {
    public abstract void swim();
}

public class java02 {
    public static void main(String[] args) {

        new Swim() {
            @Override
            public void swim() {
                System.out.println("在正常游泳");
            }
        }.swim();

        //用途: 这样搞，show里面相当于Animal的子类对象，多态的话
        //省的再创建一个子类了
        method(
                new Animal() {
                    @Override
                    public void show(Animal a) {
                        System.out.println("重写一下");
                    }
                }
        );

        //接口多态（和正常多态差不多）
        Swim s = new Swim() {
            @Override
            public void swim() {
                System.out.println("善哉");
            }
        };
        s.swim();

    }

    public static void method(Animal a) {
        a.show(a);
    }
}

abstract class Animal {
    int a = 10;//在匿名内部类中可以访问

    public abstract void show(Animal a);
}*/

/**
 * 1 - 11
 * 大项目--拼图游戏
 */
/*
GUI (Graphical User Interface)
图形用户接口：图形化方式显示操作界面
两个体系(位置分别在)：AWT包(早期) Swing包(常用)

事件：
1.事件源：按钮 图片 窗体
2.事件：默写操作 eg:鼠标单击 鼠标划入
3.绑定监听：当事件源上发生了某个事件，就执行某代码
KeyListener MouseListener ActionListener
键盘监听        鼠标监听      动作监听:鼠标左键点击和空格
鼠标监听细分为 划入 按下不松 松开 划出 4个动作
其中按下和松开可合并视为单击动作
所以单击事件，可以有：动作监听 鼠标监听中的单击事件 鼠标监听中的松开事件
3种表示方式

选择内容 ctrl+B 查看源码
        ctrl+n 输入内容 查看源码
        ctrl+f12 看类的成员
        ctrl+alt+m:在类中选中一部分代码，按此快捷键，生成相关成员方法

文件路径：
1.绝对路径，从盘符开始，eg:D:\sure_\编译工具和项目\项目文件\java_intellij idea
2.相对路径：相对当前项目而言的路径 eg:Project_01_PuzzleGame\image\background.png
 */
//模块--Project_01_PuzzleGame
//(eventTest-MyJFrame01~03分别使用了动作，鼠标，键盘监听)

/**
 * 01 常用API Math
 */
/*
知道有Math 知道里面的方法什么的有什么用，到时候知道在Math里面找就行
不用详细记住用法，要习惯查API帮助文档

Math在lang包下，final修饰，所有方法都是静态的

常见方法：
public static int abs(int a)					// 返回参数的绝对值
public static double ceil(double a)				// 返回大于或等于参数的最小整数
public static double floor(double a)			// 返回小于或等于参数的最大整数
public static int round(float a)				// 按照四舍五入返回最接近参数的int类型的值
public static int max(int a,int b)				// 获取两个int值中的较大值
public static int min(int a,int b)				// 获取两个int值中的较小值
public static double pow (double a,double b)	// 计算a的b次幂的值
public static double random()					// 返回一个[0.0,1.0)的随机值

abs方法，可以获取参数绝对值，细节:
eg:int类型  -2147483648~2147483647
在这个范围内，最小的数没有正数与之对应，结果会有误
absExact方法如果没有对应，会返回错误，但是JDK8没有 JDK15有

round 12.45 -> 12
 */

/**
 * 03 API System
 */
/*
// 获取当前时间所对应的毫秒值（当前时间为0时区所对应的时间即就是英国格林尼治天文台旧址所在位置）
计算机中的时间原点 1970/1/1/00:00  (北京时间08:00)
加在程序首尾，计算程序运行总时间
public static long currentTimeMillis()

// 终止当前正在运行的Java虚拟机，0表示正常退出，非零表示异常退出
public static void exit(int status)

// 进行数值元素copy//注意别超范围
//如果两者都是基本数据类型，则两者数据类型必须保持一致
//如果两者都是引用类型，子类可以拷贝给父类
public static native void arraycopy(Object src,  int  srcPos, Object dest, int destPos, int length);
System.arraycopy(arr1, 0, arr2, 0, 10);//从数组arr1下标0位置开始，拷贝到数组arr2中
//从数组arr2下标0位置开始，拷贝10个元素
 */
/*//运行结果：0 0 7 8 9 0 0 0 0 0
public class java02 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = new int[10];
        System.arraycopy(arr1, 6, arr2, 2, 3);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}*/

/**
 04 API Runtime
 */
/*
Runtime构造函数是私有的，不能new Runtime对象，
只能通过getRuntime获取，这样获取的Runtime为一个对象
Runtime表示虚拟机运行环境，一个电脑，只能有一个运行环境，因此一个对象

    public static Runtime getRuntime() 当前系统的运行环境对象
    public void exit(int status) 停止虚拟机
    public int availableProcessors() 获得CPU的线程数
    public long maxMemory() JVM能从系统中获取总内存大小(单位byte)
    public long totalMemory() JVM已经从系统中获取总内存大小(单位byte)
    public long freeMemory() JVM剩余内存大小(单位byte)
    public Process exec(string command) 运行cmd命令//关机之类的操作
 */
/*public class java02 {
    public static void main(String[] args) throws IOException {
        Runtime r1 = Runtime.getRuntime();
        Runtime r2 = Runtime.getRuntime();
        if (r1 == r2) {
            System.out.println("一个对象");
        }

        //Runtime.getRuntime().exit(0);
        System.out.println(111);

        System.out.println("线程数：" + Runtime.getRuntime().availableProcessors());
        System.out.println("能获取总内存: " + Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");
        System.out.println("已经获取的内存: " + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
        System.out.println("剩余内存: " + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M");

        //打开记事本
        Runtime.getRuntime().exec("notepad");
    }
}*/
//恶搞关机代码(含有图形化界面)//EXERCISE.miniProject.mini12

/**
 * 05 Object
 */
/*
构造方法是无参构造

//System.out.println(s1);//Student s1 = new Student();
//这里println底层调用了s1的toString方法 打印的是s1.toString();
//所以 可以看出 写Student类时 重写toString方法的意义

public String toString()				//返回该对象的字符串表示形式(可以看做是对象的内存地址值)
public boolean equals(Object obj)		//比较两个对象地址值是否相等；true表示相同，false表示不相同
protected Object clone()    			//对象克隆
//重写clone方法  javabean类实现cloneable接口  创建原对象调用clone
浅克隆：基本数据类型值拷贝，数组 引用数据类型地址拷贝，String拷贝串池里面地址
深克隆：基本数据类型值拷贝，数组 引用数据类型创建新的，String复用//自己写
//开发中用深克隆，会使用第三方写的工具//导入的lib包中的gson文件
 */

/*import EXERCISE.exerciseH;
import com.google.gson.Gson;

public class java02 extends exerciseH {
    public static void main(String[] args) throws CloneNotSupportedException {
        Object obj = new Object();
        String str1 = obj.toString();
        System.out.println(str1);//java.lang.Object@4554617c
        System.out.println(obj);//一样（println底层用了toString方法）
        //返回的地址值对我来说意义不大，想得到对象内部属性值
        //解决方案：重写父类toString方法
        System.out.println(new Object() {
            private String name = "张三";
            private int age = 15;

            @Override
            public String toString() {
                return name + age;
            }
        }.toString());

        String s1 = new String();
        System.out.println(s1.equals(s1));//String包下equals，你懂的
        Stu st1 = new Stu();
        Stu st2 = new Stu();
        //正常是Object包下equals，比较地址，但是这里重写了，比较内部属性
        System.out.println(st1.equals(st2));

        //配合exerciseH里面的类，验证protected修饰符
        //修饰成员对象可被调用的范围
        new java02().show();//可以
        //new exerciseH().show();//不行

        char[] data = {'a', 'b', 'c', 'd', 'e'};
        Stu s2 = new Stu(18, data, "王老吉");
        //s2.clone();//没重写的话，这里不能用，在Stu类内部可以用
        Stu s3 = (Stu) s2.clone();//返回的是Object类型
        s2.data[0] = '9';//s3中的值随之改变，证明Object的clone是浅克隆
        s3.show();

        //调用第三方工具进行深拷贝(lib包中)
        Gson gson = new Gson();
        String s = gson.toJson(s2);
        s2.data[1] = '7';//证明深克隆
        System.out.println(s);
        Stu s4 = gson.fromJson(s, Stu.class);
        s4.show();
    }
}

//Cloneable接口没有抽象方法，称为标记性接口，表示该类可以被克隆
class Stu implements Cloneable {
    int age;
    char[] data;
    String name;

    public Stu() {
    }

    public Stu(int age, char[] data, String name) {
        this.age = age;
        this.data = data;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stu stu = (Stu) o;
        return age == stu.age &&
                Objects.equals(name, stu.name);
    }

    public void show() {
        System.out.print("age= " + age);
        System.out.print("\tname= " + name);
        System.out.print("\tdata= ");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}*/


/**
 *  Objects
 */
/*
public static String toString(Object o) 			// 获取对象的字符串表现形式
public static boolean equals(Object a, Object b)	// 比较两个对象是否相等
public static boolean isNull(Object obj)			// 判断对象是否为null
public static boolean nonNull(Object obj)			// 判断对象是否不为null
 */
/*public class java02 {
    public static void main(String[] args) {
        Stu s1 = null;
        Stu s2 = new Stu(18, "Jack");
        System.out.println(Objects.equals(s1, s2));//自动会判空！
        if (Objects.isNull(s1)) {
            System.out.println("s1为空");
        }
        if (!Objects.nonNull(s1)) {
            System.out.println("s1为空");
        }
        String s= Objects.toString(s2);
        System.out.println(s);//和Object里面的toString差不多
    }
}

class Stu {
    int age;
    String name;

    public Stu() {
    }

    public Stu(int age, String name) {
        this.age = age;
        this.name = name;
    }
}*/


/*public class java02{
    public static void main(String[] args) {
        Objects
    }
}*/

/**
 *  07 BigInteger
 */
/*
构造方法：
public BigInteger(int num, Random rnd) 		//获取随机大整数，范围：[0 ~ 2的num次方-1]
public BigInteger(String val) 				//获取指定的大整数
public BigInteger(String val, int radix) 	//获取指定进制的大整数

下面这个不是构造，而是一个静态方法获取BigInteger对象
public static BigInteger valueOf(long val) 	//静态方法获取BigInteger的对象，内部有优化

**构造方法小结：**
* 如果BigInteger表示的数字没有超出long的范围，可以用静态方法获取。
* 如果BigInteger表示的超出long的范围，可以用构造方法获取。
* 对象一旦创建，BigInteger内部记录的值不能发生改变。
* 只要进行计算都会产生一个新的BigInteger对象

常见成员方法：
public BigInteger add(BigInteger val)			//加法
public BigInteger subtract(BigInteger val)		//减法
public BigInteger multiply(BigInteger val)		//乘法
public BigInteger divide(BigInteger val)		//除法
public BigInteger[] divideAndRemainder(BigInteger val)	 //除法，获取商和余数
public  boolean equals(Object x) 			    //比较是否相同
public  BigInteger pow(int exponent) 			//次幂、次方
public  BigInteger max/min(BigInteger val) 		//返回较大值/较小值//不创建新的，返回较大/小的BIgInteger对象
public  int intValue(BigInteger val) 			//转为int类型整数，超出范围数据有误
 */

/*public class java02 {
    public static void main(String[] args) {
       test01();
       test02();
    }

    private static void test01(){
        BigInteger b1 = new BigInteger(3, new Random());//0-7
        System.out.println(b1);

        BigInteger b2 = new BigInteger("999999999999999999999999999999999999999999999");
        System.out.println(b2);

        BigInteger b3 = new BigInteger("100", 2);
        System.out.println(b3);//输出十进制

        //表示范围小 long的范围
        //-16 - 16进行了优化，先创建好了BigInteger的对象，多次获取不会重新创建
        BigInteger b4 = BigInteger.valueOf(16);
        BigInteger b5 = BigInteger.valueOf(16);
        System.out.println(b4);
        System.out.println(b4 == b5);
        System.out.println("-------------------------------------------");
    }

    private static void test02(){
        BigInteger b1 = BigInteger.valueOf(3);
        BigInteger b2 = new BigInteger("100");
        System.out.println(b2.intValue());
    }
}*/


/**
 * 08 BigDecimal
 */
/*
BigDecimal(String val)    //将 BigDecimal 的字符串表示形式转换为 BigDecimal。
//这个构造方法不存在不可预知性，更准确，还有好多构造方法自己翻api帮助文档
BigDecimal.valueOf(10.1)  //不超过double取值范围

public BigDecimal add(BigDecimal value)				    // 加法运算
public BigDecimal subtract(BigDecimal value)		    // 减法运算
public BigDecimal multiply(BigDecimal value)		    // 乘法运算
public BigDecimal divide(BigDecimal value)//除不尽报错	// 除法运算

public BigDecimal divide(BigDecimal val,精确几位,舍入模式)
bd1.divide(bd2,5, RoundingMode.HALF_UP);//保留5位 四舍五入(舍入模式在RoundingMode类里面找)
对象同样不可变
 */

/**
 * 09 正则表达式
 */
/*
笔记图片：java2\day02\image\api-09.jpg
         java2\day02\image\api-11.jpg
         java2\day02\image\api-11().jpg
详细请看api Pattern类

下载了 any-rule插件，帮助写正则表达式（右键鼠标可查看）
 */
//特殊情况：
/*public class java02{
    public static void main(String[] args) {
        //问"&"是不是在[a-z]或'&'符号或[def]
        System.out.println("&".matches("[a-z&[def]]"));//true

        //需要两个字符
        System.out.println("a".matches(".."));//false

        System.out.println("abcde232".matches("\\w*"));

        //最后一位可以是数字或X或x
        String regex2 = "\\d{17}(\\d|X|x)";//[\\dXx]也行
        System.out.println("12345678912345678x".matches(regex2));

        //忽略大小写
        //(?i)abc//忽略abc的大小写
    }
}*/

/**
 * 12 爬虫
 */
/*
Pattern:表示正则表达式
Matcher: 文本匹配器，作用按照正则表达式的规则去读取字符串，从头开始读取。
         在大串中去找符合匹配规则的子串。
 */
//爬取本地数据（爬取网络数据见黑马笔记(就是一个小练习)）
/*public class java02 {
    public static void main(String[] args) {
        String str = "Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和Java11，" +
                "因为这两个是长期支持版本，下一个长期支持版本是Java17，相信在未来不久Java17也会逐渐登上历史舞台";
        Pattern p1 = Pattern.compile("Java\\d{0,2}");

        //m1要在str中找符合p规则的小串
        Matcher m1 = p1.matcher(str);

        //拿着文本匹配器从头开始读取，寻找是否有满足规则的子串
        //如果没有，方法返回false
        //如果有，返回true。在底层记录子串的起始索引和结束索引+1
        // 0,4
        System.out.println(m1.find());

        //方法底层会根据find方法记录的索引进行字符串的截取
        // substring(起始索引，结束索引);包头不包尾
        // (0,4)但是不包含4索引
        // 会把截取的小串进行返回。
        String s1 = m1.group();
        System.out.println(s1);


        //第二次在调用find的时候，会继续读取后面的内容
        //读取到第二个满足要求的子串，方法会继续返回true
        //并把第二个子串的起始索引和结束索引+1，进行记录
        System.out.println(m1.find());

        //第二次调用group方法的时候，会根据find方法记录的索引再次截取子串
        String s2 = m1.group();
        System.out.println(s2);

        while(m1.find()){
            System.out.println(m1.group());
        }
    }
}*/

//练习：
/*
public class java02 {
    public static void main(String[] args) throws IOException {
        String str = "来黑马程序员学习Java，\n" +
                "            手机号:18512516758，18512508907或者联系邮箱:boniu@itcast.cn，\n" +
                "            座机电话:01036517895，010-98951256邮箱:bozai@itcast.cn，\n" +
                "            热线电话:400-618-9090 ，400-618-4000，4006184000，4006189090";

        Pattern p1 = Pattern.compile("(1[3-9]\\d{9})|(\\w+@[\\w&&[^_]]{2,6}(\\.[a-zA-Z]{2,3}){1,2})|" +
                "(0\\d{2,3}-?[1-9]\\d{4,9})|(400-?[1-9]\\d{2}-?[1-9]\\d{3})");
        Matcher m1 = p1.matcher(str);

        while(m1.find()){
            System.out.println(m1.group());
        }

    }
}
*/


/**
 * 13 带条件爬取  (非)贪婪爬取  正则表达式在字符串方法中的使用
 */
//带条件爬取
/*public class java02 {
    public static void main(String[] args) {
        //需求1:爬取版本号为8，11.17的Java文本，但是只要Java，不显示版本号。
        //需求2:爬取版本号为8，11，17的Java文本。正确爬取结果为:Java8 Java11 Java17 Java17
        //需求3:爬取除了版本号为8，11.17的Java文本
        String s = "Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是JaVa8和JaVA11，" +
                "因为这两个是长期支持版本，下一个长期支持版本是JavA17，相信在未来不久JAva17也会逐渐登上历史舞台";

        //1.定义正则表达式
        //?理解为前面的数据Java
        //=表示在Java后面要跟随的数据
        //但是在获取的时候，只获取前半部分
        //(?i)忽略大小写
        //需求1
        String regex1 = "(?i)Java(?=8|11|17)";

        //需求2
        String regex2 = "(?i)Java(8|11|17)";
        String regex3 = "(?i)Java(?:8|11|17)";

        //需求3
        String regex4 = "(?i)Java(?!8|11|17)";


        Pattern p = Pattern.compile(regex4);
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}*/

//贪婪爬取和非贪婪爬取
/*public class java02{
    public static void main(String[] args) {
        String str = "从95年问世以来，经aaaaaaabbbbbbbaaaa历了很" +
                "多版本，目前企业中用的最多的是JaVa";
        //贪婪爬取
        Pattern p = Pattern.compile("ab+");
        //非贪婪爬取
        Pattern pp = Pattern.compile("ab+?");
        Matcher m = pp.matcher(str);
        while(m.find()){
            System.out.println(m.group());
        }
    }
}*/

//正则表达式在字符串方法中的使用
/*
public String replaceAll(String regex,String newStr)
//参数regex表示一个正则表达式。可以将当前字符串中匹配regex正则表达式的字符串替换为newStr。
public String[] split(String regex)
//参数regex表示正则表达式。可以将当前字符串中匹配regex正则表达式的符号作为"分隔符"来切割字符串。
 */

/*public class java02 {
    public static void main(String[] args) {
        String str = "小诗诗dqwefqwfqwfwq12312小丹丹dqwefqwfqwfwq12312小惠惠";

        String regex1 = "[\\w&&[^_]]+";
        System.out.println(str.replaceAll(regex1, "vs"));

        String[] ss = str.split(regex1);
        for (int i = 0; i < ss.length; i++) {
            System.out.println(ss[i]);
        }
    }
}*/

/**
 * 14 捕获分组 非捕获分组
 */
//图片笔记：java2\day02\image\api-14.jpg
//捕获分组
/*
分组规则：只看左括号，不看右括号，按照左括号的顺序，
        从左往右，依次为第一组，第二组，第三组
捕获分组就是把一组的数据捕获出来，再用一次
 */
/*public class java02{
    public static void main(String[] args) {
        //需求1:判断一个字符串的开始字符和结束字符是否一致?只考虑一个字符
        //举例: a123a b456b 17891 &abc& a123b(false)
        // \\组号:表示把第X组的内容再出来用一次
        String regex1  = "(.).+\\1";//用了\\1一定要出现'('
        System.out.println("a123a".matches(regex1));
        System.out.println("b456b".matches(regex1));
        System.out.println("17891".matches(regex1));
        System.out.println("&abc&".matches(regex1));
        System.out.println("a123b".matches(regex1));
        System.out.println("-----------------------------------");

        //需求2:判断一个字符串的开始部分和结束部分是否一致?可以有多个字符
        //举例: abc123abc b456b 123789123 &!@abc&!@ abc123abd(false)
        String regex2 = "(.+).+\\1";
        System.out.println("abc123abc".matches(regex2));
        System.out.println("b456b".matches(regex2));
        System.out.println("123789123".matches(regex2));
        System.out.println("&!@abc&!@".matches(regex2));
        System.out.println("abc123abd".matches(regex2));
        System.out.println("-----------------------------------");


        //需求3:判断一个字符串的开始部分和结束部分是否一致?开始部分内部每个字符也需要一致
        //举例: aaa123aaa bbb456bbb 111789111 &&abc&&
        //(.):把首字母看做一组
        // \\2:把首字母拿出来再次使用
        // *:作用于\\2,表示后面重复的内容出现0次或多次
        String regex3 = "((.)\\2*).+\\1";
        System.out.println("aaa123aaa".matches(regex3));
        System.out.println("bbb456bbb".matches(regex3));
        System.out.println("111789111".matches(regex3));
        System.out.println("bbbabc&&&".matches(regex3));
        System.out.println("aaa123aab".matches(regex3));
        System.out.println("-----------------------------------");
    }
}*/

/*
正则内部使用：\\
正则外部使用：$
需求:
​    将字符串：我要学学编编编编程程程程程程。
​    替换为：我要学编程
 */
/*public class java02 {
    public static void main(String[] args) {
        //  (.)表示把重复内容的第一个字符看做一组
        //  \\1表示第一字符再次出现
        //  + 至少一次
        //  $1 表示把正则表达式中第一组的内容，再拿出来用
        String str = "我要学学编编编编程程程程程程";
        String s = str.replaceAll("(.)\\1+", "$1");
        System.out.println(s);
    }
}*/
//非捕获分组
/*
(?:[123])//?:不占用组号，所以这个正则表达式没有第一组
(?=)(?!)都是非捕获分组，不占用组号
 */

/**
 * 15 JDK7时间 Date
 */
/*
构造：
public Date()//(中国东八区 +8h)
使用无参构造，可以自动设置当前系统时间的毫秒时刻
public Date(long date)
指定long类型的构造参数，可以自定义毫秒时刻。
成员方法：
public long getTime() 把日期对象转换成对应的时间毫秒值。
public void setTime(long time) 把方法参数给定的毫秒值设置给日期对象
毫秒值便于时间的比较 便于时间对象的创建
 */
/*public class java02{
    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.println(d1);
        System.out.println(d1.getTime());//输出毫秒值

        Date d2 = new Date(0L);
        System.out.println(d2);
        d2.setTime(1715589821640L);
        System.out.println(d2);
    }
}*/

/**
 * 16 JDK7时间 SimpleDateFormat
 */
/*
ctrl+alt+v自动生成左边变量(用于初始化变量)
作用：------简单看成---String和Date之间的中转站---------
  格式：按照指定的格式，把Date对象转换为String对象。
  解析：按照指定的格式，把String对象转换为Date对象

  public SimpleDateFormat()//1.
  public SimpleDateFormat(String pattern)：//2.
  用给定的模式和默认语言环境的日期格式符号构造SimpleDateFormat。
  参数pattern是一个字符串，代表日期时间的自定义格式。

  public String format(Date date)：将Date对象格式化为字符串。
  public Date parse(String source)：将字符串解析为Date对象。//3
 */
/*public class java02 {
    public static void main(String[] args) throws ParseException {
        //1.
        SimpleDateFormat sdf1 = new SimpleDateFormat();
        Date d1 = new Date(0L);
        String str1 = sdf1.format(d1);
        System.out.println(str1);

        //2.
        //格式：查api
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日E HH:mm:ss");
        String str2 = sdf2.format(new Date());
        System.out.println(str2);

        //3.
        String str3 = "2050-01-01 00:00:00";
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d2 = sdf3.parse(str3);
        System.out.println(d2);
    }
}*/

//练习1：2000-11-11转化为2000年11月11日
/*public class java02 {
    public static void main(String[] args) throws ParseException {
        String str1 = "2000-11-11";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdf2.parse(str1);

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日");
        System.out.println(sdf1.format(d1));
    }
}*/

/**
 * 17 JDK7时间 Calendar
 */
/*
抽象类 不能创建对象
public static Calendar getInstance()获取一个它的子类GregorianCalendar对象。

public final getTime()                  获取日期对象
public final setTime(Date date)         给日历设置日期对象
public long getTimeInMillis()           拿到时间毫秒值
public void setTimeInMills(long mills)  给日历设置时间毫秒值
public int get(int field)获取某个字段的值。field参数表示获取哪个字段的值，
                         可以使用Calender中定义的常量来表示：
                         Calendar.YEAR : 年
                         Calendar.MONTH ：月
                         Calendar.DAY_OF_MONTH：月中的日期
                         Calendar.HOUR：小时
                         Calendar.MINUTE：分钟
                         Calendar.SECOND：秒
                         Calendar.DAY_OF_WEEK：星期
public void set(int field,int value)设置某个字段的值
public void add(int field,int amount)为某个字段增加/减少指定的值
 */
/*public class java02 {
    public static void main(String[] args) {
        Calendar c1 = Calendar.getInstance();
        System.out.println(c1);//月份范围是0-11
        //星期日是一周的第一天，对应1

        System.out.println(c1.getTime());
        Date d1 = new Date(0L);
        c1.setTime(d1);
        System.out.println(c1);//getTimeInMills & setTimeInMills和这两个差不多
        System.out.println(c1.getTime());//这里就不过多演示了

        //get
        Calendar c2 = Calendar.getInstance();
        c2.setTime(new Date(0l));
        System.out.println(c2.get(Calendar.YEAR) + "-" + c2.get(Calendar.MONTH) + 1 +//细节+1
                "-" + c2.get(Calendar.DAY_OF_MONTH) +
                " 星期" + (c2.get(Calendar.DAY_OF_WEEK) + 6) % 7);//细节操作

        //set
        //重载了多个set方法 又不同参数传入形式//细节month->0
        c2.set(2024,0,1,8,0,0);
        System.out.println(c2.getTime());

        //add
        c2.add(Calendar.YEAR,-1);
        System.out.println(c2.getTime());
    }
}*/

/**
 * 18 JDK8 新增时间相关类
 */
/*
图片笔记：day02\image\api-18-time.jpg
新增时间类好处：1.简化代码
             2.时间日期对象都不可变 避免了多线程环境下导致的数据安全问题

注： JDK8 month 1-12

JDK8时间类类名              作用
ZoneId                     时区
Instant                    时间戳
ZoneDateTime               带时区的时间
DateTimeFormatter          用于时间的格式化和解析
LocalDate                  年、月、日LocalTime时、分、秒
LocalDateTime              年、月、日、时、分、秒
Duration                   时间间隔（秒，纳，秒）
Period                     时间间隔（年，月，日）
ChronoUnit                 时间间隔（所有单位）
 */

/*
ZoneId
//调用方法 打印一下就行
static Set<string> getAvailableZoneIds() 获取Java中支持的所有时区
static ZoneId systemDefault() 获取系统默认时区
static Zoneld of(string zoneld) 获取一个指定时区
 */
/*public class java02{
    public static void main(String[] args) {
        Set<String> zonIds = ZoneId.getAvailableZoneIds();
        System.out.println(zonIds);

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);

        ZoneId zoneId1 = ZoneId.of("Europe/Istanbul");
        System.out.println(zoneId1);
    }
}*/

/*
Instant
static Instant now() 获取当前时间的Instant对象(标准时间)//东八区+8h
static Instant ofXxxx(long epochMilli) 根据(秒/毫秒/纳秒)获取Instant对象
ZonedDateTime atZone(ZoneId zone) 指定时区
boolean isxxx(Instant otherInstant) 判断系列的方法
Instant minusXxx(long millisToSubtract) 减少时间系列的方法
Instant plusXxx(long millisToSubtract) 增加时间系列的方法
 */

/*public class java02 {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);

        //输入毫秒
        System.out.println(Instant.ofEpochMilli(0L));
        //输入秒
        System.out.println(Instant.ofEpochSecond(1L));
        //输入纳秒
        System.out.println(Instant.ofEpochSecond(1L, 10000000000L));

        ZonedDateTime zonedDateTime = Instant.now().atZone(ZoneId.of("Europe/Istanbul"));
        System.out.println(zonedDateTime);

        Instant instant1 = Instant.ofEpochMilli(100L);
        Instant instant2 = Instant.ofEpochMilli(1000L);
        if (instant1.isBefore(instant2)) {
            System.out.println("instance1在instance2前");
        }

        System.out.println(instant1);
        System.out.println(instant1.minusSeconds(1));
        System.out.println(instant1.plusSeconds(1));
    }
}*/

/*
ZoneDateTime
static ZonedDateTime now() 获取当前时间的ZonedDateTime对象
static ZonedDateTime ofXxxx(。。。) 获取指定时间的ZonedDateTime对象
ZonedDateTime withXxx(时间) 修改时间系列的方法
ZonedDateTime minusXxx(时间) 减少时间系列的方法
ZonedDateTime plusXxx(时间) 增加时间系列的方法
 */

/*public class java02{
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        //这里的month1-12
        ZonedDateTime zdt1 = ZonedDateTime.of(2024, 1, 1,
                0, 0, 0, 0, ZoneId.of("Asia/Shanghai"));
        System.out.println(zdt1);
        //第二种创建方法
        ZonedDateTime zdt2 = ZonedDateTime.ofInstant(Instant.ofEpochSecond(0L), ZoneId.of("Asia/Shanghai"));
        System.out.println(zdt2);

        System.out.println(zdt2.withYear(2024));
        System.out.println(zdt2.minusMonths(2));
        System.out.println(zdt2.plusMonths(2));
    }
}*/

/*
DateTimeFormatter
static DateTimeFormatter ofPattern(yyyy-MM-dd HH:mm:ss) 获取格式对象
            String format(ZoneDateTime) 按照指定方式格式化
 */
/*public class java02 {
    public static void main(String[] args) {
        ZonedDateTime zdt1 = Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dtf1.format(zdt1));
    }
}*/

/*
类：
LocalDate
LocalTime
LocalDateTime

共通的方法：
static xxx now()      和获取当前时间对象
static xxx of()       指定时间对象
get~                  获取成员信息
isBefore/isAfter      比较
with~                 修改时间系列
minus~                减少时间系列的方法
plus~                增加时间系列的方法

LocalDateTime独有：
public LocalDateTime toLocalDate() 前者转为后者
public LocalDateTime toLocalTime() 前者转为后者
 */
/*public class java02{
    public static void main(String[] args) {
        LocalDate ld1 = LocalDate.of(2024, 9, 9);
        System.out.println(ld1);
        System.out.println(LocalDate.now());
        System.out.println(ld1.getMonth().getValue());//将SEPTEMBER转为9
        System.out.println(ld1.getMonthValue());
        //......根据上面写
    }
}*/

/*
Duration     时间间隔（秒，纳，秒
Period       时间间隔（年，月，日）
ChronoUnit   时间间隔（所有单位）
 */
/*public class java02 {
    public static void main(String[] args) {
        // 本地日期时间对象。
        LocalDateTime today1 = LocalDateTime.now();
        // 出生的日期时间对象
        LocalDateTime birthDate1 = LocalDateTime.of(2000, 1, 1, 0, 0, 0);
        Duration duration = Duration.between(birthDate1, today1);//第二个参数减第一个参数
        System.out.println("相差的时间间隔对象:" + duration);//PT 213599H 11M 17.253S
        System.out.println("============================================");
        System.out.println(duration.toDays());//两个时间差的天数
        System.out.println(duration.toHours());//两个时间差的小时数
        System.out.println(duration.toMinutes());//两个时间差的分钟数
        System.out.println(duration.toMillis());//两个时间差的毫秒数
        System.out.println(duration.toNanos());//两个时间差的纳秒数


        LocalDate ld1 = LocalDate.of(2018, 4, 1);
        LocalDate ld2 = LocalDate.of(2024, 5, 13);
        Period p1 = Period.between(ld1, ld2);//第二个参数 - 第一个参数
        System.out.println(p1.getYears() + "年" + p1.getMonths() + "月" + p1.getDays() + "日");
        System.out.println("一共过了" + p1.toTotalMonths() + "月");


        // 当前时间
        LocalDateTime today = LocalDateTime.now();
        // 生日时间
        LocalDateTime birthDate = LocalDateTime.of(2000, 1, 1,0, 0, 0);
        System.out.println(birthDate);
        System.out.println("相差的年数:" + ChronoUnit.YEARS.between(birthDate, today));
        System.out.println("相差的月数:" + ChronoUnit.MONTHS.between(birthDate, today));
        System.out.println("相差的周数:" + ChronoUnit.WEEKS.between(birthDate, today));
        System.out.println("相差的天数:" + ChronoUnit.DAYS.between(birthDate, today));
        System.out.println("相差的时数:" + ChronoUnit.HOURS.between(birthDate, today));
        System.out.println("相差的分数:" + ChronoUnit.MINUTES.between(birthDate, today));
        System.out.println("相差的秒数:" + ChronoUnit.SECONDS.between(birthDate, today));
        System.out.println("相差的毫秒数:" + ChronoUnit.MILLIS.between(birthDate, today));
        System.out.println("相差的微秒数:" + ChronoUnit.MICROS.between(birthDate, today));
        System.out.println("相差的纳秒数:" + ChronoUnit.NANOS.between(birthDate, today));
        System.out.println("相差的半天数:" + ChronoUnit.HALF_DAYS.between(birthDate, today));
        System.out.println("相差的十年数:" + ChronoUnit.DECADES.between(birthDate, today));
        System.out.println("相差的世纪(百年)数:" + ChronoUnit.CENTURIES.between(birthDate, today));
        System.out.println("相差的千年数:" + ChronoUnit.MILLENNIA.between(birthDate, today));
        System.out.println("相差的纪元数:" + ChronoUnit.ERAS.between(birthDate, today));
    }
}*/

/**
 * 20 包装类
 */
/*
public void method(Object obj){
...//类似程序 传参如果是基本数据类型就接收不了了
}  //程序存在局限性 所以需要包装类

包装类 存储数据位置从原来的栈变成了堆

| 基本类型 | 对应的包装类（位于java.lang包中） |
| -------- | --------------------------------- |
| byte     | Byte                              |
| short    | Short                             |
| int      | Integer                           |
| long     | Long                              |
| float    | Float                             |
| double   | Double                            |
| char     | Character                         |
| boolean  | Boolean                           |

*/
/*
Integer
| 方法名                                  | 说明                                     |
| --------------------------------------- | -------------------------------------- |
| public Integer(int   value)             | 根据 int 值创建 Integer 对象(过时)        |
| public Integer(String s)                | 根据 String 值创建 Integer 对象(过时)     |
| public static Integer valueOf(int i)    | 返回表示指定的 int 值的 Integer   实例     |
| public static Integer valueOf(String s) | 返回保存指定String值的 Integer 对象        |
| static string toBinaryString(int i)     | 得到二进制                               |
| static string toOctalString(int i)      | 得到八进制                               |
| static string toHexString(int i)        | 得到十六进制                              |
| static int parseInt(string s)           | 将字符串类型的整数转成int类型的整数          |
//八种基本数据类型中，除了char，都有parseXxx的方法
 */

/*public class java02 {
    public static void main(String[] args) {
        //new出来的i1 i2地址值不同 是两个对象
        Integer i1 = new Integer(123);
        Integer i2 = new Integer("123");

        //valueOf [-128,127]之间的数据提前创建好了
        //所以i3 i4得到的是同一个对象 地址值相同
        //超过这个范围 也都是重新new的 地址值不同
        Integer i3 = Integer.valueOf(123);
        Integer i4 = Integer.valueOf("123");
        System.out.println(i1 + " " + i2 + " " + i3 + " " + i4);
        System.out.println(i3 == i4);

        //计算：1.拆箱 变成基本数据类型
        //     2.相加
        //     3.装箱 变回包装类
        int t = i1.intValue();
        t += 50;
        System.out.println(new Integer(t));

        //JDK5后 包装类有了新特性
        //自动装箱 自动拆箱
        //所以 JDK5后 包装类和对应基本数据类型之间可认为基本相同
        //底层自动调用valueOf方法  自动装箱
        Integer i5 = 21;
        //自动拆箱
        int t1 = i5;
        System.out.println(i5 + t1);
    }
}*/

//键盘录入改进 可接收空格
//sc.nextLine()方法可以接受
/*public class java02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.println(line);
        //需要的话转成其他类型
        double d = Double.parseDouble(line);
        System.out.println(d);
    }
}*/

/**
 *  常见算法 06 Arrays
 */
/*
public static toString(数组)                            将数组拼接成字符串
static int binarySearch(数组，查找的元素)                 二分法查找元素(数组必须有序)
public static int[] copyOf(原数组,新数组长度)             拷贝数组
public static int[] copyOfRange(原数组,起始索引,结束索引)  拷贝数组(指定范围)
public static void fill(数组,元素)                       填充数组
public static void sort(数组)                           按照默认方式进行数组排序
public static void sort(数组,排序规则)                   按照指定规则排序
*/

/*public class java02 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.binarySearch(arr, 2));
        System.out.println(Arrays.binarySearch(arr, 20));//(-9-1) == -10

        int[] a1 = Arrays.copyOf(arr, 20);//多了用0填充
        System.out.println(Arrays.toString(a1));

        int[] a2 = Arrays.copyOfRange(arr, 0, 9);//[0,8]包头不包尾
        System.out.println(Arrays.toString(a2));//多了用0填充

        Arrays.fill(arr, 666);
        System.out.println(Arrays.toString(arr));

        int[] a3 = {9, 22, 4, 5, 1, 2, 17, 2, 16, 41, 21, 12};
        Arrays.sort(a3);
        System.out.println(Arrays.toString(a3));

        //只能给引用数据类型的数组进行排序
        Integer[] a4 = {9, 22, 4, 5, 1, 2, 17, 2, 16, 41, 21, 12};
        Arrays.sort(a4, new Comparator<Integer>() {
            @Override//整了一个新的实现了Comparator接口的类 并初始化了这个新类的对象
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(a4));
    }
}*/


/**
 * 07 Lambda (JDK8)
 */
/*
Lambada表达式体现了 函数式编程的思想(忽略面向对象复杂的语法 强调做什么 而不是谁去做)
格式：()->{...
             }
() 对应方法的形参
-> 固定格式
{} 方法体

注意：
Lambada表达式可以用来简化匿名内部类的书写
Lambada表达式只能简化函数式接口的匿名内部类的写法
函数式接口：有且只有一个抽象方法的接口
          接口上方可以加上@FunctionalInterface注解检验
 */
/*public class java02 {
    public static void main(String[] args) {
        Integer[] arr = {9, 22, 4, 5, 1, 2, 17, 2, 16, 41, 21, 12};

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override//整了一个新的实现了Comparator接口的类 并初始化了这个新类的对象
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr,
                (Integer o1, Integer o2) -> {
                    return o2 - o1;
                });
        System.out.println(Arrays.toString(arr));

        show(() -> {
            System.out.println("正在狗刨~~");
        });
    }

    //参数是接口 传递实现接口类的对象
    public static void show(Swim s) {
        s.swim();
    }
}

@FunctionalInterface
interface Swim {
    public abstract void swim();
}*/

/*
Lambada表达式的省略写法：可推导 可省略
1.参数类型可以省略不写
2.如果只有一个参数，参数类型可以省略，同时()也可以省略
3.如果Lambda表达式方法体只有一行 大括号 分号 return 都可以省略不写 但是需要同时省略
 */
/*public class java02 {
    public static void main(String[] args) {
        Integer[] arr = {9, 22, 4, 5, 1, 2, 17, 2, 16, 41, 21, 12};
        //简化写法
        Arrays.sort(arr, (o1, o2) -> o1 - o2);
        System.out.println(Arrays.toString(arr));

        happy(new Work() {
            @Override
            public void fuck(Integer a) {
                System.out.println(a);
            }
        });
        //简化写法
        happy(a -> System.out.println(a) );
    }
    public static void happy(Work w1){
        w1.fuck(1);
    }
}

@FunctionalInterface
interface Work{
    public abstract void fuck(Integer a);
}*/

/*public class java02 {
    public static void main(String[] args) {
        String[] ss = {"fuck you", "shit", "pitch", "apple phone", "www", "yellow"};
        Arrays.sort(ss, (o1, o2) -> o2.length() - o1.length());
        System.out.println(Arrays.toString(ss));
    }
}*/

/**
 * 集合进阶 01
 * 单列集合顶层接口 Collection
 */
/*
图片笔记：day02\image\collection-01.jpg

List系列集合：有序(存时的顺序) 可重复  有索引
Set系列集合：  无序  不重复  无索引
 */
/*
Collection(接口) -> 所有单列集合的祖宗
它的功能全部单列集合都能继承使用
| 方法名                     | 说明                                  |
| :------------------------- | :---------------------------------  |
| boolean add(E e)           | 添加元素                              |
| boolean remove(Object o)   | 从集合中移除指定的元素                  |
| boolean removeIf(Object o) | 根据条件进行移除                       |
| void   clear()             | 清空集合中的元素                       |
| boolean contains(Object o) | 判断集合中是否存在指定的元素             |
| boolean isEmpty()          | 判断集合是否为空                       |
| int   size()               | 集合的长度，也就是集合中元素的个数        |
 */
/*public class java02 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        //添加成功 返回true
        coll.add("aaa");
        coll.add("bbb");
        coll.add("ccc");
        System.out.println(coll);

        //添加成功 返回true
        //因为是共性的方法 所以不能通过索引删除
        coll.remove("aaa");
        System.out.println(coll);

        //细节：底层用equals方法判断
        //因此自定义对象的查找 需要在javabean中重写equals方法
        System.out.println(coll.contains("aaa"));
        System.out.println(coll.contains("bbb"));

        System.out.println(coll.size());
        coll.clear();
        if (coll.isEmpty()) {
            System.out.println("空啦");
        }
    }
}*/


/**
 * 02 Collection 遍历
 */
/*
遍历的三种方法：
1.迭代器遍历
2.增强for
3.forEach算法--lambda表达式
*/
/*
迭代器,集合的专用遍历方式
Iterator<E> iterator(): 返回此集合中元素的迭代器,通过集合对象的iterator()方法得到

- Iterator中的常用方法
boolean hasNext(): 判断当前位置是否有元素可以被取出
E next(): 获取当前位置的元素,将迭代器对象移向下一个索引位置

- 细节点注意：
1.报错NoSuchElementException
2.迭代器遍历完毕，指针不会复位
3.循环中只能用一次next方法
4.迭代器遍历时，不能用集合的方法进行增加或者删除
(可以用迭代器的方法删除 无法添加)
 */
/*public class java02 {
    public static void main(String[] args) {
        ArrayList<String> als1 = new ArrayList<>();
        als1.add("aaa");
        als1.add("bbb");
        als1.add("ccc");
        als1.add("ddd");
        als1.add("eee");
        Iterator<String> it1 = als1.iterator();
        while (it1.hasNext()) {
            System.out.print(it1.next() + " ");
        }
        System.out.println();

        Iterator<String> it2 = als1.iterator();
        while (it2.hasNext()) {
            String s = it2.next();
            if (s.equals("bbb")) {
                it2.remove();//用Iterator<E>自带的删除
            }
        }
        System.out.println(als1);
    }
}*/

/*
增强for：
- 介绍
  - 它是JDK5之后出现的,其内部原理是一个Iterator迭代器
  - 只有所有单列集合和数组才能这么干
  - 简化数组和Collection集合的遍历
- 格式
  ​	for(集合/数组中元素的数据类型 变量名 :  集合/数组名) {
  ​		// 已经将当前遍历到的元素封装到变量中了,直接使用变量即可
  ​	}

注：快捷键：   集合名/数组名 + for 回车
    for(int a : arr){}
    a就是一个第三方变量 改变a不影响集合中的值(C++也这样)
 */
/*public class java02 {
    public static void main(String[] args) {
        ArrayList<String> als1 = new ArrayList<>();
        als1.add("aaa");
        als1.add("bbb");
        als1.add("ccc");
        als1.add("ddd");
        als1.add("eee");
        for (String a : als1) {
            System.out.print(a + " ");
        }
        for (String s : als1) {
            System.out.println(s);
        }
    }
}*/

/*
forEach算法--lambda表达式
利用forEach方法，再结合lambda表达式的方式进行遍历
 */
/*public class java02 {
    public static void main(String[] args) {
        ArrayList<String> als1 = new ArrayList<>();
        als1.add("aaa");
        als1.add("bbb");
        als1.add("ccc");
        als1.add("ddd");
        als1.add("eee");

        als1.forEach(new Consumer<String>() {
            @Override//这里s以此表示数组中每个数据
            // 修改s一样不影响集合中原有的数据
            public void accept(String s) {
                System.out.print(s + " ");
            }
        });
        System.out.println();

        //lambada表达式
        als1.forEach(s -> System.out.print(s + " "));
    }
}*/

/**
 * 03 List
 */
/*
alt + 7 显示查找类的大纲 ~= ctrl + f12(直接输入字母可以搜索)
ctrl + p 查看方法中应填参数类型
不自动排序 有索引 可重复

| 方法名                          | 描述                                     |
| ------------------------------- | -------------------------------------- |
| void add(int index,E   element) | 在此集合中的指定位置插入指定的元素           |
| E remove(int   index)           | 删除指定索引处的元素，返回被删除的元素        |
| E set(int index,E   element)    | 修改指定索引处的元素，返回被修改的元素        |
| E get(int   index)              | 返回指定索引处的元素                       |
 */

/*public class java02 {
    public static void main(String[] args) {
        List<Integer> ls1 = new ArrayList<>();
        ls1.add(0);
        ls1.add(1);
        ls1.add(2);
        ls1.add(3);
        ls1.add(4);
        ls1.add(5);
        System.out.println(ls1);

        //有传值 传索引的两种remove重载
        //这里产生冲突 优先选择实参和形参类型一样的
        //就是传索引的 二者都是int的基本数据类型
        ls1.remove(1);
        System.out.println(ls1);

        ls1.add(1,1);
        System.out.println(ls1);
        //这样操作可以在这种冲突情况进行传值的函数
        Integer i = Integer.valueOf(1);
        ls1.remove(i);
        System.out.println(ls1);
    }
}*/

/*
List集合的遍历方式：5种
     3种刚刚学的通用的
     1种for循环索引遍历
     1种列表迭代器遍历

最后一种 ListIterator接口继承Iterator
       增加了遍历时增添的功能等
       详细查api文档
 */
/*
public class java02 {
    public static void main(String[] args) {
        //列表迭代器
        List<String> ls = new LinkedList<>();
        ls.add("aaa");
        ls.add("bbb");
        ls.add("ccc");
        ls.add("ddd");
        ls.add("eee");
        ls.add("fff");

        ListIterator<String> it = ls.listIterator();
        while (it.hasNext()) {
            String s = it.next();
            if ("ccc".equals(s))
            {
                it.add("WWW");
            }
            System.out.print(s + " ");
        }
        System.out.println("\n" + ls);
    }
}
*/


/**
 * 06 带着读 ArrayList 源代码 需要可以看
 */

/**
 * 07 LinkedList 带着读 LinkedList 源代码 需要可以看
 */
/*
等于是双向链表的底层结构

| 方法名                    | 说明                             |
| ------------------------- | -------------------------------- |
| public void addFirst(E e) | 在该列表开头插入指定的元素       |
| public void addLast(E e)  | 将指定的元素追加到此列表的末尾   |
| public E getFirst()       | 返回此列表中的第一个元素         |
| public   E getLast()      | 返回此列表中的最后一个元素       |
| public E removeFirst()    | 从此列表中删除并返回第一个元素   |
| public   E removeLast()   | 从此列表中删除并返回最后一个元素 |
 */

/**
 *  08 泛型
 */
/*
如果没有泛型 代码写法一：(这段代码挺神奇的 瞅瞅)

当没有泛型时 如果没有给集合指定数据类型 默认所有数据类型都是Object类型
此时 可以往集合添加任意数据类型
但是 当我们获取数据时 却无法使用它特定的行为

泛型的介绍
  ​	泛型是JDK5中引入的特性，它提供了编译时类型安全检测机制
泛型的好处
  1. 把运行时期的问题提前到了编译期间
  2. 避免了强制类型转换
泛型的定义格式
  - <类型>: 指定一种类型的格式.尖括号里面可以任意书写,一般只写一个字母.例如: <E> <T>
  - <类型1,类型2…>: 指定多种类型的格式,多种类型之间用逗号隔开.例如: <E,T> <K,V>
泛型的细节
  1.<>不能写基本数据类型 ->编译后还是Object类型接收(就是在门口判断了一下)
  2.指定泛型具体类型后 传递数据时 可以传入该类类型或该类子类类型
  3.不写泛型 类型默认Object 如下代码
 */
/*public class java02 {
    static class Student {
        int age;
        String name;

        public Student() {
        }

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String toString() {
            return "Student{age = " + age + ", name = " + name + "}";
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(123);
        list.add("abc");
        list.add(new Student(12, "aaa"));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            System.out.println(o);
        }
    }
}*/

/*
泛型可以在很多地方定义：
  类后面        泛型类
  方法上面      泛型方法
  接口后面      泛型接口
 */
//自定义泛型类
//day02\src\EXERCISE\miniProject\mini13
/*public class java02 {
    public static void main(String[] args) {
        MyArrayList<String> mal = new MyArrayList<>();
        mal.add("aaa");
        mal.add("bbb");
        mal.add("ccc");
        System.out.println(mal.get(2));
        System.out.println(mal.toString());//自己重写了
    }
}*/

//泛型方法
/*public class java02 {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        addAll(al, 12, 13, 14);
        System.out.println(al);
    }

    public static <E> void addAll(ArrayList<E> al, E... e) {
        for (E element : e) {//可变参数的语法
            al.add(element);//e在这里相当于一个数组
        }
    }
}*/

//泛型接口
//day02\src\EXERCISE\miniProject\mini14
/*
 泛型接口的两种使用方式：
   1.实现类给出的具体类型
   2.实现类延续泛型 创建实现类对象再确定类型
mini14包中两个类分别用这两种方式实现了 List接口
   3.第三种public class MyList02 implements List ...
   按这种方式实现时 相当于没有确定类型 里面add接收Object类
   (自己试出来的 mini14中没有代码实现)
 */
/*public class java02{
    public static void main(String[] args) {
        MyList01 m1 = new MyList01();
        m1.add("aaa");
        m1.add("bbb");
        m1.add("ccc");

        MyList02<Integer> m2 = new MyList02<>();
        m2.add(11);
        m2.add(12);
        m2.add(13);
    }
}*/

/**
 * 09 泛型的通配符
 */
/*
泛型不具备继承性 数据具备继承性(结合下面代码理解)
 */
/*public class java02{
    public static void main(String[] args) {
        ArrayList<Grandpa> alg = new ArrayList<>();
        ArrayList<Father> alf = new ArrayList<>();
        ArrayList<Child> alc = new ArrayList<>();

        //泛型不具备继承性
        test(alg);// √
        //test(alf);//报错
        //test(alc);//报错

        //数据具备继承性
        alg.add(new Grandpa());
        alg.add(new Father());
        alg.add(new Child());
    }

    public static void test(ArrayList<Grandpa> alg){
    }
}

class Grandpa{
}

class Father extends Grandpa{
}

class Child extends Father{
}*/
/*
泛型通配符：(限制泛型的类型范围)
  ? 表示不确定的类型
  ? extends Grandpa 传递Grandpa 或 Grandpa所有的子类类型
  ? super Child     传递Child 或 Child所有的父类类型
 */
/*public class java02 {
    public static void main(String[] args) {
        ArrayList<Grandpa> alg = new ArrayList<>();
        ArrayList<Father> alf = new ArrayList<>();
        ArrayList<Child> alc = new ArrayList<>();

        test(alg);
        test(alf);
        test(alc);
    }

    public static void test(ArrayList<? extends Grandpa> alg) {
    }

    //public static void test01(? extends Grandpa){}//错误
}

class Grandpa {
}

class Father extends Grandpa {
}

class Child extends Father {
}*/
//exercise: day02\src\EXERCISE\miniProject\mini15

/**
 * 13 Set HashSet
 */
/*
Set接口中方法和基本与Collection的API一致
 */
//遍历Set系列集合
/*public class java02 {
    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>();
        System.out.println(s1.add("aaa"));//add返回boolean类型
        System.out.println(s1.add("aaa"));
        System.out.println(s1.add("ccc"));
        System.out.println(s1);
        s1.add("ddd");
        s1.add("eee");
        s1.add("fff");

        //3种遍历方法
        Iterator<String> it = s1.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        for (Object i : s1) {
            System.out.print(i + " ");
        }
        System.out.println();
        s1.forEach(str -> System.out.print(str + " "));
    }
}*/

/*
HashSet: 无序 不重复 无索引
LinkedHashSet: 有序(同添加的顺序) 不重复 无索引
TreeHashSet: 自动排序(从小到大) 不重复 无索引
 */

/*
HashSet(基于哈希表)
HashSet 的目的是为存储的元素提供快速查找、添加和删除操作
 -> 成员方法和Collection`Set差不多

这里的哈希表组成：
JDK8以前：数组+链表
JDK8开始：数组+链表+红黑树

哈希值：对象的整数表现形式
数据通过哈希表存储时 存储在一个数组中 下标index的确定：
int index = (数组.length - 1) & 哈希值;//& -> 按位与
也就是说： 下标根据数据对应的哈希值确定

哈希值取得：
根据hashCode方法算出来的int类型的整数
该方法定义在Object类中，所有对象都可以调用，默认使用地址值进行计算
一般情况下，会重写hashCode方法，利用对象内部的属性值计算哈希值
(如果按照默认用地址值计算 没有重写 存储的两个Per对象的name age两个值都相等
但是因为地址值不同 没有起到去重存储的效果(会出现这样的情况))
(小部分情况下 不同属性值或不同地址值计算出来的哈希值也可能一样 这叫做哈希碰撞)

HashSet底层实现 比较去重时用到了equals方法
所以存储自定义对象时 必须要重写hashCode和equals方法

hashCode的重写按alt insert就可以找到
 */

/*public class java02{
    public static void main(String[] args) {
        Student s1 = new Student("张安",48);
        Student s2 = new Student("张安",48);

        //如果Student里面没有重写hashCode 输出就不一样
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        //哈希碰撞的情况(小概率)//String里面重写了hashCode方法
        System.out.println("abc".hashCode());
        System.out.println("acD".hashCode());
    }
}

class Student{
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}*/

/**
 * 13 LinkedHashSet (extends HashSet)
 */
/*
LinkedHashSet接口中方法和基本与Collection的API一致

和HashSet一样 都是基于哈希表存储 只是底层增加了一个双向链表机制
这样可以保证 取出元素顺序和存储元素顺序一致

效率相对HashSet较低
 */

/*public class java02 {
    public static void main(String[] args) {
        String s1 = "adaa";
        String s2 = "bdasdaasdsa";
        String s3 = "casd";
        String s4 = "dAAds";
        String s5 = "ehhj";
        String s6 = "f";
        String s7 = "gjhjkhkh";

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(s1);
        hashSet.add(s2);
        hashSet.add(s3);
        hashSet.add(s4);
        hashSet.add(s5);
        hashSet.add(s6);
        hashSet.add(s7);
        hashSet.forEach(s -> System.out.print(s + " "));

        System.out.println();

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(s1);
        linkedHashSet.add(s2);
        linkedHashSet.add(s3);
        linkedHashSet.add(s4);
        linkedHashSet.add(s5);
        linkedHashSet.add(s6);
        linkedHashSet.add(s7);
        linkedHashSet.forEach(s -> System.out.print(s + " "));
    }
}*/

/**
 * 14 TreeSet
 */
//自定义类的TreeSet使用
/*
public class java02{
    public static void main(String[] args) {
        Student s1 = new Student("张三",15);
        Student s2 = new Student("Tom",58);
        Student s3 = new Student("斯蒂芬斯",21);
        Student s4 = new Student("张三",15);

        TreeSet<Student>  t1 = new TreeSet<>();
        t1.add(s1);
        t1.add(s2);
        t1.add(s3);
        t1.add(s4);

        t1.forEach(s-> System.out.println(s + " "));
    }
}

//需要实现Comparable接口 重写compareTo方法定义排序规则
class Student implements Comparable<Student>{
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
        //返回值：
        //正数：认为要添加的元素是小的 存左边(左右是指红黑树左右子树)
        //负数：认为要添加的元素是大的 存右边

        //红黑树插入结点时比较 调用这个方法
        //底层不断调用这个方法 确定结点位置 颜色等 建立红黑树
    }
}
*/

/**
 * 15 TreeSet 比较器排序
 */
/*
TreeSet(Comparator<? super E> comparator)
构造一个新的空 TreeSet，它根据指定比较器进行排序。
//注意：这里的Comparator和上面的Comparable不一样哦

//既实现了Comparable接口 又使用了比较器 且二者发生冲突 以方式二为主
 */
/*public class java02 {
    public static void main(String[] args) {
        //TreeSet<String> t1 = new TreeSet<>(new Comparator<String>() {
        //@Override
        //public int compare(String o1, String o2) {
        //int flag = o2.length() - o1.length();//根据长度降序
        //长度一样 调用默认排序规则
        //flag = flag==0 ? o1.compareTo(o2) : flag;
        //return flag;
        //}
        //});

        //此为上式Lambada表达式简化：
        TreeSet<String> t1 = new TreeSet<>(
                (o1, o2) -> {
                    int flag = o2.length() - o1.length();//根据长度降序
                    //长度一样 调用默认排序规则
                    flag = flag == 0 ? o1.compareTo(o2) : flag;
                    return flag;
                });
        t1.add("a");
        t1.add("bb");
        t1.add("ccc");
        t1.add("ddd");
        t1.add("dddd");
        t1.add("fffff");
        System.out.println(t1);
    }
}*/

/**
 * 02 Map接口
 */
/*

Map集合概述
  interface Map<K,V>  K：键的类型；V：值的类型
Map集合的特点
  - 双列集合,一个键对应一个值
  - 键不可以重复,值可以重复

| 方法名                              | 说明                                 |
| ----------------------------------- | ------------------------------------|
| V   put(K key,V   value)            | 添加元素 /覆盖                           |
| V   remove(Object key)              | 根据键删除键值对元素                   |
| void   clear()                      | 移除所有的键值对元素                   |
| boolean containsKey(Object key)     | 判断集合是否包含指定的键                |
| boolean containsValue(Object value) | 判断集合是否包含指定的值                |
| boolean isEmpty()                   | 判断集合是否为空                       |
| int size()                          | 集合的长度，也就是集合中键值对的个数      |
 */

/*public class java02{
    public static void main(String[] args) {
        Map<String,Integer> m1 = new HashMap<>();
        m1.put("张三",18);
        m1.put("李四",55);
        m1.put("王五",10);
        //put添加元素时 如果元素不存在 直接把键值对对象添加到Map集合中 返回null
        //            如果元素存在 将原有的键值对对象覆盖 返回原有的覆盖的值
        Integer i = m1.put("张三",188);
        System.out.println(m1);
        System.out.println("i = " + i);

        System.out.println(m1.remove("李四"));
        System.out.println(m1);
    }
}*/

/**
 * 03 Map 遍历
 */
/*
| 方法名                           | 说明                       |
| -------------------------------- | ------------------------ |
| V   get(Object key)              | 根据键获取值               |
| Set<K>   keySet()                | 获取所有键的集合            |
| Collection<V>   values()         | 获取所有值的集合            |
| Set<Map.Entry<K,V>>   entrySet() | 获取所有键值对对象的集合      |
 */
/*public class java02 {
    public static void main(String[] args) {
        Map<String, String> m1 = new HashMap<>();
        m1.put("勇太", "六花");
        m1.put("和真", "惠惠");
        m1.put("ano", "soyo");
        m1.put("tomori", "rikki");

        //法一  获取键值的Set集合 遍历Set集合 找分别对应的V（使用get方法）
        Set<String> s1 = m1.keySet();
        s1.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s + "\t" + m1.get(s));
            }
        });

        //法二 键值对
        //Map.Entry是Map里面的内部接口
        //getKey getValue 是Map.Entry接口里面的方法
        Set<Map.Entry<String, String>> e1 = m1.entrySet();
        for (Map.Entry<String, String> i : e1) {
            System.out.println(i.getKey() + "\t" + i.getValue());
        }

        //法三 Lambada  ->底层就是用法二
        m1.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println(s + "\t" + s2);
            }
        });
    }
}*/

/**
 * 06 HashMap
 */
/*
方法同Map，没有额外的方法
键值：无序(指插入时的顺序) 不重复 无索引
底层和HashSet一样 都是哈希表（依赖hashCode和equals方法）
-> HashCode的键位置如果存储的是自定义对象 需要重写hashCode equals方法
 */
/*public class java02{
    public static void main(String[] args) {
        Stu s1 = new Stu("aaa",1);
        Stu s2 = new Stu("bbb",2);
        Stu s3 = new Stu("ccc",3);
        Stu s4 = new Stu("ddd",4);
        Stu s5 = new Stu("eee",5);

        HashMap<Stu,Integer> hm = new HashMap<>();
        hm.put(s1,111);
        hm.put(s2,222);
        hm.put(s3,333);
        hm.put(s4,444);
        hm.put(s5,555);
        hm.put(s1,666);

        Set<Map.Entry<Stu, Integer>> e1 = hm.entrySet();
        for(Map.Entry<Stu,Integer> i : e1){
            System.out.println(i.getKey()+"\t"+i.getValue());
        }
    }
}

class Stu {
    private String name;
    private int age;

    public Stu() {
    }

    public Stu(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Stu{name = " + name + ", age = " + age + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stu stu = (Stu) o;
        return age == stu.age &&
                Objects.equals(name, stu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}*/

/**
 * 09 LinkedHashMap
 */
/*
主要方法同Map，没有额外的方法
键值：有序(指插入时的顺序) 不重复 无索引
底层原理和LinkedHashSet一样
 */

/**
 * 10 TreeMap
 */
/*
主要方法同Map，没有额外的方法
键值：排序(指升序降序之类) 不重复 无索引
底层和TreeSet一样 红黑树结构

实现Comparable接口 指定比较规则
创建集合时传递Comparator比较器对象 指定比较规则
 */
/*public class java02{
    public static void main(String[] args) {
        //TreeMap<Stu,String> tm = new TreeMap<>();
        TreeMap<Stu,String> tm = new TreeMap<>(new Comparator<Stu>() {
            @Override
            public int compare(Stu o1, Stu o2) {
                return o2.getAge() - o1.getAge();
            }
        });
        Stu s1 = new Stu("aaa",111);
        Stu s2 = new Stu("bbb",222);
        Stu s3 = new Stu("ccc",333);
        Stu s4 = new Stu("ddd",444);
        Stu s5 = new Stu("eee",555);

        tm.put(s4,"dffdf");
        tm.put(s5,"ecdc");
        tm.put(s2,"bsdadds");
        tm.put(s1,"a123");
        tm.put(s3,"cdss");

        Set<Stu> set = tm.keySet();
        for (Stu stu : set) {
            System.out.println(stu+"\t"+tm.get(stu));
        }
    }
}

class Stu implements Comparable<Stu>{
    private String name;
    private int age;

    public Stu() {
    }

    public Stu(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Stu{name = " + name + ", age = " + age + "}";
    }

    @Override
    public int compareTo(Stu o) {
        return this.age - o.age;
    }
}*/

//exercise -> 统计字符串s中各个字符出现的次数
//统计数量的题型 这样使用Map类的容器 和使用哈希表的方法原理差不多
/*public class java02 {
    public static void main(String[] args) {
        String s = "ababbcabcdabcdeee";
        TreeMap<Character, Integer> tm = new TreeMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (tm.containsKey(s.charAt(i))) {
                tm.put(s.charAt(i), tm.get(s.charAt(i)) + 1);
            } else {
                tm.put(s.charAt(i), 1);
            }
        }
        System.out.println(tm);

        StringBuilder sb = new StringBuilder();
        tm.forEach(new BiConsumer<Character, Integer>() {
            @Override
            public void accept(Character character, Integer integer) {
                sb.append(character).append("(").append(integer).append(")  ");
            }
        });
        System.out.println(sb);

        StringJoiner sj = new StringJoiner("","","");
        //add方法只接收String类型的参数
        //这里 c+"" 这样的操作是为了将Character Integer类型的变量转换为String类型
        //也可以使用 String.valueOf(c) 这样的方法进行转换
        tm.forEach((c, i) -> sj.add(c + "").add("(").add(i + "").add(")  "));
        System.out.println(sj);
    }
}*/

/**
 * 19 可变参数
 */
/*
方法的形参个数是可以改变的
格式：形参类型 + ... + 变量名
(这个变量相当于在方法中开了一个数组 这里是数组名)
eg: public static test(int...arr){}

细节：在一个方法的形参中最多只能用一个可变参数
     除了可变参数还有别的单个形参，可变参数要写在最后
eg: public static test(String s,int...arr){}
 */
/*public class java02{
    public static void main(String[] args) {
        getSum(1,2,3,4);
        getSum(1,2,3,4,5,6);
    }
    public static void getSum(int...a){
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        System.out.println("sum = " + sum);
    }
}*/

/**
 * 20 Collections
 */
/*
static <T> boolean addAll(Collection<? super T> c, T... elements)
          将所有指定元素添加到指定 collection 中。
static void shuffle(List<?> list)
          使用默认随机源对指定列表进行置换。
static <T extends Comparable<? super T>> void sort(List<T> list)
          根据元素的自然顺序 对指定列表按升序进行排序。
static <T> void sort(List<T> list, Comparator<? super T> c) -> Comparator接口实现类
          根据指定比较器产生的顺序对指定列表进行排序。
static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key) -> 二分前要排序
          使用二分搜索法搜索指定列表，以获得指定对象。
static <T> void copy(List<? super T> dest, List<? extends T> src)
          将所有元素从一个列表复制到另一个列表。
static <T> void fill(List<? super T> list, T obj)
          使用指定元素替换指定列表中的所有元素。
static <T> T max/min(Collection<? extends T> coll)
          根据指定比较器产生的顺序，返回给定 collection 的最大元素。
static void swap(List<?> list, int i, int j)//i j 指的是下标
          在指定列表的指定位置处交换元素。
 */
/*public class java02 {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        //这是个好东西啊~
        Collections.addAll(al, "aaa", "bbb", "ccc", "ddd", "eee");
        System.out.println(al);

        Collections.shuffle(al);
        System.out.println(al);

        List<String> ls = new LinkedList<>();
        Collections.addAll(ls,"asas","e","aaaapp","www");
        Collections.sort(ls, (o1,o2)->o1.length()-o2.length());
        System.out.println(ls);

        Collections.swap(ls,0,ls.size()-1);
        System.out.println(ls);

        List<Integer> li = new LinkedList<>();
        Collections.addAll(li,1,2,3,4,5,6,7,8,9);
        //如果搜索键包含在列表中，则返回搜索键的索引；否则返回 (-(插入点) - 1)。
        //插入点 被定义为将键插入列表的那一点：即第一个大于此键的元素索引；
        //如果列表中的所有元素都小于指定的键，则为 list.size()。
        //注意，这保证了当且仅当此键被找到时，返回的值将 >= 0。
        System.out.println(Collections.binarySearch(li, 5));//&&&

        System.out.println(Collections.max(li));
        System.out.println(Collections.min(ls, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        }));
    }
}*/

/**
 *  不可变集合
 */
/*
可理解为不能修改的集合
static <E> List<E> of(E...elements)
static <E> Set<E> of(E...elements)       -> 都是JDK9引入
static <K,V> Map<K,V> of(E...elements)

eg:Set<String> set = Set.of("aaa","bbb","ccc");//必须保证数据不重复
Map.of()里面最多传递10个键值对 也就是20个参数
超过10个键值对 可以使用Map.ofEntries()//JDK9  Map.copyOf()//JDK10
 */
/*public class java02{
    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("张三", "南京");
        hm.put("李四", "北京");
        hm.put("王五", "上海");
        hm.put("赵六", "北京");
        hm.put("孙七", "深圳");
        hm.put("周八", "杭州");
        hm.put("吴九", "宁波");
        hm.put("郑十", "苏州");
        hm.put("刘一", "无锡");
        hm.put("陈二", "嘉兴");
        hm.put("aaa", "111");

        Set<Map.Entry<String, String>> e1 = hm.entrySet();
        //Map.ofEntrys(T...arr)方法中传递的是可变参数 本质上就是传递数组
        //因此 我们把键值队Set集合转化为数组的形式
        //使用Set的toArray(T[])方法将Set集合转为数组
        //意思是将Set集合转为的数组存入new Map.Entry[0]的数组中
        //但是数组空间不够 底层会自动扩充空间 生成新的数组 用arr接收
        Map.Entry[] arr = e1.toArray(new Map.Entry[0]);
        //JDK9的方法 这里还不能使用
        //Map<String,String> m1 = Map.ofEntries(arr);

        //简写：
        //Map<String,String> m1 = Map.ofEntries(hm.entrySet.toArray(new Map.Entry[0]));

        //JDK10出现的方法 直接生成不可变数组
        //Map<String,String> m1 = Map.copyOf(hm);
    }
}*/

/**
 * 02 Stream流
 */
/*
Stream流的特点：函数式编程的思想 代码简洁
Stream流使用步骤：
  1.先得到一条Stream流 并把数据放上去
  2.使用中间方法对流水线上的数据进行操作
  3.使用终结方法对流水线上的数据进行操作
 */
/*
1.先得到一条Stream流
单列集合             default Stream<E> stream()          Collection中的默认方法
双列集合                     无(转为Set)                  不能直接使用
数组                public static<T> stream(T[]array)   Arrays工具类中的静态方法
同种数据类型的多个数据  public static<T> of(T...values)     Stream接口中的静态方法
 */
/*public class java02 {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        Collections.addAll(al, "aaa", "bbb", "ccc");
        //Stream<String> s1 = al.stream();
        //s1.forEach(new Consumer<String>() {
        //@Override
        //public void accept(String s) {
        //System.out.println(s);
        //}
        //});
        //简写：
        al.stream().forEach(s -> System.out.println(s));

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Jack", 12);
        hm.put("Mary", 18);
        hm.put("BigSB", 8);
        hm.keySet().stream().forEach(s -> System.out.println(s + "\t" + hm.get(s)));
        hm.entrySet().stream().forEach(s-> System.out.println(s.getKey()+"-->"+s.getValue()));

        //基本数据类型 引用数据类型都可以
        int[] arr = {1,2,3,4,5,6};
        Arrays.stream(arr).forEach(s-> System.out.print(s + " "));
        System.out.println();

        //加入可变参数时，基本数据类型 引用数据类型都可以
        //Stream.of()也可以加入数组 但是必须是引用类型的数组
        //如果加基本数据类型的数组 会把整个数组当作一个元素加入Stream流中
        Stream.of(11,12,13,14,15,16).forEach(s-> System.out.print(s+" "));
        System.out.println();
    }
}*/

/*
2.使用中间方法对流水线上的数据进行操作
| 方法名                                           | 说明
| ----------------------------------------------- | ----------------------------------------------------------
| Stream<T> filter(Predicate predicate)           | 用于对流中的数据进行过滤
| Stream<T> limit(long maxSize)                   | 截取前指定参数个数的数据 返回此流中的元素组成的流
| Stream<T> skip(long n)                          | 跳过指定参数个数的数据，返回由该流的剩余元素组成的流
| static <T> Stream<T> concat(Stream a, Stream b) | 合并a和b两个流为一个流(a b数据类型尽可能一致 不然变成a b共同的父类)
| Stream<T> distinct()                            | 元素去重 依赖hashCode equals方法(因为是使用HashSet去的重)                               |
| Stream<R>map(Function<T,R> mapper)              | 转换流中的数据类型

注意：修改Stream流中的数据 不会影响原来的集合或者数组中的数据

     中间方法 返回新的Stream流 原来的Stream流只能使用一次
     建议使用链式编程 --> 只能操作一次 不能重复使用 所以开成变量也没有什么意义
 */
/*public class java02 {
    public static void main(String[] args) {
        ArrayList<String> als = new ArrayList<>();
        Collections.addAll(als, "aaa", "d54ds", "cc", "ddw", "sdsdss", "d54ds", "aaa");
        ArrayList<Integer> ali = new ArrayList<>();
        Collections.addAll(ali, 1, 2, 3, 4, 5, 6);

        //filter
        als.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                //return true 数据留下
                //return false 数据舍弃
                return s.length() == 3;//留下长度为3的数据
            }
        }).forEach(s -> System.out.print(s + " "));
        System.out.println("\n------------------------");

        //注意事项举例
        Stream<String> t1 = als.stream().filter(s -> s.length() == 3);
        t1.filter(s -> s.startsWith("a")).forEach(s -> System.out.print(s + " "));
        System.out.println();
        //报错 变量t1不能重复使用
        //t1.filter(s->s.startsWith("d")).forEach(s-> System.out.println(s));
        //对原来集合中的数据没有影响
        System.out.println(als);
        System.out.println("------------------------");

        //limit
        als.stream().limit(5).forEach(s -> System.out.print(s + " "));
        System.out.println("\n------------------------");

        //skip
        als.stream().skip(5L).forEach(s -> System.out.print(s + " "));
        System.out.println("\n------------------------");

        //distinct
        als.stream().distinct().forEach(s -> System.out.print(s + " "));
        System.out.println("\n------------------------");

        //concat
        Stream.concat(als.stream(), ali.stream()).forEach(s -> System.out.print(s + " "));
        System.out.println("\n------------------------");

        //map
        LinkedList<String> list = new LinkedList<>();
        Collections.addAll(list, "jack-18", "Mary-28", "Son-3", "DJ-16");
        //<>中第一个数据类型String，流中原本的数据类型
        //    第二额数据类型Integer，转换之后的数据类型
        list.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                //将s通过"-"分割成类似{"jack","18"}的String类型数组
                String[] ss = s.split("-");
                //将String类型转换为Integer类型
                return Integer.valueOf(ss[1]);
            }//apply()中的s是流里面的数据 forEach里的s是转换后的Integer类型数据
        }).forEach(s -> System.out.print(s + " "));
        System.out.println("\n-----------------------");

        //Lambada表达式写法
        list.stream()
                .map(s -> Integer.valueOf(s.split("-")[1]))
                .forEach(s -> System.out.print(s + " "));
    }
}*/

/*
3.使用终结方法对流水线上的数据进行操作
| 方法名                         | 说明
| ----------------------------- | ------------------------
| void forEach(Consumer action) | 对此流的每个元素执行操作
| long count()                  | 返回此流中的元素数
| toArray()                     | 收集流中的数据 放到数组中去
| collect(Collector c)          | 收集流中的数据 放到集合中去
 */
/*public class java02 {
    public static void main(String[] args) {
        ArrayList<Integer> ali = new ArrayList<>();
        Collections.addAll(ali, 1, 2, 3, 4, 5, 6);

        //count
        System.out.println("流中数据个数：" + ali.stream().count());
        System.out.println("------------------------");

        //toArray
        //1   toArray()中无参数 生成Object类数组
        Object[] a1 = ali.stream().toArray();
        System.out.println(Arrays.toString(a1));

        //2       <>中的数据类型表示转化成Integer[]类型的数据
        Integer[] arr_i = ali.stream().toArray(new IntFunction<Integer[]>() {
            @Override    //形参value表示流中数据的个数
            public Integer[] apply(int value) {
                return new Integer[value];//生成数组长度和value保持一致
            }
        });
        //Arrays.toString()方法将数组转换成String类型(eg:[1,2,3])
        System.out.println(Arrays.toString(arr_i));
        //Lambada写法：
        Integer[] arr_i1 = ali.stream().toArray(value -> new Integer[value]);
        System.out.println(Arrays.toString(arr_i1));
        System.out.println("------------------------");

        //collect
        LinkedList<String> list = new LinkedList<>();
        Collections.addAll(list, "jack-man-18", "Mary-girl-28",
                "Son-man-3", "DJ-man-16");
        //取性别男加入List集合中
        List<String> coll = list.stream() //"man".equals()中'.'前尽量用固定数据,防止调用者是null导致错误
                .filter(s -> ("man".equals(s.split("-")[1])))
                .collect(Collectors.toList());
        System.out.println(coll);
        //取性别男加入Set集合中
        list.stream()
                .filter(s->("man".equals(s.split("-")[1])))
                .collect(Collectors.toSet())
                .forEach(s-> System.out.print(s + " "));
        System.out.println();
        //取性别男加入Map集合中
        //toMap:参数一表示键的生成规则
        //      参数二表示值的生成规则
        //参数一：
        //   Function泛型一：表示流中每个数据的类型
        //           泛型二：表示Map集合键的数据类型
        //   方法apply形参：表示流中每个数据
        //          返回值：表示生成的键
        //参数二：
        //   Function泛型一：表示流中每个数据的类型
        //           泛型二：表示Map集合值的数据类型
        //   方法apply形参：表示流中每个数据
        //          返回值：表示生成的值
        Map<String, Integer> map =
                list.stream()
                        .filter(s -> ("man".equals(s.split("-")[1])))
                        .collect(Collectors.toMap(new Function<String, String>() {
                            @Override
                            public String apply(String s) {
                                return s.split("-")[0];
                            }
                        }, new Function<String, Integer>() {
                            @Override
                            public Integer apply(String s) {
                                return Integer.valueOf(s.split("-")[2]);
                            }
                        }));
        map.entrySet().forEach(s->System.out.println(s.getKey() + " " + s.getValue()));
        //Lambada写法：
        Map<String, Integer> map2 = list.stream()
                .filter(s -> ("man".equals(s.split("-")[1])))
                .collect(Collectors.toMap(s -> s.split("-")[0], s -> Integer.valueOf(s.split("-")[2])));
        map2.entrySet().forEach(s->System.out.println(s.getKey() + " " + s.getValue()));
    }
}*/

/**
 * 01 方法引用概述
 */
/*
1.什么是方法引用？
  - 把已经存在的方法拿来用 当作函数式接口中抽象方法的方法体
2. :: 是什么符号？
  - 方法引用符
3.方法引用注意事项：
  - 需要有函数式接口
  - 被引用方法已经存在
  - 被引用方法的形参和返回值必须和抽象方法保持一致
  - 被引用方法的功能要满足当前需求
 */
//代码演示：
/*public class java02 {
    public static void main(String[] args) {
        Integer[] data = {8, 9, 10, 1, 6, 2, 3, 4, 7, 5};

        //匿名内部类写法
        //Arrays.sort(data, new Comparator<Integer>() {
        //    @Override//自定义的情况只能给引用数据类型的数组排序
        //    public int compare(Integer o1, Integer o2) {
        //        return o2 - o1;
        //    }
        //});

        //方法引用写法
        Arrays.sort(data, java02::subtraction);

        System.out.println(Arrays.toString(data));
    }

    //已经存在的第三方(假设这个是别人已经写得)方法
    public static int subtraction(int o1, int o2) {
        return o2 - o1;
    }
}*/

/**
 * 02 引用静态方法
 */
/*
格式:  类名::方法名
上一个代码演示就是引用了静态方法
 */
/*public class java02 {
    public static void main(String[] args) {
        ArrayList<String> als = new ArrayList<>();
        Collections.addAll(als,"1","2","3","4","5","6","7","8","9");

        //将上面字符串转为Integer类型并输出
        als.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        }).forEach(s -> System.out.print(s + " "));
        System.out.println();

        //Integer类中 静态方法 paseInt方法中功能满足当前需求
        als.stream().map(Integer::parseInt).forEach(s -> System.out.print(s + " "));
    }
}*/

/**
 * 03 引用类的成员方法
 */
/*
格式： 其他的类 -> 其他的类对象+方法名
         本类 -> this::方法名 (当在static方法时 不能使用this
         父类 -> super::方法名         还需要采用上面这种创建对象的方式调用)
下面代码只展示了第一种情况
 */
//代码用到的exersieH类的位置：
//day02\src\EXERCISE\exerciseH.java
/*public class java02 {
    public static void main(String[] args) {
        ArrayList<String> als = new ArrayList<>();
        Collections.addAll(als,"1","2","3","4","5","6","7","8","9");

        //01筛选大于5的数并输出
        als.stream()
                .filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return Integer.parseInt(s) > 5;
            }
        }).forEach(s -> System.out.print(s + " "));
        System.out.println();

        //01方法引用写法
        als.stream()//注意这里创建了一个exerciseH对象
                .filter(new exerciseH()::SJ)//这个类在EXERCISE文件夹中
                .forEach(s -> System.out.print(s + " "));
    }
}*/


/**
 * 05 引用构造方法
 */
/*
格式：  类名::new
用途：用来创建对象
 */
//将list集合中数据转换为Student类型 并输出
/*public class java02 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        Collections.addAll(list, "jack-18", "Mary-28", "Son-3", "DJ-16");

        list.stream().map(new Function<String, Student>() {
            @Override
            public Student apply(String s) {
                String s1 = s.split("-")[0];
                Integer i = Integer.parseInt(s.split("-")[1]);
                return new Student(s1, i);
            }
        }).forEach(System.out::println);

        //引用构造方法
        list.stream().map(Student::new)
                .forEach(System.out::println);
    }
}

class Student {
    String name;
    int age;

    public Student(String s){
        name = s.split("-")[0];
        age = Integer.parseInt(s.split("-")[1]);
    }

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}*/

/**
 * 06 类名引用成员方法
 */
/*
格式： 类名::方法名

eg: 例子中的匿名内部类写法
new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }

规则：1.必须有函数式接口；被引用的方法必须存在；方法必须满足需求
     2.返回值类型保持一致 就是<,>中第二个参数，也就是apply的返回值，和toUpperCase()的返回值一致
     3.<,>的第一个参数 也就是apply(String)括号里第一个参数，决定了可以调用哪个类中的方法
       这里(String s)表示只能调用String类中的方法
     4.apply()括号中 第二个到最后一个参数和调用的toUpperCase()中保持一致
       这里没有第二个参数了 toUpperCase()里面也没有参数 刚好保持一致
局限性：不能引用所有类中的方法 而只能引用<,>第一个参数类型的类中的方法
 */
/*public class java02 {
    public static void main(String[] args) {
        ArrayList<String> als = new ArrayList<>();
        Collections.addAll(als, "aaa", "bbb", "ccc");

        //匿名内部类写法
        //这里String转换为String本质上还是一种类型转换 所以用map方法
        als.stream().map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        }).forEach(s -> System.out.print(s + " "));
        System.out.println();

        //类名引用方法
        als.stream().map(String::toUpperCase).forEach(s -> System.out.print(s + " "));
        System.out.println();
    }
}*/

/**
 * 07 引用数组的构造方法
 */
/*
格式 数据类型[]::new
目的 创建一个指定类型的数组
注   数据类型 要和流中数据类型保持一致
 */
/*public class java02 {
    public static void main(String[] args) {
        ArrayList<Integer> ali = new ArrayList<>();
        Collections.addAll(ali,1,2,3,4,5,6,7,8,9);
        Integer[] arr = ali.stream().toArray(new IntFunction<Integer[]>() {
            @Override
            public Integer[] apply(int value) {
                return new Integer[value];
            }
        });
        System.out.println(Arrays.toString(arr));

        Integer[] arr2 = ali.stream().toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr2));
    }
}*/

/**
 * 01 异常
 */
/*
分类框架：
图片：day02\image\Throwable_error_exception.png
编译时期异常：语法错误不算，多是防止I/O输入数据错误这类的，
            如果不给出异常 编译器会报错让程序无法运行
运行时期异常：数组越界访问 调用空指针这类 编译时期不提示错误 运行起来会报错

编译时期异常&运行时期异常解析：day02\image\execptionAnalyze.jpg
 */
/*public class java02 {                                           //编译时期异常
    public static void main(String[] args) throws ParseException {//不写这个 代码报错
        String time = "2024-01-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(time);
        System.out.println(date);            //运行时期异常
        System.out.println(time.charAt(100));//StringIndexOutOfBoundsException
    }
}*/

/**
 * 03 异常的两个作用
 */
/*
1.提供查询bug的关键参考信息（就是程序报错了瞅瞅）
2.作为方法内部的一种特殊返回值 以便通知调用者底层执行情况(自己写的抛出异常)
 */
/*class Test {
    public static void main(String[] args) {
        show(10);
    }
    public static void show(int n){
        if (n < 18) {//2.
            throw new RuntimeException();
        } else {
            System.out.println(n);
        }
    }
}*/

/**
 * 04 异常的处理方式
 */
/*
1.JVM默认的处理方式
2.自己处理
3.抛出异常(交给调用者处理)
 */
/*
1.JVM默认的处理方式
  - 将异常的名称 原因 出现的位置等信息以红色字体输出在控制台
  - 程序停止执行
 */
/*public class java02 {
    public static void main(String[] args) {
        System.out.println("111");
        System.out.println(2/0);//ArithmeticException
        System.out.println("222");
        System.out.println("333");
    }
}*/

/*
2.自己处理
  - 采用下面例子中的try{}catch(){}语法格式
  - try{}中写可能报错的代码
  - catch()括号中写可能出现的异常类 并创建一个这个类的变量
  - 如果try{}中确实出现异常 且异常类恰好能被catch()中的变量抓住
  - 就执行直接跳转执行对应的catch中的代码 程序继续执行
这样做的好处是就算出现错误 程序不会中断 而是会继续执行

如果try{}里面没问题 会执行完try{}中的代码 不会执行catch(){}里面的代码
如果try{}里面有多个问题 需要写多个catch(){}与之对应 (注意父类写在下面)
                      也可采用例子中catch(异常类1 | 异常类2 e){...}的写法
如果try{}中遇到的问题没有被捕获 就还是交给虚拟机执行
 */
/*public class java02 {
    public static void main(String[] args) {
        System.out.println("111");
        try {
            System.out.println("AAAAA");
            //System.out.println(2/0);
            String s = "abc";
            System.out.println(s.charAt(10));
            System.out.println("BBBBB");
        }catch (ArithmeticException | StringIndexOutOfBoundsException e){
            System.out.println("222");
            System.out.println("333");
        }
        System.out.println("CCCCC");
    }
}*/

/*
3.抛出处理
throws  写在方法定义处 表示声明一个异常 告诉调用者 使用本方法可能还有哪些异常
        编译时异常：必须写
        运行时异常：可以不写
throw   写在方法内 结束方法 手动抛出异常对象 交给调用者
        方法下面的代码不再执行
 */
/*public class java02 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = {};
        try {
            int max = getmax(arr2);
            System.out.println(max);
        } catch (ArrayIndexOutOfBoundsException e) {//这里接收了异常信息 代码可以继续执行下去
            System.out.println("数组越界 传的是长度为的数组");
        } catch (NullPointerException e) {
            System.out.println("调用空指针 传的是null");
        }
        System.out.println("这句话仍然执行");
    }

    //这里抛出的两个异常可以省略 因为都不是编译阶段的异常
    public static int getmax(int[] arr) throws ArrayIndexOutOfBoundsException, NullPointerException {
        if(arr == null){
            throw new NullPointerException();
        }
        if(arr.length == 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}*/

/**
 * 08 异常中的常见方法
 */
/*
鼠标划住可能报错的代码 按下ctrl+alt+t 就会生成错误处理的方式
                                  (不仅有这个 还能生成if...else  while(){}等结构)
 public String getMessage()     :获取异常的描述信息,原因(提示给用户的时候,就提示错误原因。
 public String toString()       :获取异常的类型和异常描述信息(不用)。
 public void printStackTrace()  :打印异常的跟踪栈信息并输出到控制台。

 System.err.println("这个在控制台输出是红色的 用来输出错误信息 自己不常用");
 */
/*public class java02 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        try {
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            e.printStackTrace();
        }
        //虽然控制台输出了错误信息 但是程序没有因此停止
        //这里输出了这句话 但是可能在e.prinStackTrace()之后 位置不确定 这和多线程有关
        System.out.println("看看我执行了吗？");
        System.err.println("这个是红色的 用来输出错误信息 自己不常用 位置不确定");
    }
}*/


/**
 * 10 异常的使用场景
 */
/*public class java02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A a = new A();
        while (true) {
            try {
                String s = sc.nextLine();
                a.setA(Integer.parseInt(s));
                System.out.println(a);
                break;
            } catch (NumberFormatException e){
                e.printStackTrace();
                System.out.println("请输入数字");
            } catch (RuntimeException e) {
                e.printStackTrace();
                System.out.println("输入数据比100小");
            }
        }
    }
}
class A{
    int a;

    public A() {
    }

    public A(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) throws RuntimeException{
        if(a < 100){
            throw new RuntimeException();
        }
        this.a = a;
    }

    public String toString() {
        return "A{a = " + a + "}";
    }
}*/

/**
 * 11自定义异常
 */
/*
自定义异常类 的位置：day02\src\EXERCISE\miniProject\mini16\AFormatException.java
使用了自定义异常类后，上面的代码可以改写为：
 */
/*public class java02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A a = new A();
        while (true) {
            try {
                String s = sc.nextLine();
                a.setA(Integer.parseInt(s));
                System.out.println(a.a);
                break;
            } catch (AFormatException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        System.out.println(100);
    }
}
class A {
    int a;

    public A() {
    }

    public A(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) throws RuntimeException ,NumberFormatException{
        if (a < 100) {
            throw new AFormatException(a + "必须要大于等于100!");
        }
        this.a = a;
    }

    public String toString() {
        return "A{a = " + a + "}";
    }
}*/

/**
 * IO12 补 finally
 */
/*
try{}catch()finally{}
finally{}大括号里面代码一定执行(除非JVM提前停止了)

在文件操作中 想要在最后一定执行.close()的释放资源操作
考虑安全的情况下 下面是完整的写法事例

这个过于繁琐 所以JDK7 JDK9后有两次优化
//图片：day02\image\ExceptionAdd.png
优化写法前提：创建的流的对象的类都实现了AutoCloseable接口

了解一下以上内容 实际开发 这些错误基本都直接抛出处理了
 */
/*public class java02 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
             fis = new FileInputStream("D:\\sure_\\JavaFileLearn" +
                    "\\A.mp4");
             fos = new FileOutputStream("D:\\sure_\\JavaFileLearn" +
                    "\\AAA\\B.mp4");
            byte[] b1 = new byte[5*1024*1024];
            int len;
            while ((len = fis.read(b1)) != -1) {
                System.out.println(len);
                fos.write(b1, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}*/

/**
 * 01 File 概述+构造方法
 */
/*
public File(String pathname)               ：通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
public File(String parent, String child)   ：从父路径名字符串和子路径名字符串创建新的 File实例。
public File(File parent, String child)     ：从父抽象路径名和子路径名字符串创建新的 File实例。
 */
/*public class java02 {
    public static void main(String[] args) {
        String s1 = "D:\\sure_\\JavaFileLearn\\001.txt";
        File f1 = new File(s1);
        System.out.println(f1);

        String s2 = "D:\\sure_\\JavaFileLearn";//父路径名
        String s3 = "001.txt";//子路径名
        File f2 = new File(s2 , s3);//因为Linux操作系统文件中间不是'\'隔开的
        System.out.println(f2);     //而是'/' 所以不建议手动拼接 建议采用这种方式构造
                                    //java底层会根据不同的操作系统 提供不同的操作
        File f3 = new File("D:\\sure_\\JavaFileLearn");
        File f4 = new File(f3, s3);
        System.out.println(f4);
    }
}*/

/**
 * 02 File的成员方法 （判断 获取）
 */
/*
public boolean exists()           ：此File表示的文件或目录是否实际存在。
public boolean isDirectory()      ：此File表示的是否为目录。
public boolean isFile()           ：此File表示的是否为文件。
public String getAbsolutePath()   ：返回此File的绝对路径名字符串。
                               //你用相对路径创建一个File对象 可以用这个方法输出这个对象的绝对地址
public String getPath()           ：将此File转换为路径名字符串。
                               //转回来了右
public String getName()           ：返回由此File表示的文件或目录的名称。
public long length()              ：返回由此File表示的文件的长度。
                               //默认返回比特数字节数(btye)
public long lastModified()        ：返回此抽象路径名表示的文件最后一次被修改的时间。
                               //毫秒值
 */
/*public class java02 {
    public static void main(String[] args) {
        File f1 = new File("D:\\sure_\\JavaFileLearn\\001.txt");
        File f2 = new File("D:\\sure_\\JavaFileLearn\\002.txt");
        File f3 = new File("D:\\sure_\\JavaFileLearn\\Files");
        File f4 = new File("D:\\sure_\\JavaFileLearn\\DOOM启示录.pdf");
        File f5 = new File("D:\\sure_\\JavaFileLearn\\Files001646");

        if(f1.exists()){
            System.out.println(f1.getName() + "存在");
            System.out.println(f1.getName() + "是文件吗  " + f1.isFile());
            System.out.println(f1.getName() + "是文件夹吗  " + f1.isDirectory());
        }

        System.out.println(f4.length());
        System.out.println(f1.length());

        //计算文件001的最后一次修改的时间
        long t1 = f1.lastModified();
        Date d1 = new Date(t1);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s2 = sdf1.format(d1);
        System.out.println(s2);

    }
}*/

/**
 * 03 File 的成员方法 （创建 删除）
 */
/*
public boolean createNewFile()  ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
public boolean delete()         ：删除由此File表示的文件或目录。
public boolean mkdir()          ：创建由此File表示的目录。//make directory
public boolean mkdirs()         ：创建由此File表示的目录，包括任何必需但不存在的父目录。
 */
/*public class java02 {
    public static void main(String[] args) throws IOException {
        //createNewFile() 细节1：如果原文件存在 创建失败
        //                      如果源文件不存在 创建成功
        //                细节2：父级路径不存在 方法异常IOException
        //                细节3：创建文件结尾没有后缀名 创建一个没有后缀的文件
        //
        File f1 = new File("D:\\sure_\\JavaFileLearn\\001_create.txt");
        if(f1.createNewFile()){
            System.out.println("原文件不存在 创建成功");
        } else{
            System.out.println("已经有001_create.txt文件了 创建失败");
        }
        File f2 = new File("D:\\sure_\\JavaFileLearn\\001_create");
        f2.createNewFile();

        //mkdir()
        //windows当中路径是唯一的 如果当前路径存在 则无法创建 返回false
        File f4 = new File("D:\\sure_\\JavaFileLearn\\Files_create");
        System.out.println(f2.getName() + "创建是否成功  " + f2.mkdir());
        System.out.println(f4.getName() + "创建是否成功  " + f4.mkdir());

        //mkdirs()
        //还可以创建多级文件夹 逐渐取代mkdir() 底层是mkdir()实现
        File f5 = new File("D:\\sure_\\JavaFileLearn\\Files_create\\com\\shuyaun\\learn");
        System.out.println(f5.getAbsolutePath() + "创建是否成功 " + f5.mkdirs());

        //delete()
        File f6 = new File("D:\\sure_\\JavaFileLearn\\Files");
        System.out.println(f1.delete());
        System.out.println(f2.delete());
        System.out.println(f4.delete());
        System.out.println(f6.delete());
    }
}*/

/**
 * 04 File的成员方法（遍历）
 */
/*
要求掌握：
public File[] listFiles() ：返回一个File数组，表示该File目录中的所有的子文件或目录。

当调用者File表示的路径不存在 返回null
当调用者File表示的路径是文件 返回null
当调用者File表示的路径是一个空文件夹 返回长度为0的数组
当调用者File表示的路径中有隐藏文件 依然可以将隐藏文件返回
当调用者File表示的路径是需要权限才能访问的文件夹 返回null
 */
/*public class java02 {
    public static void main(String[] args) {
        File f1 = new File("D:\\sure_\\JavaFileLearn");
        File[] files = f1.listFiles();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }
}*/

/*
了解：
public static File[] listRoots()                列出可用的文件系统根
public String[] list()                          获取当前该路径下所有内容（名字）
public String[] list(FilenameFilter filter)     利用文件名过滤器获取当前该路径下所有内容
（**--只用掌握--**）public File[] listFiles()-------获取当前该路径下所有内容
public File[] listFiles(FileFilter filter)      利用文件名过滤器获取当前该路径下所有内容
public File[] listFiles(FilenameFilter filter)  利用文件名过滤器获取当前该路径下所有内容
 */
/*public class java02 {
    public static void main(String[] args) {
        File f1 = new File("D:\\sure_\\JavaFileLearn");

        File[] files1 = File.listRoots();
        for (File file : files1) {
            System.out.println(file);
        }
        System.out.println("-------------------");

        String[] s1 = f1.list();
        for (String s : s1) {
            System.out.println(s);
        }
        System.out.println("-------------------");

        String[] s2 = f1.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {//父类路径 子类路径
                return new File(dir,name).isFile() && name.endsWith(".txt");
            }
        });
        for (String s : s2) {
            System.out.println(s);
        }
        System.out.println("-------------------");

        File[] files2 = f1.listFiles();//只有掌握
        for (File file : files2) {
            if (file.getName().endsWith(".txt") && file.isFile()) {
                System.out.println(file);
            }
        }
        System.out.println("-------------------");

        File[] files3 = f1.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });
        for (File file : files3) {
            System.out.println(file);
        }
        System.out.println("-------------------");

        File[] f4 = f1.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isFile() && name.endsWith(".txt");
            }
        });
        for (File file : f4) {
            System.out.println(file);
        }
    }
}*/
//java2\day02\src\EXERCISE\miniProject\mini17
// 遍历所有电脑盘 找.exe文件

/**
 * 01 IO流体系
 */
/*
IO(input output)
IO流的作用：读写数据（本地文件 网络）
IO流的分类：
- 按照流向分：
    输入流：程序->文件 输出流  （以程序为中心）
           文件->程序 输入流
- 按照文件类型分：
    字节流：可以操作所有类型的文件
    字符流：只能操作纯文本文件（用windows自带记事本能打开的文件）
- 大体框架
    图片：day02\image\IO_Frame.png
    注意：这里四个类都是抽象类 下面继承了一些子类
    图片：day02\image\IO_All.png
 */

/**
 * 03 字节流 FileOutputStream
 */
/*
public void write(byte[] b)                    ：将 b.length字节从指定的字节数组写入此输出流。
public void write(byte[] b, int off, int len)  ：从指定的字节数组写入 off->起始位置 len->长度
public abstract void write(int b)              ：将指定的字节输出流。
字节输出流的步骤：
  1.创建字节输出流对象
    如果子级路径不存在 会创建一个文件 但要保证父级路径是存在的
    文件里面已经有信息 再.write(...)会先清空文件 再输入新输入的数据
  2.写数据
    .write(参数是整数) 但实际记录到文件中的是ASCII上对应的字符
  3.释放资源
    每次使用完流都要释放资源 不然程序不停止 文件就等于一直处于打开的状态
 */
/*public class java02 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\sure_\\JavaFileLearn\\001.txt");
        byte[] b1 = {97, 98, 99, 100, 101, 102};
        fos.write(b1);
        fos.write(b1,1,3);
        fos.close();
    }
}*/

/*
--换行--续写
换行： Windows : \r\n
      Linux   : \n
      Mac     : \r
在windows当中 java进行了优化 只要写出任意一个\r或\n java底层都可以将其补全 实现换行
但是建议写完整

续写：创建对象的第二个参数 默认false 传入true 就是打开续写开关
    之后创建对象就不会先清除文件了
 */
/*public class java02 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\sure_\\JavaFileLearn" +
                "\\001.txt",true);
        //输入字符串的小操作
        String s1 = "Hello Fuck";
        String s2 = "Fuck the world";
        String s3 = "Nothing";
        byte[] b1 = s1.getBytes();
        byte[] b2 = s2.getBytes();
        byte[] b3 = s3.getBytes();

        fos.write(b1);
        //换行的操作
        fos.write("\r\n".getBytes());
        fos.write(b2);
        fos.write("\r\n".getBytes());
        fos.write(b3);
        fos.write("\r\n".getBytes());
        fos.close();
    }
}*/

/**
 * 07 IO 字节流 FileInputStream输入流
 */
/*
方法：int 对象.read()
     读不到数据返回-1
     1.如果读取的文件不存在 直接报错
     2.读取完要释放资源
 */
/*
public class java02 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\sure_\\JavaFileLearn" +
                "\\001.txt");
        int n;
        while ((n = fis.read()) != -1) {
            System.out.print((char) n);
        }
        fis.close();
    }
}
*/

/**
 * 09 文件拷贝
 */
//将《Doom启示录》拷贝到AAA文件夹中Doom.pdf
/*public class java02 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\sure_\\JavaFileLearn" +
                "\\DOOM启示录.pdf");
        FileOutputStream fos = new FileOutputStream("D:\\sure_\\JavaFileLearn" +
                "\\AAA\\Doom.pdf");
        int n;
        while ((n = fis.read()) != -1) {
            fos.write(n);
        }
        //注意：先打开的最后关闭
        fos.close();
        fis.close();
    }
}*/

/**
 * 09 文件拷贝的弊端和解决方法
 */
/*
public int read() 一次读一个字节 太慢
--解决-->  public int read(byte[] buffer)
一次读一个数组//返回值->本次读到了多少个字节的数据
注：每次读取都尽可能把数组填满  老师经常规定数组大小5M(5*1024*1024)
 */
//将.mp4文件拷贝到AAA文件夹中
/*public class java02 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\sure_\\JavaFileLearn" +
                "\\Aa水神.mp4");
        FileOutputStream fos = new FileOutputStream("D:\\sure_\\JavaFileLearn" +
                "\\AAA\\Bb水神.mp4");
        byte[] b1 = new byte[5*1024*1024];
        int len;//为什么要记录长度len呢 因为len==-1为结束循环的条件
                //还因为 b1中如果没有读到新数据覆盖原有数组中的数据
                //数组中就还是上次读取到的数据
                //覆盖了一部分(长度为len) 后面还是原有的数据
        while ((len = fis.read(b1)) != -1) {//当读取完毕后 返回长度为-1
            System.out.println(len);
            //System.out.println(new String(b1));//new String(byte[])
            fos.write(b1, 0, len);//从下标0开始输出len长度的数据
        }
        fos.close();
        fis.close();
    }
}*/

/**
 * 013 字符集详解
 * (ASCII GBK Unicode)
 */
/*
ASCII: 用一个字节存储(8个bit位 2^8=256)
GBK: 用两个字节存储
     收录了常用中日韩汉字
     兼容ASCII
     规定汉字规定高位字节二进制首位为1 转成十进制为负数 来区别英文字母
ANSI: wndows简体版用GBK编码规则 但是繁体版 日文版 韩文版
      用的是别的编码 windows厂商把这些编码规则统一用ANSI表示
Unicode: 记录了世界上大多数语言的文字
         这里介绍其中的UTF-8的编码规则：
           ASCII           一个字节记录   0xxxxxxx
           拉丁/叙利亚等文字  两个字节记录   110xxxxx 10xxxxxx
           中日韩等文字      三个字节记录   1110xxxx 10xxxxxx 10xxxxxx
           其他文字         四个字节记录    11110xxx 10xxxxxx 10xxxxxx 10xxxxxx

为什么会出现乱码呢？
1.读取时未读取完整个文字
    用.read()一个字节一个字节读取的时候 遇到UTF-8编码规则编码的汉字
    三个字节为一个汉字 结果一个汉字分为3个字节分别解码 结果必定乱码
    (拷贝时一个一个读也没事 是因为先一个一个按照记事本的规则编码 拷贝存储
    再统一按照记事本规则解码 出来的数据不存在一个个单独解码的情况 结果自然没问题)
2.编码规则和解码规则不一样
 */

/**
 * 16 编码和解码的方法
 */
/*
编码：
public byte[] getBytes()//采取默认编码方式(idea->UTF-8)
public byte[] getBytes(String charsetName)//使用指定方式编码
解码：
String(bytes[] bytes)采取默认编码方式(idea->UTF-8)
String(bytes[], String charsetName)//使用指定方式编码
 */
/*public class java02 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "ai你呦";
        //编码
        byte[] b1 = str.getBytes();
        byte[] b2 = str.getBytes("GBK");
        System.out.println(Arrays.toString(b1));//分析两个输出结果
        System.out.println(Arrays.toString(b2));
        //解码
        System.out.println(new String(b1));//如果编码和解码方式对不上 就会乱码
        System.out.println(new String(b2, "GBK"));
    }
}*/

/**
 * 17 字符流 FileReader
 */
/*
构造方法：
  public FileReader(File file)
  public FileReader(String pathName)
读取数据：
  public int read()              读取单个数据 读到末尾返回-1
  public int read(char[] buffer) 读取多个数据 读到末尾返回-1
释放资源：
  public void close()

注意：这个.read()返回int类型的十进制数字
字节流中的read方法 会按照一个字节一个字节的读取 全部转化为十进制数字
而这个字符流的read方法 会先判断中文或英文
英文读取1个字节 转化为十进制
中文读取三个字节 转化为十进制
默认UTF-8的规则进行解码 但是有的平台是别的规则 想自己选择再查吧

底层读取的时候，执行到fr.read()时会先将文件中的数据读取到缓冲区(8192个字节)中，
尽可能填满缓冲区 填不满用0补 清除文件时 缓冲区不一定比清除
所以清除了文件不代表文件中的内容无法读取 可能读取的是缓冲区中的内容
*/
//.read()/.read(char[])
/*
注意：这里采用了两种不同的读取方法 预期会将文件内容读取并输出两遍
     但是实际仅仅读取输出了一遍 这是因为：
     文件流 fr 只被读取到了一次。
     在第一个 while 循环结束后，文件流的读取指针已经到达了文件的末尾，
     因此在第二个 while 循环中再次尝试读取时，fr.read(chars) 会立即返回 -1，表示没有更多数据可读。
 */
/*public class java02 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\sure_\\JavaFileLearn" +
                "\\002.txt");
        //1
        int n;
        while ((n = fr.read()) != -1) {
            System.out.print((char) n);//这里已经按照UTF-8的规则转成了相应十进制
        }                                //直接强制类型转换即可得到对应字符
                                         //是read方法内部转的
                                         //详细看上面笔记
        //2
        char[] chars = new char[2];//两个两个截取(字符)
        int len;
        while ((len = fr.read(chars)) != -1) {
            System.out.print(new String(chars,0,len));
        }//已经将字符串放入chars数组中 不用再手动强制类型转换
        fr.close();
    }
}*/

/**
 * 19 字符流 FileWriter
 */
/*
构造方法：
public FileWriter(File file)：              创建一个新的 FileWriter，给定要读取的File对象。
public FileWriter(String fileName)：        创建一个新的 FileWriter，给定要读取的文件的名称。
public FileWriter(File file, boolean append)：       以上两种的续写~
public FileWriter(String fileName, boolean append)：

成员方法：
void write(int c)                                    写入单个字符。
void write(char[] cbuf)                              写入字符数组。
abstract  void write(char[] cbuf, int off, int len)  写入字符数组的某一部分,off数组的开始索引,len写的字符个数。
void write(String str)                               写入字符串。
void write(String str, int off, int len)             写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
void flush()                                         刷新该流的缓冲。
void close()                                         关闭此流，但要先刷新它。

底层有一个缓冲区 写入的内容先存在缓冲区中
只有发生以下几种情况缓冲区的内容才会存到本地：
1.缓冲区装满了
2.手动刷新 flush(刷新完还能继续写入)
3.关闭文件 close(关闭了就不能再写入了)
 */
//29233----爱
//20320----你
//21606----呦
/*public class java02 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("D:\\sure_\\JavaFileLearn\\003.txt");
        fw.write(29233);//utf-8编码规则 这个字占3字节 可在文件属性中查看
        fw.write("草泥马的");//共15个字节
        fw.close();
    }
}*/

/**
 * 22 练习
 */
//练习1：拷贝文件夹
//day02\src\EXERCISE\miniProject\mini18
/*
 ^ --> 异或操作符
 相同->true
 不同->false
 两个整数异或 先分别转换为二进制 相同->1 不同->0
 一个数a 异或 同一个数b(任意) 两次，结果还是a
 */

//练习2：文件加密
//先加密: DOOM启示录.pdf --> dxxm.pdf
//再解密: dxxm.pdf --> doom.pdf
//解密只要改变一下fis fos变量名就行
//下面的是解密的代码
/*public class java02 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\sure_\\JavaFileLearn\\dxxm.pdf");
        FileOutputStream fos = new FileOutputStream("D:\\sure_\\JavaFileLearn\\doom解码.pdf");
        int n;
        while ((n = fis.read()) != -1) {
            fos.write(n ^ 2);
        }
        fos.close();
        fis.close();
    }
}*/

//练习3：读取文件004.txt中的数据并排序放回
//数据：15-2-5-1-4-9-2-3
/*
public class java02 {
    public static void main(String[] args) throws IOException {
        //1.将数据读取到变量sb(StringBuilder)中
        FileInputStream fis = new FileInputStream("D:\\sure_\\JavaFileLearn\\004数字排序.txt");
        StringBuilder sb = new StringBuilder();
        int n;
        while ((n = fis.read()) != -1) {
            sb.append((char) n);
        }
        System.out.println(sb.toString());
        fis.close();
        //2.将读取到的数据转化为Integer类型并进行排序
        String[] split = sb.toString().split("-");
        ArrayList<Integer> al = new ArrayList<>();
        for (String s : split) {
            al.add(Integer.parseInt(s));
        }
        Collections.sort(al, ((o1, o2) -> o1 - o2));
        System.out.println(al);
        //3.将数据转化为String类型并放入文件中
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < al.size(); i++) {
            if(i==al.size()-1){
                sb2.append(al.get(i));
            } else{
                sb2.append(al.get(i) + "-");
            }
        }
        String str = sb2.toString();
        FileWriter fw = new FileWriter("D:\\sure_\\JavaFileLearn\\004数字排序.txt");
        fw.write(str);
        fw.close();
    }
}
*/
//上一题的骚操作
/*public class java02 {
    public static void main(String[] args) throws IOException {
        //1.将数据读取到变量sb(StringBuilder)中
        FileInputStream fis = new FileInputStream("D:\\sure_\\JavaFileLearn\\004数字排序.txt");
        StringBuilder sb = new StringBuilder();
        int n;
        while ((n = fis.read()) != -1) {
            sb.append((char) n);
        }
        System.out.println(sb.toString());
        fis.close();
        //2.将读取到的数据转化为Integer类型并进行排序
        Integer[] array = Arrays.stream(sb.toString()
                        .split("-"))
                .map(Integer::parseInt)//方法引用
                .sorted()//默认升序排序
                .toArray(new IntFunction<Integer[]>() {
                    @Override
                    public Integer[] apply(int value) {
                        return new Integer[value];
                    }
                });
        //注意这里 数组要用Arrays工具类的toString才能得到想要的格式
        System.out.println(Arrays.toString(array));
        //3.将数据转化为String类型并放入文件中
        String sub1 = Arrays.toString(array)
                .replace(", ", "-");
        System.out.println(sub1);
        //这里必须重新创建一个sub变量 不然sub1.length()得不到
        String sub = sub1.substring(1, sub1.length() - 1);
        //正常写入
        FileWriter fw = new FileWriter("D:\\sure_\\JavaFileLearn\\004数字排序.txt");
        fw.write(sub);
        fw.close();
    }
}*/

/**
 * 25 高级流--缓冲流(字节)--BufferedInputStream
 *                      --BufferedOutputStream
 */
/*
 public BufferedInputStream(InputStream in)：    创建一个 新的缓冲输入流。
 public BufferedOutputStream(OutputStream out)： 创建一个新的缓冲输出流。

 1.高级流只是基本流的包装 内部干活的还是基本流
 2.缓冲区大小默认8192 可以在构造方法后面加上整数 手动规定缓冲区大小
 3.缓冲流可以提高效率
 */
//将a.txt拷贝 得到b.txt
/*public class java02 {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("day02\\src\\File\\a.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("day02\\src\\File\\b.txt"));

        //操作1个字节
        //int n;
        //while ((n = bis.read()) != -1) {
        //bos.write(n);
        //}
        //bos.close();//只关闭缓冲流就行 方法内部会把基本流也关闭了
        //bis.close();

        //操作多个字节
        byte[] b1 = new byte[1024];
        int len;
        while ((len = bis.read(b1)) != -1) {
            bos.write(b1, 0, len);
        }
        bos.close();
        bis.close();
    }
}*/

/**
 * 28 高级流--缓冲流字符 --BufferedReader
 *                   --BufferedWriter
 */
/*
构造方法
  public BufferedReader(Reader in) ：创建一个 新的缓冲输入流。
  public BufferedWriter(Writer out)： 创建一个新的缓冲输出流。
特有方法
  字符缓冲流的基本方法与普通字符流调用方式一致，不再阐述，我们来看它们具备的特有方法。
  BufferedReader：public String readLine(): 读一行文字。 读不到数据返回null
  BufferedWriter：public void newLine(): 换行，多系统适应

注意：1.下次写开关的书写位置
     2.字符输入输出流已经有缓冲区了，因此其缓冲流效率提高不大
       但是两个特有方法比较便利
 */
/*public class java02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("day02\\src\\File\\a.txt"));
        String str;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter("day02\\src\\File\\b.txt", true));
        bw.write("hahaha 我们的友谊坚不可摧！");
        bw.newLine();
        bw.write("lalala 我是个sb！");
        bw.newLine();
        bw.close();
    }
}*/

/**
 * 缓冲流 - exercise
 */
/*
使用IO流原则：随用随创建，不用记得要关闭
           否则可能出现一些奇怪的bug
           比如对同一个文件同时开启读取和输入通道，文件可能因为输入通道没有续写开关而清空
           导致无法读取到文件中的数据。（拷贝操作不会有这种bug，因为同时操作的不是同一个文件）
 */
//day02/src/EXERCISE/miniProject/mini19

/**
 * 32 转换流(字符流中) InputStreamReader
 *                  OutputStreamReader
 */
/*
1.实现不同编码文件间的读取 输入 克隆等操作
2.将字节流"转化"为字符流 再进行操作
//注意参数是字节流
InputStreamReader(InputStream in, String charsetName)
 int read()                                    //读取单个字符。
 int read(char[] cbuf, int offset, int length) //将字符读入数组中的某一部分。

 OutputStreamWriter(OutputStream out, String charsetName)
 void write(char[] cbuf, int off, int len)     //写入字符数组的某一部分。
 void write(int c)                             //写入单个字符。
 void write(String str, int off, int len)      //写入字符串的某一部分
 */

//读取GBK文件中的数据(包含中文)并输出
//此方法JDK11被FileReader中的操作替代，在本课13:08有演示
/*public class java02 {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(
                new FileInputStream("day02\\src\\File\\gbk01.txt"),
                "GBK");
        int a;
        while ((a = isr.read()) != -1) {
            System.out.print((char) a);
        }
        isr.close();
    }
}*/

//在GBK文件中写入一段中文句子
/*public class java02 {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(
                new FileOutputStream("day02\\src\\File\\gbk01.txt",true),
                "GBK");
        String str = "要爱舒源一辈子！";
        osw.write(str);
        osw.close();
    }
}*/

//克隆GBK成UTF-8文件
/*public class java02 {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(
                new FileInputStream("day02\\src\\File\\gbk01.txt"),
                "GBK");
        OutputStreamWriter osw = new OutputStreamWriter(
                new FileOutputStream("day02\\src\\File\\UTF-8.txt"),
                "UTF-8");
        int n;
        while ((n = isr.read()) != -1) {
            osw.write(n);
        }
        osw.close();
        isr.close();
    }
}*/

//execise: 用字节流读取中文 (读取01.txt文件中的内容并输出)
/*public class java02 {
    public static void main(String[] args) throws IOException {
        //BufferedReader参数是Reader类型，所以可以用InputStreamReader转换字节流作为参数
        BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream("day02/src/File/a.txt")));
        String str;
        while((str = br.readLine()) != null){
            System.out.println(str);
        }
        br.close();
    }
}*/

/**
 * 34 序列化流(字节流中) ObjectOutputStream
 */
/*
    把对象记录到本地文件内(以类似乱码的形式，需要用反序列化流读取)
	ObjectOutputStream(OutputStream out)
	writeObject(Object obj)    将指定的对象写入ObjectOutputStream。
 */
//将Stu对象写入object.txt文件中
//运行这段代码，要先取消下面Student类的注释
/*public class java02 {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("day02/src/File/object.txt"));
        Student s1 = new Student(18, "王五");//这里尽量不写中文
        oos.writeObject(s1);
        oos.close();
    }
}*/

//Serializable接口中没有抽象方法,是标记型接口
//一旦实现了这个接口就表示Student类可以被序列化、
/*class Student implements Serializable{
    //自定义版本号
    //经过设置(36 -- 06:19)，不写有警报，alt insert可自动生成
    //(文件尽量只有一个类且这个类实现了Serializable接口)
    private static final long serialVersionUID = 1L;

    private int age;
    private String name;
    private long id;

    public Student() {
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}*/

/**
 * 35 反序列化流 ObjectInputStream
 */
/*
public ObjectInputStream(InputStream in)： 创建一个指定InputStream的ObjectInputStream
public final Object readObject ():         读取一个对象。

当在文件中录入对象信息后，再修改class对象类的代码，
会导致类的版本号变化，使得无法正确读取文件中的信息，
因此，可以手动规定一个类的版本号来规避这种版本号变化的问题，如上面类

下面代码录入信息时，类中没有id的成员变量
读取信息前，修改类中代码，增加了id的成员变量
 */
//运行这段代码，要先取消上面Student类的注释
/*public class java02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //在文件中录入对象信息
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("day02/src/File/object.txt"));
        Student s1 = new Student(18, "王五");//这里尽量不写中文
        oos.writeObject(s1);
        oos.close();
        //读取文件中对象信息
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("day02/src/File/object.txt"));
        Object o1 = ois.readObject();
        System.out.println(o1);
        ois.close();
    }
}*/

//这个类和上面那个类略有差别，可以让age这个值不序列化到本地
/*class Student implements Serializable{
    private static final long serialVersionUID = 1L;

    //transient 瞬态关键字，不会把这个属性序列化到本地文件中
    private transient int age;
    private String name;
    private long id;

    public Student() {
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //输出得age一定为0，因为age无法被序列化，得不到，默认为0
    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}*/

/**
 * 37 序列化流 exercise
 */
/*
一个文件存多个相同类对象时
读取时可能不确定对象的个数
因此建议先将对象装进ArrayList集合中，再将集合写入文件
读取时，只读取一个集合
 */
//day02/src/EXERCISE/miniProject/mini20

/**
 * 38 字节打印流 PrintStream(字节流中)
 *   (java占位符)//day02/src/EXERCISE/miniProject/mini21
 */
 /*
字节打印流：
  构造方法
     public PrintStream(OutputStream/File/String)            关联字节输出流/文件/文件路径
     public PrintStream(String fileName, Charset charset)    指定字符编码
     public PrintStream(OutputStreamout, boolean autoFlush)  自动刷新
     public PrintStream(OutputStream out, boolean autoFlush, String encoding)    指定字符编码且自动刷新
  成员方法：
     public void write(int b)            常规方法：规则跟之前一样，将指定的字节写出
     public void println(Xxx xx)         特有方法：打印任意数据，自动刷新，自动换行
     public void print(Xxx xx)           特有方法：打印任意数据，不换行
     public void printf(String format, Object... args)   特有方法：带有占位符的打印语句，不换行
    */
/*public class java02 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        //这里的自动刷新应该是和刷新的方式和效率有关，和续写开关不一样
        PrintStream out = new PrintStream(
                new FileOutputStream("day02/src/File/print.txt")
        ,true, "UTF-8");//Charset.forName("UTF-8")的写法是在JDK11开始的
        out.println(97);
        out.print(true);
        out.println();
        out.printf("%s 爱上了 %s", "曼布", "哈基米");
        out.close();
    }
}*/

/**
 * 39 字符打印流 PrintWriter
 */
/*
字符打印流：
构造方法
    public PrintWriter(Write/File/String)                  关联字节输出流/文件/文件路径
    public PrintWriter(String fileName, Charset charset)    指定字符编码
    public PrintWriter(Write, boolean autoFlush)            自动刷新  --> (常用)
    public PrintWriter(Write out, boolean autoFlush, String encoding)    指定字符编码且自动刷新
成员方法：
    public void write(int b)                            常规方法：规则跟之前一样，将指定的字节写出
    public void println(Xxx xx)                         特有方法：打印任意数据，自动刷新，自动换行
    public void print(Xxx xx)                           特有方法：打印任意数据，不换行
    public void printf(String format, Object... args)   特有方法：带有占位符的打印语句，不换行
 */
//和前面那个字节流差不多，区别是：
//字符流底层有缓冲区，想要自动刷新需要开启
/*public class java02 {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(
                "day02/src/File/PrintWriter.txt"),true);
        pw.println("good night!");
        pw.close();
    }
}*/

/**
 * 40 解压缩流 ZipInputStream (字节流)
 */
//使用方法请看代码： 将Music,zip解压到dest路径所指文件夹内
/*public class java02 {
    public static void main(String[] args) throws IOException{
        //这个压缩包中文件的文件名不能包含中文
        //压缩包必须要是.zip格式的
        File src = new File("day02/src/ZipFile/Music.zip");
        File dest = new File("day02/src/ZipFile/");
        ZipInputStream zip = new ZipInputStream(new FileInputStream(src));
        ZipEntry ze;
        while((ze = zip.getNextEntry()) != null){
            System.out.println(ze);
            if(ze.isDirectory()){//文件夹
                File pf = new File(dest, ze.toString());
                pf.mkdirs();
            } else{//文件
                FileOutputStream fos = new FileOutputStream(new File(dest,ze.toString()));
                int b;
                while((b = zip.read()) != -1){
                    fos.write(b);
                }
                fos.close();
                zip.closeEntry();
            }
        }
        zip.close();
    }
}*/

/**
 * 41 压缩流 ZipOutputStream (字节流)
 */
//压缩单个文件--将a.txt文件压缩
/*public class java02 {
    public static void main(String[] args) throws IOException {
        File src = new File("day02/src/ZipFile/a.txt");
        //这里包含了压缩后文件夹位置+搜索文件名a.zip
        File dest = new File("day02/src/ZipFile/");

        //报错，因为dest + "a.zip" 结果是day02\src\ZipFilea.zip
        //ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(dest + "a.zip"));
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File(dest, "a.zip")));
        ZipEntry entry = new ZipEntry("a.txt");
        zos.putNextEntry(entry);

        FileInputStream fis = new FileInputStream(src);
        int n;
        //这里write的对象是ZipOutputStream而不是ZipEntry
        //说明ZipEntry是起到定框架和确定记录数据位置(是哪个文件)的作用
        while((n = fis.read()) != -1) {
            zos.write(n);
        }
        fis.close();
        zos.closeEntry();
        zos.close();
    }
}*/

//压缩整个文件夹 将aaa文件夹压缩
/*public class java02 {
    public static void main(String[] args) throws IOException {
        //需要压缩的文件夹地址
        File src = new File("day02/src/ZipFile/aaa");
        //压缩后的压缩包父级路径
        File destParent = src.getParentFile();
        File dest = new File(destParent, src.getName() + ".zip");
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(dest));
        toZip(zos, src, src.getName());
    }

    public static void toZip(ZipOutputStream zos,File src,String name) throws IOException {
        File[] files = src.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                toZip(zos, file, name + "/" + file.getName());
            } else{
                ZipEntry entry = new ZipEntry(name + "/" + file.getName());
                zos.putNextEntry(entry);
                FileInputStream fis = new FileInputStream(file);
                int n;
                while ((n = fis.read()) != -1) {
                    zos.write(n);
                }
                fis.close();
                zos.closeEntry();
            }
        }
    }
}*/

/**
 * 43 常用工具包 Commons-io
 */
/*
引入的工具包(包含文件&IO操作)：
day02/src/lib/commons-io-2.11.0.jar

工具包的详细用法：
day02/src/libHelp/commons-io整理的文档.md

部分常用方法：
leUtils类
    static void copyFile(File srcFile, File destFile)                   复制文件
    static void copyDirectory(File srcDir, File destDir)                复制文件夹(复制src中的文件到dest文件夹)
    static void copyDirectoryToDirectory(File srcDir, File destDir)     复制文件夹(将整个src复制到dest文件夹)
    static void deleteDirectory(File directory)                         删除文件夹
    static void cleanDirectory(File directory)                          清空文件夹
    static String readFileToString(File file, Charset encoding)         读取文件中的数据变成成字符串
    static void write(File file, CharSequence data, String encoding)    写出数据
IOUtils类
    public static int copy(InputStream input, OutputStream output)      复制文件
    public static int copyLarge(Reader input, Writer output)            复制大文件
    public static String readLines(Reader input)                        读取数据
    public static void write(String data, OutputStream output)          写出数据
 */
//随意实验
/*public class java02 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("D:\\sure_\\JavaFileLearn\\newPlaces\\004数字排序.txt");
        List<String> strings = IOUtils.readLines(fr);
        fr.close();
        strings.forEach(s-> System.out.println(s));
    }
}*/

/**
 * 44 常用工具包 hutool
 */
/*
引入的工具包(包含文件&IO操作)：
day02/src/lib/hutool-all-5.8.16.jar

工具包的详细用法：
day02/src/libHelp/hutool-help.txt

部分常用方法：
  FileUtil类:
    file：根据参数创建一个file对象
    touch：根据参数创建文件(创建文件 父级路径不存在 可以帮助创建父级路径)
    writeLines：把集合中的数据写出到文件中，覆盖模式。
    appendLines：把集合中的数据写出到文件中，续写模式。
    readLines：指定字符编码，把文件中的数据，读到集合中。
    readUtf8Lines：按照UTF-8的形式，把文件中的数据，读到集合中
    copy：拷贝文件或者文件夹

注意：hutool包下有FileReader FileWriter类，使用时记得导包
*/

/**
 * 01 多线程
 */
/*
进程：一个运行的程序(任何进程都可以同其他进程一起并发执行)
线程：进程中的一部分 一个执行单元

并发：在同一时刻，有多个指令在单个CPU上交替执行。
并行：在同一时刻，有多个指令在多个CPU上同时执行。

实现多线程的方式：
1.继承Thread类
2.实现Runnable接口
3.实现Callable接口
 */

/**
 * 03 多线程 Thread实现方式
 */
/*
启动多线程的步骤：
1.自定义一个类 继承Thread类
2.重写run方法
3.创建对象 调用start方法 启动线程
 */
/*class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.getName() + "hello fuck");
        }
    }
}

public class java02 {
    public static void main(String[] args) {
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        t1.setName("线程1: ");
        t2.setName("线程2: ");
        t1.start();//注意这里调用的是start方法
        t2.start();
    }
}*/

/**
 * 04 多线程 实现Runnable接口 的实现方式
 */
/*
  多线程的第二种启动方式：
    1.自己定义一个类实现Runnable接口
    2.重写里面的run方法
    3.创建自己的类的对象
    4.创建一个Thread类的对象(传参自己的类的对象)
      并调用start方法开启线程
 */
/*class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //获取当前线程的对象
            System.out.println(Thread.currentThread().getName()
                    + "fuck you  " + i);
        }
    }
}
public class java02 {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();

        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);

        t1.setName("线程1：");
        t2.setName("线程2：");

        t1.start();
        t2.start();
    }
}*/

/**
 * 05 多线程 实现Callable接口 的实现方式
 *        (可以获取多线程运行结果)
 */
/*
  多线程的第三种实现方式：
      特点：可以获取到多线程运行的结果

      1. 创建一个类MyCallable实现Callable接口
      2. 重写call （是有返回值的，表示多线程运行的结果）

      3. 创建MyCallable的对象（表示多线程要执行的任务）
      4. 创建FutureTask的对象（作用管理多线程运行的结果）
      5. 创建Thread类的对象，并启动（表示线程）
 */

//这里<>里面表示返回值的数据类型
/*class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        //返回1-100的和
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}

public class java02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable mc = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<>(mc);
        new Thread(ft).start();
        System.out.println(ft.get());//5050
    }
}*/

/**
 * 06 多线程常用的成员方法
 */
/*
String getName()                    返回此线程的名称
void setName(String name)           设置此线程的名称
static Thread currentThread()       获取当前线程的对象
static void sleep(long time)        让线程休眠指定的时间，单位为毫秒

细节：
  1.如果我们没有给线程设置名字，线程也是有默认的名字的
     格式：Thread-X（X序号，从0开始的）
  2.如果我们要给线程设置名字，可以用set方法进行设置，也可以构造方法设置
  3. 当JVM虚拟机启动之后，会自动的启动多条线程
                其中有一条线程就叫做main线程
                他的作用就是去调用main方法，并执行里面的代码
                在以前，我们写的所有的代码，其实都是运行在main线程当中
 */
//细节部分代码演示：
/*class MyThread extends Thread {
    public MyThread() {
    }

    //2.
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            //sleep方法的使用
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName() + " " + i);
        }
    }
}

public class java02 {
    public static void main(String[] args) {
        //3.
        Thread t1 = Thread.currentThread();
        System.out.println(t1.getName());

        MyThread t2 = new MyThread("线程01：");
        //1.
        MyThread t3 = new MyThread();

        t2.start();
        t3.start();
    }
}*/

/**
 * 07 线程优先级
 */
/*
线程的调度方式：
  1.抢占式调度(java)  -->有随机性
  2.非抢占式调度      -->不是随机的

相关成员方法：
setPriority(int newPriority)        设置线程的优先级
final int getPriority()             获取线程的优先级

注意：设置的优先级在1-10之间 值越高，调度的随机概率越大
     如果不设置优先级，线程默认优先级是5
 */
/*class MyRunnable implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        for (int i = 1; i <= 20; i++) {
            System.out.println(t.getName() + "  fuck you  " + i);
        }
    }
}
public class java02 {
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable();
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(Thread.currentThread().getPriority());

        t1.setPriority(10);
        t2.setPriority(1);

        //t1优先级高，大概率t1的进程先运行完(先到20)
        t1.start();
        t2.start();
    }
}*/

/**
 * 08 守护线程
 */
/*
final void setDaemon(boolean on)  设置为守护线程

守护线程也可以叫做备胎线程(戏称)
当主线程执行完毕，备胎线程就算没有执行完，也要结束
细节：备胎被抛弃需要一个反应时间，所以备胎线程不会立刻结束，而是还会执行一部分
(实际因为收到被抛弃的信息需要时间，信息传输过程中执行了一部分)
 */
/*class Handsome extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("集帅 @ " + i);
        }
    }
}

class Dreamer extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("幻想集美 @ " + i);
        }
    }
}

public class java02 {
    public static void main(String[] args) {
        Handsome t1 = new Handsome();
        Dreamer t2 = new Dreamer();

        //设置t2为守护线程
        t2.setDaemon(true);

        t1.start();
        t2.start();
    }
}*/

/**
 * 09 出让线程/礼让线程
 */
/*
public static void yield() 出让线程/礼让线程(注意书写位置)
 */
/*class MyTread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(getName() + "  " + i);
            //这个方法写在创建多线程的自定义类中
            //表示出让现在CPU的执行权
            //效果是：这个程序中，让坦克和步兵两个线程结果尽量均匀
            //但是不一定绝对坦克步兵交叉输出
            Thread.yield();
        }
    }
}
public class java02 {
    public static void main(String[] args) {
        MyTread t1 = new MyTread();
        MyTread t2 = new MyTread();

        t1.setName("步兵");
        t2.setName("坦克");

        t1.start();
        t2.start();
    }
}*/

/**
 * 10 插入线程
 */
/*
  public final void join() 插入线程/插队线程
 */
/*class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("MyThread: " + i);
        }
    }
}
public class java02 {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        t1.start();

        //不加这个，t1线程和main线程交替输出
        //加了之后，表示把t1这个线程放在当前线程之前，先运行
        //当前线程：main线程
        t1.join();

        for (int i = 1; i <= 20; i++) {
            System.out.println("main: " + i);
        }
    }
}*/

/**
 * 11 线程的生命周期
 */
//笔记图片路径：day02/image/线程的生命周期.png（不全 完全看 线程的状态.png）

/**
 * 12 线程的安全问题 同步代码块
 */
/*
ctrl+d      复制本行，并粘贴到下一行
ctrl+alt+t  划住,生成异常处理方式或for,if等
ctrl+alt+m  自动生成一个函数
 */
//3个窗口卖票 共100张票
/*class MyThread extends Thread {
    private static int ticket = 1;
    static Object object = new Object();

    public MyThread(String name) {
        super(name);
    }

    public MyThread() {
    }

    @Override
    public void run() {
        while (true) {
            //同步代码块
            //没有的话 很出现多个输出相同的ticket，ticket大于100等情况
            //因为线程的执行有随机性
            //这里object位置多写MyThread.class 表示当前类的字节码文件对象 因为这个对象一定是唯一的
            //注意synchronized一定不能加在while外面，否则结果一定是窗口一独自卖完100张票
            synchronized (object) {//这个object可以是任意类的任意对象
                if(ticket <= 100) {//但是一定要是唯一的(static修饰)
                    System.out.println(this.getName() + "卖出第" + ticket + "张票");
                    ticket++;
                } else {
                    break;
                }
            }
        }
    }
}
public class java02 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("窗口1");
        MyThread t2 = new MyThread("窗口2");
        MyThread t3 = new MyThread("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}*/

/**
 * 15 同步方法
 */
/*
同步方法格式：private synchronized void show(){}
特点：1.同步方法是锁住方法中所有的代码
     2.锁对象不能自己指定  非静态方法：this
                        静态方法：当前类的字节码文件
书写技巧：先写同步代码块，再选中sychronized中所有的代码，
        按住ctrl+alt+m 自动生成一个函数
        然后修改函数的名字(生成的函数的 主函数调用处的)
        在生成的函数修饰符后加上synchronized
        删去原来函数中的synchroized结构

StringBuilder & StringBuffer 区别：
二者所有方法相同，但是StringBuffer所有方法都是同步方法 线程安全
StringBuilder线程不安全 但是效率高些
 */
//上一个题目的同步方法解决方式
/*class MyRunnable implements Runnable {
    private int ticket = 0;

    @Override
    public void run() {
        while (true) {
            if (method()) break;
            //这个sleep如果放在同步方法里面，不会起到去重的作用
            //因为就算指望在执行的线程被阻塞了，也不会影响其被其他线程抢走执行权
            //因为它在synchronized的同步代码中，线程安全
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private synchronized boolean method() {
        if (ticket == 100) {
            return true;
        } else {
            //这里sleep方法的使用是为了让结果更容易出现窗口123交替卖票的情况
            ticket++;
            System.out.println(Thread.currentThread().getName() + "  " + ticket);
        }
        return false;
    }
}

public class java02 {
    public static void main(String[] args) {
        MyRunnable mr = new MyRunnable();
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);
        Thread t3 = new Thread(mr);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}*/

/**
 * 16 lock锁
 */
/*
虽然我们可以理解同步代码块和同步方法的锁对象问题，
但是我们并没有直接看到在哪里加上了锁，在哪里释放了锁，
为了更清晰的表达如何加锁和释放锁，JDK5以后提供了一个新的锁对象Lock

ReentrantLock()  创建一个ReentrantLock对象

void lock()     获得锁
void unlock()   释放锁
 */
//上一个题目的lock锁解决方式
/*
class MyThread extends Thread {

    private static int ticket = 1;
    static Object object = new Object();
    //锁对象是唯一的，只能有一个，这里创建了3个MyThread对象
    //因此必须加上static
    static Lock lock = new ReentrantLock();

    public MyThread(String name) {
        super(name);
    }

    public MyThread() {
    }

    @Override
    public void run() {
        //传统写法：
        //while(true){lock.lock(); ...... lock.unlock();}
        //在省略号处加入if(){}else{}
        //但是这样的话，最后else中break跳出循环后，没有执行lock.unlock()的代码
        //导致无法解锁，程序无法停止运行
        //如果在break前加上一个unlock的代码，那么这行代码就重复出现了2次，不美观
        //以下写法利用finally的特性，是标准写法
        //选中...部分(if else部分)，按住ctrl+alt+t,并适当修改
        while (true) {
            try {
                lock.lock();
                if (ticket <= 100) {
                    Thread.sleep(10);
                    System.out.println(this.getName() + "卖出第" + ticket + "张票");
                    ticket++;
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                //这段代码一定执行
                lock.unlock();
            }
        }
    }
}

public class java02 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("窗口1");
        MyThread t2 = new MyThread("窗口2");
        MyThread t3 = new MyThread("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
*/

/**
 * 18 等待唤醒机制
 */
/*
可以使得两个不同线程交替执行，不再是随机执行

使用到Object类中的方法：
void wait()       导致当前线程等待，直到另一个线程调用该对象的 notify()方法或 notifyAll()方法
void notify()     唤醒正在等待对象监视器的单个线程
void notifyAll()  唤醒正在等待对象监视器的所有线程  //前者有随机性 大多情况使用这个
 */

//实现厨师线程做面 吃货线程吃面 共计吃完10碗面
/*class Desk{
    //桌子上现有食物数量 (规定只能为1或0)
    static int flagFood = 0;
    //已经吃掉的食物数量
    static int foodCount = 0;
    //锁对象
    static Object myLock = new Object();
}

class Foodie extends Thread{
    @Override
    public void run() {
          while(true){
              synchronized (Desk.myLock){
                  //判断已经吃的食物总数是否到10
                  if(Desk.foodCount == 10){
                      break;
                  }
                  else {
                      //桌上有吃的->吃->修改桌上实时食物数量 & 已经吃掉的食物总数
                      if(Desk.flagFood == 1){
                          Desk.foodCount++;
                          Desk.flagFood = 0;
                          System.out.println(this.getName() + "吃了一份食物  总共吃掉了" + Desk.foodCount + "份食物");
                          //吃完了 唤醒厨师去做（唤醒和myLock这个锁绑定的所有方法）
                          Desk.myLock.notifyAll();
                      }
                      //桌上没吃的->等待
                      else {
                          try {
                              //将当前线程和锁进行绑定，等会唤醒和这个锁绑定的所有方法
                              Desk.myLock.wait();
                          } catch (InterruptedException e) {
                              throw new RuntimeException(e);
                          }
                      }
                  }
              }
          }
    }
}

class Cooker extends Thread{
    @Override
    public void run() {
        while(true){
            synchronized (Desk.myLock){
                //判断已经吃的食物总数是否到10
                if(Desk.foodCount == 10){
                    break;
                }
                else {
                    //桌子上有吃的->等待
                    if(Desk.flagFood == 1){
                        try {
                            Desk.myLock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    //桌子上没有吃的->制作一份放桌上->修改实时食物数量->唤醒吃货
                    else {
                        Desk.flagFood = 1;
                        System.out.println(this.getName() + "制作一份食物");
                        //唤醒和myLock这个锁绑定的所有方法
                        Desk.myLock.notifyAll();
                    }
                }
            }
        }
    }
}

public class java02 {
    public static void main(String[] args) {
        Cooker cooker = new Cooker();
        Foodie foodie = new Foodie();

        cooker.setName("厨师");
        foodie.setName("吃货");

        cooker.start();
        foodie.start();
    }
}*/

/**
 * 21 阻塞队列实现等待唤醒机制
 */
/*
+ 常见BlockingQueue(继承于Queue):
  ArrayBlockingQueue: 底层是数组,有界
  LinkedBlockingQueue: 底层是链表,无界.但不是真正的无界,最大为int的最大值
+ BlockingQueue的核心方法:
  put(anObject): 将参数放入队列,如果放不进去会阻塞
  take(): 取出第一个数据,取不到会阻塞
 */
/*public class java02 {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> al = new ArrayBlockingQueue<>(1);
        Cook c1 = new Cook(al);
        Foodie f1 = new Foodie(al);
        c1.start();
        f1.start();
        //这个输出数据会存在同时放两次或者拿两次的问题
        //这个是因为put take方法内部有lock锁
        //所以输出代码在lock锁之外导致输出异常，其实数据是没问题的，只是输出异常
    }
}

class Cook extends Thread{
    ArrayBlockingQueue<String> queue;

    public Cook(ArrayBlockingQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                queue.put("面条");
                System.out.println("放一碗面条");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Foodie extends Thread{
    ArrayBlockingQueue<String> queue;

    public Foodie(ArrayBlockingQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                queue.take();
                System.out.println("拿走一碗面条");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}*/

/**
 * 22 多线程的6种状态
 */
/*
图片资料：
day02\image\线程的状态.png

图片资料中包含7种状态 但是实际上没有java虚拟机运行的状态
因为运行状态实际虚拟机把线程交给操作系统处理了 因此不存在实际的运行状态

官方资料api帮助文档搜索 Thread.State
 */

/**
 * 23 多线程拓展
 */
/*
笔记位置：D:\sure_\Documents\黑马资料\java进阶-资料\day32-多线程&juc\笔记
 */

/**
 * 29 线程池
 */
/*
1.核心原理：
- 创建一个空池子
- 向池子提交任务，池子会创建新线程对象，任务执行完毕，线程归还给线程池，
  下回再次提交任务，不需要创建新的线程，直接复用已有的线程即可
- 再次提交任务，如果没有空闲的线程，也无法创建新线程，任务就会排队等待
2.创建线程池
我们可以使用Executors中所提供的**静态**方法来创建线程池：
static ExecutorService newCachedThreadPool()   创建一个默认的线程池(最多)
static newFixedThreadPool(int nThreads)	    创建一个指定最多线程数量的线程池
 */
/*class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "   " + i);
        }
    }
}
public class java02 {
    public static void main(String[] args) {
        //最多同时存在3个线程
        ExecutorService pool1 = Executors.newFixedThreadPool(3);
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());

        //销毁线程池--不常用
        pool1.shutdown();
    }
}*/

/**
 * 30 自定义线程池
 */
/*
1. 七个参数的解析：
corePoolSize：   核心线程的最大值，不能小于0
maximumPoolSize：最大线程数，不能小于等于0，maximumPoolSize >= corePoolSize
keepAliveTime：  空闲线程最大存活时间,不能小于0
unit：           时间单位
workQueue：      任务队列，不能为null
threadFactory：  创建线程工厂,不能为null
handler：        任务的拒绝策略,不能为null
2. 4种拒绝策略
ThreadPoolExecutor.AbortPolicy: 		    丢弃任务并抛出RejectedExecutionException异常。是默认的策略。
ThreadPoolExecutor.DiscardPolicy： 		   丢弃任务，但是不抛出异常 这是不推荐的做法。
ThreadPoolExecutor.DiscardOldestPolicy：    抛弃队列中等待最久的任务 然后把当前任务加入队列中。
ThreadPoolExecutor.CallerRunsPolicy:        调用任务的run()方法绕过线程池直接执行。
 */
/*class MyThreadPoolExecutor {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,//参数一：核心线程数量
                6,//参数二：最大线程数
                60,//参数三：空闲线程最大存活时间
                TimeUnit.SECONDS,//参数四：时间单位
                new ArrayBlockingQueue<>(3),//参数五：任务队列
                Executors.defaultThreadFactory(),//参数六：创建线程工厂
                new ThreadPoolExecutor.AbortPolicy()//参数七：任务的拒绝策略(静态内部类书写格式)
        );
        //之后正常去使用这个pool就OK
    }
}*/


/**
 * 31 最大并行数
 */
/*
我的电脑是8核16线程 最大并行数是16
下面的代码可以准确查看java程序可以使用的最大并行数(16个不一定全给java用)
 */
/*public class java02 {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}*/

/**
 * 32 线程池多大合适？
 */
/*
CPU密集型运算：(最大并行数+1)
I/O密集型运算[最大并行数*期望CPU利用率*(总时间/CPU运算时间)]
           总时间 = 等待时间*CPU运算时间
(CPU运算时间和等待时间可以用工具测试 比如thread dump)
 */

/**
 *
 */


/**
 * 01初识网络编程
 */
/*
1.什么是网络编程
2.认识BS/CS架构
3.网络编程三要素
- IP地址
  设备在网络中的地址 是唯一标识
- 端口
  应用程序在设备中的唯一标识
- 协议
  数据在网络中传输的规则 常见的协议有UDP协议和TCP协议

4.IP详解：
常见IP分类为 IPV4 IPV6
IPV4: 32bit 分为4组
      点分十进制表示法 表示为192.168.1.66等形式(4个数都读为正数 范围0-255)
      因为只有2^32个 已经用完了 所以开始采用IPV6
      细节：利用局域网IP解决IP不够的问题[公网地址(万维网使用) 私有地址(局域网实用)]
                                   [192.168.开头的就是私有地址]
           127.0.0.1是特殊IP 永远表示本机
           两个常见CMD命令：ipconfig->查看本机IP地址 ping->检查网络是否连通
IPV6: 128bit 分为8组
      冒号十六进制表示法：2001:DB8:0:23:8:800:200C:417A
      (都为正数 前面多的0可省略 包含0位压缩法)

5.端口详解：
  端口：设备上应用程序的唯一标识
  端口号：用两个字节表示的整数，它的取值范围是0~65535。
        其中，0~1023之间的端口号用于一些知名的网络服务和应用，
        普通的应用程序需要使用1024以上的端口号。
        如果端口号被另外一个服务或应用所占用，会导致当前程序启动失败
  一个端口号只能被一个应用程序使用

6.协议详解：
  图片笔记：java2\day02\image\协议笔记\
  (包含UDP TCP协议的比较)
 */

/**
 * 05 InetAddress类的使用
 */
/*
InetAddress：此类表示Internet协议（IP）地址
- 相关方法
static InetAddress getByName(String host)   确定主机名称的IP地址。主机名称可以是机器名称，也可以是IP地址
String getHostName()                        获取此IP地址的主机名
String getHostAddress()                     返回文本显示中的IP地址字符串
 */
/*public class java02 {
    public static void main(String[] args) throws UnknownHostException {
        //这个方法内部会判断设备ip是ipv4还是ipv6
        //判断后创建相应子类对象 赋值给address
        InetAddress address = InetAddress.getByName("sure-Afei-001");
        System.out.println(address);

        System.out.println(address.getHostName());
        System.out.println(address.getHostAddress());
    }
}*/

/**
 * 08 UDP协议 发送数据&接收数据
 */
//代码文件java2\day02\src\EXERCISE\miniProject\mini22\
//先运行ReceiveMessage 再运行SendMessage

/**
 * 11 UDP三种通信方式(单播 组播 广播)
 */
/*
单播：一对一发送
组播：一对多发送（组播地址：224.0.0.0~239.255.255.255  其中224.0.0.0~224.0.0.255为预留的组播地址）
广播：一对局域网所有电脑发送（广播地址：255.255.255.255）（和单播几乎一模一样 改发送至的设备的地址为广播地址即可）
 */
//代码文件java2\day02\src\EXERCISE\miniProject\mini23\ （组播）


/**
 * 12 TCP协议 发送数据&接收数据
 */
//代码文件java2\day02\src\EXERCISE\miniProject\mini24\


/**
 * 15 三次握手协议 四次挥手协议
 */
/*
该协议在TCP协议传递数据过程用到 在上一课代码中有提到
图片笔记：java2\day02\image\协议笔记\三次握手协议.jpg
        java2\day02\image\协议笔记\四次挥手协议.jpg
 */

/**
 * 01 反射
 */
/*
- 反射允许对成员变量 成员方法 构造方法进行编程式访问
  （意思就是 可以获取到一个类中所有的信息）
- 这些信息不是从java文件中获取的，而是从class字节码文件对象当中获取的
 */

/**
 * 02 获取class对象的三种方式
 */
/*
1. Class.forName("全类名")
   这里全类名 鼠标右键对象Copy-Copy_reference获得 就是包名.类名
2. 类名.class
3. 对象.getClass()
 */
/*class Stu{
    private String name;
    private int age;

    public Stu() {
    }

    public Stu(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class java02 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.源代码阶段 常用
        Class<?> clazz1 = Class.forName("com.shuyuan.learn.Stu");
        //2.加载阶段
        Class<Stu> clazz2 = Stu.class;
        //3.运行阶段  需创建对象
        Class<? extends Stu> clazz3 = new Stu().getClass();
        System.out.println("1-->" + clazz1);
        System.out.println("2-->" + clazz2);
        System.out.println("3-->" + clazz3);
        //三者获取值一样
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);

    }
}*/

/**
 * 03 反射获取构造方法
 */
/*
1. 反射获取构造方法(class对象的方法)：
| 方法名                                                             | 说明                                 |
| ------------------------------------------------------------      | ------------------------------------|
| Constructor<?>[] getConstructors()                                | 获得所有的构造（只能public修饰）         |
| Constructor<?>[] getDeclaredConstructors()                        | 获得所有的构造（包含private修饰）        |
| Constructor<T> getConstructor(Class<?>... parameterTypes)         | 获取指定构造（只能public修饰）           |
| Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) | 获取指定构造（包含private修饰）          |
   eg: clazz1.getDeclaredConstructor(String.class,int.class);
2. 用获取到的方法创建对象
   newInstance(参数)方法 （Constructor对象的）
   setAccessible(true)  如果获取的构造方法是私有的 那无法创建对象
                        可以使用这个方法 ‘暴力反射’ 强行使用
3. 用获取到的方法对象 获取方法的各种属性 -- 各种getXXX方法 详细到api帮助文档去找
 */
/*class Stu{
    public String name;
    private int age;

    public Stu() {
    }

    private Stu(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Stu{name = " + name + ", age = " + age + "}";
    }
}
public class java02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz1 = Class.forName("com.shuyuan.learn.Stu");
        Constructor<?>[] csp = clazz1.getConstructors();
        for (Constructor<?> constructor : csp) {
            System.out.println(constructor);
        }
        System.out.println("-----------------------");
        Constructor<?>[] cs = clazz1.getDeclaredConstructors();
        for (Constructor<?> c : cs) {
            System.out.println(c);
        }

        System.out.println("-----------------------");
        Constructor<?> declaredConstructor = clazz1.getDeclaredConstructor(String.class,int.class);
        System.out.println(declaredConstructor);

        declaredConstructor.setAccessible(true);
        Stu woman = (Stu) declaredConstructor.newInstance("小美", 31);
        System.out.println(woman);
    }
}*/

/**
 * 04 反射获取成员变量
 */
/*
1.反射获取成员变量
| 方法名                              | 说明                                     |
| ----------------------------------- | -------------------------------------- |
| Field[] getFields()                 | 返回所有成员变量对象的数组（只能拿public的）   |
| Field[] getDeclaredFields()         | 返回所有成员变量对象的数组，存在就能拿到       |
| Field getField(String name)         | 返回单个成员变量对象（只能拿public的）        |
| Field getDeclaredField(String name) | 返回单个成员变量对象，存在就能拿到            |
2.进一步获取已经取得的成员变量的各种信息 -- 各种getXXX方法 详细到api帮助文档去找
3.获取到成员变量的值
Object get(Object obj)            获取值
4.修改成员变量的值
void set(Object obj, Object value）赋值
 */
/*
class Stu{
    public String name;
    private int age;

    public Stu() {
    }

    private Stu(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Stu{name = " + name + ", age = " + age + "}";
    }
}
public class java02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException,
            NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz1 = Class.forName("com.shuyuan.learn.Stu");
        Field[] dfs = clazz1.getDeclaredFields();
        for (Field df : dfs) {
            System.out.println(df);
        }

        System.out.println("-----------------");
        Field age = clazz1.getDeclaredField("age");
        System.out.println(age);

        System.out.println("-----------------");
        //构造s1这个对象
        Constructor<?> dc = clazz1.getDeclaredConstructor(String.class, int.class);
        dc.setAccessible(true);
        Stu s1 = (Stu) dc.newInstance("小明", 21);
        //获取s1的成员变量age的值
        age.setAccessible(true);
        int o = (int)age.get(s1);
        System.out.println(o);
        //将年龄修改为18并输出
        age.set(s1,18);
        System.out.println(age.get(s1));

    }
}
*/

/**
 * 05 反射获取成员方法
 */
/*
1.获取成员方法
 Method[] getMethods()                                             | 返回所有成员方法对象的数组（只能拿public的 包含父类）
 Method[] getDeclaredMethods()                                     | 返回所有成员方法对象的数组，存在就能拿到
 Method getMethod(String name, Class<?>... parameterTypes)         | 返回单个成员方法对象（只能拿public的）
 Method getDeclaredMethod(String name, Class<?>... parameterTypes) | 返回单个成员方法对象，存在就能拿到
2.进一步获取成员方法的信息 -- 各种get发方法 查api帮助文档
3.运行方法
 Object invoke(Object obj, Object... args) ：运行方法
 */
/*class Stu{
    private String name;
    private int age;

    public Stu() {
    }

    public Stu(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Stu{name = " + name + ", age = " + age + "}";
    }

    private void eat(int i){
        System.out.println("eat-eat-eat" + i);
    }
}
public class java02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> clazz1 = Class.forName("com.shuyuan.learn.Stu");
        //获取*包含父类*的所有public方法
        Method[] methods1 = clazz1.getMethods();
        for (Method method : methods1) {
            System.out.println(method);
        }

        System.out.println("-------------------");
        Method[] methods2 = clazz1.getDeclaredMethods();
        for (Method method : methods2) {
            System.out.println(method);
        }

        System.out.println("-------------------");
        Method eat = clazz1.getDeclaredMethod("eat", int.class);
        Stu s1 = new Stu();
        eat.setAccessible(true);
        //如果方法有返回值 那么invoke方法也有对应的返回值
        eat.invoke(s1, 5);

    }
}*/

/**
 * 01 动态代理
 */
/*
1.好处：无侵入式的给方法增强功能
2.真正干活的对象 帮忙代理的对象 中间的接口
完整代码：day02\src\EXERCISE\miniProject\mini25
根据Demo里面的调用方法 写创建代理类中代码（参数有点多 不能出错）
 */


/**
 * 补 01: 特殊文件-Propeties属性文件(.propeties)
 */

/*Propeties属性文件：用来存储键值对信息
文件详细的写法：day02\src\SpecialDocuments\properties\\users.properties

java用Properties对象 表示.propeties文件
这个对象是一个Map集合（键值对集合），但是我们一般不会当集合使用。
核心作用：Properties是用来代表属性文件的，通过Properties可以读写属性文件里的内容

1.读
public Properties()                        用于构建Properties集合对象（空容器）常用方法
public void load(InputStream is)           通过字节输入流，读取属性文件里的键值对数据
public void load(Reader reader)            通过字符输入流，读取属性文件里的键值对数据
public String getProperty(String key)      根据键获取值（其实就是get方法的效果）
public Set<String> stringPropertyNames()   获取全部键的集合（其实就是ketSet方法的效果）

2.写
public Object setProperty(String key, String value) 保存键值对数据到Properties对象中去。
public void store(OutputStream os, String comments) 把键值对数据，通过字节输出流写出到属性文件里去
public void store(Writer w, String comments)        把键值对数据，通过字符输出流写出到属性文件里去
*/
//1.读
/*public class java02 {
    public static void main(String[] args) throws IOException {
        //创建Properties对象
        Properties p1 = new Properties();
        System.out.println(p1);

        //通过io流读取键值对数据到p1中
        p1.load(new FileReader("day02\\src\\" +
                "SpecialDocuments\\properties\\users.properties"));

        //通过提供key值查找对应的value值
        System.out.println("王小明的密码是"+p1.getProperty("王小明"));
        System.out.println("孙小红的密码是"+p1.getProperty("孙小红"));

        //获取p1中所有key值
        Set<String> keyStr = p1.stringPropertyNames();
        System.out.println("文件中的所有键值：" + keyStr);
        //遍历方式1：
        for (String key : keyStr) {
            System.out.println(key + ":" + p1.getProperty(key));
        }
        System.out.println("----------------------");
        //遍历方式2：
        p1.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
    }
}*/

//2.写
/*public class java02 {
    public static void main(String[] args) throws IOException {
        Properties p1 = new Properties();
        p1.setProperty("Jack", "18");
        p1.setProperty("Mike", "56");
        p1.setProperty("Daqi", "58");

        //这里传输的注释数据必须是英文 如果是中文 是以Unicode的形式在users上展现的
        //因为：Properties 类的 store(Writer writer, String comments) 方法
        //默认会将非ASCII字符（包括中文字符）转换为Unicode转义序列。
        p1.store(new FileWriter("day02\\src\\SpecialDocuments\\" +
                "properties\\users2.properties"),"exegesis Must be English");
    }
}*/


/**
 * 补02：特殊文件-XML文件
 */
/*
//1.介绍XML
XML是可扩展的标记语言，意思是它是由一些标签组成	的，而这些标签是自己定义的。本质上一种数据格式，可以用来表示复杂的数据关系。
XML文件有如下的特点：
- XML中的`<标签名>` 称为一个标签或者一个元素，一般是成对出现的。
- XML中的标签名可以自己定义（可扩展性），但是必须要正确的嵌套
- XML中只能有一个根标签。（最外层一个大的标签组）
- XML标准中可以有属性
- XML必须第一行有一个文档声明，格式是固定的`<?xml version="1.0" encoding="UTF-8"?>`
- XML文件必须是以.xml为后缀结尾

//2.特殊字符书写问题
- 像 `<,>,& `等这些符号不能出现在标签的文本中，因为标签格式本身就有<>，会和标签格式冲突。
  如果标签文本中有这些特殊字符，需要用一些占位符代替。
  &lt;  表示 <
  &gt;  表示 >
  &amp; 表示 &
  &apos; 表示 '
  &quot; 表示 "
  eg:
  <data> 3 &lt; 2 &amp;&amp; 5 &gt; 4 </data>
- 如果在标签文本中，出现大量的特殊字符，不想使用特殊字符，此时可以用CDATA区，格式如下
  <data1>
      <![CDATA[
     		3 < 2 && 5 > 4
      ]]>
  </data1>

//3.解析xml文本--读
使用第三方dom4j库：day02\src\lib\dom4j-2.1.4.jar
SAXReader： Dom4j提供的解析器，可以认为是代表整个Dom4j框架
//对象是SAXReader
public SAXReader()构建Dom4J的解析器对象
public Document read(String url)把XML文件读成Document对象
public Document read(InputStream is)通过字节输入流读取XML文件
Element getRootElement()获得根元素对象
//对象是元素
public String getName()                    得到元素名字
public List<Element> elements()            得到当前元素下所有子元素
public List<Element> elements(String name) 得到当前元素下指定名字的子元素返回集合
public Element element(String name)        得到当前元素下指定名字的子元素，如果有很多名字相同的返回第一个
public String attributeValue(String name)  通过属性名直接得到属性值
public String elementText(子元素名)          得到指定名称的子元素的文本
public String getText()                    得到文本

//4.写入xml文件--写
不建议使用dom4j 非常繁琐
可以直接把程序中的数据拼接成xml格式 直接用io流写出4
eg:将下面内容写到xml文件中
<?xml version="1.0" encoding="UTF-8" ?>
<Books>
    <book>java入门到删库</book>
    <book>java删库到跑路</book>
    <book>java跑路到被抓</book>
    <总结>学java这辈子有了</总结>
</Books>

//5.约束xml文件的书写
//(用dtd约束文档 schema(.xsd)约束文档 约束xml文件)。。。略
 */

//1.上述方法的练习--读
/*public class java02 {
    public static void main(String[] args) throws DocumentException {
        SAXReader sReader = new SAXReader();
        //使用.read()方法 将XML文件用一个xRead变量表示
        Document xRead = sReader.read("day02\\src\\SpecialDocuments\\xml\\users.xml");
        //使用.getRootElement()方法 将xml文件根元素用变量root表示
        Element root = xRead.getRootElement();
        System.out.println(root.getName());

        //输出users的所有子元素名称
        List<Element> elements = root.elements();
        elements.forEach(e -> System.out.println(e.getName()));

        //输出user1的属性值
        Element user1 = root.element("user1");
        user1.attributes().forEach(e -> System.out.println(e.getName() + ":" + e.getStringValue()));
    }
}*/

//2.写
/*public class java02 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
        sb.append("<Books>\r\n");
        sb.append("<book>java入门到删库</book>\r\n");
        sb.append("<book>java删库到跑路</book>\r\n");
        sb.append("<book>java跑路到被抓</book>\r\n");
        sb.append("<总结>学java这辈子有了</总结>\r\n");
        sb.append("</Books>\r\n");

        FileWriter fw = new FileWriter("day02\\src\\SpecialDocuments\\xml\\write.xml");
        fw.write(sb.toString());
        fw.close();
    }
}*/

/**
 * 补3：日志技术
 */
/*
1.作用：
- 日志可以将系统执行的信息，方便的记录到指定位置，可以是控制台、可以是文件、可以是数据库中。
- 日志可以随时以开关的形式控制启停，无需侵入到源代码中去修改
2.体系结构
程序员会使用·日志框架·来实现相关代码
日志框架种类很多 所以有了统一的标准 ·日志接口·来规范使用 降低学习成本
主流的日志框架和日志接口如下：
LogBack----Simple Logging Facade for Java(SLF4J)（都是第三方的）
3.Logback模块
图片笔记：day02\image\Logback-moduel.png
4.用法：先配置好如下第三方文件：
       day02\src\lib\logback-classic-1.2.3.jar
       day02\src\lib\logback-core-1.2.3.jar
       day02\src\lib\slf4j-api-1.7.26.jar
       day02\src\logback.xml  -->这个xml文件必须直接在src目录下，是不可少的配置文件
配置好如下第三方库之后，就按照下列代码的形式使用就行 重点在LODDER常量的声明 (这个XML文件要大概知道怎么修改)
5.日志级别
日志级别指的是日志信息的类型，日志都会分级别，常见的日志级别如下（优先级依次升高）
trace   追踪，指明程序运行轨迹
debug   调试，实际应用中一般将其作为最低级别，而trace则很少使用
info    输出重要的运行信息，数据连接、网络连接、I0操作等等，使用较多
warn    警告信息，可能会发生问题，使用较多
error   错误信息，使用较多
使用 eg:LOGGER.error("chu~~哎~丸辣！");
 */
/*public class java02 {
    //创建一个Logger日志对象
    //(选slf4j中的Logger)
    //(因为是不希望别人改变的 给所有人用的 ”常量“ 所以用如下写法)
    public static final Logger LOGGER = LoggerFactory.getLogger("java02类");
    public static void main(String[] args) {
            try {
                LOGGER.info("chu方法开始执行~~~");
                chu(10, 2);
                LOGGER.info("chu方法执行完毕~~~");
            } catch (Exception e) {
                //出错必须用error 这样专业~
                LOGGER.error("chu~~哎~丸辣！");
            }
    }
    public static void chu(int a,int b){
        LOGGER.debug("参数a = " + a);
        LOGGER.debug("参数b = " + b);
        int c = a / b;
        System.out.println(a + " 除 " + b + " = " + c);
        //结果用info也行 但因为是比较重要的日志 所以用info
        LOGGER.info("结果是" + c);
    }
}*/


/**
 * 补4：JUnit单元测试
 */
//使用Junit测试框架 测试这两个方法
//javaTest.java
/*
public class java02 {
    //获取字符串的长度
    public static void printLength(String str) {
        if(str == null){
            System.out.println("字符串为null");
            return;
        }
        System.out.println("长度为: " + str.length());
    }

    //获取字符串的最大索引
    public static Integer printMaxIndex(String str) {
        if (str == null) {
            System.out.println("字符串为null");
            return -1;
        }
        return str.length() - 1;
    }
}
*/

/**
 * 补5：注解-自定义注解-元注解
 */
/*
注意两个元注解：@Retention、@Target
@Retention：注解的保留策略，表示注解的生命周期，有三个取值：SOURCE、CLASS、RUNTIME
@Target：注解的作用目标，表示注解可以作用于哪些程序元素，有四种取值：CONSTRUCTOR、FIELD、LOCAL_VARIABLE、METHOD、PACKAGE、TYPE

注意自定义注解的格式：见MyAnnotation.java
//mini26--MyJunit.java
 */
//注解的解析（所有自定义注解都隐式地继承了java.lang.annotation.Annotation接口）
/*@MyAnnotation(name = "张三",age = 88)
class Demo {
    public void demo(){
        System.out.println("demo方法");
    }
}

public class java02 {
    public static void main(String[] args) {
         Class c = Demo.class;
         if(c.isAnnotationPresent(MyAnnotation.class)){
             MyAnnotation myAnnotation = (MyAnnotation) c.getAnnotation(MyAnnotation.class);
             System.out.println(myAnnotation.name());
             System.out.println(myAnnotation.age());
         }
    }
}*/















