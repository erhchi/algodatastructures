package group4;

public class XMLToken {

	String token;
	
	public XMLToken(String token){
		this.token = token;
	}
	
	
	boolean isTag(){		
		if(countOpenBrackets()==1 && countCloseBrackets()==1){
			return true;
		}
		return false;
	}
	
	boolean isWord(){
		if((!token.contains("<") && !token.contains(">")) && !token.contains(" ")){
			return true;
		}
		return false;
	}
	
	
	boolean isClosingTag(){
		if(token.contains("</")){
			return true;
		}
		return false;
	}
		
	
	boolean isOpeningTag(){
		if(((countOpenBrackets()==1 && countCloseBrackets()==1) && !(token.charAt(1) == '/')) && !isSelfClosingTag()){
			return true;	
		}			
		return false;
	}
	
	
	boolean isSelfClosingTag(){
		if(token.contains("/>")){
			return true;
		}
		return false;
	}
	
	
	
	private int countOpenBrackets(){
		int count = 0;
		
		for(int i=0; i < token.length(); i++){			
//			System.out.println(token.charAt(i));
//			System.out.println(String.valueOf(token.charAt(i)));
//			System.out.println(Character.toString(token.charAt(i)));

			if(token.charAt(i) == '<'){
				count++;
			}	
		}
		return count;		
	}
	
	private int countCloseBrackets(){
		int count = 0;
		
		for(int i = 0; i < token.length(); i++){
			if(token.charAt(i) == '>'){
				count++;
			}
		}
		return count;
	}
	
}
