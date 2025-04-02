package FileInformation;
import java.io.*;
public class eg8 {

	public static void main(String[] args) {
		File ob=new File("C:\\Users\\HP\\OneDrive\\Desktop\\new CSW\\CSW_2\\src\\FileInformation\\gelu.txt");
		
		try {
			if(ob.createNewFile()) {
				System.out.println(ob.getName());
			}else {
				System.out.println("File exists");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
