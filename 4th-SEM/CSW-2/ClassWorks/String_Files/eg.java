package Strings_Files;

import java.util.*;

/*write a program to create an arrayList of characters which takes each character from String s1 */
//create a function public int count vowels (String s) which will return the no. of vowels 
//using this method check whether a particular character public boolean isVowel(char c) to check whether the character in arrayList is a vowel or not
//and return the frequency of each vowel in arrayList
public class eg {
	public static boolean isVowel(char c) {
		return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
	}
	
	public static int countVowel(String s) {
		int count=0;
		
		for(int i=0;i<s.length();i++) {
			if(isVowel(s.charAt(i))) {
				count++;
			}
		}
		return count;
			
	}
	public static void vowel(String s) {
		int count=0;
		char c=' ';
		for(int i=0;i<s.length();i++) {
			for (int j=i;j<s.length();j++) {
				if(isVowel(s.charAt(i))) {
				c=s.charAt(j);
				count++;		
			}
		System.out.println("Vowel "+c+" occurs "+count +" times");
		
		}
			c=' ';
			count=0;
	}
}
	
	public static void main(String[] args) {
		String s1="Hello World";
		ArrayList<Character> a=new ArrayList<>();
		
		for(int i=0;i<s1.length();i++){
			a.add(s1.charAt(i));
		}
		
		System.out.println(countVowel(s1));
		vowel(s1);
	}

}
