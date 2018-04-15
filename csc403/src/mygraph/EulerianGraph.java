package mygraph;

import java.util.ArrayList;

public class EulerianGraph {
	private boolean isEulerian;
	private boolean[][] marked;
	private int[][] path;
	
	public EulerianGraph(Graph G) {
		isEulerian = true;
		for (int v = 0; v < G.V(); v++) {
			ArrayList<Integer> neighbors = (ArrayList<Integer>) G.neighbors(v);
			if (neighbors.size() % 2 != 0) {
				isEulerian = false;
				break;
			}
		}
	}
	
	public boolean isEulerian() { return isEulerian; }

}
