package practice.test;

import java.util.Scanner;

/**
 *
 * 给定整数m以及n个数字A1, A2, …, An，将数列A中所有元素两两异或，共能得到n(n-1)/2个结果。请求出这些结果中大于m的有多少个。
 * Created by admin on 16/9/21.
 */
public class Test6 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println(getResult(m, n, array));
    }

    private static int getResult(int m, int n, int[] array) {
        int count = 0;

        if(array.length < 2) return count;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(array[i] != array[j]) {
                    if ((array[i] ^ array[j]) > m) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private class Node {
        int num;
        int value;

        private Node(int num, int value) {
            this.num = num;
            this.value = value;
        }
    }
}
