package program6;

import program6.BasicLinkedList.Node;
import stdlib.StdOut;

public class BasicLinkedTest {

	public static void main(String[] args) {
		BasicLinkedList<String> ill = new BasicLinkedList<>();
		ill.add("A");
		ill.add("B");
		ill.add("C");
		ill.add("D");

		for(String item : ill){
			System.out.println(item);
		}
		
		ill.insertBeforeIndex("X", 0);
		
		StdOut.println();
		
		for(String item : ill){
			System.out.println(item);
		}
		
		
		ill.insertBeforeIndex("E", ill.size());
		
		StdOut.println();
		
		for(String item : ill){
			System.out.println(item);
		}
		
		StdOut.println();
		
		StdOut.println("The word 'the' occurs " + ill.countValue("C") + " times.");
		
		
//		try{
//		System.out.println("x:" + ill.getValueAtIndex(2));
//		}
//		catch(Exception ex){
//			System.out.println(ex.toString());
//		}
//		
		
		
		/*
		// Test that index values are properly checked.  Each try/catch
				// block should result in a thrown exception.  
		try {
			StdOut.println(ill.getValueAtIndex(-1));
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}

		try {
			StdOut.println(ill.getValueAtIndex(ill.size()));
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		*/
		
		
	}

}
