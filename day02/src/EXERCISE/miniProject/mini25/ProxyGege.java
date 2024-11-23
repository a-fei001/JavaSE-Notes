package EXERCISE.miniProject.mini25;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyGege{
    public static WorkOfGege createProxyGege(Gege ge){
         //ClassLoader loader：指定代理类的类加载器，一般使用目标类的类加载器。
         //Class<?>[] interfaces：代理对象实现的接口列表，代理对象会实现并代理这些接口中的方法。
         //InvocationHandler h：定义代理对象的方法行为。每次调用代理方法时，都会将调用转发给 InvocationHandler 的 invoke 方法。
         WorkOfGege o = (WorkOfGege) Proxy.newProxyInstance(ProxyGege.class.getClassLoader(),
                new Class[]{WorkOfGege.class},
                new InvocationHandler() {
                    /*
                     * 参数一：代理的对象
                     * 参数二：要运行的方法 sing
                     * 参数三：调用sing方法时，传递的实参
                     * */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("sing")) {
                            System.out.println("准备麦克风，收米");
                        } else if (method.getName().equals("dance")) {
                            System.out.println("准备场地，收米");
                        }
                        return method.invoke(ge, args);
                    }
                });
        return o;
    }
}

/*
java.lang.reflect.Proxy类：提供了为对象产生代理对象的方法：
  public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
  参数一：用于指定用哪个类加载器，去加载生成的代理类
  参数二：指定接口，这些接口用于指定生成的代理长什么，也就是有哪些方法
  参数三：用来指定生成的代理对象要干什么事情
*/