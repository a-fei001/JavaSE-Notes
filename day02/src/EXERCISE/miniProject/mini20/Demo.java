package EXERCISE.miniProject.mini20;

import java.io.*;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student s1 = new Student("张三",18,"南京");
        Student s2 = new Student("Jack",78,"纽约");
        Student s3 = new Student("Peter",31,"柏林");

        ArrayList<Student> students = new ArrayList<Student>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("day02/src/File/student.txt"));
        oos.writeObject(students);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("day02/src/File/student.txt"));
        Object o = ois.readObject();
        System.out.println(o);
    }
}
