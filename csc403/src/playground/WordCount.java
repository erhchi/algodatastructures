package playground;

import stdlib.*;
import java.util.*;

public class WordCount {
	
	public static void main(String[] args){
		StdIn.fromFile("data/words1.txt");
		String[] words = StdIn.readAllStrings();
		
		
		HashMap<String, Integer> hm = new HashMap<>();
		
		int count = 1;
		for(String word : words){
			//System.out.println(word);
			//if exists pull and ++
			if(hm.containsKey(word)){
				count = hm.get(word)+1;
				hm.put(word, count);
			}
			//else new
			else{
				hm.put(word, count);
			}
		
		
		
//		String[] words = {};
//		HashMap<String, Integer> hm = new HashMap<>();
//		
//		while(StdIn.hasNextLine()){
//			String line = StdIn.readLine();
//			words = line.split("\\s+");
//			
////			for(int i = 0; i<words.length; i++){
////				System.out.println(words[i]);
////			}
//			int count = 1;
//			for(String word : words){
//				//System.out.println(word);
//				//if exists pull and ++
//				if(hm.containsKey(word)){
//					count = hm.get(word)+1;
//					hm.put(word, count);
//				}
//				//else new
//				else{
//					hm.put(word, count);
//				}
//			}
			
			
			
			//hm.put(word, arg1)
		}
		
		for(String key : hm.keySet()){
			System.out.println("key: " + key + " value: " + hm.get(key));
		}
		
		
	}
	

}
