package book;

public class Triangle {
	
	private int width;
	
	public Triangle(int aWidth){
		width = aWidth;
	}
	
	public int getArea(){
		if(width == 1){
			return 1;
		}
		
		Triangle smallerTriangle = new Triangle(width-1);
		int smallerArea = smallerTriangle.getArea();
		
		return smallerArea + width;
	}	
	
	
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

