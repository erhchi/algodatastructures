package finalexamW;
import stdlib.*;
import algs13.Queue;
/* ***********************************************************************
 *
 *  This is an implementation of a binary search tree.
 *  For the third program, you are to modify this class
 *  as described in the assignment.  
 *
 *************************************************************************/
public class Program3BST<K extends Comparable<? super K>, V> {
	
	private Node<K,V> root;             // root of BST

	private static class Node<K extends Comparable<? super K>,V> {
		public K key;       // sorted by key
		public V val;             // associated data
		public Node<K,V> left, right;  // left and right subtrees
		public int size;
		public int height;

		public Node(K key, V val, int N) {
			this.key = key;
			this.val = val;
			this.size = 0;
			this.height = 0;
		}
	}

	// is the symbol table empty?
	public boolean isEmpty() { return root == null; }

	/* *********************************************************************
	 *  Search BST for given key, and return associated value if found,
	 *  return null if not found
	 ***********************************************************************/
	// does there exist a key-value pair with given key?
	public boolean contains(K key) {
		return get(key) != null;
	}

	// return value associated with the given key, or null if no such key exists
	public V get(K key) { return get(root, key); }

	private V get(Node<K,V> x, K key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) return get(x.left, key);
		else if (cmp > 0) return get(x.right, key);
		else              return x.val;
	}

	/* *********************************************************************
	 *  Insert key-value pair into BST
	 *  If key already exists, update with new value
	 ***********************************************************************/
	public void put(K key, V val) {
		if (val == null) { delete(key); return; }
		root = put(root, key, val);
	}

	private Node<K,V> put(Node<K,V> x, K key, V val) {
		
		if (x == null) return new Node<>(key, val, 1);
		
		int cmp = key.compareTo(x.key);
		
		
		if      (cmp < 0)
			x.left  = put(x.left,  key, val);
		else if (cmp > 0)
			x.right = put(x.right, key, val);
		else
			x.val   = val;
		return x;
	}

	public void delete(K key) {
		root = delete(root, key);
	}

	private Node<K,V> delete(Node<K,V> x, K key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			// Key to delete is to the left of x.
			x.left  = delete(x.left,  key);
			return x;
		}
		else if (cmp > 0) {
			// Key to delete is to the right of x.
			x.right = delete(x.right, key);
			return x;
		}
		else {
			// x contains the key we wish to delete.
			if (x.left == null && x.right == null) {
				// x is a leaf.
				return null;
			}
			else if (x.left == null) {
				// x has only a right child.
				return x.right;
			}
			else if (x.right == null) {
				// x has only a left child.
				return x.left;
			}
			else {
				// x has two children.
				Node<K,V> leftTreeMaxNode = x.left;
				// Find the node with the largest key to the left.
				while (leftTreeMaxNode.right != null) {
					leftTreeMaxNode = leftTreeMaxNode.right;
				}
				// Copy that largest key and its value to x.
				K leftTreeMaxKey = leftTreeMaxNode.key;
				x.key = leftTreeMaxNode.key;
				x.val = leftTreeMaxNode.val;
				// Delete the node copied from.
				x.left = delete(x.left, leftTreeMaxKey);
				return x;
			}
		}
	}

	public void drawTree() {
		if (root != null) {
			StdDraw.setPenColor (StdDraw.BLACK);
			StdDraw.setCanvasSize(1200,700);
			setSizes();
			setHeights();
			drawTree(root, .5, 1, .3, 0);
		}
	}
	
	private void drawTree (Node<K,V> n, double x, double y, double range, int depth) {
		int CUTOFF = 10;
		StdDraw.setPenColor(StdDraw.RED);
		
		//couldn't make it look nice for the 2nd tree b/c the text overlaps on the 2 leaves
		//StdDraw.text(x, y, n.key.toString() + " / Size:" + n.size + " / Height:" + n.height);
		//StdDraw.text(x, y, n.key.toString() + "S: " + n.size + "H: " + n.height);
		StdDraw.text(x, y, n.key.toString() + " " + n.size + " " + n.height);
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius (.007);
		
		if (n.left != null && depth != CUTOFF) {
			StdDraw.line (x-range, y-.08, x-.01, y-.01);
			drawTree (n.left, x-range, y-.1, range*.5, depth+1);
		}
		if (n.right != null && depth != CUTOFF) {
			StdDraw.line (x+range, y-.08, x+.01, y-.01);
			drawTree (n.right, x+range, y-.1, range*.5, depth+1);
		}
	}

	public void setSizes(){
		//System.out.println(setSizes(root));
		setSizes(root);
	}
	
	private int setSizes(Node<K,V> x) {

		if(x == null) return(0);
		
		else{
//			int test = 1 + setSizes(x.left);
//			System.out.println("Node: " + x.key + " " + test );
//			x.size = test;
			
//			int test = 1 + setSizes(x.right);
//			System.out.println("Node: " + x.key + " " + test);
//			x.size = test;			

			//System.out.println("Node: " + x.key);
			
			
			return(x.size = 1 + setSizes(x.left) + setSizes(x.right));
		}
		
	}
	
	public void setHeights() {
		//System.out.println(setHeights(root));
		setHeights(root);
	}
	
	private int setHeights(Node<K,V> x){
		if(x == null) return(-1);
		else{			
			//System.out.println("Node: " + x.key + " " + x.height);
			
			//was thinking it would be nice to have a max function...then I remembered where I saw it! Thanks
			return x.height = 1 + Math.max(setHeights(x.left), setHeights(x.right));			

			
//			int left = setHeights(x.left);
//			int right = setHeights(x.right);
//			
//			if(left>right){
//				return x.height = left + 1;
//			}
//			else{
//				return x.height = right + 1;
//			}
			
//			if(setHeights(x.left)>setHeights(x.right)){
//				return x.height = setHeights(x.left) + 1;
//			}
//			else{
//				return x.height = setHeights(x.right) + 1;
//			}
			
		}
	}
	
	
	//simple test code to practice stepping through inOrder recursion
	
//	public void printInOrder(){
//		printInOrder(root);
//	}
//	
//	private void printInOrder(Node<K,V> x){
//		if(x==null){return;}
//		printInOrder(x.left);
//		System.out.println("Node: " + x.key + " " + x.val);
//		printInOrder(x.right);
//	}
		
	
	/* ***************************************************************************
	 *  Test client
	 *****************************************************************************/
	public static void main(String[] args) {
				
		Program3BST<String, Integer> st = new Program3BST<String, Integer>();
		
		StdIn.fromString ("15, 20, 25, 30, 05, 08, 10, 02, 16");
		for (int i = 0; !StdIn.isEmpty(); i++) {
			String key = StdIn.readString();
			st.put(key, i);
		}
		
		st.drawTree ();
		StdDraw.save("data/final#1.png");
		
		//st.printInOrder();

				
//		StdIn.fromString ("G A B C E F D H");
//		st = new Program3BST<String, Integer>();
//		for (int i = 0; !StdIn.isEmpty(); i++) {
//			String key = StdIn.readString();
//			st.put(key, i);
//		}
//		st.drawTree ();
//		StdDraw.save("data/Program3Unbalancedtree.png");
	}
}
