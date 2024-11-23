package EXERCISE.miniProject.mini08;

public class Demo {
    public static void main(String[] args) {
        Interimpl ii = new Interimpl();
        ii.method();           //基本
        ii.show();             //默认
        Inter01.staticShow();  //静态

        //私有测试
        ii.test01();
        ii.test02();
        Inter02.test03();
        Inter02.test04();

        //接口的应用：接口多态
        work(ii);
    }
    public static void work(Inter01 ii){
        System.out.println("666");
        ii.show();
    }
}
