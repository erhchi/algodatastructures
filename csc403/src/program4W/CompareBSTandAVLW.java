package program4W;

import java.util.ArrayList;
import java.util.Collections;
import stdlib.*;
import stdlib.StdIn;

public class CompareBSTandAVLW {

	public static void main(String[] args) {
		
		Program4BSTW<String, Long> bstTale = new Program4BSTW<>();
		Program4AVLTreeW<String, Long> avlTale = new Program4AVLTreeW<>();
		
		try{
			StdIn.fromFile("data/tale.txt");
			String[] words = StdIn.readAllStrings();
//			long count = 0;			
//			for(String word:words){
//				bstTale.put(word, count);
//				avlTale.put(word, count);
//				count++;
//			}
			
			long count = 0;
			
			for(String word:words){
				//would there ever be a case when one word, from the same input existed in 
				//one tree but not the other? if it did then that would be a source of a bug
				//in the tree implementation.
				if(bstTale.contains(word) && avlTale.contains(word)){
					//bstCount = bstTale.get(word) + 1;
					//avlCount = avlTale.get(word) + 1;
					count = bstTale.get(word) + 1;
				}
				else{
					//bstCount = 1;
					//avlCount = 1;
					count = 1;
				}
				bstTale.put(word, count);
				avlTale.put(word, count);
			}
			
//			for(String word:words){
//				if(bstTale.contains(word)){
//					bstCount = bstTale.get(word) + 1;
//				}
//				else{
//					bstCount = 1;
//				}
//				bstTale.put(word, bstCount);
//				
//				if(avlTale.contains(word)){
//					avlCount = avlTale.get(word) + 1;
//				}
//				else{
//					avlCount = 1;
//				}
//				avlTale.put(word, avlCount);
//			}			
			
			//should return 7989
			System.out.println("count of the bst the's:" + bstTale.get("the"));
			System.out.println("count of the avl the's:" + avlTale.get("the"));
			System.out.println("");
			
//			System.out.println(bstTale.contains("wisdom"));
//			System.out.println(bstTale.get("wisdom"));
			
			
			System.out.println("Total BST compares for tale.txt: " + bstTale.compareCounts());
			System.out.println("Total AVL compares for tale.txt: " + avlTale.compareCounts());
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
		
		try{
			StdIn.fromFile("data/8kints.txt");
			int[] numbers = StdIn.readAllInts();
			ArrayList<Integer> alist = new ArrayList<>();
			for(Integer number: numbers){
				alist.add(number);
			}
			
			System.out.println(alist.isEmpty());
			System.out.println(alist.size());
			System.out.println("");
			
			Program4BSTW<Integer, Boolean> bst8k = new Program4BSTW<>();
			Program4AVLTreeW<Integer, Boolean> avl8k = new Program4AVLTreeW<>();
			for(int i = 0; i<=alist.size()-1; i++){
				//System.out.println(alist.get(i));
				bst8k.put(alist.get(i), true);
				avl8k.put(alist.get(i), true);
			}
			
			System.out.println("Total BST compares for 8kints.txt: " + bst8k.compareCounts());
			System.out.println("Total AVL compares for 8kints.txt: " + avl8k.compareCounts());
			System.out.println("");
			
			Collections.sort(alist);
			
			Program4BSTW<Integer, Boolean> bst8kSorted = new Program4BSTW<>();
			Program4AVLTreeW<Integer, Boolean> avl8kSorted = new Program4AVLTreeW<>();
			for(int i = 0; i<=alist.size()-1; i++){
				//System.out.println(i + " " + alist.get(i));
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
