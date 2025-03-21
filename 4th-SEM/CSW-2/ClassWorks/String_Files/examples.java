package Strings_Files;
import java.util.*;
/*Write a program to take a String as hello and return the char value at 4th position
 * print the char present at odd positions
 * count the frequency of particular char using charAt()*/
public class examples {
	
	public static void main(String[] args) {
		String s="Hello World";
		char search='o';
		int count=0;
		System.out.println("Character at 4th position :"+s.charAt(4));
		System.out.println("Characters at odd position :");
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==search) {
				count++;
			}
			if(i%2!=0) {
				
				System.out.print(s.charAt(i)+" ");
			}
		}
		System.out.println("Character "+search+" found "+count+" times");
		
	

	}
	
}
