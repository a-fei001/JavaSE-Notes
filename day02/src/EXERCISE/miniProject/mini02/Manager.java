package EXERCISE.miniProject.mini02;

public class Manager extends Per {
    private int manageBonus;

    public Manager() {
    }

    public int getManageBonus() {
        return manageBonus;
    }

    public void setManageBonus(int manageBonus) {
        this.manageBonus = manageBonus;
    }

    public Manager(String id, String name, int salary, int manageBonus) {
        super(id, name, salary);
        this.manageBonus = manageBonus;
    }

    @Override
    public void work() {
        System.out.println("管理手下");
    }

    @Override
    public void show() {
        super.show();
        System.out.println("manageBonus= " + this.manageBonus);
        this.eat();
        this.work();
    }
}
