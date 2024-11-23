package EXERCISE.miniProject.mini03;

public class Teacher extends Per{
    public Teacher() {
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    @Override
    public void show(){
        System.out.print("老师的信息----");
        super.show();
    }
}
