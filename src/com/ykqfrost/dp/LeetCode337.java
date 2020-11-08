package com.ykqfrost.dp;

import com.ykqfrost.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @author ykq
 * @date 2020/11/7
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * <p>
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3,null,3,null,1]
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode337 {

    /**
     * 超时，思路没问题，自底向上
     */
    public int rob0(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int floor = -1;
        int num = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            } else {
                queue.add(new TreeNode(-1));
            }
            if (node.right != null) {
                queue.add(node.right);
            } else {
                queue.add(new TreeNode(-1));
            }
            list.add(node.val == -1 ? 0 : node.val);
            boolean hasNormalNode = false;
            for (TreeNode treeNode : queue) {
                if (treeNode.val != -1) {
                    hasNormalNode = true;
                    break;
                }
            }
            if (!hasNormalNode) {
                break;
            }
        }
        System.out.println(list);
        int[][] max = new int[list.size() * 2 + 1][2];
        for (int i = list.size() - 1; i >= 0; i--) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            max[i][0] = Math.max(max[left][0], max[left][1]) + Math.max(max[right][0], max[right][1]);
            max[i][1] = max[left][0] + max[left][1] + list.get(i);
        }
        return Math.max(max[0][0], max[0][1]);
    }

}
