package EXERCISE.miniProject.mini03;

public class Demo {
    public static void main(String[] args) {
        Student s1 = new Student("张三", 18);
        Teacher t1 = new Teacher("王老师", 25);
        Administrator a1 = new Administrator("阿姨", 55);
        register(s1);
        register(t1);
        register(a1);
    }

    public static void register(Per p) {
        p.show();
    }
}
