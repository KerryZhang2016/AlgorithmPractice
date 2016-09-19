package practice.test;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by admin on 16/9/10.
 */
public class Test2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        int MaxMem = scanner.nextInt();

        int[] memory = new int[MaxMem];// 内存
        HashMap<Integer, Space> spaces = new HashMap<Integer, Space>();// 已分配内存块

        for (int i = 0; i < T; i++) {
            String operation = scanner.nextLine();
            doOperation(memory, spaces, operation);
        }
    }

    private static void doOperation(int[] memory, HashMap<Integer, Space> spaces, String operation) {
        if(operation.startsWith("new")) {
            // 创建内存
            int num = Integer.parseInt(operation.substring(4, operation.length()));

            // 判断位置

            // 创建成功
            int size = spaces.size();
            spaces.put(size + 1, new Space(num, num));

        } else if (operation.startsWith("del")) {
            // 清空内存
        } else if (operation.startsWith("def")) {
            // 清理内存
        }
    }

    /**
     * 一段内存
     * */
    private static class Space {
        int size;

        int position;// 位置

        private Space(int size, int position) {
            this.size = size;
            this.position = position;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }
}
