package EXERCISE.miniProject.mini18;

import java.io.*;

/**
 * 将AAA文件夹拷贝 得到一个BBB文件夹
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        File f1 = new File("D:\\sure_\\JavaFileLearn\\AAA");
        File f2 = new File("D:\\sure_\\JavaFileLearn\\BBB");

        copyDir(f1, f2);
    }
    public static void copyDir(File source, File dest) throws IOException {
        //如果文件不存在 就创建一个 存在就不管啦~
        dest.mkdirs();
        File[] files = source.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    FileInputStream fis = new FileInputStream(file);
                    FileOutputStream fos = new FileOutputStream(new File(dest, file.getName()));
                    byte[] buf = new byte[1024];
                    int len;
                    while ((len = fis.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                    }
                    fos.close();
                    fis.close();
                } else {
                    copyDir(file, new File(dest, file.getName()));
                }
            }
        }
    }
}
