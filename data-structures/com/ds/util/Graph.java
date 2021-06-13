package com.ds.util;

public abstract class Graph {

	protected int vertices;
	protected DoublyLinkedList<Integer>[] adjacencyList;

	@SuppressWarnings("unchecked")
	public Graph(int vertices) {
		this.vertices = vertices;
		adjacencyList = new DoublyLinkedList[vertices];

		for (int i = 0; i < vertices; i++) {
			adjacencyList[i] = new DoublyLinkedList<>();
		}
	}

	public int vertices() {
		return vertices;
	}

	public abstract void addEgde(int src, int dest);

	public abstract void removeEgde(int src, int dest);

	public void print() {
		if (adjacencyList == null) {
			System.out.println("Empty graph");
			return;
		}

		for (int i = 0; i < adjacencyList.length; i++) {
			DoublyLinkedList<Integer> dll = adjacencyList[i];
			System.out.print("| " + i + " | -> ");
			dll.print();
		}
	}
}
