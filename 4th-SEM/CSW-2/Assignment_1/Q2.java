package Assignment_1;
class Rectangle{
	
	private int length;
	private int width;
	
	//parameterized constructor
	public Rectangle(int length, int width) {
		this.length = length;
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	int area() {
		return this.length*this.width;
	}
	
	int perimeter() {
		return 2*(this.length+this.width);
	}
	
	

}
public class Q2 {

	public static void main(String[] args) {
		Rectangle r1=new Rectangle(12,10);
		System.out.println("Area : "+r1.area());
		System.out.println("Perimter : "+r1.perimeter());
		
	}

}
