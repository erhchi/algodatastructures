package group4;

import java.util.Scanner;

public class PlayPianoScale {

	public static void main(String args[]) {
		
		System.out.println("Play piano scale starting with key:");
		Scanner console = new Scanner(System.in);
		int choice = Integer.parseInt(console.nextLine());
		console.close();
		//System.out.println("Key:" + Integer.toString(choice));
		
		//first frequency
		//final double LOWEST_KEY = 27.5;		
		//EqualTemperedFrequency etf = new EqualTemperedFrequency(LOWEST_KEY);
		//key 10
		//final double KEY_10 = 46.249;
		//EqualTemperedFrequency etf = new EqualTemperedFrequency(KEY_10);
				
		EqualTemperedFrequency etf = new EqualTemperedFrequency(EqualTemperedFrequency.CalcualteFrequencyFromKey(choice));
				
		for(int i = choice; i<89; i++){
			
			etf.play(3);
			
			etf = etf.next();
			
			//System.out.printf("Playing frequency: " + etf.toString() + "%.3f %n",etf.getFrequency());	
		}
		
	}

}
