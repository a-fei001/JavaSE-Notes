package EXERCISE.miniProject.mini15;

public class Husky extends Dog{
    @Override
    public void eat() {
        System.out.print("一只叫做" + getName() + "的" + getAge() + "岁的哈士奇,正在吃骨头");
        this.withEat();
    }

    @Override
    public void withEat() {
        System.out.println(",边吃边拆家");
    }
}
