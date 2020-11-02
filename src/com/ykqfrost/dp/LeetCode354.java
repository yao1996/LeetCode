package com.ykqfrost.dp;

import java.util.Arrays;

/**
 * @author ykq
 * @date 2020/11/2
 */
public class LeetCode354 {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        int[] mm = new int[envelopes.length];
        mm[0] = 1;
        for (int i = 1; i < envelopes.length; i++) {
            int[] cur = envelopes[i];
            for (int j = i - 1; j >= 0; j--) {
                int[] prev = envelopes[j];
                if (cur[0] > prev[0] && cur[1] > prev[1]) {
                    mm[i] = Math.max(mm[j] + 1, mm[i]);
                }
            }
            if (mm[i] == 0) {
                mm[i] = 1;
            }
        }
        int max = 0;
        for (int i : mm) {
            max = Math.max(max, i);
        }
        return max;
    }
}
