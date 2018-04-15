package topologicalsort;

import java.util.LinkedList;
import stdlib.In;
import stdlib.StdOut;
import algs42.Digraph;

public class TestTopologicalSort {
	public static void main(String[] args) {
		Digraph dg = new Digraph(new In("data/simpleDAG2.txt"));
		try {
			TopologicalSort t = new TopologicalSort(dg);
			for (int v: t.order()) {
				StdOut.print(v + " ");
			}
			StdOut.println();
		}
		catch (NotDAGException e) {
			StdOut.println("The digraph is not a DAG!");
		}
	}

}
