package midterm;

public class number6 {

	
	public static void main(String[] args) {
	
		int N = 10;
		int[] a = new int[N];
		
		for(int i = 1; i <=N-1; i++){
			a[i] = i;
		}
		
		int max = 0;
		
		for(int i = 1; i <=N-1; i++){
			for(int j=1; j <=N-1; j++){
				if(j>=i){
					max = a[j]+a[i];
				}
			}
		}
		
		System.out.println(max);
		
		/*for(int i = 1; i <= N; i++){
			for(int j=1; j<=N; j++){
				if(j>=i){
				a[i-j]++;
			}
		}
		}*/

	/*	for(int i : a){
			System.out.println(a.toString());
		}*/
	}

}


//test what he did with the loop

/*Integer[] num = {1,4,20,9,16,43};
Integer max = num[0];

for (int j = 0; j<num.length; j++){
	for(int i=j; i<num.length; i++){
		Integer value = num[j]-num[i];

if(value>max){
max = value;
}

System.out.println("num[j] =" "+num[j]+ " num[i] = " + num[i] + " = value "+value)
}
System.out.println("-------------------------------------");
}
System.out.println("---------------"+max+"-----------------");
*/
//if j>i then candidate for subtraction
/*
 * output should look like the linear idea...
 * ________________________
 * 1num[j] = x num[i] = y value = z
 * 2
 * 3
 * 4
 * 5
 * --------------------------
 * 1
 * 2
 * 3
 * 4
 * ---------------------------
 * 1
 * 2
 * 3
 * ----------------------------
*/
