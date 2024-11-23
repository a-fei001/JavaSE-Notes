package EXERCISE.miniProject.mini19;

//写法2 --> 采取HashMap的操作
//提取csb.txt的内容，并排序

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Demo02 {
    public static void main(String[] args) throws IOException {
        //读取数据并排序
        BufferedReader br = new BufferedReader(new FileReader("D:\\sure_\\" +
                "编译工具和项目\\项目文件\\java_intellij idea\\java2\\day02\\src\\EXERCISE\\" +
                "miniProject\\mini19\\csb.txt"));
        TreeMap<Integer,String> map = new TreeMap<>();
        String line;
        while ((line = br.readLine()) != null) {
            map.put(Integer.parseInt(line.split("\\.")[0]), line);
        }
        br.close();
        System.out.println(map);

        //录入数据
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\sure_\\" +
                "编译工具和项目\\项目文件\\java_intellij idea\\java2\\day02\\src\\EXERCISE\\" +
                "miniProject\\mini19\\NewCSB.txt"));
        Set<Map.Entry<Integer, String>> en = map.entrySet();
        for (Map.Entry<Integer, String> ie : en) {
            String value = ie.getValue();
            bw.write(value);
            bw.newLine();
        }
        bw.close();
    }
}
