package week7;

import java.util.ArrayList;
import java.util.Collections;
import edu.princeton.cs.algs4.StdIn;

public class TestSortOptions {

	public static void main(String[] args) {
		ArrayList<Contact> contacts = initializeContactsArray();
		
		//displayContacts(contacts);
		
        promptForOption(contacts);
        
        //displayContacts(contacts);
	}

    /*
     * Data Initialization
     */
    
    private static ArrayList<Contact> initializeContactsArray() {
        ArrayList<Contact> list = new ArrayList<>();        
        list.add(new Contact("Adam", "Ant", "MI", 14));
        list.add(new Contact("Bill", "Barnes", "OH", 62));
        list.add(new Contact("Jane", "Doe", "CA", 41));
        list.add(new Contact("Joe", "Jones", "IL", 35));
        list.add(new Contact("Ida", "Know", "FL", 23));
        
        return list;
    }
    
    /*
     * Prompt for the user to enter their option from the keyboard
     *
     * 1 = Sort by last name
     * 2 = Sort by Home State
     * 3 = Sort by Age
     * 0 = End input and exit/terminate the application
     *
     */
    
    private static void promptForOption(ArrayList<Contact> contacts) {
    	System.out.println("Greetings, Professor Falken. Shall we play a game?");
		System.out.println();	
    	promptOrReprompt();
		
    	//should have use switch / case...
		int choice = 0;
		while(!StdIn.isEmpty()){
			
			choice = StdIn.readInt();
			
			if(choice == 1){
				/*It appears in Java 8 you can pass the objects and a lambda expression to the sort method of the collections
				Collections.sort(contacts, (a,b) -> a.getLastName().compareToIgnoreCase(b.getLastName()));*/
				Collections.sort(contacts, new LastNameComparator());
				displayContacts(contacts);
				promptOrReprompt();
			}			
			else if(choice == 2){
				Collections.sort(contacts, new StateComparator());
				displayContacts(contacts);
				promptOrReprompt();
			}			
			else if(choice == 3){
				/*Collections.sort(contacts, (a,b) -> a.getAge() < b.getAge() ? -1 : a.getAge() == b.getAge() ? 0 : 1);*/
				Collections.sort(contacts, new AgeComparator());
				displayContacts(contacts);
				promptOrReprompt();
			}						
			else if(choice > 3 || choice < 0){
				//System.err.println("Invalid entry.\n");
				System.out.println("Invalid entry.\n");
				promptOrReprompt();
			}
			else if(choice == 0){
				System.out.println("Exiting...");
				break;
			}	
		}
    }

    /*
     * Display the Contact information sorted by using the selected option from 
     * the above "promptForOption" method result
     */
    
    private static void displayContacts(ArrayList<Contact> contacts) {
    	for(Contact c : contacts){
			System.out.println(c);
		}
    	System.out.println();
    }
    
    private static void promptOrReprompt(){
		System.out.println(String.format("%-20s %s", "Sort by last name", ":[1]"));
		System.out.println(String.format("%-20s %s", "Sort by Home State", ":[2]"));
		System.out.println(String.format("%-20s %s", "Sort by Age", ":[3]"));
		System.out.print("Enter option or 0 to end input: ");
    }

}





