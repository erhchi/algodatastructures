package mygraph;
import stdlib.*;

public class DepthFirstSearch {
	private final boolean[] marked;    // marked[v] = is there an s-v path?
	private int count;                 // number of vertices connected to s

	// single source
	public DepthFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}

	// depth first search from v
	private void dfs(Graph G, int v) {
		marked[v] = true;
		count++;
		for (int w : G.neighbors(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}

	// is there an s-v path?
	public boolean marked(int v) {
		return marked[v];
	}

	// number of vertices connected to s
	public int count() {
		return count;
	}

	// test client
}
