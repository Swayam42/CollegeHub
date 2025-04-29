package Assignment_5;
/*Interactive String Explorer: Prompt the user for a string. Display a menu with options
to perform various operations: convert to lowercase/uppercase, search for a
character/index, or concatenate with another string. Based on user selection, perform
the appropriate string operation and show the result */
import java.util.Scanner;
public class Q8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a String : ");
        String s=sc.next();
        int choice;
        
        while(true){
            System.out.println("\n--- String Menu---");
            System.out.println("1. Convert LowerCase");
            System.out.println("2. Convert UpperCase");
            System.out.println("3. Search Character");
            System.out.println("4. Search Index");
            System.out.println("5. Concatenate a String");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            if(!sc.hasNextInt()){
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
                continue;
            }
            choice=sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    s = s.toLowerCase();
                    System.out.println("LowerCase : "+s);
                    break;
                case 2:
                    s = s.toUpperCase();
                    System.out.println("UpperCase : "+s);
                    break;
                case 3:
                    System.out.print("Search Character : ");
                    char se=sc.next().charAt(0);
                    int fO = s.indexOf(se);
                    if (fO == -1) {
                        System.out.println("Character not found.");
                    } else {
                        System.out.println("First occurrence of character '" + se + "' is at index: " + fO);
                    }
                    break;
                case 4:
                    System.out.print("Search Index : ");
                    int index = sc.nextInt();
                    sc.nextLine();
                    if (index < 0 || index >= s.length()) {
                        System.out.println("Index out of bounds.");
                    } else {
                        System.out.println("Character at index " + index + " is: " + s.charAt(index));
                    }
                    break;
                case 5:
                    System.out.print("Enter string to concatenate: ");
                    String concatStr = sc.nextLine();
                    s = s.concat(concatStr);
                    System.out.println("Concatenated String: " + s);
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
