package com.ds.util;

public class DirectedGraph extends Graph {

	public DirectedGraph(int vertices) {
		super(vertices);
	}

	@Override
	public void addEgde(int src, int dest) {
		if (src < vertices && dest < vertices) {
			adjacencyList[src].insertAtEnd(dest);
		}
	}

	@Override
	public void print() {
		System.out.println(">>> Directed Graph <<<");
		super.print();
	}

	@Override
	public void removeEgde(int src, int dest) {
		if (src < vertices && dest < vertices) {
			adjacencyList[src].remove(dest);
		}
	}
}
