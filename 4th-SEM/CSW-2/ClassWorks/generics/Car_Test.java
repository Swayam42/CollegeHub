package Generics_CollectionClasses;
import java.util.*;
class Car implements Comparable<Car>{
	private int modelNum;
	private String name;
	private double price;
	
	public Car(int modelNum, String name, double price) {
		this.modelNum = modelNum;
		this.name = name;
		this.price = price;
	}
	
	public int getModelNum() {
		return modelNum;
	}
	public void setModelNum(int modelNum) {
		this.modelNum = modelNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int compareTo(Car c) {
		if(this.price<c.price) {
			return -1;
		}
		else if(this.price==c.price) {
			return 0;
		}else {
			return 1;
		}
	}
	
}

public class Car_Test {

	public static void main(String[] args) {
		//Array of Cars
		Car obj[]=new Car[3];
		obj[0]=new Car(123,"Honda Civic",1500000);
		obj[1]=new Car(456,"Toyota Corolla",200000);
		obj[2]=new Car(789,"Ford Mustang",1000000);
		ArrayList<Car> l1=new ArrayList<>();
		
		for(Car i:obj) {
			l1.add(i);
		
		}
		
		for(Car i:l1){
			System.out.println(i.getName()+", Price :"+i.getPrice());
		}
		

	}

}
