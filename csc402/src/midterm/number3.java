package midterm;

	import java.util.Iterator;
	import java.util.NoSuchElementException;

	import edu.princeton.cs.algs4.In;
	import edu.princeton.cs.algs4.Out;
	import edu.princeton.cs.algs4.StdIn;
	import edu.princeton.cs.algs4.StdOut;

	public class number3<Item> implements Iterable<Item> {

		private Node<Item> first;	//top of stack
		private int n;				//size of the stack
		
		
		//helper linked list class
		private static class Node<Item>{
			private Item item;
			private Node<Item> next;
		}
		
		public number3(){
			first = null;
			n = 0;
		}
		
		
		//return true if this stack is empty otherwise false
		public boolean isEmpty(){
			return first == null;
		}
		
		//return the number of items in this stack
		public int size(){
			return n;
		}
		
		
		//add the item to the stack
		public void push(Item item){
			Node<Item> oldfirst = first;
			first = new Node<Item>();
			first.item = item;
			first.next = oldfirst;
			n++;
		}
		
		
		//removes and returns the item most recently added to this stack
		public Item pop(){
			if(isEmpty()) throw new NoSuchElementException("Stack underflow");
			Item item = first.item;		//save item to return
			first = first.next;			//delete the first node
			n--;
			return item;				//return the saved item
		}
		
		
		public Item peek(){
			if(isEmpty()) throw new NoSuchElementException("Stack underflow");
			return first.item;
		}
		
			
		public static void main(String[] args) {
			
			/*number3<String> s = new number3<String>();
			while(!q.isEmpty())
				s.push(q.dequeue());
			while(!s.isEmpty())
				q.enqueue(s.pop());*/
			
			number3<Integer> s = new number3<Integer>();
			
			int n = 50;
			
			while (n > 0){
				s.push(n % 2);
				n = n /2;
			}
			
			while(!s.isEmpty())
				System.out.print(s.pop());
			System.out.println();
			
			for (int i : s){
				System.out.println(i);
			}

		}

		
		//return an iterator to this stack that iterates through the items in LIFO order
		public Iterator<Item> iterator(){
			return new ListIterator<Item>(first);
		}
		
		private class ListIterator<Item> implements Iterator<Item>{
			private Node<Item> current;
			
			public ListIterator(Node<Item> first){
				current = first;
			}
			
			public boolean hasNext(){
				return current != null;
			}
			
			public void remove(){
				throw new UnsupportedOperationException();
			}
			
			public Item next(){
				if(!hasNext()) throw new NoSuchElementException();
				Item item = current.item;
				current = current.next;
				return item;
			}
		}
		
		public String toString(){
			StringBuilder sb = new StringBuilder();
			for(Item item : this){
				sb.append(item);
				sb.append(' ');
			}
			return sb.toString();
		}
	
}
