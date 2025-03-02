/*Write a program to create a Book class with the following member variables: bookId, 
bookName, and price. Implement the appropriate constructor and methods for this 
class. 
Additionally, create a driver class to: 
i. Instantiate two Book objects. 
ii. Compare the books based on their price. 
iii. Print the details of both books. 
Note: Override the toString() and equals() methods.  */
package Assignment_2.Part_1;
class Book{
	int bookId;
	String bookName;
	double price;
	public Book(int bookId, String bookName, double price) {
		
		this.bookId = bookId;
		this.bookName = bookName;
		this.price = price;
	}
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public boolean equals(Object obj) {
		Book b1=(Book)obj;
		return this.price==b1.price;
	}
	public String toString() {
		return "\nBookId : "+getBookId()+"\nBook Name : "+getBookName()+"\nPrice : "+getPrice();
	}
	
}
public class Q2 {

	public static void main(String[] args) {
	Book b1=new Book(123,"Chabila Barnabodha",45.5);
	Book b2=new Book(456,"R D Sharma Maths",599.9);
	
	System.out.println("\nBook 1 "+b1.toString());
	System.out.println("\nBook 2 "+b2.toString());
	if(b1.equals(b2)) {
		System.out.println("\nBoth books have same prices");
	}else {
		System.out.println("\nBoth books have different prices");
	}

	}

}

/*
Output :
Book 1
BookId : 123
Book Name : Chabila Barnabodha
Price : 45.5

Book 2
BookId : 456
Book Name : R D Sharma Maths
Price : 599.9

Both books have different prices
*/
