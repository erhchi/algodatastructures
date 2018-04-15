package program2;

import stdlib.StdAudio;
import stdlib.StdIn;
import algs31.*;
import java.util.concurrent.TimeUnit;

public class PlaySimpleSong {

	static BinarySearchST<String,Double> Frequencybst = new BinarySearchST<String,Double>();
	
	public static void main(String[] args) {		
		try{			
			StdIn.fromFile("data/notes_frequencies.txt");
			
			while(StdIn.hasNextLine()){
				String line = StdIn.readLine();
				String[] fields = line.split("\\s+");
				String note = fields[0];
				Double frequency = Double.parseDouble(fields[1]);
				Frequencybst.put(note, frequency);
			}
			
//			for(String note : Frequencybst.keys()){
//				System.out.println("Note: " + note + " - " + Frequencybst.get(note));
//			}
			
			playSong("data/sample_simple_song.txt");
			TimeUnit.SECONDS.sleep(2);
			playSong("data/lotr.txt");
			
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	private static void playSong(String location){		
		StdIn.fromFile(location);
		
		while(StdIn.hasNextLine()){
			String line = StdIn.readLine();
			String[] fields = line.split("\\s+");
			String note = fields[0];
			Double duration = Double.parseDouble(fields[1]);
			
			Double frequency = Frequencybst.get(note);
			playTone(frequency, duration);
		}
	}
	
	private static void playTone(double frequency, double duration){
		final int sliceCount = (int)(StdAudio.SAMPLE_RATE * duration);
		final double[] slices = new double[sliceCount+1];
		for(int i=0; i<=sliceCount; i++){
			slices[i] = Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
		}
		StdAudio.play(slices);
	}

}
