package practice.test;

import java.util.Scanner;

/**
 *
 * 头条的2017校招开始了！为了这次校招，我们组织了一个规模宏大的出题团队。每个出题人都出了一些有趣的题目，而我们现在想把这些题目组合成若干场考试出来。在选题之前，我们对题目进行了盲审，并定出了每道题的难度系数。一场考试包含3道开放性题目，假设他们的难度从小到大分别为a, b, c，我们希望这3道题能满足下列条件：
 a <= b <= c
 b - a <= 10
 c - b <= 10
 所有出题人一共出了n道开放性题目。现在我们想把这n道题分布到若干场考试中（1场或多场，每道题都必须使用且只能用一次），然而由于上述条件的限制，可能有一些考试没法凑够3道题，因此出题人就需要多出一些适当难度的题目来让每场考试都达到要求。然而我们出题已经出得很累了，你能计算出我们最少还需要再出几道题吗？
 * Created by admin on 16/9/21.
 */
public class Test5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int[] array = new int[num];

        for (int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(getResult(array));
    }

    /**
     * 获取结果
     * */
    private static int getResult(int[] array) {
        int count = 0;
        // 快速排序
        sort(array, 0, array.length - 1);

        int i = 0;
        while (i <= array.length - 3) {
            // 往后遍历三个
            if(array[i + 1] - array[i] >10) {
                // 第二个不符合
                count += 2;
                i += 1;
            } else {
                if(array[i + 2] - array[i + 1] > 10) {
                    // 第三个不符合
                    count += 1;
                    i += 2;
                } else {
                    i +=3;
                }
            }
        }

        if(i == array.length - 2) {
            // 倒数第二个位置
            if(array[i + 1] - array[i] > 10) {
                // 不符合
                count += 2;
            } else {
                count += 1;
            }
        } else if(i == array.length -1) {
            count += 2;
        }

        return count;
    }

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
}
