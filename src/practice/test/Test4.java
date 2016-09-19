package practice.test;

import java.util.Scanner;

/**
 * Created by admin on 16/9/13.
 */
public class Test4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            System.out.println(getResult(n));
        }
    }

    private static long getResult(long n) {
        return n < 2 ? n : getResult(--n) + getResult(--n);
    }

    private static long Fib(int n) {
        int i;
        long a = 0;
        long b = 1;
        long c = 0;

        if(n <= 1) {
            return n;
        } else {
            for (i = 2; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }
}
