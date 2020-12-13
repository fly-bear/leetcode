package com.dzx.easy;


import com.dzx.ListNode;

/**
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * 双指针，一个逐步前进，一个只前进到一半
 */


public class SimpleMiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode mid = head;
        ListNode point = head;
        int n = 1;
        int step = 0;
        while (point.next!=null) {
            step++;
            while (n < step / 2 + 1) {
                mid = mid.next;
                n++;
            }
            point = point.next;
        }
        return mid;
    }
}
