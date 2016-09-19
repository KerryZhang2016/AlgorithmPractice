package practice.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();// 获取第一行
            String[] array = line.split(" ");// 获取每个单词

            System.out.println(judgeTowWords(array[0], array[1]));
        }
    }

    /**
     * 判断
     * */
    private static String judgeTowWords(String word1, String word2) {
        if(word1.length() != word2.length()) {
            return "no";
        }

        char index = word1.charAt(0);
        List<Integer> positions = new ArrayList<Integer>();

        // 获取起始点
        for (int i = 0; i < word2.length(); i++) {
            if(word2.charAt(i) == index) {
                positions.add(i);
            }
        }

        // 开始从第二个字符遍历
        for (int i = 1; i < word1.length(); i++) {
            char c = word1.charAt(i);

            String result = "no";
            for (int position : positions) {
                if(position + i > word1.length() - 1) {
                    position = position - word1.length();
                }
                if(c == word2.charAt(position + i)) {
                    result = "yes";
                }
            }

            if(result.equals("no")) {
                return "no";
            }
        }

        return "yes";
    }
}
