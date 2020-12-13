package com.dzx;


/**
 * @Author:Zhengxiong.Dai
 * @Date:2020/12/8 18:13
 * 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 **/
public class AddTwoNumbers {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null;
		ListNode end = result;
		int a = 0;
		while (l1 != null && l2!=null) {
			int sum = l1.val + l2.val + a;
			if (sum >= 10) {
				a = sum/10;
				sum = sum%10;
			}else {
				a = 0;
			}
			ListNode node = new ListNode(sum);
			if (result == null) {
				result = node;
				end = result;
			}else {
				end.next = node;
				end = end.next;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		l1 = l1==null?l2:l1;
		while (l1 != null) {
			int sum = l1.val+a;
			if (sum >= 10) {
				a = sum/10;
				sum = sum%10;
			}else {
				a = 0;
			}
			ListNode node = new ListNode(sum);
			end.next = node;
			end = end.next;
			l1 = l1.next;
		}
		if (a > 0) {
			ListNode node = new ListNode(a);
			end.next = node;
			end = end.next;
		}
		return result;
	}

	public static void main(String[] args) {
		ListNode a = null;
		ListNode b = null;
		ListNode p = a;
		for (int i : new int[]{9,9,9,9,9,9,9}) {
			ListNode node = new ListNode(i);
			if (p == null) {
				a = node;
				p = a;
			}else {
				p.next = node;
				p = p.next;
			}
		}
		p=b;
		for (int i : new int[]{9,9,9,9}) {
			ListNode node = new ListNode(i);
			if (p == null) {
				b = node;
				p = b;
			}else {
				p.next = node;
				p = p.next;
			}
		}
		ListNode result = addTwoNumbers(a,b);
		System.out.println("pass");
	}
}
