/*Write a program to create a Car class with the following member variables: model, 
color, and speed. Implement the appropriate constructor and methods for this class.
Additionally, create a driver class to:
i. Instantiate two Car objects.
ii. Compare the cars based on their speed.
iii. Print the details of the car with the greater speed.
Note: Implement the Comparable interface and override the compareTo() method.
*/
package Assignment2_1;
class Car implements Comparable<Car>{
	String model;
	String color;
	int speed;
	public Car(String model, String color, int speed) {
		
		this.model = model;
		this.color = color;
		this.speed = speed;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	@Override
	public int compareTo(Car o) {
		if(this.speed==o.speed) {
			return 0;
		}
		else if(this.speed>o.speed) {
			return 1;
		}else {
			return -1;
		}
}
	
}
public class Q3 {

	public static void main(String[] args) {
	Car c1=new Car("Tesla","Red",120);
	Car c2=new Car("BMW","Blue",250);
	if(c1.compareTo(c2)==1) {
		System.out.println(c1.getModel()+" has greater speed");
	}
	else if(c1.compareTo(c2)==-1) {
		System.out.println(c2.getModel()+" has greater speed");
	}else {
		System.out.println("Both have equal speed");
	}
}

}
/*
Output :
BMW has greater speed
*/

