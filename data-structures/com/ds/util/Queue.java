package com.ds.util;

public class Queue<T> {
	private T[] array;
	private int maxSize;
	private int front;
	private int back;
	private int size;

	@SuppressWarnings("unchecked")
	public Queue(int capacity) {
		this.maxSize = capacity;
		array = (T[]) new Object[capacity];
		back = -1;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private boolean isFull() {
		return size == maxSize;
	}

	public void enqueue(T data) {
		if (isFull()) {
			throw new IllegalStateException("Queue is full");
		}
		back = (back + 1) % maxSize;
		array[back] = data;
		++size;
	}

	public T dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("Queue is empty");
		}
		T data = array[front];
		front = (front + 1) % maxSize;
		--size;
		return data;
	}
}
