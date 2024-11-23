package EXERCISE.miniProject.mini07;

//定义成抽象的，不让外界创建Person对象
//抽象类的子类要重写重写抽象类中的抽象方法，否则还是抽象类
//但这里没有抽象方法
public abstract class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
