package com.ykqfrost.binarysearch;

/**
 * @author ykq
 * @date 2020/9/9
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= 数组长度 <= 10000
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JianZhiOffer53 {

    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == nums[mid]) {
                left = mid + 1;
            } else if (mid != nums[mid] && (mid == 0 || mid - 1 == nums[mid - 1])) {
                return mid;
            } else {
                right = mid - 1;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        JianZhiOffer53 jianZhiOffer53 = new JianZhiOffer53();
        int[] nums = {0, 2, 3, 4, 5, 6, 7,8, 9};
        System.out.println(jianZhiOffer53.missingNumber(nums));
    }

}
