package program1;

import stdlib.*;
import algs31.*;

public class ComputeGPA {	
	
	public static void main(String[] args) {
		
		try{
			BinarySearchST<String, Double> bs = new BinarySearchST<String, Double>();
			bs.put("A+", 4.33);
			bs.put("A", 4.00);
			bs.put("A-", 3.67);
			bs.put("B+", 3.33);
			bs.put("B", 3.00);
			bs.put("B-", 2.67);
			bs.put("C+", 2.33);
			bs.put("C", 2.00);
			bs.put("C-", 1.67);
			bs.put("D", 1.00);
			bs.put("F", 0.00);
						
			
			StdIn.fromFile("data/a1grades.txt");
			
			/*
			 * as each grade is read, aggregate the points
			 * divide total points by number of grades
			 * assume input could be on multiple lines, each value separated by whitespace
			 * ex. 
			 * A B C
			 * C
			 */
			
			
			int count = 0;
			double totalPoints = 0.0;
			
			while(StdIn.hasNextLine()){
				String line = StdIn.readLine();	
//				System.out.println(line);
				
				String[] grade = line.split("\\s");
				
				for(int i=0; i<=grade.length-1; i++){
					totalPoints += bs.get(grade[i]);
					count++;
				}
			}

//			System.out.println("Points: " + totalPoints);
//			System.out.println("Grades: " + count);
			System.out.println("\nGPA: " + totalPoints/count);
			
			
		}
		catch(Exception e){
			System.out.println("Error: " + e.toString());
		}
	}
}
