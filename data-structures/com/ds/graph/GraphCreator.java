package com.ds.graph;

import com.ds.util.DirectedGraph;
import com.ds.util.Graph;
import com.ds.util.UndirectedGraph;

public class GraphCreator {

	public static void main(String[] args) {
		Graph uGraph = new UndirectedGraph(4);
		uGraph.addEgde(0, 1);
		uGraph.addEgde(0, 2);
		uGraph.addEgde(1, 3);
		uGraph.addEgde(2, 3);
		uGraph.print();
		uGraph.removeEgde(2, 3);
		uGraph.print();

		Graph dGraph = new DirectedGraph(4);
		dGraph.addEgde(0, 1);
		dGraph.addEgde(0, 2);
		dGraph.addEgde(1, 3);
		dGraph.addEgde(2, 3);
		dGraph.print();
		dGraph.removeEgde(2, 3);
		dGraph.print();
	}
}
