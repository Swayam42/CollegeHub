/*
 Write a Java program that defines a Point class with attributes X and Y, and includes a 
parameterized constructor to initialize these attributes. Implement a copy 
constructor to create a new point object with the same attribute values. Ensure that 
modifications made to one object do not affect the other. Utilize getter and setter 
methods to retrieve and update the attribute values.
 */
class Point{
    private int x;
    private int y;

    Point(int x,int y){
        this.x=x;
        this.y=y;
    }
    //Copy Constructor
    Point(Point p){
        this.x=p.x;
        this.y=p.y;
    } 
    
    //Getter and Setter Methods :
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
    @Override
    public String toString(){
        return x+","+y;
    }
}

public class Q3_Point {
    public static void main(String[] args) {
        Point p1=new Point(23,56);
        System.out.println("Point p1 : "+p1.toString());
        Point p2=new Point(p1);
        System.out.println("Point p2 : "+p2.toString());
    }
}
/*
 OUTPUT 
Point p1 : 23,56
Point p2 : 23,56
 */
