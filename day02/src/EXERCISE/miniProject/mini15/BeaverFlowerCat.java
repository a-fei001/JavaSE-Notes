package EXERCISE.miniProject.mini15;

public class BeaverFlowerCat extends Cat{

    @Override
    public void eat() {
        System.out.println("一只叫做" + getName() + "的" + getAge() + "岁的波斯猫,正在吃鱼");
    }
}
