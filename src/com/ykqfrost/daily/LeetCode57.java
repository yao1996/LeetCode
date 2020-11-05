package com.ykqfrost.daily;

import java.util.Arrays;

/**
 * @author ykq
 * @date 2020/11/4
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int[][] result = new int[intervals.length + 1][2];
        int num = 0;
        boolean hasNewIntervalUsed = false;
        if (intervals.length > 0 && newInterval[1] < intervals[0][0]) {
            result[0] = newInterval;
            num++;
            hasNewIntervalUsed = true;
        }
        for (int[] one : intervals) {
            int start = one[0];
            int end = one[1];
            if (newStart >= start && newStart <= end) {
                end = Math.max(end, newEnd);
                hasNewIntervalUsed = true;
            } else if (start >= newStart && start <= newEnd) {
                start = newStart;
                end = Math.max(end, newEnd);
                hasNewIntervalUsed = true;
            }
            if (num > 0 && newStart > result[num - 1][1] && newEnd < start) {
                result[num] = newInterval;
                num++;
                hasNewIntervalUsed = true;

                result[num] = one;
                num++;
            } else if (num == 0 || (result[num - 1][1] < start)) {
                result[num] = new int[]{start, end};
                num++;
            } else {
                start = Math.min(result[num - 1][0], start);
                end = Math.max(result[num - 1][1], end);
                result[num - 1] = new int[]{start, end};
            }
        }
        if (!hasNewIntervalUsed) {
            result[intervals.length] = newInterval;
            num++;
        }
        return Arrays.copyOf(result, num);
    }

}
