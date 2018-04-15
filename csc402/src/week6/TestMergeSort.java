package week6;

import utils.Helper;

/*
 * This is an example of a successful run:
 * 
	Displaying students array before sorting...
	Students [firstName=Joe, lastName=Jones, studentId=1001]
	Students [firstName=Adam, lastName=Ant, studentId=950]
	Students [firstName=Bill, lastName=Barnes, studentId=735]
	Students [firstName=Mark, lastName=Roth, studentId=1102]
	Students [firstName=Jerome, lastName=Howard, studentId=1050]
	Being sorting...
	End sorting...
	Displaying students array after sorting...
	Students [firstName=Adam, lastName=Ant, studentId=950]
	Students [firstName=Bill, lastName=Barnes, studentId=735]
	Students [firstName=Mark, lastName=Roth, studentId=1102]
	Students [firstName=Jerome, lastName=Howard, studentId=1050]
	Students [firstName=Joe, lastName=Jones, studentId=1001]
 *	
 */

public class TestMergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student[] students = initializeStudentsArray();
		
		System.out.println("Displaying students array before sorting...");
		display(students);
		
		System.out.println("Being sorting...");
		/*
		 * The Student array will be sorted by studentId
		 * which is declared as a String
		 */
		Merge.sort(students); 
		System.out.println("End sorting...");
		
		System.out.println("Displaying students array after sorting...");
		display(students);
	}

	private static Student[] initializeStudentsArray() {
		Student [] students = {new Student("1001", "Joe", "Jones"),
				new Student(" 950", "Adam", "Ant"),
				new Student(" 735", "Bill", "Barnes"),
				new Student("1102", "Mark", "Roth"),
				new Student("1050", "Jerome", "Howard" )};
		return students;
	}

	private static void display(Student[] students) {
		Helper.ShowComparableIterationNewLine(students);
	}

}
