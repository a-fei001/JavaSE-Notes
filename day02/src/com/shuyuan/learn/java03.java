public class java03 {

    // 快速排序的入口方法
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // 获取分区索引
            int partitionIndex = partition(array, low, high);

            // 递归排序分区
            quickSort(array, low, partitionIndex - 1);  // 左边
            quickSort(array, partitionIndex + 1, high); // 右边
        }
    }

    // 分区方法
    private static int partition(int[] array, int low, int high) {
        // 选择最后一个元素作为基准
        int pivot = array[high];
        int i = (low - 1); // 小于基准的元素索引

        for (int j = low; j < high; j++) {
            // 如果当前元素小于或等于基准
            if (array[j] <= pivot) {
                i++;
                // 交换 array[i] 和 array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // 将基准元素放到正确的位置
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1; // 返回基准的索引
    }

    // 主方法测试快速排序
    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};
        int n = array.length;

        System.out.println("排序前的数组:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        quickSort(array, 0, n - 1);

        System.out.println("\n排序后的数组:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
