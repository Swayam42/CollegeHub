package Assignment_5;
/*Create a Java program that uses StringBuilder to perform a series of text 
manipulations on a user-provided string. The program should allow users to: 
a. Add a substring at a specified position. 
b. Remove a range of characters from the string. 
c. Modify a character at a specified index. 
d. Concatenate another string at the end. 
e. Display the current string after each operation. 
The program should repeatedly prompt the user to choose an operation until they 
decide to exit. After each operation, it should display the modified string, 
demonstrating the mutable nature of StringBuilder.  */
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter initial text: ");
        StringBuilder text = new StringBuilder(scanner.nextLine());
        int choice;

        while (true) {
            System.out.println("\n--- StringBuilder Text Editor ---");
            System.out.println("1. Add substring");
            System.out.println("2. Remove range of characters");
            System.out.println("3. Modify a character");
            System.out.println("4. Concatenate string");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }
            
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter substring to add: ");
                    String subString = scanner.nextLine();
                    System.out.print("Enter index to insert at: ");
                    int insertIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (insertIndex >= 0 && insertIndex <= text.length()) {
                        text.insert(insertIndex, subString);
                    } else {
                        System.out.println("Invalid index. Please try again.");
                    }
                    break;
                case 2:
                    System.out.print("Enter start index to remove: ");
                    int startDel = scanner.nextInt();
                    System.out.print("Enter end index to remove: ");
                    int endDel = scanner.nextInt();
                    scanner.nextLine();
                    if (startDel >= 0 && endDel <= text.length() && startDel < endDel) {
                        text.delete(startDel, endDel);
                    } else {
                        System.out.println("Invalid indices. Please check and try again.");
                    }
                    break;
                case 3:
                    System.out.print("Enter index of character to modify: ");
                    int modIndex = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new character: ");
                    char newChar = scanner.next().charAt(0);
                    scanner.nextLine();
                    if (modIndex >= 0 && modIndex < text.length()) {
                        text.setCharAt(modIndex, newChar);
                    } else {
                        System.out.println("Invalid index. Please try again.");
                    }
                    break;
                case 4:
                    System.out.print("Enter string to concatenate: ");
                    text.append(scanner.nextLine());
                    break;
                case 5:
                    System.out.println("Exiting... Thank you for using the text editor.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }

            System.out.println("\nCurrent Text: " + text);
            System.out.println("Length: " + text.length());
        }
    }
}
