package practice.test;

/**
 * Created by admin on 16/10/8.
 */
public class Test10 {

    private static final int BEGIN_YEAR = 2016;
    private static final int WHEEL_DIMENSION = 2050;

    public static void main(String[] args) {
        long data = 0x1bd0b812;
        System.out.println(getSpeedFromData(data) + "");

        long totalTime = getTimeFromData(data);
        Date date = new Date();
        long res = totalTime % 1440l;
        date.minute = (int) (res % 60l);// 计算分钟
        date.hour = (int) (res / 60l);// 计算小时

        long numDays = 0;
        numDays += totalTime / 1440l;
        date.year = BEGIN_YEAR;// 设置年

        // 超过一年，进位
        while (numDays > yearLength(date.year)) {
            numDays -= yearLength(date.year);
            date.year ++;
        }

        // 超过一个月，进位
        date.month = 1;
        while (numDays > daysInMonth(isLeapYear(date.year), date.month)) {
            numDays -= daysInMonth(isLeapYear(date.year), date.month);
            date.month ++;
        }
        // 设置日
        date.day = (int) numDays;

        System.out.println("获得日期" + date.year + "年" + date.month + "月" + date.day + "日" + date.hour + ":" + date.minute);
    }

    private static boolean isLeapYear(long year) {
        boolean flag = false;
        if((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) {
            flag = true;
        }
        return flag;
    }

    private static long yearLength(long year) {
        if(isLeapYear(year)) return 366;
        else return 365;
    }

    private static int daysInMonth(boolean isHeap, int month) {
        if(month == 2) {
            // 二月
            if(isHeap) {
                return 29;
            } else {
                return 28;
            }
        } else if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else {
            return 30;
        }
    }

    /**
     * 计算时间
     *
     * @return 距离2016/01/01 00:00 多少分钟
     * */
    private static long getTimeFromData(long data) {
        long time = (data >> 10) & 0x003FFFFF;
        return time;
    }

    /**
     * 计算速度
     * @return km/h
     * */
    private static float getSpeedFromData(long data) {
        float speed;
        long wheelCount = (data & 0x000003ff);
        speed = (float) (wheelCount * WHEEL_DIMENSION) / 1000.0f / 60.0f * 3.6f;
        return speed;
    }

    static class Date {
        int year;
        int month;
        int day;
        int hour;
        int minute;
    }
}
