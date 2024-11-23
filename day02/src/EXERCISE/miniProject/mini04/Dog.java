package EXERCISE.miniProject.mini04;

public class Dog extends Animal{
    public Dog() {
    }

    public Dog(int age, String color) {
        super(age, color);
    }

    @Override
    public void eat(String something) {
        System.out.println("狗吃"+something);
    }
    @Override
    public void show(){
        System.out.print("一只狗");
        super.show();
    }
}
