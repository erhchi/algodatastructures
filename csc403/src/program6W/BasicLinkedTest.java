package program6W;

public class BasicLinkedTest {

	public static void main(String[] args) {
		BasicLinkedList<String> ill = new BasicLinkedList<>();
		ill.add("A");
		ill.add("B");
		ill.add("C");
		ill.add("D");
		
		for(String letter : ill){
			System.out.println(letter);
		}

	}

}
