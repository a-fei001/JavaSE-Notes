package EXERCISE.miniProject.mini04;

public class Cat extends Animal {
    public Cat() {
    }

    public Cat(int age, String color) {
        super(age, color);
    }

    @Override
    public void eat(String something) {
        System.out.println("猫吃" + something);
    }

    public void show(){
        System.out.print("一只猫");
        super.show();
    }
}
