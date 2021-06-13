package com.ds.util;

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

	public void reverse() {
		head = reverse(head);
	}

	public void reverseFirstKElements(int k) {
		reverseSublist(1, k);
	}

	public void reverseEveryKElements(int k) {
		if (k < 1)
			return;

		for (int i = 1; i <= nodeCount;) {
			reverseSublist(i, (i + k - 1));
			i = i + k;
		}
	}

	public void reverseAlternateKElements(int k) {
		if (k < 1)
			return;

		boolean isReversed = false;
		for (int i = 1; i <= nodeCount;) {
			if (!isReversed) {
				reverseSublist(i, (i + k - 1));
				isReversed = true;
			} else {
				isReversed = false;
			}

			i = i + k;
		}
	}

	/**
	 * <p>
	 * Given a LinkedList with ‘n’ nodes, reverse it based on its size in the
	 * following way:
	 * <ul>
	 * <li>If ‘n’ is even, reverse the list in a group of n/2 nodes.</li>
	 * <li>If n is odd, keep the middle node as it is, reverse the first ‘n/2’ nodes
	 * and reverse the last ‘n/2’ nodes.</li>
	 * </ul>
	 * </p>
	 */
	public void reverseBySkippingMiddleNode() {

	}

	public void insertAtEnd(T value) {
		Node<T> newNode = new Node<>(value);
		tail.next = newNode;
		tail = newNode;
	}

	public Node<T> find(T value) {
		Node<T> temp = head;
		while (temp != null && !temp.getData().equals(value)) {
			temp = temp.next;
		}

		return temp;
	}

	public void delete(T value) {
		Node<T> prev = null, current = head;
		while (current != null && !current.getData().equals(value)) {
			prev = current;
			current = current.next;
		}

		if (current != null) {
			prev.next = current.next;
			current.next = null;
		}
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

	/**
	 * Rearrange list such that nodes from the second half of the LinkedList are
	 * inserted alternately to the nodes from the first half in reverse order
	 */
	public void rearrangeList() {
		Node<T> slowPtr = head;
		Node<T> fastPtr = head;
		while (slowPtr != null && fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}

		Node<T> headRev = reverse(slowPtr);
		Node<T> headFwd = head;

		while (headFwd != null && headRev != null) {
			Node<T> temp = headFwd.next;
			headFwd.next = headRev;
			headFwd = temp;

			temp = headRev.next;
			headRev.next = headFwd;
			headRev = temp;
		}

		if (headFwd != null) {
			headFwd.next = null;
		}
	}

	public void reverseSublist(int startIdx, int endIdx) {
		if (startIdx >= endIdx)
			return;

		Node<T> prev = null, current = head;

		// Loop till (p-1) is found.
		for (int i = 0; current != null && i < startIdx - 1; ++i) {
			prev = current;
			current = current.next;
		}

		Node<T> sublistHead = prev;
		Node<T> sublistTail = current;
		Node<T> next = null;

		// current will become 'q+1'th node.
		for (int i = 0; current != null && i < endIdx - startIdx + 1; ++i) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		if (sublistHead != null)
			sublistHead.next = prev;
		else
			head = prev;

		sublistTail.next = current;
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
