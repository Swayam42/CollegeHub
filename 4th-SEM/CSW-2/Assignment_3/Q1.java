package Assignment_3;
/*You are given a string containing alphanumeric characters, and your task is to design a 
Java program that extracts and displays the numeric characters from the given string. If 
no numeric characters are present, the program should display an appropriate message 
indicating their absence. Additionally, if the input string is null or empty, the program 
must throw a NullPointerException with a meaningful error message. */

public class Q1 {

	public static void main(String[] args) {
		String s="St3r2i5ng";
		try {
			boolean num=false;
			System.out.print("Numeric Characters : ");
			for(int i=0;i<s.length();i++) {
				if(Character.isDigit(s.charAt(i))) {
					num=true;
					if(num==true) {
						System.out.print(s.charAt(i)+" ");
						
					}
				}
			}if(num==false) {
				System.out.println("Numeric char not found");
			}
		}
		catch(NullPointerException e) {
			System.out.println("Null String");
			System.out.println(e);
		}

	}

}

/*OUTPUT :
s="St3r2i5ng"
Numeric Characters : 3 2 5 

s=null
Numeric Characters : Null String
java.lang.NullPointerException: Cannot invoke "String.length()" because "s" is null

s="String"
Numeric Characters : Numeric char not found
*/
