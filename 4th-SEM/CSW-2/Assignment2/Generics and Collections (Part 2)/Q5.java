package Assignment2_2;
import java.util.*;
/*Create a Book class with member variables id, name, author, and quantity to store 
details of each issued book. The Book class should include a parameterized 
constructor. Design a Library class that creates a HashMap of books, where the key is 
an Integer (representing the book ID) and the value is a Book object. Instantiate at 
least two Book objects and display the collection of books stored in the HashMap. 
Use appropriate methods of the HashMap class to perform the following operations: 
(a) Check if a particular book name is present on the map. 
(b) Remove a book entry by deleting the value associated with a specific key. */
class Book{
	private int id;
    String name;
    String author;
	int quantity;
	public Book(int id, String name, String author, int quantity) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String toString() {
		return getId()+"-"+getName();
	}
	
	
}
class Library{
	
	HashMap<Integer	,Book> map=new HashMap<>();
	
	public Library(){
	Book b1=new Book(1,"Book A","Author X",4);
	Book b2=new Book(2,"Book B","Author Y",34);
	Book b3=new Book(3,"Book C","Author Z",8);
	map.put(b1.getId(),b1);
	map.put(b2.getId(),b2);
	map.put(b3.getId(),b3);
	
	}
	public void display(){
		for(Integer key:map.keySet()) {
			System.out.println("Key : "+key+" Val : "+map.get(key).getName());
		}
	}
	public void search(String name) {
		for(Book val:map.values()) {
			if(val.getName().equalsIgnoreCase(name)) {
				System.out.println("Book found ");
				break;
			}else {
				System.out.println("Book not found");
				break;
			}
		}
	}
	public void remove(int bookId) {
		if(map.containsKey(bookId)) {
			map.remove(bookId);
			System.out.println("BookId with "+bookId+" removed");
		}else {
			System.out.println("Book Not Found");
		}
	}
}

public class Q5 {

	public static void main(String[] args) {
		Library l1=new Library();
		l1.display();
		l1.search("Book A");
		l1.remove(2);
		l1.display();
		
	}

}
