package com.ykqfrost.linkedlist;

/**
 * @author ykq
 * @date 2020/9/18
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
