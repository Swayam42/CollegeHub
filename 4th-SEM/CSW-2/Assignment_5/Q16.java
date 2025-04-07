package Assignment_5;
/*Display File Metadata: Create a Java program that displays metadata of a specified file. 
The user should be able to input the file name, and the program should output the file 
size, last modified date, and other available attributes.*/
import java.io.*;
public class Q16 {

	public static void main(String[] args) {
		File ob=new File("C:\\Users\\HP\\OneDrive\\Desktop\\new CSW\\CSW_2\\src\\Q14");
		File[] f=ob.listFiles();
		if(f!=null) {
			for(File i:f) {
				if(i.isFile()) {
					System.out.println(i.getName()+" Date Modified :"+new java.util.Date(i.lastModified()) +", File Size : "+i.length()+" bytes");
				}
			}
		}

	}

}
/*
OUTPUT :
input.txt Date Modified :Mon Apr 07 11:12:21 IST 2025, File Size : 5 bytes
output.txt Date Modified :Mon Apr 07 11:13:15 IST 2025, File Size : 5 bytes
test1.java Date Modified :Mon Apr 07 11:16:34 IST 2025, File Size : 949 bytes
*/
