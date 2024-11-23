package EXERCISE.miniProject.mini02;

public class Per {
    private String id;
    private String name;
    private int salary;

    public Per() {
    }

    public Per(String id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void work() {
        System.out.println("员工在工作");
    }

    public void eat() {
        System.out.println("吃米饭");
    }

    public void show() {
        System.out.println("id= " + this.id + "\tname= "
                + this.name + "\tsalary= " + this.salary);
    }
}
