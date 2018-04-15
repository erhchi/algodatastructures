package book;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Average {

	public static void main(String[] args) {
		double sum = 0.0;
		int count = 0;
		while(!StdIn.isEmpty()){
			double value = StdIn.readDouble();
			sum += value;
			count++;
		}
		double avg = sum / count;
		StdOut.printf("Average is %.5f\n", avg);

	}

}
