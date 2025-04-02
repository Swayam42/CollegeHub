package FileInformation;
import java.io.*;
import java.util.*;
public class eg2 {

	public static void main(String[] args) {
		try {
		FileOutputStream ob =new FileOutputStream("C:\\Users\\HP\\OneDrive\\Desktop\\new CSW\\CSW_2\\src\\FileInformation\\hello.txt");
		Scanner sc=new Scanner(System.in);
		System.out.println("Kuch Boliye : ");
		String s=sc.nextLine();
		byte b[]=s.getBytes();
		ob.write(b);
		ob.close();
		System.out.println("File Saved");
		}catch(Exception e){
			
			
			System.out.println(e.getMessage());
		}

	}

}
