package week6;
/*
 * The Check class will have 3 properties:
 * 		checkNumber - Integer
 * 		payTo       - String
 * 		date        - Date
 */
import java.util.*;
import java.lang.*;

public class Check implements Comparable<Check> {
	
	int checkNumber = 0;
	String payTo = "";
	Date date = null;
	
	public Check(){}
	
	public Check(int number, String name, Date date){
		this.checkNumber = number;
		this.payTo = name;
		this.date = date;
	}
	
	public int compareTo(Check other){
		int compare = Integer.compare(checkNumber, other.checkNumber);
		if(compare != 0){
			return compare;
		}
		compare = payTo.compareTo(other.payTo);
		if(compare != 0){
			return compare;
		}
		return compare = date.compareTo(other.date);
	}
	
	public String toString(){
		//return "Check [checkNumber=" + checkNumber + ", payTo=" + payTo + ", date=" + date + "\r\n";
		StringBuilder sb = new StringBuilder();
		sb.append("Check [checkNumber=").append(checkNumber)
		.append(", payTo=").append(payTo)
		.append(", date=").append(date)
		.append("]");
		//.append("\r\n");
		return sb.toString();
		
	}
}
