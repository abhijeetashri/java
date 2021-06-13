package com.ds.linkedlist;

import com.ds.util.ListNode;

public class LinkedListSublistReversal {

	public static void main(String[] args) {
		ListNode<Integer> list = getList();
		list.printListNode();
		list.reverseFirstKElements(5);
		System.out.println("Reversing K-elements...");
		list.printListNode();
		list = getList();
		list.reverseEveryKElements(4);
		System.out.println("Reversing every K-elements...");
		list.printListNode();
		list = getList();
		list.reverseAlternateKElements(3);
		System.out.println("Reversing alternate K-elements...");
		list.printListNode();
	}

	private static ListNode<Integer> getList() {
		ListNode<Integer> list = new ListNode<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		list.add(7);
		list.add(8);
		list.add(9);
		list.add(10);
		list.add(11);
		return list;
	}

}
