package mygraph;

/*
 * This is an abstract Graph class.  It only defines
 * instance variables for the number of vertices and
 * the number of edges.  How the graph is represented
 * is decided by a concrete sub-class.
 * 
 */
import stdlib.GraphvizBuilder;

public abstract class Graph {
	protected final int V;
	protected int E;

	/**
	 * Create an empty graph with V vertices.
	 */
	public Graph(int V) {
		if (V < 0) throw new Error("Number of vertices must be nonnegative");
		this.V = V;
		this.E = 0;
	}

	/**
	 * Add the undirected edge v-w to graph.
	 * @throws java.lang.IndexOutOfBoundsException unless both 0 <= v < V and 0 <= w < V
	 */
	public abstract void addEdge(int v, int w);

	/**
	 * Return the list of neighbors of vertex v as in Iterable.
	 * @throws java.lang.IndexOutOfBoundsException unless 0 <= v < V
	 */
	public abstract Iterable<Integer> neighbors(int v);

	/**
	 * Return the number of vertices in the graph.
	 */
	public int V() { return V; }

	/**
	 * Return the number of edges in the graph.
	 */
	public int E() { return E; }

	/**
	 * Return a string representation of the graph.
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		String NEWLINE = System.getProperty("line.separator");
		s.append(V + " vertices, " + E + " edges " + NEWLINE);
		for (int v = 0; v < V; v++) {
			s.append(v + ": ");
			for (int w : neighbors(v)) {
				s.append(w + " ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}

	/**
	 * Save a graphviz representation of the graph.
	 * See <a href="http://www.graphviz.org/">graphviz.org</a>.
	 */
	public void toGraphviz(String filename) {
		GraphvizBuilder gb = new GraphvizBuilder ();
		for (int v = 0; v < V; v++) {
			gb.addNode (v);
			boolean showSelfLoop = false;
			for (int w : neighbors(v)) {
				if (v < w) // only once each edge
					gb.addEdge (v, w);
				if (v == w) {
					showSelfLoop = !showSelfLoop;
					if (showSelfLoop)
						gb.addEdge (v, w);
				}
			}
		}
		gb.toFileUndirected (filename);
	}

}
