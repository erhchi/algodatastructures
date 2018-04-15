package book;

import edu.princeton.cs.algs4.In;
import java.util.Comparator;

public class Insertion {

	public static void sort(Comparable[] a){
		int n = a.length;
		for (int i = 0; i < n; i++){
			for (int j=i; j>0 && less(a[j], a[j-1]); j--){
				exch(a, j, j-1);
			}
		}
	}
	
	
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

	
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
    
	public static void main(String[] args) {
		In in = new In(args[0]);
		String[] a = in.readAllStrings();
		
		show(a);
		
		Insertion.sort(a);
		System.out.println();
		
		show(a);

	}

}
