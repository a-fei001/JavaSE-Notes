package EXERCISE.miniProject.mini11;

public class Demo {
    public static void main(String[] args) {
        //静态内部类
        Outer.Inner oi = new Outer.Inner();
        oi.show01();
        Outer.Inner.show02();

        //局部内部类
        Outer o = new Outer();
        o.bigShow();
    }
}
