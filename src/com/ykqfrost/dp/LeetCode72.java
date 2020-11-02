package com.ykqfrost.dp;

/**
 * @author ykq
 * @date 2020/11/2
 */
public class LeetCode72 {

    public int minDistance(String word1, String word2) {
        int[][] mm = new int[word1.length() + 1][word2.length() + 1];
        mm[0][0] = 0;
        for (int i = 0; i < word1.length(); i++) {
            mm[i + 1][0] = i + 1;
        }
        for (int i = 0; i < word2.length(); i++) {
            mm[0][i + 1] = i + 1;
        }
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    mm[i + 1][j + 1] = mm[i][j];
                } else {
                    int delete = mm[i][j + 1] + 1;
                    int replace = mm[i][j] + 1;
                    int insert = mm[i + 1][j] + 1;
                    mm[i + 1][j + 1] = Math.min(delete, replace);
                    mm[i + 1][j + 1] = Math.min(insert, mm[i + 1][j + 1]);
                }
            }
        }
        return mm[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        LeetCode72 leetCode72 = new LeetCode72();
        int i = leetCode72.minDistance("intention", "execution");
        System.out.println(i);
    }

}
