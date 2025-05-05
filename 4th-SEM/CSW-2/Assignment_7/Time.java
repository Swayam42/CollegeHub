package Assignment_7;
import java.time.*;
import java.time.temporal.ChronoUnit;
public class Time {

	public static void main(String[] args) {
		//print current time of your system
		
			LocalTime t=LocalTime.now();
			System.out.println(t);
			
			LocalTime t2=LocalTime.of(12, 43); // hour,min
			System.out.println(t2);
			
			LocalTime t3=LocalTime.parse("03:30");
			System.out.println("Parsing String to LocalTime Object : "+t3);
			
			LocalTime t4=t.minus(1,ChronoUnit.HOURS);//Time before 1 hour   
			System.out.println(t4);
			
			//To compare 1 time with another :
			boolean CompareTime=LocalTime.parse("03:20").isBefore(LocalTime.parse("02:42"));
			System.out.println(CompareTime);
	}

}
