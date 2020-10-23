package com.ykqfrost.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ykq
 * @date 2020/10/22
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode56 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        System.out.println(Arrays.deepToString(intervals));
        int[][] res = new int[intervals.length][2];
        int index = 0;
        int first = intervals[0][0];
        int last = intervals[0][1];
        for (int[] i : intervals) {
            if (i[0] <= last && i[1] > last) {
                last = i[1];
            } else if (i[0] > last) {
                int[] r = new int[2];
                r[0] = first;
                r[1] = last;
                res[index] = r;
                index++;
                first = i[0];
                last = i[1];
            }
        }
        int[] r = new int[2];
        r[0] = first;
        r[1] = last;
        res[index] = r;
        index++;
        return Arrays.copyOf(res, index);
    }

    public static void main(String[] args) {
        LeetCode56 leetCode56 = new LeetCode56();
        int[][] a = {{4, 5}, {1, 4}};
        int[][] res = leetCode56.merge(a);
        System.out.println(Arrays.deepToString(res));
    }
}
