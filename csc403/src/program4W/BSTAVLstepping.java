package program4W;

import java.util.ArrayList;
import java.util.Collections;

import stdlib.StdIn;

public class BSTAVLstepping {

public static void main(String[] args) {
		
		Program4BSTW<String, Integer> bst = new Program4BSTW<>();
		Program4AVLTreeW<String, Integer> avl = new Program4AVLTreeW<>();
		
		try{
			StdIn.fromString("D F B G E A C");
			for(int i=0; !StdIn.isEmpty(); i++){
				String key = StdIn.readString();
				bst.put(key, i);
				avl.put(key, i);
			}
		
			
			System.out.println("Total BST compares: " + bst.compareCounts());
			System.out.println("Total AVL compares: " + avl.compareCounts());
			System.out.println("");
			
//			bstTale.drawTree();
//			StdDraw.save("data/Program4BST.png");
//			
//			avlTale.drawTree();
//			StdDraw.save("data/Program4AVL.png");
			
		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
		

	}
}
