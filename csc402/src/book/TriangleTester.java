package book;


public class TriangleTester{
	public static void main(String[] args){
		Triangle t = new Triangle(4);
		int area = t.getArea();
		
		StringBuilder sb = new StringBuilder();
		//sb.append("Area: {0}", area);
		sb.append("Area: ");
		sb.append(area);
		
		System.out.println(sb.toString());
	}
}
