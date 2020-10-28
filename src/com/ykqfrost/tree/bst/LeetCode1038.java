package com.ykqfrost.tree.bst;

import com.ykqfrost.tree.TreeNode;

/**
 * @author ykq
 * @date 2020/10/28
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * <p>
 * 提醒一下，二叉搜索树满足下列约束条件：
 * <p>
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * 注意：该题目与 538: https://leetcode-cn.com/problems/convert-bst-to-greater-tree/  相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode1038 {

    public TreeNode bstToGst(TreeNode root) {
        pastTraverse(root, 0);
        return root;
    }

    private int pastTraverse(TreeNode node, int prevSum) {
        if (node == null) {
            return prevSum;
        }
        int sum = pastTraverse(node.right, prevSum);
        node.val = sum + node.val;
        return pastTraverse(node.left, node.val);
    }
}
