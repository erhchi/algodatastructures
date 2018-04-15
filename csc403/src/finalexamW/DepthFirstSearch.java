package finalexamW;
import algs41.*;
import stdlib.*;

public class DepthFirstSearch {
	private final boolean[] marked;    // marked[v] = is there an s-v path?
	private int count;                 // number of vertices connected to s
	private int indent = 0;
	private String spaces;

	// single source
	public DepthFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	
	
	/*
	 *BEGIN CODE FOR FINAL EXAM #7 
	 */
	
	//method to set spaces
	private String setSpaces(int indentSize){
		spaces = "";
		for(int i = 0; i<indent; i++){
			spaces += " ";
		}
		return spaces;
	}
	
	
	// depth first search from v
	private void dfs(Graph G, int v) {
				
		System.out.println(setSpaces(indent) + "First time at vertex: " + v);
				
		marked[v] = true;
		count++;

		int itCount = 0;
		
		for (int w : G.adj(v)) {
			
			//only indent if w is first item in adj list
			if(itCount ==0){
				indent++;
			}
			
			if(marked[w]){
				System.out.println(setSpaces(indent) + "Visiting vertex: " + w + " again");
			}
			
			if (!marked[w]) {
				dfs(G, w);
			}			
			itCount++;		
		}
		
		//unload stack, ie. finished with a vertex; decrement indent
		indent--;
		System.out.println(setSpaces(indent) + "Finished searching from: " + v);
		
	}
	
	/*
	 *END CODE FOR FINAL EXAM #7
	 */

	
	// is there an s-v path?
	public boolean marked(int v) {
		return marked[v];
	}

	// number of vertices connected to s
	public int count() {
		return count;
	}

	// test client
	public static void main(String[] args) {
		args = new String [] { "data/tinyG.txt", "0" };
		//args = new String [] { "data/tinyCG.txt", "0" };

		In in = new In(args[0]);
		Graph G = new Graph(in);
		StdOut.println (G);

		int s = Integer.parseInt(args[1]);
		DepthFirstSearch search = new DepthFirstSearch(G, s);

		System.out.println();
		StdOut.print("Marked=");
		for (int v = 0; v < G.V(); v++) {
			if (search.marked(v))
				StdOut.print(v + " ");
		}

		StdOut.println();
		StdOut.println("Count=" + search.count ());
		if (search.count() != G.V()) StdOut.println("NOT connected");
		else                         StdOut.println("connected");
		
		//G.toGraphviz("C:\\DPU\\403\\workspace\\algs4\\data\\dfs.png");
	}

}
