/*Character Array and Search: Ask for a string from the user. Convert the string to a 
character array. Prompt the user to enter a character to search in the string. Find the 
first and last occurrences of the character. Display the character array and the positions 
found (if any).  */
import java.util.Scanner;
public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        char[] charArray = s.toCharArray();

        System.out.println("\nCharacter Array:");
        for (char c : charArray) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.print("\nEnter a character to search: ");
        char searchChar = sc.next().charAt(0);

        int firstOccurrence = s.indexOf(searchChar);
        int lastOccurrence = s.lastIndexOf(searchChar);

        if (firstOccurrence != -1) {
            System.out.println("\nFirst occurrence of '" + searchChar + "': Position " + firstOccurrence);
            System.out.println("Last occurrence of '" + searchChar + "': Position " + lastOccurrence);
        } else {
            System.out.println("\nThe character '" + searchChar + "' was not found in the string.");
        }

        sc.close();

    }
}
