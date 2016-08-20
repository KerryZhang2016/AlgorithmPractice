package practice;

/**
 * 选择排序法
 * 选择排序（Selection sort）是一种简单直观的排序算法。
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 *
 * Created by admin on 16/8/20.
 */
public class SelectSort {

    private static void sort(int[] args) {
        int len = args.length;
        for (int i = 0, k = 0; i < len; i++,k = i) {
            // 在这层循环中找最小
            for (int j = i + 1; j < len; j++) {
                // 如果后面的元素比前面的小,那么就交换下标，每一趟都会选择出来一个最小值的下标
                if(args[k] > args[j]) k = j;
            }

            if(i != k) {
                int tmp = args[i];
                args[i] = args[k];
                args[k] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = new int[5];
        test[0] = 2;
        test[1] = 1;
        test[2] = 5;
        test[3] = 1;
        test[4] = 2;

        sort(test);
        for (int i : test) {
            System.out.println(i);
        }
    }

}
