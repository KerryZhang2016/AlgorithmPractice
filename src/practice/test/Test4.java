package practice.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by admin on 16/9/13.
 */
public class Test4 {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("2016-09-18");
        Date date2 = sdf.parse("2016-09-19");
        System.out.println(date1.compareTo(date2));
    }

    /**
     * 判断选择的日期是否是本周
     * */
    public static boolean isThisWeek(String str) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        System.out.println(currentWeek);

        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(str);
        calendar.setTime(date);
        int paramWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        System.out.println(paramWeek);

        return paramWeek == currentWeek;
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
