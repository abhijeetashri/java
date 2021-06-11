package com.linkedlist.core;

public class PalindromicLinkedList {

	public static void main(String[] args) {
		ListNode<Integer> list = new ListNode<>();
		list.add(2);
		list.add(4);
		list.add(6);
		list.add(4);
		list.add(2);
		list.add(2);
		list.printListNode();

		System.out.println(list.isPalindromic());
	}
}
