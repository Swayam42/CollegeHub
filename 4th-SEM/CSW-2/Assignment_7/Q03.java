package Assignment_7;
/*Write a program that sorts a list of strings based on their lengths in descending order. 
Define a custom comparator using a lambda expression that compares strings based on 
their lengths. Use the custom comparator to sort the list of strings in descending order 
of length. */
import java.util.*;

public class Q03 {
	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<>();
		String s1="hello",s2="go",s3="mariegold",s4="undefined";
		list.add(s1);list.add(s2);list.add(s3);list.add(s4);
	Collections.sort(list,(str1,str2)->str2.length()-str1.length());
		System.out.println(list);
	}
}
