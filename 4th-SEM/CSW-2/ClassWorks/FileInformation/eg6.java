package FileInformation;
import java.io.*;
public class eg6 {

	public static void main(String[] args) {
		try {
			String s="dfsdlfk";
			FileWriter fw=new FileWriter("C:\\Users\\HP\\OneDrive\\Desktop\\new CSW\\CSW_2\\src\\FileInformation\\hello.txt");
		for(int i=0;i<s.length();i++) {
			fw.write(s.charAt(i));
		}
		System.out.println("Succesfull");
		fw.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
