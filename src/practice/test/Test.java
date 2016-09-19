package practice.test;

import java.util.*;

/**
 * Created by admin on 16/9/10.
 */
public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            getOrientation(scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
        }
    }

    private static void getOrientation(String str1, String str2, String str3) {
        List<Integer> array1 = getLocation(str1, str2);
        List<Integer> array2 = getLocation(str1, str3);

        // 比较
        if(array1.size() == 0 || array2.size() == 0) {
            System.out.println("invalid");
            return;
        }

        int max1 = 0;
        int min1 = 0;
        int max2 = 0;
        int min2 = 0;
        for(Integer i : array1) {
            if(i > max1) {
                max1 = i;
            }
            if(min1 == 0 || i < min1) {
                min1 = i;
            }
        }
        for(Integer i : array2) {
            if(i > max2) {
                max2 = i;
            }
            if(min2 == 0 || i < min2) {
                min2 = i;
            }
        }

        if(max1 < min2) {
            System.out.println("forward");
        } else if(max2 < min1) {
            System.out.println("backward");
        } else {
            System.out.println("both");
        }

    }

    private static List<Integer> getLocation(String str1, String str2) {
        List<Integer> array = new ArrayList<Integer>();

        for(int i = 0; i + str2.length() <= str1.length(); i ++) {
            if(str1.substring(i, i+str2.length()).equals(str2)) {
                array.add(i);
            }
        }
        return array;
    }
}
