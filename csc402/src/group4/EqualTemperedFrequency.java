package group4;

public class EqualTemperedFrequency implements Comparable<EqualTemperedFrequency> {

	private double frequency;
	final double LOWEST_KEY = 27.5;
	
	public EqualTemperedFrequency(){}
	
	public EqualTemperedFrequency(double initial) {
		this.frequency = initial;
	}
	
	public int compareTo(EqualTemperedFrequency that){
		int compare = Double.compare(this.frequency, that.getFrequency());
		return compare;
	}
	
	double getFrequency(){
		return frequency;
	}
	
	public void play(double duration){
		//TODO...implement the "play"
		System.out.print("Playing Frequency..." + this.toString());
		for(int i = 1; i<duration+1; i++){
			System.out.print(" ..." + i);
			if(i==duration){System.out.print("\n");};
		}
	}

	public String toString(){
		return Double.toString(frequency);
	}
	
	public EqualTemperedFrequency next(){
		return new EqualTemperedFrequency(this.frequency * Math.pow(2.0, .083));
	}
	
	public static double CalcualteFrequencyFromKey(int key){
		double newFrequency = 0.0;
		
		//formula = f(n) = 440 x 2 ^ n-49/12
		
		try{
			newFrequency = 440 * Math.pow(2,(((double)key-49)/12));
		}
		catch(Exception e){
			System.out.println(e.toString());
		}
		
		return newFrequency;
	}
	
	
	public boolean isLessThanOrEqual(EqualTemperedFrequency that){
		if(this.frequency < that.getFrequency()){
			return true;
		}
		return false;
	}
}
