package EXERCISE.miniProject.mini08;

public interface Inter01 {
    public abstract void method();

    public default void show() {
        System.out.println("接口中的默认方法");
    }

    public static void staticShow() {
        System.out.println("Inter接口中的静态方法");
    }
}
