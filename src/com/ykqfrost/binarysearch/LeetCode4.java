package com.ykqfrost.binarysearch;

/**
 * @author ykq
 * @date 2020/9/1
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode4 {

    /**
     * https://blog.csdn.net/chen_xinjia/article/details/69258706
     * 二分查找法
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1 == null ? 0 : nums1.length;
        int length2 = nums2 == null ? 0 : nums2.length;
        // 确保nums1比nums2短，对nums1进行二分查找
        if (length1 > length2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        assert nums2 != null;
        if (length1 == 0) {
            return (double) nums2[(length2 - 1) / 2] / 2 + (double) nums2[length2 / 2] / 2;
        }
        int cutLeft = 0, cutRight = length1;
        int cut1Num;
        int cut2Num;
        while (cutLeft <= length1) {
            cut1Num = (cutLeft + cutRight + 1) / 2;
            cut2Num = (length1 + length2) / 2 - cut1Num;
            int l1 = cut1Num - 1 < 0 ? Integer.MIN_VALUE : nums1[cut1Num - 1];
            int r1 = cut1Num >= length1 ? Integer.MAX_VALUE : nums1[cut1Num];
            int l2 = cut2Num - 1 < 0 ? Integer.MIN_VALUE : nums2[cut2Num - 1];
            int r2 = cut2Num >= length2 ? Integer.MAX_VALUE : nums2[cut2Num];
            System.out.println(l1 + "  " + r1);
            System.out.println(l2 + "  " + r2);
            if (l1 > r2) {
                cutRight = cut1Num - 1;
            } else if (r1 < l2) {
                cutLeft = cut1Num + 1;
            } else {
                // 正确
                if ((length1 + length2) % 2 == 1) {
                    return Math.min(r1, r2);
                } else {
                    int l = Math.max(l1, l2);
                    int r = Math.min(r1, r2);
                    return ((double) l + r) / 2;
                }
            }
        }
        return 0;
    }

    /**
     * 归并排序，时间复杂度O(n+m)，与题目要求不符
     */
    public double mergeSort(int[] nums1, int[] nums2) {
        int[] nums;
        if (nums1 == null) {
            nums = new int[nums2.length];
        } else if (nums2 == null) {
            nums = new int[nums1.length];
        } else {
            nums = new int[nums1.length + nums2.length];
        }
        for (int i = 0, j = 0; i + j < nums.length; ) {
            if (nums1 == null || i >= nums1.length) {
                nums[i + j] = nums2[j];
                j++;
            } else if (nums2 == null || j >= nums2.length) {
                nums[i + j] = nums1[i];
                i++;
            } else if (nums1[i] > nums2[j]) {
                nums[i + j] = nums2[j];
                j++;
            } else if (nums1[i] <= nums2[j]) {
                nums[i + j] = nums1[i];
                i++;
            }
        }
        if (nums.length % 2 == 0) {
            int sum = nums[nums.length / 2] + nums[nums.length / 2 - 1];
            return sum / (double) 2;
        } else {
            return nums[nums.length / 2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        LeetCode4 leetCode4 = new LeetCode4();
        System.out.println(leetCode4.findMedianSortedArrays(nums1, nums2));
    }

}
