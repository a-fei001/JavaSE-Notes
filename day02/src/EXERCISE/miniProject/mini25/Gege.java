package EXERCISE.miniProject.mini25;

public class Gege implements WorkOfGege{
    private String name;

    @Override
    public String sing(String songName){
        System.out.println(this.name + "正在唱" + songName);
        return "谢谢";
    }

    @Override
    public void dance(){
        System.out.println(this.name + "正在跳");
    }

    public Gege() {
    }

    public Gege(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Gege{" +
                "name='" + name + '\'' +
                '}';
    }
}
