package EXERCISE.miniProject.mini11;

public class Outer {
    int a = 10;
    static int b = 20;

    static class Inner {
        public void show01() {
            Outer o = new Outer();
            System.out.println("a = " + o.a);
            System.out.println("b = " + b);
            System.out.println("Outer-Inner-show01()");
        }

        public static void show02() {
            Outer o = new Outer();
            System.out.println("a = " + o.a);
            System.out.println("b = " + b);
            System.out.println("Outer-Inner-show02()");
        }
    }

    public void bigShow() {
        int c = 30;//用static修饰报错，不要在方法中声名static
        class MiniInner {//局部类不能是静态的
            String name;
            int age;

            public void method01() {//static修饰报错，局部内部类也不能包含静态方法
                System.out.println("Outer-bigShow()-MiniInner");
            }
        }
        MiniInner mi = new MiniInner();
        mi.name = "张三";
        mi.age = 99;
        System.out.println("a= "+a);
        System.out.println("b= "+b);
        System.out.println("c= "+c);
        System.out.println("name= "+mi.name);
        System.out.println("age= "+mi.age);
    }
}

