package FileInformation;

import java.io.*;
import java.util.*;
import java.time.LocalDate;
public class Q1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Write your Diary Entry : ");
		String s=sc.nextLine();
		File f=new File("C:\\Users\\HP\\OneDrive\\Desktop\\new CSW\\CSW_2\\src\\FileInformation\\diary.txt");
		try {
			if(f.exists()) {
				System.out.println("File exists");
			}else {
				f.createNewFile();
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		try {
			FileWriter writer = new FileWriter(f, true); 
            writer.write("Date: " + LocalDate.now() + "\n");
            writer.write(f+"\n");
            writer.close();
            System.out.println("Your diary entry has been saved.");
		} catch (IOException e) {
		e.getMessage();
		}

	}

}
