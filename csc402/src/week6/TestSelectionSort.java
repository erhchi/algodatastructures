package week6;
/*
 * This is an example of a successful run:
 * 
 	Displaying checks array before sorting...
	Check [checkNumber=1001, payTo=Joe Jones, date=Mon Feb 06 15:36:40 CST 2017]
	Check [checkNumber=950, payTo=Adam Ant, date=Mon Feb 06 15:36:40 CST 2017]
	Check [checkNumber=735, payTo=Bill Barnes, date=Mon Feb 06 15:36:40 CST 2017]
	Check [checkNumber=1102, payTo=Mark Roth, date=Mon Feb 06 15:36:40 CST 2017]
	Check [checkNumber=1050, payTo=Jerome Howard, date=Mon Feb 06 15:36:40 CST 2017]
	Being sorting...
	End sorting...
	Displaying checks array after sorting...
	Check [checkNumber=735, payTo=Bill Barnes, date=Mon Feb 06 15:36:40 CST 2017]
	Check [checkNumber=950, payTo=Adam Ant, date=Mon Feb 06 15:36:40 CST 2017]
	Check [checkNumber=1001, payTo=Joe Jones, date=Mon Feb 06 15:36:40 CST 2017]
	Check [checkNumber=1050, payTo=Jerome Howard, date=Mon Feb 06 15:36:40 CST 2017]
	Check [checkNumber=1102, payTo=Mark Roth, date=Mon Feb 06 15:36:40 CST 2017]
 *	
 */
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import utils.Helper;

public class TestSelectionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Check[] checks = initializeChecksArray();		
		
		System.out.println("Displaying checks array before sorting...");
		display(checks);
		
		System.out.println("Being sorting...");
		/*
		 * The Checks array will be sorted by checkNumber
		 * which is declared as a Integer
		 */
		Selection.sort(checks); 
		System.out.println("End sorting...");
		
		System.out.println("Displaying checks array after sorting...");
		display(checks);
		
		
		//test comparable TODO: REMOVE
		/*Check ck1 = new Check(1,"x", new Date(System.currentTimeMillis()));
		Check ck2 = new Check(1,"x", new Date(System.currentTimeMillis()+1));
		System.out.println(ck1.compareTo(ck2));*/
		
	}

	private static Check[] initializeChecksArray() {
		
		Check[] cks = {	new Check(1001, "Joe Jones", new Date(System.currentTimeMillis())),
						new Check(950, "Adam Ant", new Date(System.currentTimeMillis())),
						new Check(735, "Bill Barnes", new Date(System.currentTimeMillis())),
						new Check(1102, "Mark Roth", new Date(System.currentTimeMillis())),
						new Check(1050, "Jerome Howard", new Date(System.currentTimeMillis()))};
						//new Check(1050, "Jerome Howard", new Date(2017,02,06,15,36,40))};
				
		return cks;
	}

	private static void display(Check[] checks) {
		Helper.ShowComparableIterationNewLine(checks);
	}

}
