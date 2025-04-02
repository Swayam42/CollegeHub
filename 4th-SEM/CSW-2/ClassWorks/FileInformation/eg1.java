package FileInformation;
import java.io.File;
import java.util.Scanner;
public class eg1 {

	public static void main(String[] args) {
	try {
		File ob=new File("C:\\Users\\HP\\OneDrive\\Desktop\\new CSW\\CSW_2\\src");
		System.out.println(ob.exists());
		Scanner sc=new Scanner(ob);
		while(sc.hasNextLine()) {
			String s1=sc.nextLine();
			System.out.println(s1);
		}
		sc.close();
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	}

}
