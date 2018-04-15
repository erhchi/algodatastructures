package sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import utils.Helper;

public class Shellsort {

	public static void sort(Comparable[] a){
		int n = a.length;
		int h = 1;
		
		StdOut.println(n);
		StdOut.println(h);
		
		while (h < n/3){
			h = 3*h + 1;
		}
		
		System.out.println(n);
		System.out.println(h);
		
		System.out.println();
		Helper.ShowComparableIterationNewLine(a);
		System.out.println();
		
		while(h>=1){
			for(int i = h; i < n; i++){
				for (int j=i; j >= h && less(a[j], a[j-h]); j -= h){
					exchange(a, j, j-h);
				}
			}
			h = h/3;
			System.out.println(h);
		}
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
