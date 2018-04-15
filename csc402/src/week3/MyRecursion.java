package week3;

public class MyRecursion {

	
	public static double minValueIterative (double[] list) {
		double result = list[0];
		int i = 1;
		while (i < list.length) {
			if (list[i] < result) result = list[i];
			i = i + 1;
		}
		return result;
	}

	/** recursive version */
	public static double minValueR (double[] list) {
		return minValueHelper (list, 1, list[0]);
	}
	private static double minValueHelper (double[] list, int i, double result) {
		if (i < list.length) {
			if (list[i] < result) result = list[i];
			result = minValueHelper (list, i + 1, result);
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		
		
		double[] list = new double[] { 33, 44, 55, 11 };
		
		
		double minValue = minValueIterative (list);
		if (minValue == 11) {
			System.out.println("The minValue test was successful.");
		} else {
			System.out.println("The minValue test was not successful.");
		}
		
		double minValueR = minValueR (list);
		if (minValueR == 11) {
			System.out.println("The minValueR test was successful.");
		} else {
			System.out.println("The minValueR test was not successful.");
		}
		

	}

}
