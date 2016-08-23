package practice;

/**
 * 二分查找法,又称为折半查找，它是一种效率较高的查找方法。
 * 【二分查找法要求】：1.必须采用顺序存储结果 2.必须按关键字大小有序排列
 *
 * Created by admin on 16/8/23.
 */
public class BinarySearch {

    public static int binarySearch(int[] srcArray, int des) {
        int low = 0;
        int high = srcArray.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if(des == srcArray[middle]) {
                return middle;
            } else if (des <srcArray[middle] ) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 查找在指定区间内的位置
     * */
    public static int binarySearch(int[] srcArray, int des, int beginIndex, int endIndex) {
        int middle = (beginIndex + endIndex) / 2;
        if(des < srcArray[beginIndex] || des > srcArray[endIndex] || beginIndex > endIndex) {
            return -1;
        }

        if(des < srcArray[middle]) {
            return binarySearch(srcArray, des, beginIndex, middle - 1);
        } else if(des > srcArray[middle]) {
            return binarySearch(srcArray, des, middle + 1, endIndex);
        } else {
            return middle;
        }
    }


    public static void main(String[] args) {
        int[] src = new int[] {1, 3, 5, 7, 8, 9};
        System.out.println(binarySearch(src, 5));
        System.out.println(binarySearch(src,7,0,src.length-1));
    }
}
