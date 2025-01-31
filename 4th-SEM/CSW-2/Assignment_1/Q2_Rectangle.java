/*
 Design a Java class called Rectangle with private attributes length and width. Include 
a constructor to initialize these attributes, as well as setter and getter methods for each 
attribute. Additionally, implement methods to calculate the area and perimeter of the 
rectangle. Write a main method to create an object of the Rectangle class, set values 
for its attributes, and display the area and perimeter. 
 */

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
public class Q2_Rectangle{
    public static void main(String[] args) {

            Rectangle r1=new Rectangle(12,10);
            System.out.println("Rectangle Dimensions : "+"Length = "+r1.getLength()+", Width = "+r1.getWidth());
            System.out.println("Area : "+r1.area());
            System.out.println("Perimter : "+r1.perimeter());
        }
}

/*
 OUTPUT 
Rectangle Dimensions : Length = 12, Width = 10
Area : 120
Perimter : 44
 */
