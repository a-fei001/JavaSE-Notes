package EXERCISE.miniProject.mini05;

public class Rabbit extends Animal{

    @Override
    void show(){
        super.show();
    }

    public Rabbit() {
    }

    public Rabbit(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("兔子在吃胡萝卜");
    }
}
