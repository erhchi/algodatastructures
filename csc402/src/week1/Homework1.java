package week1;

/**
 * This is a skeleton file for your homework. Edit the sections marked TODO. You
 * may also edit the function "main" to test your code.
 *
 * You must not change the declaration of any method. This will be true of every
 * skeleton file I give you.
 *
 * For example, you will get zero points if you change the line
 * <pre>
 *     public static double minValue (double[] list) {
 * </pre>
 * to something like
 * <pre>
 *     public static void minValue (double[] list) {
 * </pre>
 * or
 * <pre>
 *     public static double minValue (double[] list, int i) {
 * </pre>
 * 
 * Each of the functions below (minValue, minPosition, distanceBetweenMinAndMax) 
 * is meant to be SELF CONTAINED. This means that you should use no other functions
 * or classes. You should not use any HashSets or ArrayLists, 
 * or anything else! In addition, each of your functions should go
 * through the argument array at most once. The only exception to this
 * removeDuplicates, which is allowed to call numUnique and then go through the
 * array once after that.
 */

public class Homework1 {

	/**
	 * minValue returns the minimum value in an array of doubles. You can assume
	 * the array is nonempty and has no duplicates. Your solution must go
	 * through the array exactly once. Your solution must not call any other
	 * functions. Here are some examples (using "==" informally):
	 *
	 * <pre>
	 *   -7  == minValue (new double[] { 1, -4, -7, 7, 8, 11 })
	 * </pre>
	 */
	public static double minValue (double[] list) { 
		try{
			//Instructions said assume nonempty arrays but it's drilled into me to always code defensively.
			if (list.length == 0){
				System.out.println("The array contained no values.");
				return 0;
			}
			else{
				
				double min = list[0];
				//Starting i at one b/c first value loaded, otherwise first iteration would be checking values at [0]
				for(int i =1; i<list.length; i++){
					//System.out.println(min);
					//System.out.println(list[i]);					
					if(list[i] < min)
						min = list[i];
				}				
				return min;
			}
		}
		//The check inside my try should catch any empty arrays but just in case of any other bound errors
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("IndexOutOfBounds Warning. Check processing array values.");
			return 0;
		}
		catch(Exception e){
			System.out.println("System exception.");
			return 0;
		}
	}
	
	public static double maxValue (double[] list) { 
		try{
			//Per instructions - assume array is nonempty
			double max = list[0];
			//Starting i at one b/c first value loaded, otherwise first iteration would be checking values at [0]
			for(int i =1; i<list.length; i++){					
				if(list[i] > max)
					max = list[i];
			}				
			return max;
		}
		catch(Exception e){
			System.out.println("System exception.");
			return 0;
		}
	}

	/**
	 * minPosition returns the position of the minimum value in an array of
	 * doubles. The first position in an array is 0 and the last is the
	 * array.length-1.
	 *
	 * You can assume the array is nonempty and has no duplicates. Your solution
	 * must go through the array exactly once. Your solution must not call any
	 * other functions. Here are some examples (using "==" informally):
	 *
	 * <pre>
	 *   0 == minPosition(new double[] { -13, -4, -7, 7, 8, 11 })
	 * </pre>
	 */
	public static int minPosition (double[] list) {
		
		try{
			//Per instructions - assume array is nonempty			
			double minValue = minValue(list);
			int minPosition = 0;
			for(int i=0; i < list.length; i++){
				if(minValue == list[i]){
					minPosition = i;
				}
			}				
			return minPosition;
		}
		catch(Exception e){
			System.out.println("System exception.");
			return -1;
		}
	}
	
	public static int maxPosition (double[] list) {
		
		try{
			//Per instructions - assume array is nonempty		
			double maxValue = maxValue(list);
			int maxPosition = 0;
			for(int i=0; i < list.length; i++){
				if(maxValue == list[i]){
					maxPosition = i;
				}
			}				
			return maxPosition;
		}
		catch(Exception e){
			System.out.println("System exception.");
			return -1;
		}
	}
	

	/**
	 * distanceBetweenMinAndMax returns difference between the minPosition and
	 * the maxPosition in an array of doubles.
	 *
	 * You can assume the array is nonempty and has no duplicates. Your solution
	 * must go through the array exactly once. Your solution must not call any
	 * other functions. Here are some examples (using "==" informally):
	 *
	 * <pre>
	 *   1 == distanceBetweenMinAndMax(new double[] { 1, -4, -7, 7, 8, 11, -9 }) // -9,11
	 * </pre>
	 */
	public static int distanceBetweenMinAndMax (double[] list) {
		//Assume array is nonempty
		try{
			int distance = 0;
			
			int minPosition =  minPosition(list);
			int maxPosition = maxPosition(list);
			
			distance = Math.abs(minPosition - maxPosition);
			
			return distance;
		}
		catch(Exception e){
			System.out.println("System exception.");
			return -1;
		}
	}
	

	/**
	 * The following tests below should pass if your methods above are correct.
	 * It is required for you to write 5 more tests for each method to ensure your 
	 * methods above are written correctly.
	 */
	public static void main(String[] args) {
		
		// minValue Test sample
		double minValue = minValue (new double[] { 1, -4, -7, 7, 8, 11 });
		if (minValue == -7) {
			System.out.println("The minValue test was successful.");
		} else {
			System.out.println("The minValue test was not successful.");
		}				
		
		double minValue2 = minValue(new double[] {0,1,2,3});
		if (minValue2 == 0) {
			System.out.println("The minValue test was successful.");
		} else {
			System.out.println("The minValue test was not successful.");
		}
		
		double minValue3 = minValue(new double[] {88, 1000, 332, 5, -22, -99});
		if (minValue3 == -99) {
			System.out.println("The minValue test was successful.");
		} else {
			System.out.println("The minValue test was not successful.");
		}
		
		double minValue4 = minValue(new double[] {-22, 178, 34, -55, 2, 411});
		if (minValue4 == -55) {
			System.out.println("The minValue test was successful.");
		} else {
			System.out.println("The minValue test was not successful.");
		}
		
		double minValue5 = minValue(new double[] {7, -8, -232, 0, -1, 9});
		if (minValue5 == -232) {
			System.out.println("The minValue test was successful.");
		} else {
			System.out.println("The minValue test was not successful.");
		}
		
		//Just testing empty array
		/*double minValueTest = minValue(new double[] {});
		if (minValueTest > 0) {
			System.out.println("The minValue test was successful.");
		} else {
			System.out.println("The minValue test was not successful.");
		}*/
		
				
		// minPosition Test sample
		double minPosition = minPosition(new double[] { -13, -4, -7, 7, 8, 11 });
		if (minPosition == 0) {
			System.out.println("The minPosition test was successful.");
		} else {
			System.out.println("The minPosition test was not successful.");
		}

		double minPosition2 = minPosition(new double[] { 22, 66, -7, 7, -8, 11 });
		if (minPosition2 == 4) {
			System.out.println("The minPosition test was successful.");
		} else {
			System.out.println("The minPosition test was not successful.");
		}	
		
		double minPosition3 = minPosition(new double[] { 404 });
		if (minPosition3 == 0) {
			System.out.println("The minPosition test was successful.");
		} else {
			System.out.println("The minPosition test was not successful.");
		}
		
		double minPosition4 = minPosition(new double[] { 3, 55, 90, 1, 0, 21 });
		if (minPosition4 == 4) {
			System.out.println("The minPosition test was successful.");
		} else {
			System.out.println("The minPosition test was not successful.");
		}
		
		double minPosition5 = minPosition(new double[] { -8, -9, 22, 8, 99, 7, -505 });
		if (minPosition5 == 6) {
			System.out.println("The minPosition test was successful.");
		} else {
			System.out.println("The minPosition test was not successful.");
		}
		
		
		// distanceBetweenMinAndMax Test sample
		double distance = distanceBetweenMinAndMax(new double[] { 1, -4, -7, 7, 8, 11, -9 });
		if (distance == 1) {
			System.out.println("The distanceBetweenMinAndMax test was successful.");
		} else {
			System.out.println("The distanceBetweenMinAndMax test was not successful.");
		}
		
		double distance2 = distanceBetweenMinAndMax(new double[] { 1, -4, -7, 7, 8, -9, 11 });
		if (distance2 == 1) {
			System.out.println("The distanceBetweenMinAndMax test was successful.");
		} else {
			System.out.println("The distanceBetweenMinAndMax test was not successful.");
		}
		
		double distance3 = distanceBetweenMinAndMax(new double[] { -21, 5, 474, 8, 33, -8, 65, 45, -1 });
		if (distance3 == 2) {
			System.out.println("The distanceBetweenMinAndMax test was successful.");
		} else {
			System.out.println("The distanceBetweenMinAndMax test was not successful.");
		}
		
		double distance4 = distanceBetweenMinAndMax(new double[] { 77, 3, 33, 20, 4, 899 });
		if (distance4 == 4) {
			System.out.println("The distanceBetweenMinAndMax test was successful.");
		} else {
			System.out.println("The distanceBetweenMinAndMax test was not successful.");
		}
		
		double distance5 = distanceBetweenMinAndMax(new double[] { 989, 44, 18, -21, 67, -9 });
		if (distance5 == 3) {
			System.out.println("The distanceBetweenMinAndMax test was successful.");
		} else {
			System.out.println("The distanceBetweenMinAndMax test was not successful.");
		}
	}
}
