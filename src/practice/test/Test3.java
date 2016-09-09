package practice.test;

import java.util.*;

/**
 * Created by admin on 16/9/6.
 */
public class Test3 {

    public static void main(String[] args) {

        int[] a = {2, 4, 2};
        int[] b = {1, 3, 3, 5, 1};
        int[] c = {3, 7, 5, 9, 10};

        sort(a);// 排序

        List<Entity> list = new ArrayList<Entity>();
        for (int i = 0; i < b.length; i++) {
            list.add(new Entity(b[i], c[i]));
        }
        list.sort(new EntityComparator());


        int price = 0;
        for (int i = list.size()-1; i >= 0; i--) {
            if(canUse(a, list.get(i).b)) {
                price = price + list.get(i).c;// 累计金钱
            }
        }

        System.out.print(price);
    }

    private static boolean canUse(int[] a, int b) {
        for (int i = 0; i < a.length; i++) {
            if(a[i] >= b) {
                a[i] = 0;
                return true;
            }
        }
        return false;

    }

    private static class Entity {
        private Entity(int b, int c) {
            this.b = b;
            this.c = c;
        }

        int b;
        int c;
    }

    public static class EntityComparator implements Comparator<Entity> {

        @Override
        public int compare(Entity entity1, Entity entity2) {
            if(entity1.c > entity2.c) return 1;
            return -1;
        }

    }

    public static void sort(int[] args){
        int len = args.length;
        for (int i = 0,k = 0; i < len; i++,k = i) {
            // 在这一层循环中找最小
            for (int j = i + 1; j < len; j++) {
                // 如果后面的元素比前面的小，那么就交换下标，每一趟都会选择出来一个最小值的下标
                if (args[k] > args[j]) k = j;
            }

            if (i != k) {
                int tmp = args[i];
                args[i] = args[k];
                args[k] = tmp;
            }
        }
    }
}