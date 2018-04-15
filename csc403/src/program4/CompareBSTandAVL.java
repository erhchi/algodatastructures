package program4;

import java.util.ArrayList;
import java.util.Collections;
import stdlib.*;
import stdlib.StdIn;

public class CompareBSTandAVL {

	public static void main(String[] args) {
		
		Program4BST<String, Long> bstTale = new Program4BST<>();
		Program4AVLTree<String, Long> avlTale = new Program4AVLTree<>();
		
		try{
			StdIn.fromFile("data/tale.txt");
			String[] words = StdIn.readAllStrings();
			//keeping counts separate to help indicate if i had a bug with the tree put implementations, since
			//counts should be same.
			long bstCount = 0;
			long avlCount = 0;
			
			for(String word:words){
				if(bstTale.contains(word)){
					bstCount = bstTale.get(word) + 1;
				}
				else{
					bstCount = 1;
				}
				bstTale.put(word, bstCount);
				
				if(avlTale.contains(word)){
					avlCount = avlTale.get(word) + 1;
				}
				else{
					avlCount = 1;
				}
				avlTale.put(word, avlCount);
			}		
			
			//should return 7989
			System.out.println("count of the bst the's:" + bstTale.get("the"));
			System.out.println("count of the avl the's:" + avlTale.get("the"));
			System.out.println("");
			
			System.out.println("Total BST compares for tale.txt: " + bstTale.compareCounts());
			System.out.println("Total AVL compares for tale.txt: " + avlTale.compareCounts());
			System.out.println("");
			
		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
		
		try{
			StdIn.fromFile("data/8Kints.txt");
			int[] numbers = StdIn.readAllInts();
			ArrayList<Integer> alist = new ArrayList<>();
			for(Integer number: numbers){
				alist.add(number);
			}
					
			Program4BST<Integer, Boolean> bst8k = new Program4BST<>();
			Program4AVLTree<Integer, Boolean> avl8k = new Program4AVLTree<>();
			for(int i = 0; i<=alist.size()-1; i++){
				bst8k.put(alist.get(i), true);
				avl8k.put(alist.get(i), true);
			}
			
			System.out.println("Total BST compares for 8kints.txt: " + bst8k.compareCounts());
			System.out.println("Total AVL compares for 8kints.txt: " + avl8k.compareCounts());
			System.out.println("");
			
			Collections.sort(alist);
			
			Program4BST<Integer, Boolean> bst8kSorted = new Program4BST<>();
			Program4AVLTree<Integer, Boolean> avl8kSorted = new Program4AVLTree<>();
			for(int i = 0; i<=alist.size()-1; i++){
				bst8kSorted.put(alist.get(i), true);
				avl8kSorted.put(alist.get(i), true);
			}
			System.out.println("Total BST compares for 8kints.txt sorted: " + bst8kSorted.compareCounts());
			System.out.println("Total AVL compares for 8kints.txt sorted: " + avl8kSorted.compareCounts());
			System.out.println("");
			
		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
	}
}
