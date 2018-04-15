package group4;

import edu.princeton.cs.algs4.In;

public class CountTokensTest {

	public static void main(String args[]){
		In in = new In(args[0]);
		
		String[] list = in.readAllStrings();
		
		XMLToken token;
		
		for(String item : list){
			System.out.println("Token: " + item);
			
			token = new XMLToken(item);
			
			
			System.out.println("Is Word: " + token.isWord());
			System.out.println("Is Tag: " + token.isTag());
			System.out.println("Is opening tag: " + token.isOpeningTag());
			System.out.println("Is closing tag: " + token.isClosingTag());
			System.out.println("Is self-closing tag: " + token.isSelfClosingTag());
			System.out.println();
			
		}
		
		
		
		
//		String testBrackets = "<<test>>";
//		XMLToken testBracketsXML = new XMLToken(testBrackets);
//		System.out.println(testBracketsXML.countOpenBrackets());
//		System.out.println(testBracketsXML.countCloseBrackets());		
		
		
//		String testWSP = "test wsp";
//		XMLToken testWhitespace = new XMLToken(testWSP);
//		System.out.println(testWhitespace.isWord());
//		
//		String testNWSP = "testnowhtsp";
//		XMLToken testNoWhitespace = new XMLToken(testNWSP);
//		System.out.println(testNoWhitespace.isWord());
		
		
	}
}
