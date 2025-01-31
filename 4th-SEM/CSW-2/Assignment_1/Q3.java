package Assignment_1;

class Point{
	

	int x;
	int y;
	
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	//copy constructor
	Point(Point p){
		x=p.x;
		y=p.y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x=x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		return x +","+y;
	}
	
}
public class Q3 {

	public static void main(String[] args) {
		Point p1 =new Point(10,15);
		System.out.println("Point p1 : "+p1.toString());
		Point p2=new Point(p1);
		System.out.println("Point p2 : "+p2.toString());

	}

}
