package Assignment_7;

/*Write a Java program that demonstrates how to format a LocalDateTime object using 
the DateTimeFormatter class. Create a LocalDateTime instance representing a 
specific date and time. Then, use a custom format pattern "yyyy-MM-dd HH:mm:ss" to 
convert this date-time into a formatted string. Finally, print the formatted result.*/

import java.time.*;
import java.time.format.DateTimeFormatter;
public class Q08 {

	public static void main(String[] args) {
		LocalDateTime dt=LocalDateTime.now();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss" );
		String s=dt.format(formatter);
		System.out.println(s);

	}

}
