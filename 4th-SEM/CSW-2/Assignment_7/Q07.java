package Assignment_7;
/*Using the Java Date and Time API, write a Java program to perform the following 
tasks: 
a) Retrieve and display the current date and time. 
b) Calculate the date that is 2 weeks from today. 
c) Format and display the current date in the "MM/dd/yyyy" format.*/
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class Q07 {

	public static void main(String[] args) {
		LocalDate dt=LocalDate.now();
		System.out.println("Current Date : "+dt);
		LocalTime t=LocalTime.now();
		System.out.println("Current Time : "+t);
		
		LocalDate dtAfter =dt.plusWeeks(2);
		System.out.println("Date after 2 weeks : "+dtAfter);
		 LocalDateTime d=LocalDateTime.now();
		 DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MM/dd/yyyy");
		 String s1=d.format(formatter);
		 System.out.println(s1);
	}

}
