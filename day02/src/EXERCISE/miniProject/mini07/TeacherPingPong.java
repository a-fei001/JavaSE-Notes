package EXERCISE.miniProject.mini07;

public class TeacherPingPong extends Person implements Teach{
    public TeacherPingPong() {
    }

    public TeacherPingPong(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("教乒乓球");
    }
}
