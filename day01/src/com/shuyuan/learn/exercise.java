package com.shuyuan.learn;

//数组遍历
/*public class exercise {
    public static void main(String[] args) {
        int[] a = new int[5];
        for (int i = 0; i < a.length; i++) {
            a[i] = 11 * (i + 1);
        }
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            if (i != a.length - 1)
                System.out.print(a[i] + ",");
            else
                System.out.print(a[i] + "]");
        }
    }
}*/



//设计方法，求数组最大值
/*public class exercise {
    public static void main(String[] args) {
        int[] a = new int[5];
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(100) + 1;
            System.out.println(a[i]);
        }
        System.out.println("max = " + rmax(a));
    }

    public static int rmax(int[] a) {
        int max = -1;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }
}*/

//arr from to 定义一个方法，将数组arr下标从from到to的数复制到另一个数组中
//并将其返回
/*public class exercise {
    public static void main(String[] args) {
        long[] arr = new long[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        Scanner sc = new Scanner(System.in);
        int from = sc.nextInt();
        int to = sc.nextInt();
        long[] a2 = copy(arr, from, to);
        for (int i = 0; i < a2.length; i++) {
            System.out.println(a2[i] + " ");
        }
    }
    public static long[] copy(long[] arr, int from, int to) {
        int size = to - from + 1;
        long[] a2 = new long[size];
        int k = 0;
        for (int i = from; i <= to; i++) {
            a2[k] = arr[i];
            k++;
        }
        return a2;
    }
}*/












