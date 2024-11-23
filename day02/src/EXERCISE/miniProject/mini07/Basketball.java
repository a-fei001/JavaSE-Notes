package EXERCISE.miniProject.mini07;

public class Basketball extends Person implements Learn,SpeakEnglish{
    public Basketball() {
    }

    public Basketball(String name, int age) {
        super(name, age);
    }

    @Override
    public void learn() {
        System.out.println("学习打篮球");
    }

    @Override
    public void speak() {
        System.out.println("说英语");
    }
}
