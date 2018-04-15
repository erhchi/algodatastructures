package written1;

import algs31.*;
import stdlib.StdIn;

public class testground {

	static BinarySearchSTModified<String,Integer> bst = new BinarySearchSTModified<String, Integer>();
	
	public static void main(String[] args) {
		String phrase = "E A S Y Q U E S T I O N";
		//String phrase = "S E";// A R "; //C H E X A M"; // P L E";
		String[] x = phrase.split(" ");
		
		System.out.println(x.length + "\n");
		
		for(int i = 0; i<=x.length-1; i++){
			bst.put(x[i], i);
		}
		
		System.out.println("Total compares: " + bst.comparecounts);
		
//		for(String key : bst.keys()){
//			System.out.println("Key: " + key + " Value: " + bst.get(key));
//		}

	}

}
