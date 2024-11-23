package EXERCISE;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * 6
 * <p>
 * 7
 * <p>
 * 9
 * <p>
 * 7
 * <p>
 * 9
 * 10
 * <p>
 * 7
 * <p>
 * 9
 * 10
 * <p>
 * 7
 * <p>
 * 9
 * 10
 * <p>
 * <p>
 * 02
 * <p>
 * 7
 * <p>
 * 9
 * 10
 * <p>
 * <p>
 * 02
 * <p>
 * 7
 * <p>
 * 9
 * 10
 * <p>
 * <p>
 * 02
 * <p>
 * 7
 * <p>
 * 9
 * 10
 * <p>
 * <p>
 * 02
 * <p>
 * 03
 * <p>
 * 7
 * <p>
 * 9
 * 10
 * <p>
 * <p>
 * 02
 * <p>
 * 03
 * <p>
 * 7
 * <p>
 * 9
 * 10
 * <p>
 * <p>
 * 02
 * <p>
 * 03
 */
//练习：遍历字符串&统计字符串个数
//两个方法：
//charAt()：会根据索引获取对应的字符
//length(): 会返回字符串的长度
/*public class exercise{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();//ctrl+alt+v 生成sc.next()前面的内容
        //快速生成for循环快捷键
        //数组名.fori 回车   forr倒着遍历
        //字符串.length().fori  回车
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);//citrl alt v 自动生成左边
            System.out.print(c+" ");
        }
    }
}*/


/**
 * 7
 */

// 字符串拼接案例
/*
 定义一个方法，把 int 数组中的数据按照指定的格式拼接成一个字符串返回，调用该方法，
​ 并在控制台输出结果。例如，数组为 int[] arr = {1,2,3}; ，执行方法后的输出结果为：[1, 2, 3]
*/
/*public class exercise {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        String s = arrToString(arr);
        System.out.println(s);
    }

    public static String arrToString(int[] arr) {
        if (arr == null) {
            return "";
        }
        if (arr.length == 0) {
            return "[]";
        }
        String result = "[";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
            //result = result + arr[i];
            if (i != arr.length - 1)
                result += ',';
        }
        result += "]";
        return result;
    }
}*/

//字符串反转案例
/*
* ​ 定义一个方法，实现字符串反转。键盘录入一个字符串，调用该方法后，在控制台输出结果
​ 例如，键盘录入 abc，输出结果 cba
* */
/*public class exercise {
    public static void main(String[] args) {
        String str = "abcdef";
        reverse(str);
    }

    //shift f6 批量修改
    public static void reverse(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i) + " ");
        }
    }
}*/

/**
 * 9
 */
//手机屏蔽
/*
 * *String substring(int beginIndex,int endIndex)  截取
 * 包头不包尾
 * 对原字符串没影响，只有返回值才是截取的小段
 * *String substring(int beginIndex)
 * 截取到末尾
 * */
/*public class exercise {
    public static void main(String[] args) {
        //1.获取一个手机号码
        String num = "15037115954";
        //2.截取前三位
        String start = num.substring(0, 3);
        //3.截取后4位
        String end = num.substring(7);
        //4.输出加密号码
        System.out.println(start + "****" + end);
    }
}*/

//敏感词替换
/*
键盘录入一个 字符串，如果字符串中包含（TMD），则使用***替换
*/
/*
String replace(oldValue,newValue)     替换
对原字符串没影响，只有返回值才是截取的小段
 */
/*public class exercise{
    public static void main(String[] args) {
        String talk = "你他妈的狗屎吧，天天舔大粪也不会恶心成那个逼样。";
        String[] str={"他妈的","狗屎","大粪","恶心","逼"};
        for (int i = 0; i < str.length; i++) {//数组的length属性
            talk = talk.replace(str[i],"***");
        }
        System.out.println(talk);
    }
}*/

/**10
 *
 */
