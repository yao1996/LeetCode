package com.ykqfrost.dp;

/**
 * @author ykq
 * @date 2020/9/11
 * 0-1背包问题
 * https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/bei-bao-wen-ti
 */
public class Package01 {

    public int getMaxValue(int[] w, int[] v, int weight) {
        int[][] values = new int[w.length + 1][weight + 1];
        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j <= weight; j++) {
                if (w[i] > j) {
                    values[i + 1][j] = values[i][j];
                    continue;
                }
                // 取第i件商品时
                int value1 = values[i][j - w[i]] + v[i];
                int value2 = values[i][j];
                values[i + 1][j] = Math.max(value1, value2);
            }
        }
        return values[w.length][weight];
    }

    public static void main(String[] args) {
        Package01 package01 = new Package01();
        int weight = 4;
        int[] w = {2, 1, 3};
        int[] v = {4, 2, 3};
        System.out.println(package01.getMaxValue(w, v, weight));
    }

}
