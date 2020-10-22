package com.ykqfrost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ykq
 * @date 2020/10/13
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        quickSort(nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
        int target = 0;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // 已排序
            if (nums[i] > target / 2) {
                break;
            }
            // 不重复
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (k > j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    lists.add(list);
                    j++;
                    k--;
                    while (k > j && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (k > j && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return lists;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (end - start < 2) {
            return;
        }
        int q = nums[end - 1];
        int i = start;
        int j = start;
        while (j < end - 1) {
            if (nums[j] <= q) {
                swap(nums, i, j);
                i++;
                j++;
            } else if (nums[i] > q) {
                j++;
            }
        }
        nums[end - 1] = nums[i];
        nums[i] = q;
        quickSort(nums, start, i);
        quickSort(nums, i + 1, end);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        LeetCode15 leetCode15 = new LeetCode15();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = leetCode15.threeSum(nums);
        System.out.println(lists);
    }

}
