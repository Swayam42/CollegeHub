/*Create and Write to a File: Write a Java program that prompts the user for a diary entry, 
then creates a file named "diary.txt" and writes the current date followed by the user's 
entry into this file. Ensure the program checks if the file already exists and informs the 
user, to avoid overwriting any previous content.*/
package Assignment_5;
import java.io.*;
import java.util.Scanner;
import java.time.LocalDate;
public class Q9 {

	public static void main(String[] args) {
		try {
			FileOutputStream ob=new FileOutputStream("C:\\Users\\HP\\OneDrive\\Desktop\\new CSW\\CSW_2\\src\\Assignment_5\\diary.txt");
			Scanner sc=new Scanner(System.in);
			LocalDate dt=LocalDate.now();
			String s1=dt.toString();
			System.out.println(s1);
			byte b1[]=s1.getBytes();
			ob.write(b1);
			System.out.println("Input Content : ");
			String s=sc.nextLine();
			byte b[]=s.getBytes();
			ob.write(b);
			ob.close();
			System.out.println("File Saved Successfully");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}

/*
OUTPUT :
2025-04-02
Input Content : 
Kya Hui
File Saved Successfully

*/
