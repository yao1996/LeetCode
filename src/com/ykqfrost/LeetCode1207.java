package com.ykqfrost;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ykq
 * @date 2020/10/28
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * <p>
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-number-of-occurrences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode1207 {

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxOccurrence = 0;
        for (int i : arr) {
            Integer occurence = map.get(i);
            occurence = occurence == null ? 1 : occurence + 1;
            map.put(i, occurence);
            maxOccurrence = Math.max(maxOccurrence, occurence);
        }
        int[] occurenceArr = new int[maxOccurrence + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (occurenceArr[value] != 0) {
                return false;
            }
            occurenceArr[value] = 1;
        }
        return true;
    }
}
