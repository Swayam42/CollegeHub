/*Write a Java program with a Car class having private fields (make, model), a 
parameterized constructor, getter, and setter methods. In the CarTester class, 
instantiate myCar1 with values and myCar2 with null. Print their initial details, 
update myCar2 using setters, and print the updated details.  */
class Car{
	 String make;
	 String model;
	public Car() {
		
	}
	public Car(String make,String model) {
		this.make=make;
		this.model=model;
	}
	
	//getter methods :
	
	String getMake() {
		return this.make;
	}
	
	String getModel() {
		return this.model;
	}
	
	//setter methods :
	
	void setMake(String make) {
		this.make=make;
	}
	
	void setModel(String model) {
		this.model=model;
	}
	
}
public class Q1_CarTester {

	public static void main(String[] args) {
		Car myCar1=new Car("Tata","Nano");
		Car myCar2=new Car();
		System.out.println("Initially : ");
		System.out.println("\nCar1 : "+myCar1.getMake()+" "+myCar1.getModel());
		System.out.println("Car2 : "+myCar2.getMake()+" "+myCar2.getModel());
		myCar2.setMake("BMW");
		myCar2.setModel("M2");
		System.out.println("\nAfter Update : ");
		System.out.println("\nCar1 : "+myCar1.getMake()+" "+myCar1.getModel());
		System.out.println("Car2 : "+myCar2.getMake()+" "+myCar2.getModel());

	}

}

/*OUTPUT 

 Initially : 

Car1 : Tata Nano
Car2 : null null

After Update : 

Car1 : Tata Nano
Car2 : BMW M2
 */
