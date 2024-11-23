package EXERCISE.miniProject.mini15;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        //测试对象的创建代码
        Animal acp = new PersianCat();
        acp.setAge(5);
        acp.setName("大黄猫");
        acp.eat();

        Animal adh = new Husky();
        adh.setName("二哈");
        adh.setAge(8);
        adh.eat();

        //测试下面要求的函数
        ArrayList<BeaverFlowerCat>al1 = new ArrayList<>();
        ArrayList<PersianCat>al2 = new ArrayList<>();
        ArrayList<Husky>al3 = new ArrayList<>();
        ArrayList<Teddy>al4 = new ArrayList<>();

        keepPet01(al1);
        keepPet01(al2);
        //keepPet01(al3);
        //keepPet01(al4);

        //keepPet02(al1);
        //keepPet02(al2);
        keepPet02(al3);
        keepPet02(al4);

        keepPet03(al1);
        keepPet03(al2);
        keepPet03(al3);
        keepPet03(al4);
    }
    public static<E> void keepPet01(ArrayList<? extends Cat> al){

    }
    public static<E> void keepPet02(ArrayList<? extends Dog> al){

    }
    public static<E> void keepPet03(ArrayList<? extends Animal> al){

    }
}
