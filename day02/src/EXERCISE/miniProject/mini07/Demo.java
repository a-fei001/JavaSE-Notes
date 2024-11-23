package EXERCISE.miniProject.mini07;

//这个项目有两个思路：看课   （都多了两个中间的抽象类）
//其中一思路：
//建立一中间 的运动员和教练(抽象类)，学习和教用抽象类完成
//这有说英语这一个接口

public class Demo {
    public static void main(String[] args) {
        PingPong pp = new PingPong("张皓瀚", 18);
        System.out.println(pp.getName() + "\t" + pp.getAge());
        pp.learn();
        pp.speak();
    }
}
