package week6;

public class TestInsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] names = initializeNamesArray();
		
		System.out.println("Displaying names array before sorting...");
		display(names);
		
		System.out.println("Being sorting...");
		Insertion.sort(names);
		System.out.println("End sorting...");
		
		System.out.println("Displaying names array after sorting...");
		display(names);
	}

	private static String[] initializeNamesArray() {
		String array[] = {"Joe", "Bill", "Ann", "Omar", "Sydney", "Ellen", "Mark", "Marshall", "Earl", "Vicky"};
		
		return array;
	}

	private static void display(String[] names) {
        for (String name : names) {
            System.out.println(name);
        }
	}

}
