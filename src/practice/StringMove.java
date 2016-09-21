package practice;

/**
 * 字符串移动
 *
 * 题目：字符串由*和26个小写字母组成，要求把*都移到左边，字母都移到右边切保持位置不变,要求最小复杂度的算法。
 *
 * Created by admin on 16/9/21.
 */
public class StringMove {

    public static void main(String[] args) {
        char[] array = {'a', 'b', '*', 'c', '*'};

        System.out.print(move2(array));
    }

    /**
     * 典型的不想动脑子的解法（就是我的解法~）
     * 时间复杂度O(2n),空间复杂度O(n),it can work but....
     * */
    public static char[] move(char[] array) {
        int length = array.length;
        char[] result = new char[length];
        int index = 0;

        // 先来放*
        for (int i = 0; i < length; i++) {
            if(array[i] == '*') {
                result[index++] = '*';
            }
        }

        // 然后来放字母
        for (int i = 0; i < length; i++) {
            if(array[i] != '*') {
                result[index++] = array[i];
            }
        }
        return result;
    }

    // 然后面试官就问我能不能优化一下，她想要空间复杂度为O(1)的算法

    /**
     * 其实我是拒绝的，虽然我好像之前看过类似的题目，但是真的对算法不感冒。
     *
     * 想了想，不创建新的数组也是可以的，依次判断，如果是*，就把它往前放，然后把中间部分的元素往后移一位。
     * 时间复杂度O(n^2),空间复杂度O(1)
     * */
    public static char[] move2(char[] array) {
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            if(array[i] == '*') {
                // 移动从i-1到index的元素，向后移一位
                for (int j = i; j > index; j--) {
                    array[j] = array[j - 1];
                }
                array[index] = '*';// 填充*
            }
        }

        return array;
    }

    // 然后面试官还是不满意，说希望能更快点。其实我也知道应该有个小技巧，可以优化的更好，不会这么笨，但是就是想不起来了。
    // 面试官就提示了一下，试一试倒序

    /**
     * 有个思路还是挺简单的，这样时间复杂度就变成了O(n)
     * */
    public static char[] move3(char[] array) {
        int index = array.length - 1;

        // 移动所有字母到最后
        for (int i = array.length - 1; i >= 0; i--) {
            if(array[i] != '*') {
                array[index--] = array[i];
            }
        }

        // 填充所有的*
        for (int i = 0; i <= index; i++) {
            array[i] = '*';
        }

        return array;
    }

    /**
     * 总结：
     * （1）全是套路
     * （2）算法还是很有趣的，不断学习进步把
     *
     * 最后还进阶了一个问题，如果字符串是由a，b，c三种字符组成，需要最后排序成a在最左边，b在中间，c在最右边，怎么去做？
     *
     * 最简单的思路是遍历两遍，计数+填充，时间复杂度在O(2n)
     * 我提的思路是把a，b看成一类，c看成一类，按上面的算法计算一遍，这样需要O(n),然后再去分a，b，这样会比O(2n)要小一点。
     * 面试官的思路好像是，遍历把a往前放，记录indexA和indexB，然后往indexA和indexB之间补上b。
     * */



}
