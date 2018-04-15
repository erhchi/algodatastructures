package finalexam;
import algs41.*;
import stdlib.*;

public final class DFSTrace {
	private static boolean[] marked;    
	private static int count;                 
	private static String spaces;

	
	public static void dfsPrintTrace(Graph g){
		//*** Declare and initialize the marked array.
		marked = new boolean[g.V()];
		dfsPrintTrace(g, 0, marked, 0);
	}
	
	private static void dfsPrintTrace(Graph g, int start, boolean[] marked, int indent){
				
		System.out.println(setSpaces(indent) + "First time at vertex: " + start);
				
		marked[start] = true;
		count++;

		int itCount = 0;
		
		for (int w : g.adj(start)) {
			
			//only indent if w is first item in adj list
			if(itCount ==0){
				indent++;
			}
			
			if(marked[w]){
				System.out.println(setSpaces(indent) + "Visiting vertex: " + w + " again");
			}
			
			if (!marked[w]) {
				dfsPrintTrace(g, w, marked, indent);
			}			
			itCount++;		
		}
		
		//unload stack, ie. finished with a vertex; decrement indent
		indent--;
		System.out.println(setSpaces(indent) + "Finished searching from: " + start);
		
	}
	
	//method to set spaces
	private static String setSpaces(int indent){
		spaces = "";
		for(int i = 0; i<indent; i++){
			spaces += " ";
		}
		return spaces;
	}
		
	
	// test client
//	public static void main(String[] args) {
//		args = new String [] { "data/tinyG.txt"};
//
//		In in = new In(args[0]);
//		Graph G = new Graph(in);
//		//StdOut.println (G);
//
//		DFSTrace.dfsPrintTrace(G);
//
//	}

}
