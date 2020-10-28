package com.ykqfrost.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author ykq
 * @date 2020/10/28
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode199 {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> currentList = new ArrayDeque<>();
        currentList.add(root);
        Queue<TreeNode> nextList = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        while (!currentList.isEmpty()) {
            TreeNode node = currentList.poll();
            if (node.left != null) {
                nextList.add(node.left);
            }
            if (node.right != null) {
                nextList.add(node.right);
            }
            if (currentList.isEmpty()) {
                res.add(node.val);
                currentList.addAll(nextList);
                nextList.clear();
            }
        }
        return res;
    }

}
