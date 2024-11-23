package EXERCISE.miniProject.mini04;

public class Demo {
    public static void main(String[] args) {
        Dog d1 = new Dog(8, "黄色");
        Cat c1 = new Cat(5, "橘色");
        Person p1 = new Person("张三", 25);

        if(d1 instanceof Dog)
        p1.keepPet(d1, "肉骨头");
        if(c1 instanceof Cat)
        p1.keepPet(c1, "鱼骨头");
    }
}
