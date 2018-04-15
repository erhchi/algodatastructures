	// Filename: RecFact.java
	//
	// This program computes a factorial of a given integer entered by
	// the user.  The function factorial(int a) is recursive.

	

import java.util.Scanner;

public class factorialtomuro {


	  public static void main(String[] args) {

	    Scanner sc = new Scanner(System.in);

	    int n1;
	    System.out.print("Enter an integer: ");
	    n1 = sc.nextInt();

	    int answer = factorial(n1); // n! is returned from the function

	    System.out.println(n1 + "! is " + answer);

	    sc.close();
	  } // end main()

	  public static int factorial(int a) {
	    // compute a!
	    if (a == 1)  // base case
	      return 1;
	    else
	      return (factorial(a-1) * a); // recursive call (with a-1)

	  }

}
