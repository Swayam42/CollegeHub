package Assignment_5;
/*Write a Java program that uses StringBuffer to construct a simple text editor which 
can perform the following operations: 
a. Append a given string to the existing text. 
b. Insert a given string at a specified index within the existing text. 
c. Delete a portion of text between two specified indices. 
d. Reverse the entire text. 
e. Replace a portion of the text between two specified indices with a given string. 
Your program should display a menu with options to perform each of the above 
operations. After each operation, print the current state of the text. Also, display the 
current capacity and length of the StringBuffer after each operation to showcase its 
dynamic nature.*/
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuffer text = new StringBuffer();
        int choice;

        while (true) {
            System.out.println("\n--- Simple Text Editor ---");
            System.out.println("1. Append text");
            System.out.println("2. Insert text");
            System.out.println("3. Delete text");
            System.out.println("4. Reverse text");
            System.out.println("5. Replace text");
            System.out.println("6. Exit");
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
                    System.out.print("Enter text to append: ");
                    text.append(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter text to insert: ");
                    String insertText = scanner.nextLine();
                    System.out.print("Enter index to insert at: ");
                    int insertIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (insertIndex >= 0 && insertIndex <= text.length()) {
                        text.insert(insertIndex, insertText);
                    } else {
                        System.out.println("Invalid index. Please try again.");
                    }
                    break;
                case 3:
                    System.out.print("Enter start index to delete: ");
                    int startDel = scanner.nextInt();
                    System.out.print("Enter end index to delete: ");
                    int endDel = scanner.nextInt();
                    scanner.nextLine();
                    if (startDel >= 0 && endDel <= text.length() && startDel < endDel) {
                        text.delete(startDel, endDel);
                    } else {
                        System.out.println("Invalid indices. Please check and try again.");
                    }
                    break;
                case 4:
                    text.reverse();
                    break;
                case 5:
                    System.out.print("Enter start index to replace: ");
                    int startRep = scanner.nextInt();
                    System.out.print("Enter end index to replace: ");
                    int endRep = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter replacement text: ");
                    String replaceText = scanner.nextLine();
                    if (startRep >= 0 && endRep <= text.length() && startRep < endRep) {
                        text.replace(startRep, endRep, replaceText);
                    } else {
                        System.out.println("Invalid indices. Please check and try again.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting... Thank you for using the text editor.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }

            System.out.println("\nCurrent Text: " + text);
            System.out.println("Length: " + text.length());
            System.out.println("Capacity: " + text.capacity());
        }
    }
}
