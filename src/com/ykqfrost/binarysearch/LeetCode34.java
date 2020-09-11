package com.ykqfrost.binarysearch;

import java.util.Arrays;

/**
 * @author ykq
 * @date 2020/9/9
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode34 {

    public int[] searchRange(int[] nums, int target) {
        int targetPos = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                targetPos = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (targetPos == -1) {
            return new int[]{-1, -1};
        }
        left = targetPos - 1;
        for (; left >= 0; left--) {
            if (nums[left] != target) {
                break;
            }
        }
        right = targetPos + 1;
        for (; right < nums.length; right++) {
            if (nums[right] != target) {
                break;
            }
        }
        return new int[]{left + 1, right - 1};
    }

    public static void main(String[] args) {
        LeetCode34 leetCode34 = new LeetCode34();
        int[] nums = { 7, 7};
        System.out.println(Arrays.toString(leetCode34.searchRange(nums, 7)));
    }

}
