package FileInformation;
import java.io.*;
public class eg7 {

	public static void main(String[] args) {
		try {
			FileReader fr=new FileReader("C:\\Users\\HP\\OneDrive\\Desktop\\new CSW\\CSW_2\\src\\FileInformation\\hello.txt");
		int ch;
		while((ch=fr.read())!=-1) {
			System.out.println((char)ch);
		}
		fr.close();
		System.out.println("read successfully");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		

	}

}
