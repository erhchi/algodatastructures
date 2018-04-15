
public class discrete {
	
	private static void sum(){
		int sum =0;
		int n = 4;
		int inner = 0;
		int outer = 0;
		//for(int i=0; i< n*n; i = 2*i){
		for(int i=0; i< n*n; i++){
			System.out.println(i);
			System.out.println(n);
			System.out.println(n*n);
			System.out.println(Math.pow(n, 2));
			System.out.println(2*i);
			
			outer++;
			
			for(int j=1; j < Math.pow(n, 4); j = 4*j){
				System.out.println(Math.pow(n, 4));
				
				sum++;
				System.out.println(sum);
				
				inner++;
				
			}
		}
		System.out.println();
		System.out.println(outer);
		System.out.println(inner);
		
	}
	
	private static void sum2(){
		int sum = 0;
		int n = 2;
		int i = n;
		int inner = 0;
		int outer = 0;
		
		
		while(i >= 1){
			System.out.println(i);
			System.out.println(n);
			outer++;
			for(int j = 0; j < Math.pow(n,  4); j++){
				System.out.println(Math.pow(n, 4));
				System.out.println(j);
				sum++;
				System.out.println(sum);
				
				inner++;
			}
			i = i/3;
		}
		
		System.out.println();
		System.out.println(outer);
		System.out.println(inner);
	}
	
	private static void total(){
		int s = 0;
		int n = 4;
		int inner = 0;
		int outer = 0;
		int last = 0;
		
		for(int i = 1; i <= n; i++){
			System.out.println(i);
			outer++;
			s = s+i;
			for(int j = 1; j <= i; j++){
				System.out.println("i: " + i + " j: " + j);
				inner++;
				s = s+ j*i;
			}
		}
		last++;
		s = s + 10;
		
		
		
		System.out.println();
		
		System.out.println(outer);
		System.out.println(inner);
		System.out.println("last:" + last);
	}
	
	private static void factorial(){
		int n=4;
		int sum = 0;
		int factor = 0;
		for(int i=1; i <= n; i++){
			//sum++;
			
			for(int j=1; j<i; j++){
				factor = factor + (j * (j+1));
			}
			
			System.out.println(factor);
			
			//sum = sum + i*i;
			//System.out.println("i:" + i + " ");
			//System.out.println(i*i);
		}
		
		//System.out.println(sum);
	}
	
	private static void factorial2(){
		long total=0;
		
		int n=100; 
		
		long mod = 0;
		
		//409113
		 
	      int i=1;
	      while(i <= n) {
	        long factorial=1;
	        int j=1;
	        //System.out.println("j: " + j);
	        while(j <= i) {
	          factorial=factorial*j;
	          j = j+1;
	        }
	        
	        System.out.println(factorial);
	        total = total + factorial;
	        i=i+1;
	      }
	      
	      mod = total%35;
	      System.out.println("mod: " + mod);
	      System.out.println("Sum: " + total);
	      System.out.println((float)total/35);
	}

	public static void main(String[] args) {

		sum();
		//sum2();
		//total();
		//factorial();
		//factorial2();

	}

}
