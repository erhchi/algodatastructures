package program6W;

import java.util.*;

public class BasicLinkedList3<T> implements Iterable<T> {

	private Node<T> first;	//first node in list
	private Node<T> last;
	private int N;
	
	public static class Node<T>{
		private int index;
		private T value;
		private Node<T> next;
	}	
		
 	public BasicLinkedList3(){
 		first = null;
		last = null;
		N = 0;
	};
	
	
	
	public void add(T item){
		Node<T> newNode = new Node<>();
		newNode.value = item;
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
	
	
	public T getValueAtIndex(int index){
		if(index < 0 || index > this.size() || this.first == null){
			throw new IndexOutOfBoundsException();
		}
		
		Node<T> node = this.first;
		for(int i=0; i<index; i++){
			node = node.next;
		}
		
		return node.value;
	}
	
	
//	public T getValueAtIndex(int index){
//		Node<T> eval = this.first;
//		if(index < 0 || index > this.size()){
//			throw new IndexOutOfBoundsException();
//		}
//		else{
//			for(int i=0; i<=this.size(); i++){
//				if(eval.index == index){
//					return (T) eval;
//				}
//				else{
//					eval = eval.next;
//				}
//			}
//		}		
//		return (T) eval;
//	}
	
	

	
	
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
