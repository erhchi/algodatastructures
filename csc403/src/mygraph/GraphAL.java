package mygraph;
import stdlib.*;
import algs13.Bag;
import algs13.Stack;

/*
 *  This class implements a graph using the 
 *  adjacency list representation.  Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */
public class GraphAL extends Graph {
	private final Bag<Integer>[] adj;

	/**
	 * Create an empty graph with V vertices.
	 */
	@SuppressWarnings("unchecked")
	public GraphAL(int V) {
		super(V);
		this.adj = new Bag[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<>();
		}
	}

	/**
	 * Create a random graph with V vertices and E edges with no parallel edges or self loops.
	 * Expected running time is proportional to V + E.
	 */
	public GraphAL(int V, int E) { this (V, E, false); }

	/**
	 * Create a random graph with V vertices and E edges.
	 * Expected running time is proportional to V + E.
	 */
	public GraphAL(int V, int E, boolean allowParallelEdgesAndSelfLoops) {
		this(V);
		if (E < 0) throw new Error("Number of edges must be nonnegative");
		if (allowParallelEdgesAndSelfLoops) {
			for (int i = 0; i < E; i++) {
				int v = (int) (Math.random() * V);
				int w = (int) (Math.random() * V);
				addEdge(v, w);
			}
		} else {
			if (E > V*(V-1)/2) throw new Error("Number of edges must be less than V*(V-1)/2");
			newEdge: while (E>0) {
				int v = (int) (Math.random() * V);
				int w = (int) (Math.random() * V);
				if (v == w) continue;
				for (int w2 : adj[v])
					if (w == w2)
						continue newEdge;
				addEdge(v, w);
				E--;
			}
		}
	}

	/**
	 * Add the undirected edge v-w to graph.
	 * @throws java.lang.IndexOutOfBoundsException unless both 0 <= v < V and 0 <= w < V
	 */
	public void addEdge(int v, int w) {
		if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
		if (w < 0 || w >= V) throw new IndexOutOfBoundsException();
		E++;
		adj[v].add(w);
		adj[w].add(v);
	}

	/**
	 * Return the list of neighbors of vertex v as in Iterable.
	 * @throws java.lang.IndexOutOfBoundsException unless 0 <= v < V
	 */
	public Iterable<Integer> neighbors(int v) {
		if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
		return adj[v];
	}

}
