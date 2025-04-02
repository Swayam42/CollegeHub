/*Append Content to an Existing File: Write a Java program that adds a new diary entry 
to the "diary.txt" file without overwriting its existing content. The program should ask 
the user for the new entry and append it to the file along with a timestamp.*/

package Assignment_5;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;
public class Q11 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		File file=new File("C:\\Users\\HP\\OneDrive\\Desktop\\new CSW\\CSW_2\\src\\Assignment_5\\diary.txt");
		if(!file.exists()) {
			System.out.println("Diary doesn't exist");
		}
		try (BufferedWriter w=new BufferedWriter (new FileWriter(file,true))){
			System.out.println("Enter your diary Entry : ");
			String s=sc.nextLine();
			String timestamp=LocalDateTime.now().toString();
			w.write("\nDate "+timestamp+"\n"+s+"\n");
			System.out.println("New Entry Added Successfully");
		}
		catch(Exception e) {
			System.out.println("Error Appending to file : "+e.getMessage());
		}

	}

}
