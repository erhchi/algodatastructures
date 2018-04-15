package week7;

import java.util.Comparator;

/*
 * The Contact class will have 3 properties:
 * 		firstname   - String
 * 		lastname    - String
 * 		homestate   - String
 * 		age         - Integer
 */

public class Contact {
	private String firstname;
	private String lastname;
	private String homestate;
	private int age;
	
	public Contact(String firstname, String lastname, String homestate, int age){
		this.firstname = firstname;
		this.lastname = lastname;
		this.homestate = homestate;
		this.age = age;
	}
	
	public String getFirstName(){
		return firstname;
	}
	
	public String getLastName(){
		return lastname;
	}
	
	public String getHomeState(){
		return homestate;
	}
	
	public int getAge(){
		return age;
	}
	
	public String toString(){
		return "Contact [firstname=" + this.firstname + ", lastname=" + this.lastname + ", homestate=" + this.homestate + ", age=" + this.age + "]";
	}
}

//Per lecture...moving into separate files
class FirstNameComparator implements Comparator<Contact>{
	public int compare(Contact a, Contact b){
		return a.getFirstName().compareToIgnoreCase(b.getFirstName());
	}
}

class LastNameComparator implements Comparator<Contact>{
	public int compare(Contact a, Contact b){
		return a.getLastName().compareToIgnoreCase(b.getLastName());
	}
}

class StateComparator implements Comparator<Contact>{
	public int compare(Contact a, Contact b){
		return a.getHomeState().compareToIgnoreCase(b.getHomeState());
	}
}

class AgeComparator implements Comparator<Contact>{
	public int compare(Contact a, Contact b){
		return a.getAge() - b.getAge();
	}
}




