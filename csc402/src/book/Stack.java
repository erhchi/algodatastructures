package book;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stack<Item> implements Iterable<Item> {

	private Node<Item> first;	//top of stack
	private int n;				//size of the stack
	
	
	//helper linked list class
	private static class Node<Item>{
		private Item item;
		private Node<Item> next;
	}
	
	public Stack(){
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
		
		System.out.println("args: ");
		for (String arg : args){
			System.out.println(arg);
		}
		
		In in = new In(args[0]);
/*		if(in.isEmpty()){
			System.out.println("empty");
		}
		else{
			String[] file = in.readAllLines();
			for(String f : file){
				System.out.println(f);
			}
			
		}*/
		
		Stack<String> stack = new Stack<String>();
		
		while(!in.isEmpty()){
			String item = in.readString();
			if(!item.equals("-"))
				stack.push(item);
			else if(!stack.isEmpty())
				System.out.println("(" + stack.size() + " left on stack)");
		}
		
		
/*		System.out.println(stack.first);
		System.out.println(stack.n);
		System.out.println(stack.toString());
		System.out.println(stack.isEmpty());
		System.out.println(stack.peek());
*/		
		for (String s : stack){
			System.out.println(s);
		}
		//stack.iterator();
		
		
/*		while(!StdIn.isEmpty()){
			String item = StdIn.readString();
			if(!item.equals("-"))
				stack.push(item);
			else if (!stack.isEmpty())
				StdOut.println("(" + stack.size() + " left on stack)");
		}
*/
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
