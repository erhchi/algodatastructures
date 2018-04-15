package book;

import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.In;

public class LinkedStack<Item> implements Iterable<Item> {
	
	private int n;
	private Node first;
	
	private class Node{
		private Item item;
		private Node next;
	}
	
	public LinkedStack(){
		first = null;
		n=0;
		assert check();
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return n;
	}
	
	//add the item to the stack
	public void push(Item item){
		Node second = first;
		//first = new Node();
		Node first = new Node();
		first.item = item;
		first.next = second;
		n++;
		//assert check();
	}
	
	
	//removes and returns the item most recently added to this stack
	public Item pop(){
		if(isEmpty()) throw new NoSuchElementException("Stack underflow");
		Item item = first.item;		//save item to return
		first = first.next;			//delete the first node
		n--;
		assert check();
		return item;				//return the saved item
	}
	
	
	public Item peek(){
		if(isEmpty()) throw new NoSuchElementException("Stack underflow");
		return first.item;
	}
	
	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	
	//an iterator doesn't implement remove() since it's optional
	private class ListIterator implements Iterator<Item>{
		private Node current = first;
		public boolean hasNext() {return current !=null;}
		public void remove(){throw new UnsupportedOperationException();}
		
		public Item next(){
			if(!hasNext()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	
	//check internal invariants
	private boolean check(){
		//check a few properties of instance variable 'first'
		if(n<0){
			return false;
		}
		if(n==0){
			if(first != null) return false;
		}
		else if(n==1){
			if(first == null)	return false;
			if(first.next == null)	return false;
		}
		else{
			if(first == null)	return false;
			if(first.next == null) return false;
		}
		
		//check internal consistency of instance variable n
		int numberOfNodes = 0;
		for(Node x = first; x != null && numberOfNodes <= n; x = x.next){
			numberOfNodes++;
		}
		if(numberOfNodes != n) return false;
		
		return true;
	}
	
	
	public static void main(String[] args) {
		LinkedStack<String> stack = new LinkedStack<String>();
		
		In in = new In(args[0]);
		while(!in.isEmpty()){
			String item = in.readString();
			if (!item.equals("-")) stack.push(item);
			else if (!stack.isEmpty()) System.out.print(stack.pop() + " ");
		}
		
		System.out.println("(" + stack.size() + " left on stack)");

		for (String s : stack){
			System.out.println(s);
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
