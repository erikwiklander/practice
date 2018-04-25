package io.wiklandia.practice.linkedlist;

public class ListNode<T> {
	T val;
	public ListNode<T> next;

	public ListNode(T val) {
		this.val = val;
	}

	public static <T> ListNode<T> reverse(ListNode<T> head) {
		ListNode<T> pre = null;
		ListNode<T> n = head;
		while (n != null) {
			ListNode<T> temp = n.next;
			n.next = pre;
			pre = n;
			n = temp;
		}
		return pre;
	}

	public static <T> void print(ListNode<T> head) {
		ListNode<T> n = head;
		while (n != null) {
			System.out.print(n.val + "->");
			n = n.next;
		}
		System.out.println("*");
	}

}
