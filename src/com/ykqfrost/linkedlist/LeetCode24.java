package com.ykqfrost.linkedlist;

/**
 * @author ykq
 * @date 2020/10/13
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：[1]
 *  
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode24 {

    public ListNode swapPairs(ListNode head) {
        ListNode first = new ListNode(0);
        first.next = head;

        int i = 0;
        ListNode temp = null;
        ListNode node = first;
        while (node.next != null) {
            if (i == 0) {
                temp = node;
                node = node.next;
                i++;
            } else if (i == 1) {
                temp.next = node.next;
                node.next = node.next.next;
                temp.next.next = node;
                i++;
            } else if (i == 2) {
                i = 0;
            }
        }
        return first.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        LeetCode24 leetCode24 = new LeetCode24();
        ListNode node = leetCode24.swapPairs(node1);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
