package sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import utils.Helper;

public class selection {

	public static void sort(Comparable[] a){
		int n = a.length;
		for(int i=0; i<n; i++){
			int min = i;
			for(int j = i+1; j < n; j++){
				
				System.out.println("--------------------------");
				System.out.println("i = " + i);
				System.out.println("j = " + j);
				System.out.println();
				
				
				System.out.println("min="+ min + " j=" + j);
				System.out.print(a[min] + " " + a[j] + " ");
				System.out.println(less(a[j],a[min]));
				//System.out.println();
				
				System.out.println();
				Helper.ShowComparableIterationNewLine(a);
				System.out.println();
				
				
				if(less(a[j], a[min])){
					min = j;
				}
				System.out.println("swap value (min) = " + min);
				exchange(a,i,min);
				
				//System.out.println();
				Helper.ShowComparableIterationNewLine(a);
				System.out.println();
				System.out.println();
			}
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
