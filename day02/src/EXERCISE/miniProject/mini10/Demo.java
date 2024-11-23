package EXERCISE.miniProject.mini10;


public class Demo {
    public static void main(String[] args) {

        //Inner无private修饰，可以这样直接调用
        //Outer.Inner oi = new Outer().new Inner();

        Outer o = new Outer();
        //函数调用法：接收方式1：用Inner父类接收形成多态
        Object oi = o.getInstance();
        //接收方式2：不接了，直接使用
        System.out.println(o.getInstance());

        Outer o1 = new Outer();
        //private修饰Inner就不能这样调用show()
        o1.getInstance().show();
    }
}
