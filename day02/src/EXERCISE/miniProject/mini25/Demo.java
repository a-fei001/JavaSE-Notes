package EXERCISE.miniProject.mini25;

public class Demo {
    public static void main(String[] args) {
        Gege ge = new Gege("坤哥");
        WorkOfGege proxyGege = ProxyGege.createProxyGege(ge);
        System.out.println(proxyGege.sing("鸡你太美"));
        proxyGege.dance();
    }
}





/*
package EXERCISE.miniProject.mini25;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyGege{
    public static WorkOfGege createProxyGege(Gege ge){
         WorkOfGege o = (WorkOfGege) Proxy.newProxyInstance(ProxyGege.class.getClassLoader(),
                new Class[]{WorkOfGege.class},
                new InvocationHandler() {
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

package EXERCISE.miniProject.mini25;

public interface WorkOfGege {
    //唱
    public abstract String sing(String songName);
    //跳
    public abstract void dance();
}


package EXERCISE.miniProject.mini25;

public class Gege implements WorkOfGege{
    private String name;

    @Override
    public String sing(String songName){
        System.out.println(this.name + "正在唱" + songName);
        return "谢谢";
    }

    @Override
    public void dance(){
        System.out.println(this.name + "正在跳");
    }

    public Gege() {
    }

    public Gege(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Gege{" +
                "name='" + name + '\'' +
                '}';
    }
}

 */