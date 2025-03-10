/*Write a Java program that includes a class Address with member variables plotNo, at, 
and post. The class should define a parameterized constructor to initialize these 
attributes. 
Create a TreeMap, where the key is the name of a person (String), and the value is an 
Address object. Insert the required key-value pairs into the TreeMap and use an 
Iterator to display the entries. */
import java.util.*;


class Address {
    private int plotNo;
    private String at;
    private String post;

    public Address(int plotNo,String at,String post) {
        this.plotNo=plotNo;
        this.at=at;
        this.post=post;
    }

    @Override
    public String toString() {
        return "Plot No: " +plotNo+", At: " +at +", Post: "+post;
    }
}

public class Q7 {
    public static void main(String[] args) {
      
        TreeMap<String, Address> addressBook = new TreeMap<>();

       
        addressBook.put("Amit", new Address(101, "MG Road", "Mumbai"));
        addressBook.put("Priya", new Address(102, "Park Street", "Kolkata"));
        addressBook.put("Rajesh", new Address(103, "Dwaraka", "Delhi"));

   
        Iterator<Map.Entry<String, Address>> iterator = addressBook.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Address> entry = iterator.next();
            System.out.println("Name: " + entry.getKey() + ", Address: " + entry.getValue());
        }
    }
}
/*
Output :
Name: Amit, Address: Plot No: 101, At: MG Road, Post: Mumbai
Name: Priya, Address: Plot No: 102, At: Park Street, Post: Kolkata
Name: Rajesh, Address: Plot No: 103, At: Dwaraka, Post: Delhi
*/
