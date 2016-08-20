package practice;

/**
 * 冒泡排序法
 * 它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
 * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端.
 *
 * Created by admin on 16/8/20.
 */
public class BubbleSort {

    private static void sort(int[] args) {
        // 第一层循环从数组的最后往前遍历
        for (int i = args.length - 1; i > 0; --i) {
            //这里循环的上界是 i - 1，在这里体现出 “将每一趟排序选出来的最大的数从sorted中移除”
            for (int j = 0; j < i; j++) {
                //保证在相邻的两个数中比较选出最大的并且进行交换(冒泡过程)
                if(args[j] > args[j+1]) {
                    int temp = args[j];
                    args[j] = args[j+1];
                    args[j+1] = temp;
                }
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
