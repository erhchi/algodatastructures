// Exercise 4.1.13 (Solution published at http://algs4.cs.princeton.edu/)
package finalexamW;
import algs41.*;
import stdlib.*;
import algs13.Queue;
import algs13.Stack;

public class BreadthFirstPaths {
	//private static final int INFINITY = Integer.MAX_VALUE;
	private final boolean[] marked;  // marked[v] = is there an s-v path
	//private final int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
	//private final int[] distTo;      // distTo[v] = number of edges shortest s-v path

	// single source
	public BreadthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		//distTo = new int[G.V()];
		//edgeTo = new int[G.V()];
		bfs(G, s);
	}


	// BFS from single soruce
	private void bfs(Graph G, int s) {
		Queue<Integer> q = new Queue<>();
		//for (int v = 0; v < G.V(); v++) distTo[v] = INFINITY;
		//distTo[s] = 0;
		marked[s] = true;
		q.enqueue(s);
		System.out.println("Enqueued: " + s);

		while (!q.isEmpty()) {
			int v = q.dequeue();
			System.out.println("Dequeued: " + v);
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					//edgeTo[w] = v;
					//distTo[w] = distTo[v] + 1;
					marked[w] = true;
					q.enqueue(w);
					System.out.println("Enqueued: " + w);
				}
			}
		}
	}


	// test client
	public static void main(String[] args) {
		//args = new String [] { "data/tinyAG.txt", "0"};
		args = new String [] { "data/tinyG.txt", "0" };
		In in = new In(args[0]);
		Graph G = new Graph(in);
		//StdOut.println(G);

		int s = Integer.parseInt(args[1]);
		BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

//		for (int v = 0; v < G.V(); v++) {
//			if (bfs.hasPathTo(v)) {
//				StdOut.format("%d to %d (%d):  ", s, v, bfs.distTo(v));
//				for (int x : bfs.pathTo(v)) {
//					if (x == s) StdOut.print(x);
//					else        StdOut.print("-" + x);
//				}
//				StdOut.println();
//			}
//
//			else {
//				StdOut.format("%d to %d (-):  not connected\n", s, v);
//			}
//
//		}
	}


}
