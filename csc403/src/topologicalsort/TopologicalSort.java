package topologicalsort;

import algs42.Digraph;

import java.util.*;

import stdlib.In;
import stdlib.StdOut;

public class TopologicalSort {

	boolean[] temporarilyMarked;
	boolean[] permanentlyMarked;
	LinkedList<Integer> order;
	
	public TopologicalSort(Digraph dg)
	{
		temporarilyMarked = new boolean[dg.V()];
		permanentlyMarked = new boolean[dg.V()];
		order = new LinkedList<Integer>();
		for (int i = 0; i < dg.V(); i++) {
			temporarilyMarked[i] = false;
			permanentlyMarked[i] = false;
		}
		
		for (int v = 0; v < dg.V(); v++) {
			if (!temporarilyMarked[v] && !permanentlyMarked[v]) {
				dfs(dg, v);
			}
		}
	}
	
	private void dfs(Digraph dg, int v) {
		if (temporarilyMarked[v]) {
			throw new NotDAGException();
		}
		if (!permanentlyMarked[v]) {
			temporarilyMarked[v] = true;
			for (int w: dg.adj(v)) {
				dfs(dg, w);
			}
			permanentlyMarked[v] = true;
			temporarilyMarked[v] = false;
			order.addFirst(v);
		}
	}

	// Return topological order if a DAG; null otherwise
	public Iterable<Integer> order() {
		return order;
	}

	// Does the digraph have a topological order?
	public boolean hasOrder() {
		return order != null;
	}
}
