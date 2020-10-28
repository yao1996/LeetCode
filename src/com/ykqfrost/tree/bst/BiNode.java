package com.ykqfrost.tree.bst;

import com.ykqfrost.tree.TreeNode;

import java.util.Stack;

/**
 * @author ykq
 * @date 2020/10/28
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 * <p>
 * 返回转换后的单向链表的头节点。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 * 提示：
 * <p>
 * 节点数量不会超过 100000。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binode-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BiNode {

    public TreeNode convertBiNode(TreeNode root) {
        TreeNode node = new TreeNode(0);
        inOrderTraverse(root, node);
        return node.right;
    }

    private void inOrder(TreeNode root) {
        TreeNode temp = new TreeNode(0);
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode parent = temp;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.add(node);
                node = node.left;
                continue;
            }
            node= stack.pop();
            parent.right = node;
            node.left = null;
            parent = node;
            node = node.right;
        }
    }

    private TreeNode inOrderTraverse(TreeNode node, TreeNode parent) {
        if (node == null) {
            return parent;
        }
        parent = inOrderTraverse(node.left, parent);
        node.left = null;
        parent.right = node;
        parent = inOrderTraverse(node.right, node);
        return parent;
    }

    public static void main(String[] args) {
        BiNode biNode = new BiNode();
        TreeNode treeNode = new TreeNode(4);

    }
}
