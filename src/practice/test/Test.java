package practice.test;

import java.util.Scanner;

/**
 * Created by admin on 16/9/5.
 */
public class Test {

    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);

        int number = Integer.parseInt(cin.nextLine());
        int[] array = new int[number];
        for (int m = 0; m < number; m++) {
            array[m] = Integer.parseInt(cin.nextLine());
        }
        for(int m = 0; m < number; m ++){
            int k = array[m];

            int digit = 1;
            while (k >= Math.pow(2, digit)) {
                k  = (int) (k - Math.pow(2, digit));
                if(k != 0) {
                    digit ++;
                }
            }

            // 余下k个数，目前位数为digit
            if(k == 0) {
                String result = "";
                for (int i = 0; i < digit; i ++) {
                    result = result + "7";
                }
                System.out.print(result + "");
            } else {
                String str = Integer.toBinaryString(k - 1);// 获取二进制字符串
                if(str.length() < digit) {
                    String head = "";
                    for (int i = 0; i < digit - str.length(); i++){
                        head = head + "0";
                    }
                    str = head + str;// 获取最终的字符串
                }
                // 替换字符
                str = str.replace("0", "4");
                str = str.replace("1", "7");
                System.out.print(str);
            }
        }
    }
}
