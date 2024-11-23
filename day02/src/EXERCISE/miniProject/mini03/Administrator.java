package EXERCISE.miniProject.mini03;

public class Administrator extends Per{
    public Administrator() {
    }

    public Administrator(String name, int age) {
        super(name, age);
    }

    @Override
    public void show(){
        System.out.print("管理员的信息----");
        super.show();
    }
}
