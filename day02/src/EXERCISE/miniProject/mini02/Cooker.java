package EXERCISE.miniProject.mini02;

public class Cooker extends Per {
    Cooker() {
    }

    Cooker(String id, String name, int salary) {
        super(id, name, salary);
    }

    @Override
    public void work() {
        System.out.println("把米饭做成菜");
    }

    @Override
    public void show() {
        super.show();
        this.eat();
        this.work();
    }
}
