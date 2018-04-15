package program6W;

import java.util.ArrayList;
import java.util.*;

public class IndexedLinkedList<T> {

	private Node<T> first;	//first node in list
	private Node<T> last;
	private int count;
	private ArrayList<T> items = new ArrayList<>();
	private LinkedList<T> linked;
	
	private class Node<T>{
		private T key;
		private Node next;
		//private V value;
	}
	
	
	//create empty indexed linked list
 	public IndexedLinkedList(){
 		linked = new LinkedList<>();
	};
	
	
	public void insertBeforeIndex(T value, int index){
		try{
			linked.add(index, value);
			count++;
		}
		catch(IndexOutOfBoundsException ex){
			System.out.println(ex.toString());
		}
	}
	
	public int getIndexOfValue(T value){
		return linked.indexOf(value);
		
	}
	
	public T getValueAtIndex(int index){
		if(index<0 || index > this.size()){
			throw new IndexOutOfBoundsException();
		}
		else{
			return linked.get(index);
		}
	}
	
	public int countValue(T value){
		int valCount = 0;
		
		for(T val : this.values()){
			if(value.equals(val)){
				valCount++;
			}
		}
		
		return valCount;
	}
	
	
	public Iterable<T> values(){
		return linked;
	}

	
	
	
	public int size(){return count;}
	
	public boolean isEmpty(){
		if(first==null)
			return true;
		else{
			return false;
		}
	}
	
	
}
