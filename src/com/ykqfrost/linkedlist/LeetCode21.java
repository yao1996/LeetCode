package com.ykqfrost.linkedlist;

/**
 * @author ykq
 * @date 2020/9/18
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode21 {

    public ListNode mergeTwoListRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoListRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListRecursion(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = null;
        ListNode next = null;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                ListNode temp = l2.next;
                if (next == null) {
                    next = l2;
                    node = l2;
                } else {
                    next.next = l2;
                    next = next.next;
                }
                l2 = temp;
            } else {
                ListNode temp = l1.next;
                if (next == null) {
                    next = l1;
                    node = l1;
                } else {
                    next.next = l1;
                    next = next.next;
                }
                l1 = temp;
            }
        }
        if (l1 == null && next == null) {
            return l2;
        } else if (l1 == null) {
            next.next = l2;
        } else if (next == null) {
            return l1;
        } else {
            next.next = l1;
        }
        return node;
    }

}
