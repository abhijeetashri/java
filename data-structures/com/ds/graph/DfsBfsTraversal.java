package com.ds.graph;

import com.ds.util.DirectedGraph;
import com.ds.util.Graph;

public class DfsBfsTraversal {

	public static void main(String[] args) {
		Graph dGraph = new DirectedGraph(12);
		dGraph.addEgde(1, 2);
		dGraph.addEgde(1, 3);
		dGraph.addEgde(2, 4);
		dGraph.addEgde(2, 5);
		dGraph.addEgde(3, 6);
		dGraph.addEgde(3, 7);
		dGraph.addEgde(4, 8);
		dGraph.addEgde(5, 9);
		dGraph.addEgde(5, 10);
		dGraph.addEgde(6, 11);
		dGraph.print();

		System.out.println(">>> BFS Traversal <<<");
		dGraph.bfs(1);

		System.out.println(">>> DFS Traversal <<<");
		dGraph.dfs(1);
	}
}
