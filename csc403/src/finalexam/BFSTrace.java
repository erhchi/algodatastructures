package finalexam;

import algs13.Queue;
import algs41.Graph;
import stdlib.In;

public class BFSTrace {
	private static boolean[] marked;  

	public static void bfsPrintTrace(Graph G) {
		marked = new boolean[G.V()];
		//default first vertex to 0
		bfsPrintTrace(G,0);
	}

	private static void bfsPrintTrace(Graph G, int s) {
		Queue<Integer> q = new Queue<>();
		marked[s] = true;
		//enqueue the first (or passed) vertex
		q.enqueue(s);
		System.out.println("Enqueued: " + s);

		while (!q.isEmpty()) {
			//pull out the first vertex in the queue 
			//and add vertecies from its adjacency list
			//subsequent loops (recursions) will dequeue those values and add their vertecies
			int v = q.dequeue();
			System.out.println("Dequeued: " + v);
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					marked[w] = true;
					q.enqueue(w);
					System.out.println("Enqueued: " + w);
				}
			}
		}
	}


	// test client
	public static void main(String[] args) {
		args = new String [] { "data/tinyG.txt"};
		In in = new In(args[0]);
		Graph G = new Graph(in);

		BFSTrace.bfsPrintTrace(G);
	}

}
