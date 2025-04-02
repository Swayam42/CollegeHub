/*Read from a File: Write a Java application that opens the "diary.txt" file created in the 
previous question and displays its content on the console. The program should handle 
cases where the file does not exist by displaying an appropriate error message. */

package Assignment_5;
import java.io.*;
public class Q10 {

	public static void main(String[] args) {
		try {
			FileInputStream f=new FileInputStream("C:\\Users\\HP\\\\OneDrive\\Desktop\\new CSW\\CSW_2\\src\\Assignment_5\\diary.txt");
			int i;
			while((i=f.read())!=-1) {
				System.out.print((char)i);
			}
			f.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
