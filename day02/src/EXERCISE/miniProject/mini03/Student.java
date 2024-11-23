package EXERCISE.miniProject.mini03;

public class Student extends Per{
    public Student() {
    }

    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void show(){
        System.out.print("学生的信息----");
        super.show();
    }
}
