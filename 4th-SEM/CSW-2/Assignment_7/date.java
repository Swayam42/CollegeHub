package Assignment_7;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class date {

	public static void main(String[] args) {
		//now method : 
		LocalDate dt=LocalDate.now(); 
		System.out.println("Today : "+dt);
		//print yesterday's LocalDate and tomorrow's LocalDate : using minusDays() and plusDays()
		
		LocalDate yes=dt.minusDays(1);
		System.out.println("Yesterday : "+yes);
		LocalDate tom=dt.plusDays(1);
		System.out.println("Tomorrow : "+tom);
		
		LocalDate dt3=LocalDate.of(2005,9,7);
		System.out.println(dt3);
		System.out.println(dt3+" Leap year : "+dt3.isLeapYear());
		
		LocalDate dt4=LocalDate.parse("1999-03-06");
		
		
		LocalDate dt5 =dt.minus(1,ChronoUnit.MONTHS); //Going back 1 month
		System.out.println("Before 1 Month: "+dt5);
		
		//wap that takes a LocalDate 2018-11-27..using parse method convert into parse method and get the day of week using getDayOfWeek()
		
		LocalDate d1=LocalDate.parse("2018-11-27");
		System.out.println(d1);
		System.out.println("Day of week : "+d1.getDayOfWeek());
		
		//print getDayOfMonth : it returns the LocalDate in int
		System.out.println("Day of Month : "+d1.getDayOfMonth());
		
		
 	}

}
