package EXERCISE.miniProject.mini17;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        getListRoot();
    }

    public static void getListRoot() {
        File[] files = File.listRoots();
        for (File file : files) {
            getDirectory(file);
        }
    }

    public static void getDirectory(File file) {
        File[] ff = file.listFiles();
        if (ff != null) {//当遇到无权限访问的文件夹时 ff为null
            for (File file1 : ff) {
                if (file1.isFile()) {
                    if (file1.getName().endsWith(".exe")) {
                        System.out.println(file1);
                    }
                } else {
                    getDirectory(file1);
                }
            }
        }
    }
}
