package Generics_CollectionClasses;
import java.util.ArrayList;


public class AL {

	
	public static void main(String[] args) {
		ArrayList<String>car=new ArrayList<>();
		car.add("Ambassador");
		car.add("GWagonr");
		car.add("Jaguar");
		car.set(2,"Taycan");
		System.out.println(car +"\nSize : "+car.size());

	}

}
