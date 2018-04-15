package group4;

import java.util.Scanner;

import edu.princeton.cs.algs4.In;

public class CountTokens {

	public static void main(String args[]){
		
		System.out.println("Provide the location and name of the file to be parsed: ");
		Scanner console = new Scanner(System.in);
		String filepath = console.nextLine();
		//System.out.println(filepath + "\n");
		
		try{
			In in = new In(filepath);		
			//In in = new In(args[0]);
			String[] list = in.readAllStrings();
			
			XMLToken token;
			
			int word=0,open=0,close=0,self=0;
			
			for(String item : list){
				//System.out.println("Token: " + item);
				
				token = new XMLToken(item);
				
				if(token.isWord()){
					word++;
				}
				
				if(token.isOpeningTag()){
					open++;
				}
				
				if(token.isClosingTag()){
					close++;
				}
				
				if(token.isSelfClosingTag()){
					self++;
				}				
				
//				System.out.println("Is Word: " + token.isWord());
//				System.out.println("Is Tag: " + token.isTag());
//				System.out.println("Is opening tag: " + token.isOpeningTag());
//				System.out.println("Is closing tag: " + token.isClosingTag());
//				System.out.println("Is self-closing tag: " + token.isSelfClosingTag());
//				System.out.println();
				
			}
				
			System.out.println("Words: " + word + "\nOpening tags: " + open + "\nClosing tags: " + close + "\nSelf-closing: " + self);
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			main(args);
		}
		
	}
	
}
