package book;

import java.util.Comparator;
import edu.princeton.cs.algs4.In;

public class Selection {
	
	private Selection(){}

	
	public static void sort(Comparable[] a){
		int n = a.length;
		for (int i = 0; i < n; i++){
			int min = i;
			for (int j = i + 1; j < n; j++){
				if(less(a[j], a[min])) min = j;
			}
			exch(a, i, min);
		}
	}
	
	private static void sort(Object[] a, Comparator comparator){
		int n = a.length;
		for(int i=0; i < n; i++){
			int min = i;
			for (int j = i + 1; j < n; j++){
				if(less(comparator, a[j], a[min])) min = j;
			}
			exch(a, i ,min);
		}
	}

	//is v < w?
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	
	private static boolean less(Comparator comparator, Object v, Object w){
		return comparator.compare(v, w) < 0; 
	}
	
	//exchange a[i] and a[j]
	private static void exch(Object[] a, int i, int j){
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	private static void show(Comparable[] a){
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]);
		}
	}
	
		
	public static void main(String[] args) {
		
		In in = new In(args[0]);
		String[] a = in.readAllStrings();
		
		show(a);
		
		Selection.sort(a);
		System.out.println();
		
		show(a);
		
		
		/*for(String s : a){
			System.out.print(s);
		}*/
		

	}

}
