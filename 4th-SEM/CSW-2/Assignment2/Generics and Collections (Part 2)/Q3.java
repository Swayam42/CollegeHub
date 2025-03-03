/*
Write a Java program that includes a Car class and a CarApp class. The Car class 
should have private fields: modelNo (int), name (String), and stock (int). Define a 
parameterized constructor and override the compareTo method as public int 
compareTo(Car car) to enable sorting of cars based on the total stock available. 
In the CarApp class, create an ArrayList of Car objects, sort them, and print the 
updated sorted list.
*/
import java.util.*;
class Car implements Comparable<Car>{
	private int modelNo;
	private String name;
	private int stock;
	public Car(int modelNo, String name, int stock) {
		
		this.modelNo = modelNo;
		this.name = name;
		this.stock = stock;
	}
	public int getModelNo() {
		return modelNo;
	}
	public void setModelNo(int modelNo) {
		this.modelNo = modelNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int compareTo(Car c) {
		if(this.stock==c.getStock()) {
			return 0;
		}else if(this.stock>c.stock) {
			return 1;
		}else {
			return -1;
		}
	}
	public String toString() {
		return getModelNo()+" "+getName()+" "+getStock();
	}
	
}
public class Q3 {

	public static void main(String[] args) {
		ArrayList<Car> al=new ArrayList<>();
		al.add(new Car(2013,"Creta",10));
		al.add(new Car(2020 ,"MG", 13));
		al.add(new Car(2018,"Kia",20));
		al.add(new Car(2017,"Audi",45));
		al.add(new Car(2015,"BMW",55));
		Collections.sort(al);
		for(Car i:al) {
			System.out.println(i);
		}

	}

}

/*
Output :
2013 Creta 10
2020 MG 13
2018 Kia 20
2017 Audi 45
2015 BMW 55
*/
