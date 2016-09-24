package practice;

import java.util.Random;

/**
 * 洗牌算法
 *
 * Created by admin on 16/9/24.
 */
public class Shuffle {

    public static void main(String[] args) {
        int[] array = new int[52];
        int[] result = new int[52];

        for (int i = 0; i < 52; i++) {
            array[i] = i;
        }
//        shuffleFisherYates(array, 52);
        shuffleInsideOut(array, 52, result);
        for (int i = 0; i < 52; i++) {
            System.out.println(result[i] + "");
        }
    }

    /**
     * FisherYates洗牌算法
     *
     * 每次从未选中的数字中随机挑选一个加入排列，时间复杂度为O(n)
     * */
    private static void shuffleFisherYates(int[] array, int length) {
        for (int i = length - 1; i > 0; i--) {
            Random random = new Random();
            int a = random.nextInt(i);
            int temp = array[i];
            array[i] = array[a];
            array[a] = temp;
        }
    }

    /**
     * inside-out算法
     *
     * 算法的思想就是遍历原数组，把原数组中位置 i 的数据随机放到新数组的前i个位置（包括第i个）中的某一个（假设放到第k个），
     * 然后把新数组的第k个位置的数放到新数组的第 i 个位置
     * */
    private static void shuffleInsideOut(int[] arraySrc, int length, int[] arrayDest) {
        arrayDest[0] = arraySrc[0];

        for (int i = 1; i < length; i++) {
            Random random = new Random();
            int k = random.nextInt(i);
            arrayDest[i] = arrayDest[k];
            arrayDest[k] = arraySrc[i];
        }
    }

    /**
     * 测试一个洗牌程序的正确性：运行该洗牌程序m次，然后计算每张牌在每个位置出现的次数，这个次数应该接近m/n,其中n为牌的数目
     * */

}
