package week2;

/**
 * This is a skeleton file for your homework. Edit the sections marked TODO. You
 * may also edit the function "main" to test your code.
 *
 * You must not change the declaration of any method. This will be true of every
 * skeleton file I give you.
 *
 * For example, you will get zero points if you change the line
 * <pre>
 *     public static int numUnique (double[] list) {
 * </pre>
 * to something like
 * <pre>
 *     public static void numUnique (double[] list) {
 * </pre>
 * or
 * <pre>
 *     public static int numUnique (double[] list, int i) {
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

public class Homework2 {
    
    /**
     * numUnique returns the number of unique values in an array of doubles.
     * Unlike the previous questions, the array may be empty and it may contain
     * duplicate values. Also unlike the previous questions, you can assume the
     * array is sorted.
     *
     * Your solution must go through the array exactly once. Your solution must
     * not call any other functions. Here are some examples (using "=="
     * informally):
     *
     * <pre>
     *
     *   8 == numUnique(new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 })
     *
     * </pre>
     */
    public static int numUnique (double[] list) {
    	int counter = 0;
    	try{
    		if (list.length == 0){
    			System.out.println("Warning: The array contained no values.");
    			return 0;
    		}
    		else{    			
    			double comparevalue = list[0];
    			counter++; //the first value in the nonempty array is unique
    			for (int i=1; i < list.length; i++)
    			{
    				if(comparevalue != list[i]){
    					comparevalue = list[i];
    					counter++;
    				}
    			}
    		}
    	}
    	catch(Exception e){
    		System.out.println("System exception, numUnique.");
    	}
    	return counter; 
    }

    
    /**
     * removeDuplicates returns a new array containing the unique values in the
     * array. There should not be any extra space in the array --- there should
     * be exactly one space for each unique element (Hint: numUnique tells you
     * how big the array should be). You may assume that the list is sorted, as
     * you did for numUnique.
     *
     * Your solution may call numUnique, but should not call any other
     * functions. After the call to numUnique, you must go through the array
     * exactly one more time. Here are some examples (using "==" informally):
     *
     * <pre>
     *
     * double noDuplicates[] = removeDuplicates (new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 });
     *
     * </pre>
     */
    
    public static double[] removeDuplicates (double[] list) {
    	double cleanlist[] = new double[numUnique(list)];
    	try{    		
    		//the first value will get added to the new array
    		double comparevalue = list[0];
    		cleanlist[0] = list[0];
    		
    		//counter for new array spaces
    		int newcounter = 1;
    		
    		for(int i=1; i<list.length; i++){
    			if (comparevalue != list[i]){
    				cleanlist[newcounter] = list[i];
    				comparevalue = list[i];
    				newcounter++;
    			}
    		}    		
    	}
    	catch(Exception e){
    		System.out.println("System exception, removeDuplicates.");
    	}   
    	return cleanlist; 
    }

    
	/**
	 * The following tests below should pass if your methods above are correct.
	 * It is required for you to write 5 more tests for each method to ensure your 
	 * methods above are written correctly.
	 */
	public static void main(String[] args) {
		
        // uniqueNumbers Test sample
        double uniqueNumbers = numUnique(new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 });
        if (uniqueNumbers == 8) {
            System.out.println("The uniqueNumbers test was successful.");
        } else {
            System.out.println("The uniqueNumbers test was not successful.");
        }

        double uniqueNumbers2 = numUnique(new double[] { });
        if (uniqueNumbers2 == 0) {
            System.out.println("The uniqueNumbers test was successful. [Empty Array Test]");
        } else {
            System.out.println("The uniqueNumbers test was not successful.");
        }
        
        double uniqueNumbers3 = numUnique(new double[] { 101, 101, 101, 22, 45, 87, 209, 209, 1, 1, 7 });
        if (uniqueNumbers3 == 7) {
            System.out.println("The uniqueNumbers test was successful.");
        } else {
            System.out.println("The uniqueNumbers test was not successful.");
        }

        double uniqueNumbers4 = numUnique(new double[] { 3 });
        if (uniqueNumbers4 == 1) {
            System.out.println("The uniqueNumbers test was successful.");
        } else {
            System.out.println("The uniqueNumbers test was not successful.");
        }
        
        double uniqueNumbers5 = numUnique(new double[] { 5, 8 });
        if (uniqueNumbers5 == 2) {
            System.out.println("The uniqueNumbers test was successful.");
        } else {
            System.out.println("The uniqueNumbers test was not successful.");
        }
        
        double uniqueNumbers6 = numUnique(new double[] { 20, 23, 24, 24, 28, 28, 30, 30 });
        if (uniqueNumbers6 == 5) {
            System.out.println("The uniqueNumbers test was successful.");
        } else {
            System.out.println("The uniqueNumbers test was not successful.");
        }
        
		
		
        // removeDuplicates Test sample
		double noDuplicates[] = removeDuplicates (new double[] { 11, 11, 11, 11, 22, 33, 44, 44, 44, 44, 44, 55, 55, 66, 77, 88, 88 });
		if (noDuplicates.length > 0) {
			System.out.println("The removeDuplicates test was successful.");
			for (double duplicate : noDuplicates) {
				System.out.println("Value ["+duplicate+"]");
			}
		} else {
			System.out.println("The removeDuplicates test was not successful.");
		}		
		
		double noDuplicates2[] = removeDuplicates (new double[] { 88, 88, 90 });
		if (noDuplicates2.length > 0) {
			System.out.println("The removeDuplicates test was successful.");
			for (double duplicate : noDuplicates2) {
				System.out.println("Value ["+duplicate+"]");
			}
		} else {
			System.out.println("The removeDuplicates test was not successful.");
		}		
		
		double noDuplicates3[] = removeDuplicates (new double[] { 1, 1, 7, 22, 45, 87, 101, 101, 101, 209, 209 });
		if (noDuplicates3.length > 0) {
			System.out.println("The removeDuplicates test was successful.");
			for (double duplicate : noDuplicates3) {
				System.out.println("Value ["+duplicate+"]");
			}
		} else {
			System.out.println("The removeDuplicates test was not successful.");
		}
		
		double noDuplicates4[] = removeDuplicates (new double[] { 38, 40, 40, 52, 52, 68, 68, 99, 99, 99, 100 });
		if (noDuplicates4.length > 0) {
			System.out.println("The removeDuplicates test was successful.");
			for (double duplicate : noDuplicates4) {
				System.out.println("Value ["+duplicate+"]");
			}
		} else {
			System.out.println("The removeDuplicates test was not successful.");
		}
		
		double noDuplicates5[] = removeDuplicates (new double[] { 10, 11, 12, 13 });
		if (noDuplicates5.length > 0) {
			System.out.println("The removeDuplicates test was successful.");
			for (double duplicate : noDuplicates5) {
				System.out.println("Value ["+duplicate+"]");
			}
		} else {
			System.out.println("The removeDuplicates test was not successful.");
		}
		
		double noDuplicates6[] = removeDuplicates (new double[] { 77, 77, 80, 90, 100 });
		if (noDuplicates6.length > 0) {
			System.out.println("The removeDuplicates test was successful.");
			for (double duplicate : noDuplicates6) {
				System.out.println("Value ["+duplicate+"]");
			}
		} else {
			System.out.println("The removeDuplicates test was not successful.");
		}
	}
}
