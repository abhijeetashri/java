package com.ds.linkedlist;

import com.ds.util.ListNode;

public class LinkedListReversal {

	public static void main(String[] args) {
		ListNode<Integer> list = new ListNode<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
//		list.add(6);
//		list.printListNode();
//		list.reverse();
		list.printListNode();
		
		list.reverseSublist(2, 4);
		list.printListNode();
	}
}
