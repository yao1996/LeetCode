package com.ykqfrost.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ykq
 * @date 2020/10/22
 * 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
 * <p>
 * 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[[10,20],[30,200],[400,50],[30,20]]
 * 输出：110
 * 解释：
 * 第一个人去 A 市，费用为 10。
 * 第二个人去 A 市，费用为 30。
 * 第三个人去 B 市，费用为 50。
 * 第四个人去 B 市，费用为 20。
 * <p>
 * 最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= costs.length <= 100
 * costs.length 为偶数
 * 1 <= costs[i][0], costs[i][1] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-city-scheduling
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode1029 {

    public int twoCitySchedCost(int[][] costs) {
        int targetNum = costs.length / 2;
        int num1 = 0;
        int num2 = 0;
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Math.abs(o1[0] - o1[1]) - Math.abs(o2[0] - o2[1]);
            }
        });
        int i = costs.length - 1;
        int cost = 0;
        while (i >= 0) {
            int a = costs[i][0];
            int b = costs[i][1];
            if (num1 == targetNum) {
                num2++;
                cost += b;
            } else if (num2 == targetNum) {
                num1++;
                cost += a;
            } else if (a < b) {
                num1++;
                cost += a;
            } else {
                num2++;
                cost += b;
            }
            i--;
        }
        return cost;
    }

    public static void main(String[] args) {
        LeetCode1029 leetCode1029 = new LeetCode1029();
        int[][] costs = {{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        int cost = leetCode1029.twoCitySchedCost(costs);
        System.out.println(cost);
    }

}
