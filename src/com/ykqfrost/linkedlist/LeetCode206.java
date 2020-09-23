package com.ykqfrost.linkedlist;

/**
 * @author ykq
 * @date 2020/9/18
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode206 {

    public ListNode reverseListRecursion(ListNode head) {
        if (head == null) {
            return null;
        }
        return reverseIteaion(head);
    }

    public ListNode reverseRecursion(ListNode preNode, ListNode node) {
        ListNode next = node.next;
        node.next = preNode;
        if (next == null) {
            return node;
        }
        return reverseRecursion(node, next);
    }

    public ListNode reverseIteaion(ListNode node) {
        ListNode next = node.next;
        node.next = null;
        while (next != null) {
            ListNode next2 = next.next;
            next.next = node;
            node = next;
            next = next2;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        LeetCode206 leetCode206 = new LeetCode206();
        ListNode node = leetCode206.reverseListRecursion(node1);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

}
