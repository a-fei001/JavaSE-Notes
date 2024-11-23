package EXERCISE.miniProject.mini15;

public class Teddy extends Dog{
    @Override
    public void eat() {
        System.out.print("一只叫做" + getName() + "的" + getAge() + "岁的泰迪,正在吃骨头");
        this.withEat();
    }

    @Override
    public void withEat() {
        System.out.println(",边吃边蹭");
    }
}
