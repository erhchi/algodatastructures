package algs31;
import stdlib.*;
import algs13.Queue;

public class SimplerBST<K extends Comparable<? super K>, V> {
	private Node<K,V> root;             // root of BST

	private static class Node<K extends Comparable<? super K>,V> {
		public K key;       // sorted by key
		public V val;             // associated data
		public Node<K,V> left, right;  // left and right subtrees

		public Node(K key, V val) {
			this.key = key;
			this.val = val;
		}
	}

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
		//assert check();
	}

	private Node<K,V> put(Node<K,V> x, K key, V val) {
		if (x == null) return new Node<>(key, val);
		int cmp = key.compareTo(x.key);
		if      (cmp < 0)
			x.left  = put(x.left,  key, val);
		else if (cmp > 0)
			x.right = put(x.right, key, val);
		else
			x.val   = val;
		return x;
	}

	/* *********************************************************************
	 *  Delete
	 ***********************************************************************/

	public void deleteMin() {
		if (root == null) throw new Error("Symbol table underflow");
		root = deleteMin(root);
		//assert check();
	}

	private Node<K,V> deleteMin(Node<K,V> x) {
		if (x.left == null) return x.right;
		x.left = deleteMin(x.left);
		return x;
	}

	public void deleteMax() {
		if (root == null) throw new Error("Symbol table underflow");
		root = deleteMax(root);
		//assert check();
	}

	private Node<K,V> deleteMax(Node<K,V> x) {
		if (x.right == null) return x.left;
		x.right = deleteMax(x.right);
		return x;
	}

	public void delete(K key) {
		root = delete(root, key);
	}
	
	private Node<K,V> delete(Node<K,V> x, K key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) x.left  = delete(x.left,  key);
		else if (cmp > 0) x.right = delete(x.right, key);
		else {
			// Checking for leaf node.
			if (x.right == null && x.left == null){
				// This is a leaf node.
				return null;
			} else if (x.right == null) {
				// One child, to the left.
				return x.left;
			} else if (x.left == null) {
				// One child, to the right.
				return x.right;
			} else {
				// Node x has two children.
				Node<K,V> rightTreeMinNode = findMin(x.right);
				x.key = rightTreeMinNode.key;
				x.val = rightTreeMinNode.val;
				x.right = delete(x.right, rightTreeMinNode.key);
			}
		}
		return x;
	}
	
	private Node<K,V> findMin(Node<K,V> x) {
		if (x.left == null) return x;
		else return findMin(x.left);
	}


	/* *********************************************************************
	 *  Range count and range search.
	 ***********************************************************************/
	public Iterable<K> keys() {
		Queue<K> q = new Queue<>();
		inOrder(root, q);
		return q;
	}

	private void inOrder(Node<K,V> x, Queue<K> q) {
		if (x == null) return;
		inOrder(x.left, q);
		q.enqueue(x.key);
		inOrder(x.right, q);
	}

   	public Iterable<K> keys(K lo, K hi) {
		Queue<K> queue = new Queue<>();
		inOrder(root, queue, lo, hi);
		return queue;
	}

	private void inOrder(Node<K,V> x, Queue<K> queue, K lo, K hi) {
		if (x == null) return;
		int cmplo = lo.compareTo(x.key);
		int cmphi = hi.compareTo(x.key);
		if (cmplo < 0) inOrder(x.left, queue, lo, hi);
		if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key);
		if (cmphi > 0) inOrder(x.right, queue, lo, hi);
	}


	// height of this BST (one-node tree has height 0)
	public int height() { return height(root); }
	private int height(Node<K,V> x) {
		if (x == null) return -1;
		return 1 + Math.max(height(x.left), height(x.right));
	}

	// level order traversal
	public Iterable<K> levelOrder() {
		Queue<K> keys = new Queue<>();
		Queue<Node<K,V>> queue = new Queue<>();
		queue.enqueue(root);
		while (!queue.isEmpty()) {
			Node<K,V> x = queue.dequeue();
			if (x == null) continue;
			keys.enqueue(x.key);
			queue.enqueue(x.left);
			queue.enqueue(x.right);
		}
		return keys;
	}

	/* ***************************************************************************
	 *  Visualization
	 *****************************************************************************/
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (K key: levelOrder())
			sb.append (key + " ");
		return sb.toString ();
	}

	// You may modify "drawTree" if you wish
	public void drawTree() {
		if (root != null) {
			StdDraw.setPenColor (StdDraw.BLACK);
			StdDraw.setCanvasSize(1200,700);
			drawTree(root, .5, 1, .25, 0);
		}
	}
	private void drawTree (Node<K,V> n, double x, double y, double range, int depth) {
		int CUTOFF = 10;
		StdDraw.text (x, y, n.key.toString ());
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

	/* ***************************************************************************
	 *  Test client
	 *****************************************************************************/
	public static void main(String[] args) {
		StdIn.fromString ("D F B G E A C");

		SimplerBST<String, Integer> st = new SimplerBST<>();
		for (int i = 0; !StdIn.isEmpty(); i++) {
			String key = StdIn.readString();
			st.put(key, i);
		}
		
		System.out.println(st.height());
		
		st.delete("D");
		st.drawTree();
		StdDraw.save("data/TreeDDeleted.jpg");		

		st.delete("B");
		st.drawTree ();
		StdDraw.save("data/TreeBDeleted.jpg");

		st.delete("E");
		st.drawTree ();
		StdDraw.save("data/TreeEDeleted.jpg");

		Iterable<String> keys = st.levelOrder();
		for (String s : keys)
			StdOut.println(s + " " + st.get(s));
	}
}
