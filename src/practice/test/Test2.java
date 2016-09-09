package practice.test;

import java.util.Scanner;

/**
 * Created by admin on 16/9/5.
 */
public class Test2 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int number = Integer.parseInt(cin.nextLine());
        int[] array = new int[number];
        for (int m = 0; m < number; m++) {
            array[m] = Integer.parseInt(cin.nextLine());
        }
        for (int i = 0; i < number; i++) {
            System.out.println(getLuckyNumber(array[i]));
        }
    }

    /**
     * 获取小于n的幸运数个数
     * */
    private static int getLuckyNumber(int n) {
        int number = 0;
        for (int i = 1; i <= n; i++) {
            if(isLucky(i)) {
                number ++;
            }
        }
        return number;
    }

    /**
     * 是否是幸运数
     * */
    private static boolean isLucky(int x) {
        return f(x) == g(x);
    }

    private static int f(int x) {
        int result = 0;
        String str = x + "";
        for (int i = 0; i < str.length(); i++) {
            result = result +  Integer.parseInt(str.substring(i, i + 1));
        }
        return result;
    }

    private static int g(int x) {
        int result = 0;
        String str = Integer.toBinaryString(x);// 获取二进制字符串

        for (int i = 0; i < str.length(); i++) {
            result = result +  Integer.parseInt(str.substring(i, i + 1));
        }
        return result;
    }
}
