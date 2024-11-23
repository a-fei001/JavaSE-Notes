package EXERCISE.miniProject.mini10;

public class Outer {
    private int a = 10;

    public class Inner {
        private int a = 20;

        public void show() {
            int a = 30;
            System.out.println(a);
            System.out.println(this.a);
            //Outer.this获取了外部类的地址值
            System.out.println(Outer.this.a);
        }
    }

    public Inner getInstance() {
        return new Inner();
    }
}