//对称字符串
/*
用到StringBuilder的情况：1.字符串的拼接(String太慢啦) 2.字符串的反转
*/
/*public class exercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String s1 = sc.next();

        String s2 = new StringBuilder(s1).reverse().toString();

        if (s2.equals(s1)) {
            System.out.println("s1是对称字符串");
        } else {
            System.out.println("s1不是对称字符串");
        }
    }
}*/

//拼接字符串
/*public class exercise{
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        String s = arrToString(arr);
        System.out.println(s);
    }
    public static String arrToString(int[] arr){
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if(i != 4){
                sb.append(',');
            }
        }
        return sb.append(']').toString();
    }
}*/

/**
 * 02
 */
//添加整数并遍历
/*
基本数据类型对应包装类
int --> Integer
char --> Character
别的都是首字母大写就行了
 */
/*public class exercise {
    public static void main(String[] args) {
        ArrayList<StringJoiner> als = new ArrayList<>();
        StringJoiner sj = new StringJoiner(", ");
        sj.add("what");
        sj.add("a");
        sj.add("fucking");
        sj.add("day");
        als.add(sj);
        System.out.println(als);

        ArrayList<Integer> ali = new ArrayList<>();
        ali.add(111);
        ali.add(222);
        ali.add(333);
        ali.add(444);
        ali.add(555);
        System.out.println(ali);
        System.out.print("[");
        for (int i = 0; i < ali.size(); i++) {
            System.out.print(ali.get(i));
            if (i != ali.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}*/

/**
 * 03
 */
//添加学生对象并遍历
/*public class exercise {
    public static void main(String[] args) {
        ArrayList<exerciseH> ale = new ArrayList<>();

        exerciseH s1 = new exerciseH("张三", 15);
        exerciseH s2 = new exerciseH("刀哥", 55);
        exerciseH s3 = new exerciseH("老八", 38);
        exerciseH s4 = new exerciseH("虎哥", 45);
        exerciseH s5 = new exerciseH("卢本伟", 22);
        ale.add(s1);
        ale.add(s2);
        ale.add(s3);
        ale.add(s4);
        ale.add(s5);

        for (int i = 0; i < ale.size(); i++) {
            exerciseH e1 = ale.get(i);
            System.out.println("姓名：" + e1.getName() + "\t年龄：" + e1.getAge());
        }
    }
}*/

/*
public class exercise {
    public static void main(String[] args) {
        ArrayList<exerciseH> ale = new ArrayList<>();

        exerciseH s1 = new exerciseH("张三", 15);
        exerciseH s2 = new exerciseH("刀哥", 55);
        exerciseH s3 = new exerciseH("老八", 38);
        exerciseH s4 = new exerciseH("虎哥", 45);
        exerciseH s5 = new exerciseH("卢本伟", 22);
        ale.add(s1);//添加的是s1的地址值
        ale.add(s2);
        ale.add(s3);
        ale.add(s4);
        ale.add(s5);

        for (int i = 0; i < ale.size(); i++) {
            exerciseH e1 = ale.get(i);
            System.out.println("姓名：" + e1.getName() + "\t年龄：" + e1.getAge());
        }
    }
}*/

/**
 * 04
 */
//查找用户的索引
/*public class exercise {
    public static void main(String[] args) {
        ArrayList<exerciseH> ale = new ArrayList<>();

        exerciseH s1 = new exerciseH("001", "sb001", "aaa");
        exerciseH s2 = new exerciseH("002", "sb002", "bbb");
        exerciseH s3 = new exerciseH("003", "sb003", "ccc");
        ale.add(s1);
        ale.add(s2);
        ale.add(s3);

        //输入id查找用户是否存在
        Scanner sc = new Scanner(System.in);
        String m_id = sc.next();

        System.out.println("用户是否存在?\t" + judegeAle(ale, m_id));
    }

    public static boolean judegeAle(ArrayList<exerciseH> ale, String m_id) {
        for (int i = 0; i < ale.size(); i++) {
            if (ale.get(i).getId().equals(m_id)) {
                return true;
            }
        }
        return false;
    }
}*/





















