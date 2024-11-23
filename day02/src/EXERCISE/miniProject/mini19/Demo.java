package EXERCISE.miniProject.mini19;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//写法1
//提取csb.txt的内容，并排序

public class Demo {
    public static void main(String[] args) throws IOException {
        //读取数据到ArrayList<String>集合
        BufferedReader br = new BufferedReader(new FileReader("D:\\sure_\\" +
                "编译工具和项目\\项目文件\\java_intellij idea\\java2\\day02\\src\\EXERCISE\\" +
                "miniProject\\mini19\\csb.txt"));
        ArrayList<String> list = new ArrayList<String>();
        String line = null;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        br.close();

        //排序并输出
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //"\\."这种写法和正则表达式有关
                //"\\"转义为了一个"\"，和"."组合为"\."，表示"."的意思
                int a = Integer.parseInt(o1.split("\\.")[0]);
                int b = Integer.parseInt(o2.split("\\.")[0]);
                return a - b;
            }
        });
        list.forEach(System.out::println);

        //录入NewCSB.txt中
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\sure_\\" +
                "编译工具和项目\\项目文件\\java_intellij idea\\java2\\day02\\src\\EXERCISE\\" +
                "miniProject\\mini19\\NewCSB.txt"));
        for (String str : list) {
            bw.write(str);
            bw.newLine();
        }

        bw.close();
    }
}
