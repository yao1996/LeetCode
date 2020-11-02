package com.ykqfrost.daily;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author ykq
 * @date 2020/11/2
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 * <p>
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer n : nums1) {
            map.put(n, 1);
        }
        for (Integer n : nums2) {
            Integer b = map.get(n);
            if (b != null && b > 0) {
                list.add(n);
                map.put(n, 0);
            }
        }
        int[] r = new int[list.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = list.get(i);
        }
        return r;
    }
}
