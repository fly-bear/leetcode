package com.dzx.medium;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 每个复制节点插在原节点后面，奇数节点为原始节点，偶数节点为复制节点。
 * 遍历奇数节点，其 random 若不为 null，则接下来的偶数节点的 random 指向奇数节点 random 的下一个
 * 遍历偶数节点，取出成链表
 */
public class CopyRandomList {
	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}
		Node p = head;
		Node next;
		while (p != null) {
			next = p.next;
			Node node = new Node(p.val);
			p.next = node;
			node.next = next;
			p = next;
		}
		p = head;

		while (p != null) {
			p.next.random = p.random == null?null:p.random.next;
			p = p.next.next;
		}
		p=head;
		Node result = null;
		Node end = null;
		while (p != null) {
			if (result == null) {
				result = p.next;
				end = result;
			}else {
				end.next = p.next;
				end = p.next;
			}
			p.next = p.next.next;
			p = p.next;
		}
		return result;
	}

	private class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
}
