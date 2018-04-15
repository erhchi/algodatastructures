package sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class template {
	
	public static void sort(Comparable[] a){
		
	}
	
	private static boolean less(Comparable v, Comparable w){
		return v.compareTo(w) < 0;
	}
	
	private static void exchange(Comparable[] a, int i, int j){
		Comparable t = a[i]; a[i] = a[j]; a[j] = t;
	}
	
	private static void show(Comparable[] a){
		for (int i = 0; i < a.length; i++)
			StdOut.print(a[i] + " ");
		StdOut.println();
	}
	
	public static boolean isSorted(Comparable[] a){
		for (int i=1; i<a.length; i++)
			if(less(a[i], a[i-1])) return false;
		return true;
	}

	public static void main(String[] args){
		In in = new In(args[0]);
		/*while(!in.isEmpty()){
			String item = in.readString();
			System.out.println(item);
		}*/
		
		String[] a = in.readAllStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
	
}


