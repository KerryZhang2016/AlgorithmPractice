package practice;

/**
 * 快速排序法
 *
 * 又称划分交换排序（partition-exchange sort），一种排序算法，最早由东尼·霍尔提出。
 * 在平均状况下，排序n个项目要Ο(n log n)次比较。在最坏状况下则需要Ο(n2)次比较，但这种状况并不常见。事实上，快速排序通常明显比其他Ο(n log n)算法更快，因为它的内部循环（inner loop）可以在大部分的架构上很有效率地被实现出来
 *
 * 算法规则： 本质来说，快速排序的过程就是不断地将无序元素集递归分割，一直到所有的分区只包含一个元素为止。
 * 由于快速排序是一种分治算法，我们可以用分治思想将快排分为三个步骤：
 * 1.分：设定一个分割值，并根据它将数据分为两部分
 * 2.治：分别在两部分用递归的方式，继续使用快速排序法
 * 3.合：对分割的部分排序直到完成
 *
 * ①以第一个关键字 K 1 为控制字，将 [K 1 ,K 2 ,…,K n ] 分成两个子区，使左区所有关键字小于等于 K 1 ，右区所有关键字大于等于 K 1 ，最后控制字居两个子区中间的适当位置。在子区内数据尚处于无序状态。
 * ②把左区作为一个整体，用①的步骤进行处理，右区进行相同的处理。（即递归）
 * ③重复第①、②步，直到左区处理完毕。
 *
 * Created by admin on 16/8/20.
 */
public class QuickSort {

    private static void sort(int[] args, int start, int end) {
        // 当分治的元素大于1时,才有意义
        if(end - start > 1) {
            int mid;
            mid = dividerAndChange(args, start, end);
            // 对左部分排序
            sort(args, start, mid);
            // 对右部分排序
            sort(args, mid + 1, end);
        }

    }

    private static int dividerAndChange(int[] args, int start, int end) {
        // 标准值
        int pivot = args[start];
        while (start < end) {
            // 从右向左寻找，一直找到比参照值还小的数值，进行替换
            // 这里要注意，循环条件必须是 当后面的数小于参照值的时候,我们才跳过这个循环
            while (start < end && args[end] >= pivot)
                end--;

            if(start < end) {
                args[start++] = args[end];
            }

            // 从左往右寻找，一直找到比参照值还大的数组,进行替换
            while (start < end && args[start] < pivot)
                start++;

            if(start < end) {
                args[end--] = args[start];
            }
        }

        args[start] = pivot;
        return start;
    }

    public static void main(String[] args) {
        int[] test = new int[5];
        test[0] = 2;
        test[1] = 3;
        test[2] = 5;
        test[3] = 1;
        test[4] = 8;

        sort(test, 0, 4);
        for (int i : test) {
            System.out.println(i);
        }
    }
}
