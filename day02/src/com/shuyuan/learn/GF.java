package com.shuyuan.learn;

/**
 * 01
 * <p>
 * 02
 * <p>
 * 03
 * <p>
 * 04
 * <p>
 * 02
 * <p>
 * 03
 * <p>
 * 04
 * <p>
 * 01 static静态变量
 * <p>
 * 02
 * <p>
 * 03
 * <p>
 * 04
 * <p>
 * 01 static静态变量
 */
/*public class GF {
    String name;
    int age;
    String genter;
    private char blood;

    public void sleep() {
        System.out.println("it is sleeping");
    }

    public void eat() {
        System.out.println("it is eating");
    }

    public void bb() {
        blood = 'A';
        System.out.println("it is " + blood);
    }
}*/

/**
 * 02
 */
/*public class GF {
    private int age;

    public void setage(int age) {
        //age = age;//错误，就近原则
        //离形参age近，所以被赋值的age为形参
        this.age = age;//这样是对滴
    }

    public int getage() {
        return age;
    }
}*/

/**
 * 03
 */
/*
public class GF{
    private int age;
    GF(){}
    GF(int age){
        System.out.println("GF 构造函数");
        this.age = age;
    }
    public void set(int age){
        this.age=age;
    }
    public void print(){
        System.out.println(this.age+" ");
    }
}
*/

/**
 * 04
 */
/*public class GF{
    //成员变量
    private String userName;
    private String passWord;
    private String email;
    private String gender;
    private int age;
//两种构造方法
    public GF() {
    }
    public GF(String userName, String passWord, String email, String gender, int age) {
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //set & get 略
    *//*
    写法：
    * 1 手写全部
    * 2 alt+insert快捷键生成
    * 3 ptg插件 右键生成
    * *//*
}*/

/**
 * 01 static静态变量
 */
/*public class GF {
    private String name;
    private int age;
    public static String teacher;

    public GF() {
    }

    public GF(String name, int age) {
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
        return "GF{" +
                "name='" + name + '\'' +
                ", age=" + age + ", teacher='" +
                teacher + '\'' +
                '}';
    }
}*/

/**
 * 02 static 静态方法和工具类
 */
//工具类
/*public class GF {
    private GF() {
    }

    public static String printArr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static Double getAverage(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        Double an = sum / (double) arr.length;
        return an;
    }
}*/


















