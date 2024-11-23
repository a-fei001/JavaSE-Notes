package com.shuyuan.learn;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class T {
    private static Set<String> hashSet;
    public static void main(String[] args) throws IOException {

        File file = new File("D:\\sure_\\JavaFileLearn\\AAA");
        hashSet = new HashSet<String>();
        countType(file);
        System.out.println(hashSet);
    }
    public static void countType(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if(f.isFile()) {
                    String s = f.getName();
                    String[] split = s.split("\\.");
                    hashSet.add(split[split.length-1]);
                } else {
                    countType(f);
                }
            }
        }
    }
}
