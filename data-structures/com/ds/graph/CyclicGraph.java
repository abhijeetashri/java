package com.ds.graph;

import com.ds.util.Graph;
import com.ds.util.UndirectedGraph;

public class CyclicGraph {

	public static void main(String[] args) {
		Graph uGraph = new UndirectedGraph(4);
		uGraph.addEgde(0, 1);
		uGraph.addEgde(0, 2);
		uGraph.addEgde(1, 2);
		uGraph.addEgde(2, 3);
		uGraph.print();
		if(uGraph.isCyclic(0)) {
			System.out.println("Graph is cyclic");
		} else {
			System.out.println("Graph is acyclic");
		}
		
		
		uGraph = new UndirectedGraph(6);
		uGraph.addEgde(0, 1);
		uGraph.addEgde(0, 2);
		uGraph.addEgde(0, 3);
		uGraph.addEgde(1, 4);
		uGraph.addEgde(1, 5);
		uGraph.addEgde(2, 5);
		uGraph.print();
		if(uGraph.isCyclic(0)) {
			System.out.println("Graph is cyclic");
		} else {
			System.out.println("Graph is acyclic");
		}
	}
}
