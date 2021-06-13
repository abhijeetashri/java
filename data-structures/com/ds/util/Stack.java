package com.ds.util;

public class Stack<T> {
	private T[] array;
	private int maxSize;
	private int top;
	private int size;

	@SuppressWarnings("unchecked")
	public Stack(int capacity) {
		this.maxSize = capacity;
		array = (T[]) new Object[capacity];
		top = -1;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == maxSize;
	}

	public void push(T data) {
		if (isFull()) {
			throw new IllegalStateException("Stack is full");
		}

		array[top++] = data;
		++size;
	}

	public T pop() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is empty");
		}

		T data = array[top--];
		--size;
		return data;
	}
}
