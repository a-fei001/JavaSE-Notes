package EXERCISE.miniProject.mini09;

public class Demo {
    public static void main(String[] args) {
        /*我们希望用InterImpl实现Inter，
        并调用InterImpl中的method05方法
        但是Inter有很多方法要重写，看InterImpl重写一大堆方法
        不方便阅读
        所以，
        用适配器设计模式来解决问题
        这样代码更好阅读*/
        /*
        如果该类有爹，则让适配器继承它的爹，这样间接继承，
         */
        InterImpl ii = new InterImpl();
        ii.method05();
    }
}
