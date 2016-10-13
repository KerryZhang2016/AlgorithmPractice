package practice.test;

import java.util.Scanner;

/**
 * Created by admin on 16/10/10.
 */
public class Test12 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = Integer.parseInt(in.nextLine());// 长度
        String str = in.nextLine();
        int m = Integer.parseInt(in.nextLine());
        String[] array = new String[m];
        for (int i = 0; i < m; i ++) {
            array[i] = in.nextLine();
        }

        System.out.print(getResult(str, array) + "");
    }

    private static int getResult(String str, String[] array) {
        if(str.length() == 2) {
            if(contains(str, array)) {
                return 1;
            } else {
                return 0;
            }
        } else if(str.length() < 2) {
            return 0;
        }
        int acc = -1;
        int index = 0;
        int next = index + 1;
        int delete = 0;

        while (next <= str.length() - 1) {
            char indexChar = str.charAt(index);
            char nextChar = str.charAt(next);
            String s = indexChar + ""+ nextChar;

            if(contains(s, array)) {
                // 非法
                if(next == str.length() - 1) {
                    delete ++;
                    next++;
                } else {
                    if(acc == -1) {
                        if(isDeleteIndex(str.charAt(index), str.charAt(next), str.charAt(next + 1), array)) {
                            delete++;
                            index = next;
                            next ++;
                        } else {
                            delete++;
                            next++;
                            acc = index;
                        }
                    } else {
                        if(isDeleteIndex(str.charAt(acc), str.charAt(index), str.charAt(next), str.charAt(next+1), array)) {
                            // 删除index
                            delete ++;
                            index = acc;
                        } else {
                            // 删除next
                            delete ++;
                            acc = index;
                            next ++;
                        }
                    }
                }

            } else {
                // 合法
                acc = index;
                index = next;
                next ++;
            }
        }

        return delete;
    }

    private static boolean contains(String s, String[] array) {
        for (String str : array) {
            if(str.equals(s)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDeleteIndex(char index, char next, char next2, String[] array) {
        String s = index + ""+ next2;
        return !contains(s, array);
    }

    private static boolean isDeleteIndex(char acc, char index, char next, char next2, String[] array) {
        String s1 = acc + ""+ next + "" + next2;
        String s2 = acc + "" + index + "" + next2;
        return getResult(s1, array) <= getResult(s2, array);
    }
}
