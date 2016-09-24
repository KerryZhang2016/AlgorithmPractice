package practice.test;

import java.util.Scanner;

/**
 * 十进制转n进制
 *
 * Created by admin on 16/9/23.
 */
public class Test8 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();
        System.out.println(getResult(m, n));
    }

    private static String getResult(int m, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] num = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        while (m > 0) {
            stringBuilder.insert(0, num[m % n]);
            m = m / n;
        }
        return stringBuilder.toString();
    }
}
