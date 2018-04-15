package midterm;

public class number1 {

	public static void main(String[] args) {
		Integer a1 = 128;
		Integer a2 = 128;
				
		System.out.println(a1 == a2);
		
		Integer aL1 = 150;
		Long aL2 = new Long(150);
		
		System.out.println(aL1);
		System.out.println(aL2);
		
		//System.out.println(a1.toString());
		//System.out.println(a2.toString());
		
		Integer b1 = new Integer(1000);
		Integer b2 = new Integer(1000);
		
		//Integer b3 = new Integer(null);
		
		System.out.println(b1.toString());
		System.out.println(b2.toString());
		
		
		//b1=b2;
		
		System.out.println(b1 == b2);
		
		Integer c1 = 100;
		Integer c2 = 100;
		
		
		/*int c1 = 150;
		int c2 = 150;
		*/System.out.println(c1 == c2);

	}

}
