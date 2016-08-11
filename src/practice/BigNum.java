package practice;

/**
 * 大数计算
 *
 * Created by kerry on 16/8/11.
 */
public class BigNum {

    /**
     * 两个大数相加
     * */
    private static String add(String a, String b) {
        String str = "";
        String strTemp = "";

        int lenA = a.length();
        int lenB = b.length();
        int maxLen = (lenA > lenB) ? lenA : lenB;
        int minLen = (lenA < lenB) ? lenA : lenB;

        for (int i = maxLen - minLen; i > 0; i--) {
            strTemp += "0";
        }

        if(maxLen == lenA) {
            b = strTemp + b;
        } else {
            a = strTemp + a;
        }

        int JW = 0;
        for (int i = maxLen - 1; i >= 0; i--) {
            int tempA = Integer.parseInt(String.valueOf(a.charAt(i)));
            int tempB = Integer.parseInt(String.valueOf(b.charAt(i)));
            int temp;

            if(tempA + tempB + JW >= 10 && i != 0) {
                temp = tempA + tempB + JW - 10;
                JW = 1;
            } else {
                temp = tempA + tempB + JW;
                JW = 0;
            }
            str = String.valueOf(temp) + str;
        }
        return str;
    }

    /**
     * 相减
     * */
    public static String minus(String a, String b) {
        String str = "";
        int lenA = a.length();
        int lenB = b.length();

        if(lenA >= lenB) {
            int maxLen = (lenA > lenB) ? lenA : lenB;
            int minLen = (lenA < lenB) ? lenA : lenB;
            String strTemp = "";

            for (int i = maxLen - minLen; i > 0; i--) {
                strTemp += "0";
            }
            b = strTemp + b;
            int JW = 0;

            for (int i = maxLen - 1; i >= 0; i--){
                int tempA = Integer.parseInt(String.valueOf(a.charAt(i)));
                int tempB = Integer.parseInt(String.valueOf(b.charAt(i)));
                int temp = 0;
                if(i != 0) {
                    if(tempA - tempB - JW < 0) {
                        temp = tempA - tempB - JW + 10;
                        JW = 1;
                    } else {
                        temp = tempA - tempB - JW;
                        JW = 0;
                    }
                    str = String.valueOf(temp) + str;
                } else {
                    if(tempA - tempB - JW < 0) {
                        str = minus(b, a);
                        str = "-" + str;
                    } else {
                        temp = tempA - tempB - JW;
                        if(temp != 0)
                            str = String.valueOf(temp) + str;
                    }
                }
            }
        } else {
            str = minus(b, a);
            str =  "-" + str;
        }

        return str;
    }

    /**
     * 相乘
     * */
    private static void multiply(String str1, String str2) {
        int alen = str1.length();
        int blen = str2.length();
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();

        // 两数乘积数不会超过乘数位数和+3位
        int cSize = alen + blen + 3;
        // 开辟乘积数组
        int[] c = new int[cSize];
        // 乘积数组填充0
        for (int i = 0; i < c.length; i++) {
            c[i] = 0;
        }
        // 对齐逐位相乘
        for (int j = 0; j < blen; j++) {
            for (int i = 0; i < alen; i++) {
                c[i + j] += Integer.parseInt(String.valueOf(a[i])) * Integer.parseInt(String.valueOf(b[j]));
            }
        }
        int m = 0;
        // 进位处理
        for (m = cSize - 1; m > 0; m--) {
            int carry = c[m] / 10;
            c[m] = c[m] % 10;
            if(carry > 0)
                c[m - 1] += carry;
        }
        // 找到最高位
        for (m = cSize - 1; m >= 0; m--) {
            if(c[m] > 0) {
                break;
            }
        }

        // 打印
        System.out.print("乘积:" + m + "@@");
        for (int n = 0; n <= m; n ++) {
            System.out.print(c[n]);
        }
    }



    public static void main(String[] args) {
        System.out.println("相加：" + add("111111" , "222222222"));
        System.out.println("相减：" + minus("111111" , "11111"));
        multiply("12", "6");
    }

}
