package com.ds.util;

public class DoublyLinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	private int modCount;

	public void insertAtEnd(T data) {
		Node<T> newNode = new Node<>(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		++modCount;
	}

	public void print() {
		StringBuilder sb = new StringBuilder();
		Node<T> temp = head;
		while (temp != null) {
			sb.append(temp.getData()).append(" -> ");
			temp = temp.next;
		}
		sb.append("null");
		System.out.println(sb.toString());
	}

	private static class Node<T> {
		T data;
		Node<T> next;
		Node<T> prev;

		public Node(T data) {
			this.data = data;
		}

		public T getData() {
			return data;
		}
	}

	public void remove(int value) {
		Node<T> current = head;
		while (current != null && !current.getData().equals(value)) {
			current = current.next;
		}

		if (current != null) {
			Node<T> prev = current.prev;
			Node<T> next = current.next;
			if (prev != null)
				prev.next = next;

			if (next != null)
				next.prev = prev;

			if (current == head)
				head = next;

			current.next = null;
			current.prev = null;
			++modCount;
		}
	}
}
