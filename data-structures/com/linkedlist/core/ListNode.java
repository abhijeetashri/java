package com.linkedlist.core;

import java.util.Optional;

public final class ListNode<T> {
	private Node<T> head;
	private Node<T> tail;
	private int nodeCount;

	public void add(T data) {
		Node<T> newNode = new Node<>(data);
		if (head == null) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		tail = newNode;
		++nodeCount;
	}

	public Node<T> getHead() {
		return head;
	}

	public Node<T> getTail() {
		return tail;
	}

	// Zero-based index
	public Node<T> getNodeAt(int index) {
		if (nodeCount < index)
			throw new IllegalArgumentException("Illegal index value");
		Node<T> temp = head;
		while (temp != null && index > 0) {
			temp = temp.next;
			--index;
		}
		return temp;
	}

	public void linkNodes(Node<T> from, Node<T> to) {
		from.next = to;
	}

	public void printListNode() {
		Node<T> temp = head;
		StringBuilder listNode = new StringBuilder();
		while (Optional.ofNullable(temp).isPresent()) {
			listNode.append(temp.getData()).append(" -> ");
			temp = temp.next;
		}
		listNode.append("null");
		System.out.println(listNode);
	}

	public boolean hasCycle() {
		Node<T> slowPtr = head;
		Node<T> fastPtr = head;

		while (fastPtr != null && slowPtr != null && fastPtr.next != null) {
			if (fastPtr.next == slowPtr) {
				return true;
			}
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}

		return false;
	}

	public int cycleLength() {
		Node<T> slowPtr = head;
		Node<T> fastPtr = head;
		int length = 0;

		while (fastPtr != null && slowPtr != null && fastPtr.next != null) {
			if (fastPtr.next == slowPtr) {
				length = calculateLoopLength(slowPtr);
				break;
			}
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}

		return length;
	}

	public Node<T> startOfCycle() {
		int cycleStartIndex = nodeCount - cycleLength();
		Node<T> currentNode = head;
		do {
			currentNode = currentNode.next;
			--cycleStartIndex;
		} while (cycleStartIndex > 0);
		return currentNode;
	}

	public void removeCycle() {
		Node<T> startNodeOfCycle = startOfCycle();
		Node<T> currentNode = startNodeOfCycle;
		while (currentNode != null && currentNode.next != startNodeOfCycle) {
			currentNode = currentNode.next;
		}
		currentNode.next = null;
	}

	private int calculateLoopLength(Node<T> slowPtr) {
		int cycleLength = 0;
		Node<T> currentNode = slowPtr;
		do {
			++cycleLength;
			currentNode = currentNode.next;
		} while (currentNode != slowPtr);
		return cycleLength;
	}

	public boolean isPalindromic() {
		Node<T> slowPtr = head;
		Node<T> fastPtr = head;
		while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}

		Node<T> headOfHalfReversedList = reverse(slowPtr);
		Node<T> headFwd = head;
		Node<T> headRev = headOfHalfReversedList;

		while (headFwd != null && headRev != null) {
			if (!headFwd.getData().equals(headRev.getData())) {
				break; // not a palindrome
			}
			headFwd = headFwd.next;
			headRev = headRev.next;
		}

		reverse(headOfHalfReversedList);
		return headFwd == null || headRev == null;
	}

	private Node<T> reverse(Node<T> head) {
		Node<T> prev = null;
		while (head != null) {
			Node<T> next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	public static class Node<T> {
		private T data;
		private Node<T> next;

		public Node(T data) {
			this.data = data;
		}

		public T getData() {
			return data;
		}
	}
}
