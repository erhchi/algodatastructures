package week3;

import java.util.Arrays;

public class MyRecursion3 {

	public static void reverseR (double[] a) {
		reverseHelper(a, 0, a.length-1);
	}
	
	private static double[] reverseHelper(double[] a, int start, int end){
		try{
			if (start >= end){
				return a;
			}			
			//save value b/c reassigning
			double temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			
			return reverseHelper(a, start+1, end-1);
		}
		catch(Exception e){
    		System.out.println("System exception, reverseHelper.");
    		return a;
    	}
	}
	
	
	public static void main(String[] args){
		
		double[] list0 = new double[] {};
		double[] list1 = new double[] { 5 };
		double[] list2 = new double[] { -3, 5 };
		double[] list3 = new double[] { 2, -3, 5 };
		double[] list4 = new double[] { -1, 2, -3, 5 };
		double[] list5 = new double[] { 33, 44, 55 };		

		System.out.println("Reversing the lists");
		reverseR (list0);
		System.out.println ("list0: " +Arrays.toString (list0));
		reverseR (list1);
		System.out.println ("list1: " +Arrays.toString (list1));
		reverseR (list2);
		System.out.println ("list2: " +Arrays.toString (list2));
		reverseR (list3);
		System.out.println ("list3: " +Arrays.toString (list3));
		reverseR (list4);
		System.out.println ("list4: " +Arrays.toString (list4));
		reverseR (list5);
		System.out.println ("list5: " +Arrays.toString (list5));
	}
}
