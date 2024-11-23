package EXERCISE.miniProject.mini15;

public class PersianCat extends Cat {

    @Override
    public void eat() {
        System.out.println("一只叫做" + getName() + "的" + getAge() + "岁的狸花猫,正在吃小饼干");
    }
}
