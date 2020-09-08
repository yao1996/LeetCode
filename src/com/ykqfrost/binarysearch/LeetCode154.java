package com.ykqfrost.binarysearch;

/**
 * @author ykq
 * @date 2020/9/2
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 注意数组中可能存在重复的元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入: [1,3,5]
 * 输出: 1
 * 示例 2：
 * <p>
 * 输入: [2,2,2,0,1]
 * 输出: 0
 * 说明：
 * <p>
 * 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
 * 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 思路：
 * 半有序，取一个数，如果左侧的数比该数大，找到目标
 * 采用二分查找，二分查找的问题在于如果全是重复的数字，时间复杂度指数级递增
 * 采用遍历，时间复杂度为O(n)
 */
public class LeetCode154 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid - 1;
            } else if (nums[mid] == nums[right]) {
                // {3,3,1,3}
                // 防止出现如上情况，最小值在mid和right中间
                right --;
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        LeetCode154 leetCode154 = new LeetCode154();
        int[] nums = {3,3,1,3};
        System.out.println(leetCode154.findMin(nums));
    }
}

