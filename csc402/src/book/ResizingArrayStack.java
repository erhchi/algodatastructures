package book;

import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.In;

public class ResizingArrayStack<Item> implements Iterable<Item> {

	private Item[] a;		//array of items
	private int n;			//number of elements on a stack
	
	
	public ResizingArrayStack(){
		a = (Item[]) new Object[2];
		n = 0;
	}
	
	public boolean isEmpty(){
		return n == 0;
	}
	
	public int size(){
		return n;
	}
	
	
	private void resize(int capacity){
		assert capacity >= n;
		
		//textbook implementation
		Item[] temp = (Item[]) new Object[capacity];
		for(int i=0; i<n; i++){
			temp[i] = a[i];
		}
		a = temp;
		
		//alternative implementation
		//a = java.util.Arrays.copyOf(a, capacity);
	}
	
	
	public void push(Item item){
		if(n==a.length)resize(2*a.length); 	//double size of array if necessary
		a[n++] = item;						//add item
	}
	
	public Item pop(){
		if(isEmpty()) throw new NoSuchElementException("Stack underflow");
		Item item = a[n-1];
		a[n-1] = null;
		n--;
		
		//shrink size of array if necessary
		if(n>0 && n==a.length/4) resize(a.length/2);
		
		return item;
	}
	
	public Item peek(){
		if(isEmpty()) throw new NoSuchElementException("Stack underflow");
		return a[n-1];
	}
	
	
	public static void main(String[] args) {
		ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
		
		In in = new In(args[0]);
		while(!in.isEmpty()){
			String item = in.readString();
			if (!item.equals("-")) stack.push(item);
			else if (!stack.isEmpty()) System.out.print(stack.pop() + " ");
		}
		
		System.out.println("(" + stack.size() + " left on stack)");

	}
	

	public Iterator<Item>iterator(){
		return new ReverseArrayIterator();
	}
	
	private class ReverseArrayIterator implements Iterator<Item>{
		private int i;
		
		public ReverseArrayIterator(){
			i = n-1;
		}
		
		public boolean hasNext(){
			return i >= 0;
		}
		
		public void remove(){
			throw new UnsupportedOperationException();
		}
		
		public Item next(){
			if(!hasNext()) throw new NoSuchElementException();
			return a[i--];
		}
	}

}
