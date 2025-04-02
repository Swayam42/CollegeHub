package FileInformation;
import java.io.FileInputStream;
public class eg3 {

	public static void main(String[] args) {
		try {
			FileInputStream f=new FileInputStream("C:\\Users\\HP\\OneDrive\\Desktop\\new CSW\\CSW_2\\src\\FileInformation\\hello.txt");
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
