package practice.test;

import java.util.Scanner;

/**
 * Created by admin on 16/10/10.
 */
public class Test11 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();// 长度
        int[] arr = new int[num];// 数组

        for (int i = 0; i < num; i++) {
            arr[i] = in.nextInt();
        }

        System.out.print(getResult(arr) + "");
    }


    private static int getResult(int[] arr) {
        if(arr.length <= 2) {
            return arr.length;
        }

        int length = arr.length;// 初始长度
        int index = 0;
        int acc = -1;// 已确认的位置
        int next = index + 1;
        int res = length;

        while (next <= length-1) {
            if(isOdd(arr[index] + arr[next])) {
                res -= 2;
                if(acc == -1) {
                    index += 2;
                    next = index + 1;
                } else {
                    index = acc;
                    next ++;
                }
            } else {
                acc = index;
                index = next;
                next ++;
            }
        }

        return res;
    }

    private static boolean isOdd(int sum) {
        return sum % 2 == 1;
    }
}
