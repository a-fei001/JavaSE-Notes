package EXERCISE.miniProject.mini08;

public interface Inter02 {
    public default void show() {
        System.out.println("Inter02的默认方法");
    }

    //test函数为啥有注释嘞？因为我的jdk版本是8，这种新功能用不了
    public default void test01() {
        System.out.println("test01开始执行了");
        //helpTest();
    }

    public default void test02() {
        System.out.println("test02开始执行了");
        //helpTest();
    }

/*    private void helpTest() {
        System.out.println("01与02重复的100行代码");
    }*/

    public static void test03() {
        System.out.println("test03开始执行了");
        //StaticHelpTest();
    }

    public static void test04() {
        System.out.println("test04开始执行了");
        //StaticHelpTest();
    }

/*    private static void StaticHelpTest() {
        System.out.println("01与02重复的100行代码");
    }*/
}
