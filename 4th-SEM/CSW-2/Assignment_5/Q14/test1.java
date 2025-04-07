package Q14;
/*Copy File Content: Write a Java program that copies the content from one file (source) 
to another (destination). The program should prompt the user for both source and 
destination file paths and perform the copy operation, ensuring that it doesn't overwrite
an existing file without user confirmation. */
import java.io.*;
public class test1 {
	
	public static void main(String[] args){
	try {
		//we have to copy the contents of input.txt file to output.txt file  
		FileInputStream ob=new FileInputStream("C:\\Users\\HP\\OneDrive\\Desktop\\new CSW\\CSW_2\\src\\Q14\\input.txt");
		FileOutputStream f=new FileOutputStream("C:\\Users\\HP\\OneDrive\\Desktop\\new CSW\\CSW_2\\src\\Q14\\output.txt");
		int c;
		while((c=ob.read())!=-1){
			f.write((char)c);
		}	
		System.out.println("Contents Copied Successfully");
	}
	catch(Exception e){
		System.out.println("Error Arrised : "+e.getMessage());
	}
	
	 }
}
