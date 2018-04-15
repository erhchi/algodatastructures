package program6W;

import java.util.*;

public class BasicLinkedList2<T> implements Iterable<T> {

	private Node<T> first;	//first node in list
	private Node<T> last;
	private int N;
	private ArrayList<Node> arrayList = new ArrayList<>();
	
	public class Node<T>{
		private int index;
		private T key;
		private Node next;
		//private V value;
		
//		public int Index(){
//			return index;
//		}
	}
	
	
	
		
 	public BasicLinkedList2(){
 		first = null;
		last = null;
		N = 0;
	};
	
	
	
	public void add(T item){
		Node<T> newNode = new Node<>();
		newNode.key = item;
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
		
		arrayList.add(newNode);
		N++;
	}
	
	
//	public String toString(){
//		StringBuilder sb = new StringBuilder();
//		//sb.append()
//		return sb.toString();
//	}
	
	
	public int size(){return N;}
	
	public boolean isEmpty(){
		if(first==null)
			return true;
		else{
			return false;
		}
	}
	
	public Iterable<Node> values(){
		return arrayList;
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
			T item = (T) current;
			current = current.next;
			return item;
		}
	
	}
	
	
	
}
