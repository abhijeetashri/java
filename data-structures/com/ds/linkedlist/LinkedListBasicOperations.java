package com.ds.linkedlist;

import com.ds.util.ListNode;
import com.ds.util.ListNode.Node;

public class LinkedListBasicOperations {

	public static void main(String[] args) {
		ListNode<Integer> list = getList();
		list.printListNode();

		// Insert at end
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.insertAtEnd(6);
		list.printListNode();

		// Find by value
		System.out.println("Find by value");
		Node<Integer> node = list.find(7);
		if (node == null) {
			System.out.println("Node not found in the list");
		} else {
			System.out.println("Found the node");
		}

		// Delete by value
		System.out.println("Delete by value");
		list.delete(4);
		list.printListNode();
	}

	private static ListNode<Integer> getList() {
		ListNode<Integer> list = new ListNode<>();
		list.add(1);
		list.add(2);
		list.add(3);
		return list;
	}
}