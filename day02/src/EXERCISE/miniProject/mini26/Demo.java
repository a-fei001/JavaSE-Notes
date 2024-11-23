package EXERCISE.miniProject.mini26;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//实现功能：加了@Junit的方法可以跑 不加不能跑
public class Demo {
    public void test1(){
        System.out.println("test1 method");
    }

    @MyJunit
    public void test2(){
        System.out.println("test2 method");
    }

    public void test3(){
        System.out.println("test3 method");
    }

    public void test4(){
        System.out.println("test4 method");
    }

    @MyJunit
    public void test5(){
        System.out.println("test5 method");
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Demo demo = new Demo();
        //Class<T> 是一个泛型类，其中 T 是类型参数。通过指定 Demo 作为类型参数，
        //Class<Demo> 这个声明表示这个 Class 对象是与 Demo 类相关的。
        Class<Demo> demoClass = Demo.class;
        Method[] methods = demoClass.getDeclaredMethods();//获取所有方法

        for (Method method : methods) {
            if (method.isAnnotationPresent(MyJunit.class)) {
                //加了@MyJunit注解的方法可以跑
                method.invoke(demo);//参数是任意Demo对象
            }
        }
    }
}
