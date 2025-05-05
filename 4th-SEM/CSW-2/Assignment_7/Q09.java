package Assignment_7;
/*Write a Java program to calculate the simple interest on a current account using the 
Java Date and Time API. The program should prompt the user to enter the start date 
and the initial amount. Assume the rate of interest is 8% per annum. Calculate the 
number of days between the start date and the current date, then compute the interest 
using the simple interest formula. Finally, display the total amount after adding the 
interest to the initial amount.*/
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
public class Q09 {
		
	public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			System.out.println("Input Date (yyyy-MM-dd): ");
			String startDate=sc.nextLine();
			LocalDate start=LocalDate.parse(startDate);
			System.out.print("Initial Amount : ");
			int p=sc.nextInt();
			int r=8;
			LocalDate currDate=LocalDate.now();
			int daysBetween=(int)ChronoUnit.DAYS.between(start, currDate);
			int t=daysBetween/365;
			double SI = (p*r*t)/100;
			System.out.println("Simple Interest : "+SI);
			
			
	}
}
