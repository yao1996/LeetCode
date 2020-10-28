package com.ykqfrost.tree.bst;

import com.ykqfrost.tree.TreeNode;

import java.util.ArrayList;

/**
 * @author ykq
 * @date 2020/10/28
 * 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。
 * <p>
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
 * <p>
 * 如果有多种构造方法，请你返回任意一种。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balance-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode1382 {

    /**
     * 重新建树
     */
    public TreeNode balanceBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        inOrder(root, list);
        for (TreeNode node : list) {
            node.left = null;
            node.right = null;
        }
        return buildBST(list, 0, list.size());
    }

    private void inOrder(TreeNode node, ArrayList<TreeNode> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node);
        inOrder(node.right, list);
    }

    private TreeNode buildBST(ArrayList<TreeNode> list, int start, int end) {
        if (start >= end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode parent = list.get(mid);
        parent.left = buildBST(list, start, mid);
        parent.right = buildBST(list, mid + 1, end);
        return parent;
    }

}
