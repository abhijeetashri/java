package com.ds.util;

public class UndirectedGraph extends Graph {

	public UndirectedGraph(int vertices) {
		super(vertices);
	}

	@Override
	public void addEgde(int src, int dest) {
		if (src < vertices && dest < vertices) {
			adjacencyList[src].insertAtEnd(dest);
			adjacencyList[dest].insertAtEnd(src);
		}
	}

	@Override
	public void print() {
		System.out.println(">>> Undirected Graph <<<");
		super.print();
	}

	@Override
	public void removeEgde(int src, int dest) {
		if (src < vertices && dest < vertices) {
			// Remove bidirectional connections
			adjacencyList[src].remove(dest);
			adjacencyList[dest].remove(src);
		}
	}
}
