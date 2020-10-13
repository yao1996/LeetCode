package com.ykqfrost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ykq
 * @date 2020/10/12
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>(nums.length);
        for (int i : nums) {
            Integer frequency = frequencyMap.get(i);
            if (frequency == null) {
                frequencyMap.put(i, 1);
            } else {
                frequencyMap.put(i, frequency + 1);
            }
        }
        HashMap<Integer, List<List<Integer>>> sumMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                List<List<Integer>> sumList = sumMap.get(sum);
                if (sumList == null) {
                    sumList = new ArrayList<>();
                }
                sumList.add(list);
                sumMap.put(sum, sumList);
            }
        }
        Object[] twoSumArray = sumMap.keySet().toArray();
        List<List<Integer>> rtn = new ArrayList<>();
        for (Object o : twoSumArray) {
            int twoSum = (int) o;
            int t = target - twoSum;
            List<List<Integer>> first = sumMap.get(t);
            if (first == null || first.size() == 0) {
                continue;
            }
            List<List<Integer>> second = sumMap.get(twoSum);
            for (List<Integer> list1 : first) {
                for (List<Integer> list2 : second) {
                    List<Integer> third = new ArrayList<>();
                    third.addAll(list1);
                    third.addAll(list2);
                    int k = 0;
                    // 判断个数是否充足
                    for (; k < third.size(); k++) {
                        Integer frequency = frequencyMap.get(third.get(k));
                        if (frequency == null || frequency == 0) {
                            break;
                        }
                        frequency--;
                        frequencyMap.put(third.get(k), frequency);
                    }
                    if (k == third.size()) {
                        boolean hasRepeated = false;
                        for (List<Integer> rtnList : rtn) {
                            int x = 0;
                            for (; x < third.size(); x++) {
                                if (rtnList.contains(third.get(x))) {
                                    rtnList.remove(third.get(x));
                                } else {
                                    break;
                                }
                            }
                            for (int y = 0; y < x; y++) {
                                rtnList.add(third.get(y));
                            }
                            if (x == third.size()) {
                                hasRepeated = true;
                                break;
                            }
                        }
                        if (!hasRepeated) {
                            rtn.add(third);
                        }
                    }
                    // 恢复
                    for (int x = 0; x < k; x++) {
                        int frequency = frequencyMap.get(third.get(x));
                        frequency++;
                        frequencyMap.put(third.get(x), frequency);
                    }
                }
            }
        }
        return rtn;
    }

    public static void main(String[] args) {
        LeetCode18 leetCode18 = new LeetCode18();
        int[] a = new int[]{-2, -1, -1, 1, 1, 2, 2};
        List<List<Integer>> lists = leetCode18.fourSum(a, 0);
        System.out.println(lists);
    }

}
