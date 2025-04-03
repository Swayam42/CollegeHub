package Assignment_5;
/*Case Conversion and Comparison: Prompt the user to input two strings. Convert both 
strings to lowercase and uppercase. Compare the converted strings to check case
insensitive equality. Display the converted strings and the result of the comparison.  */
import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String firstString = sc.nextLine().trim();
        
        System.out.print("Enter second string: ");
        String secondString = sc.nextLine().trim();

        String lowerFirst = firstString.toLowerCase();
        String lowerSecond = secondString.toLowerCase();
        String upperFirst = firstString.toUpperCase();
        String upperSecond = secondString.toUpperCase();

        System.out.println("\nLowercase versions:");
        System.out.println("First: " + lowerFirst);
        System.out.println("Second: " + lowerSecond);

        System.out.println("\nUppercase versions:");
        System.out.println("First: " + upperFirst);
        System.out.println("Second: " + upperSecond);

        if (firstString.equalsIgnoreCase(secondString)) {
            System.out.println("\nThe strings are equal (case insensitive).");
        } else {
            System.out.println("\nThe strings are NOT equal (case insensitive).");
        }

        sc.close();
    }
}
/*
Output :
Enter first string: Hello
Enter second string: World

Lowercase versions:
First: hello
Second: world

Uppercase versions:
First: HELLO
Second: WORLD

The strings are NOT equal (case insensitive).
*/
