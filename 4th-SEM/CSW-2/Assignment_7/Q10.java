package Assignment_7;
/*Write a Java program using the Java Date and Time API to calculate the number of 
days between two dates. The program should prompt the user to enter a start date and 
an end date (in YYYY-MM-DD format), and then display the total number of days 
between the two dates using the ChronoUnit.DAYS method.*/
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
public class Q10 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Input Start Date (yyyy-MM-dd): ");
		String startDate=sc.nextLine();
		LocalDate start=LocalDate.parse(startDate);
		System.out.println("Input End Date (yyyy-MM-dd): ");
		String endDate=sc.nextLine();
		LocalDate end=LocalDate.parse(endDate);
		long daysBetween=ChronoUnit.DAYS.between(start,end);
		System.out.println("Days between : "+start+" and "+end+" : "+daysBetween+" days" );

	}

}
