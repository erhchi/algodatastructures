package book;

import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class BinarySearch {

	
	public static int indexOf(int[] a, int key){
		int lo = 0;
		int hi = a.length - 1;
		while(lo <= hi){
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) hi = mid - 1;
			else if (key > a[mid]) lo = mid + 1;
			else return mid;
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("args: ");
		for (String arg : args){
			System.out.println(arg);
		}
		
		In in = new In(args[0]);
		
		//In in = new In("C:\\Users\\ehaerr\\workspace\\CSC 402\\resources\\tinyW.txt");
		
		int[] whitelist = in.readAllInts();
		Arrays.sort(whitelist);
		
		while(!StdIn.isEmpty()){
			int key = StdIn.readInt();
			if(indexOf(whitelist, key) == -1)
				StdOut.println(key);
		}
	}
	
}
