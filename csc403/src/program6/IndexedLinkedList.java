package program6;

import java.util.*;

public class IndexedLinkedList<T> implements Iterable<T> {

	private Node<T> first;	//first node in list
	private Node<T> last;
	private int N;
	
	public static class Node<T>{
		private T value;
		private Node<T> next;
	}	
		
 	public IndexedLinkedList(){
 		first = null;
		last = null;
		N = 0;
	};
	
	//if add called without index default to end of list
	public void add(T value){
		add(value, this.size());
	}
	
	public void add(T value, int index){
		//check status of request 
		if(index < 0 || index > this.size()){
			throw new IndexOutOfBoundsException();
		}
		
		Node<T> newNode = new Node<>();
		
		if(N==0 || index == 0){
			//insert at beginning
			//get current first, if N==0 this will be null
			Node<T> oldFirst = this.first;
			//create new node
			newNode.value = value;
			newNode.next = oldFirst;
			first = newNode;
			last = newNode;
		}
		else{
			//insert at end of list
			newNode.value = value;
			Node oldLast = last;
			oldLast.next = newNode;
			last = newNode;
		}
		N++;
	}
	
	public void insertBeforeIndex(T value, int index){
		//check status of request 
		if(index < 0 || index > this.size()){
			throw new IndexOutOfBoundsException();
		}
		
		//if 0 call insert first...can't insert before index 0
		if(index == 0 || index == this.size()){
			add(value, index);
		}
		else{
			Node<T> current = this.first;
			Node<T> prev;
			//iterate only up to index location
			for(int i = 0; i<index; i++){
				prev = current;
				current = current.next;
				//at location before specified index update nodes
				if(i == index-1){
					Node<T> insert = new Node<>();
					insert.value = value;
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
	
	public int getIndexOfValue(T value){
		Node<T> node = this.first;
		for(int i =0; i<=this.size(); i++){
			if(node.value.equals(value)){
				//return node.index;
				return i;
			}
			else{
				node = node.next;
			}
		}
		return -1;
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
			if (!hasNext()) throw new NoSuchElementException();
			T item = current.value;
			current = current.next;
			return item;
		}
	
	}
	
	
	
}
