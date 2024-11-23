package EXERCISE.miniProject.mini07;

public class PingPong extends Person implements Learn, SpeakEnglish {
    public PingPong() {
    }

    public PingPong(String name, int age) {
        super(name, age);
    }


    @Override
    public void learn() {
        System.out.println("学习乒乓球");
    }

    @Override
    public void speak() {
        System.out.println("说英语");
    }
}
