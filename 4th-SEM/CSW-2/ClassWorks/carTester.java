package csw2;
class Car{
	String make;
	String model;
	
	public Car(String make,String model) {
		this.make=make;
		this.model=model;
	}
	
	//setter 
	void setMake(String make) {
		this.make=make;
	}
	
	void setModel(String model) {
		this.model=model;
	}
}
public class carTester {

	public static void main(String[] args) {
		Car myCar1=new Car("Tata","Nano");
		Car myCar2=new Car(null,null);
		System.out.println("Initially : ");
		System.out.println("\nCar1 : "+myCar1.make+" "+myCar1.model);
		System.out.println("Car2 : "+myCar2.make+" "+myCar2.model);
		myCar2.setMake("BMW");
		myCar2.setModel("M2");
		System.out.println("\nAfter Update : ");
		System.out.println("\nCar1 : "+myCar1.make+" "+myCar1.model);
		System.out.println("Car2 : "+myCar2.make+" "+myCar2.model);

	}

}
