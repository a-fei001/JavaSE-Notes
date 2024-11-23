package EXERCISE.miniProject.mini04;

public class Person {
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

    void keepPet(Animal a, String food) {
        System.out.print("年龄为" + this.age + "的" + this.name + "养了");
        a.show();
        a.eat(food);
    }
}
