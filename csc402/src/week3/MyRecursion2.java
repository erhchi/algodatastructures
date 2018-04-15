package week3;

public class MyRecursion2 {

	
	
	public static double sumR (double[] a) {		
		return sumHelper(a, a.length-1);
	}	
	
	private static double sumHelper(double[] list, int counter){
		//System.out.println(counter);
		//System.out.println(list[counter]);
		try{
			if(list.length == 0){
				return 0;
			}		
			else if(counter == 0){
				return list[0];
			}else{
				return list[counter] + (sumHelper(list, counter-1));
			}
		}
		catch(Exception e){
    		System.out.println("System exception, sumHelper.");
    		return 0;
    	}
	}	
	
	
	public static void main(String[] args) {
		
		//double[] list5 = new double[] { 33, 44, 55 };
		//System.out.println("sumR");
		//System.out.println ("list5: " +sumR (list5));
		
		double[] list0 = new double[] {};
		double[] list1 = new double[] { 5 };
		double[] list2 = new double[] { -3, 5 };
		double[] list3 = new double[] { 2, -3, 5 };
		double[] list4 = new double[] { -1, 2, -3, 5 };
		double[] list5 = new double[] { 33, 44, 55 };

		
		
		System.out.println("Display the sum of the array contents");
		System.out.println ("list5: " +sumR (list5));
		System.out.println ("list0: " +sumR (list0));
		System.out.println ("list1: " +sumR (list1));
		System.out.println ("list2: " +sumR (list2));
		System.out.println ("list3: " +sumR (list3));
		System.out.println ("list4: " +sumR (list4));
		
	}

}
