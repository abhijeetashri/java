package com.linkedlist.core;

import com.linkedlist.core.ListNode.Node;

public class DriverClass {

	public static void main(String[] args) {
		ListNode<String> list = new ListNode<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add("G");
		list.add("H");
		list.printListNode();
		Node<String> midNode = list.getNodeAt(4);
		System.out.println("Creating a cycle...");
		list.linkNodes(list.getTail(), midNode);
		System.out.println(list.hasCycle());

		if (list.hasCycle()) {
			System.out.println("Cycle is present in LinkedList");
			System.out.println("Cycle length: " + list.cycleLength());
			System.out.println("Starting of cycle node: " + list.startOfCycle().getData());
			System.out.println("Removing cycle from LinkedList");
			list.removeCycle();
			System.out.println("Removed cycle from LinkedList");
		}
		list.printListNode();
	}
}
