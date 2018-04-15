package program6;

import java.util.*;

public class BasicLinkedList<T> implements Iterable<T> {

	private Node<T> first;	//first node in list
	private Node<T> last;
	private int N;
	
	public static class Node<T>{
		private int index;
		private T value;
		private Node<T> next;
	}	
		
 	public BasicLinkedList(){
 		first = null;
		last = null;
		N = 0;
	};
	
	
	
	public void add(T value){
		Node<T> newNode = new Node<>();
		newNode.value = value;
		//newNode.next = first;
		newNode.next = null;
		
		if(N == 0){
			newNode.index = 0;
			first = newNode;
			last = newNode;
			//last = null;
		}
		else{
			if(last != null){
				Node oldLast = last;
				oldLast.next = newNode;
				newNode.index = oldLast.index+1;
			}
			last = newNode;
		}		
		
		N++;
	}
	
	public void insertFirst(T value){
		//get current first
		Node<T> currentFirst = this.first;
		//create new node
		Node<T> newNode = new Node<>();
		newNode.index = 0;
		newNode.value = value;
		newNode.next = currentFirst;
		this.first = newNode;
	}
	
	public void insertBeforeIndex(T value, int index){
		//check status of request 
		if(index < 0 || index > this.size()){
			throw new IndexOutOfBoundsException();
		}
				
		Node<T> current = this.first;
		Node<T> prev;
		
		//if 0 call insert first...can't insert before index 0
		if(index == 0){
			insertFirst(value);
		}
		else if(index == this.size()){
			add(value);
		}
		else{
			//iterate only up to index location
			for(int i = 0; i<index; i++){
				prev = current;
				current = current.next;
				//at location before specified index update nodes
				if(i == index-1){
					Node<T> insert = new Node<>();
					insert.value = value;
					insert.index = i;
					insert.next = current;
					prev.next = insert;
					N++;
				}
			}
		}
		
	}
	
	
	public T getValueAtIndex(int index){
		//check status of request and list
		if(index < 0 || index > this.size()-1 || this.first == null){
			throw new IndexOutOfBoundsException();
		}
		
		Node<T> node = this.first;
		for(int i=0; i<index; i++){
			node = node.next;
		}
		
		return node.value;
	}
	
	
	
	public int countValue(T value){
		int valueTimes = 0;
		
		for(T node : this){
			if(node.equals(value)){
				valueTimes++;
			}
		}
		
		return valueTimes;
	}

	
	public int size(){return N;}
	
	
	public boolean isEmpty(){
		if(first==null)
			return true;
		else{
			return false;
		}
	}
		

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<T>{
		private Node<T> current = first;
		
		@Override
		public boolean hasNext() {
			if(current !=null){
				return true;
			}
			else{
				return false;
			}
		}

		@Override
		public T next() {
			T item = current.value;
			current = current.next;
			return item;
		}
	
	}
	
	
	
}
