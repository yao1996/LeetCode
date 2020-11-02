package com.ykqfrost.dp;

/**
 * @author ykq
 * @date 2020/11/2
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode300 {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] mm = new int[nums.length];
        int[] curBase = new int[nums.length];
        mm[0] = 1;
        curBase[0] = 1;
        int finalOne = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            if (cur > finalOne) {
                mm[i] = mm[i - 1] + 1;
                finalOne = cur;
                curBase[i] = curBase[i - 1] + 1;
                continue;
            }
            mm[i] = mm[i - 1];
            if (mm[i] == 1) {
                finalOne = Math.min(finalOne, nums[i]);
            }
            if (cur == finalOne) {
                curBase[i] = curBase[i - 1];
                continue;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    curBase[i] = curBase[j] + 1;
                    if (curBase[i] == mm[i]) {
                        finalOne = Math.min(nums[i], finalOne);
                    }
                    break;
                }
                curBase[i] = 1;
            }
        }
        return mm[nums.length - 1];
    }

    public static void main(String[] args) {
        LeetCode300 leetCode300 = new LeetCode300();
        int[] a = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int max = leetCode300.lengthOfLIS(a);
        System.out.println(max);
    }

}
