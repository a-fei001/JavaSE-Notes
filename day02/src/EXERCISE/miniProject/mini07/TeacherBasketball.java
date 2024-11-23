package EXERCISE.miniProject.mini07;

public class TeacherBasketball extends Person implements Teach {
    public TeacherBasketball() {
    }

    public TeacherBasketball(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("教打篮球");
    }
}
