package com.ds.util;

import java.util.List;

import com.ds.util.DoublyLinkedList.Node;

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

	public abstract void addEgde(int src, int dest);

	public abstract void removeEgde(int src, int dest);

	public int vertices() {
		return vertices;
	}

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

	public void bfs(int start) {
		if (vertices < 1) {
			return;
		}

		StringBuilder result = new StringBuilder();

		// Initialize trackers
		boolean[] visited = new boolean[vertices];
		Queue<Integer> queue = new Queue<>(vertices);

		// Initialize with source
		queue.enqueue(start);
		visited[start] = true;

		while (!queue.isEmpty()) {
			Integer vertex = queue.dequeue();
			result.append(vertex).append(" -> ");
			List<Node<Integer>> list = adjacencyList[vertex].nodes();

			for (int i = 0; i < list.size(); i++) {
				Integer node = list.get(i).getData();

				// Enqueue only unvisited nodes
				if (!visited[node]) {
					queue.enqueue(node);
					visited[node] = true;
				}
			}
		}

		result.append("null");
		System.out.println(result.toString());
	}

	public void dfs(int start) {
		if (vertices < 1) {
			return;
		}

		StringBuilder result = new StringBuilder();

		// Initialize trackers
		boolean[] visited = new boolean[vertices];
		Stack<Integer> stack = new Stack<>(vertices);

		// Initialize with source
		stack.push(start);
		visited[start] = true;

		while (!stack.isEmpty()) {
			Integer vertex = stack.pop();
			result.append(vertex).append(" -> ");
			List<Node<Integer>> list = adjacencyList[vertex].nodes();

			for (int i = 0; i < list.size(); i++) {
				Integer node = list.get(i).getData();

				// Push only unvisited nodes
				if (!visited[node]) {
					stack.push(node);
					visited[node] = true;
				}
			}
		}

		result.append("null");
		System.out.println(result.toString());
	}
}
