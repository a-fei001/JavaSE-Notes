package EXERCISE.miniProject.mini01;

public class Demo {
    public static void main(String[] args) {
        FlowerCat fc = new FlowerCat();
        System.out.println("----狸花猫：");
        fc.eat();
        fc.drink();
        fc.work();

        DollCat dc = new DollCat();
        System.out.println("----布偶猫：");
        dc.eat();
        dc.drink();
        dc.work();

        twoDog twd = new twoDog();
        System.out.println("----二哈");
        twd.eat();
        twd.drink();
        twd.work();
        twd.toDie();

        tarDog tad = new tarDog();
        System.out.println("----泰迪");
        tad.eat();
        tad.drink();
        tad.work();
        tad.toDie();
    }
}
