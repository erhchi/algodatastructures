package program6W;

import java.util.Iterator;

public class BasicLinkedList<T> implements Iterable<T> {

	private Node<T> first;	//first node in list
	private Node<T> last;
	private int count;
	
	private class Node<T>{
		private T key;
		private Node next;
		//private V value;
	}
	
	
	
 	public BasicLinkedList(){
 		first = null;
		last = null;
		count = 0;
	};
	
	public void add(T item){
		Node<T> newNode = new Node<>();
		newNode.key = item;
		//newNode.next = first;
		newNode.next = null;
		
		if(count == 0){
			first = newNode;
			last = newNode;
			//last = null;
		}
		else{
			if(last != null){
				Node oldLast = last;
				oldLast.next = newNode;
			}
			last = newNode;
		}		
		
		
		count++;
	}
	
	
	
	public int size(){return count;}
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
			T item = current.key;
			current = current.next;
			return item;
		}
	
	}
	
	
	
}
