package Assignment_5;
/*Delete a Specific File: Write a Java program where the user can enter the name of a file 
to be deleted from the system. The program should check if the file exists and delete it, 
providing a confirmation message upon successful deletion or an error message if the 
file does not exist. */

import java.io.*;
import java.util.Scanner;

public class Q13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the file to delete:");
        String f = sc.nextLine();
        File file = new File("C:\\Users\\HP\\OneDrive\\Desktop\\new CSW\\CSW_2\\src\\Assignment_5\\" +f);
        if (file.exists()) {
        	if(file.delete()) {
                System.out.println("File "+f+" deleted successfully");
            }
        } else {
            System.out.println("File does not exist.");
        }
        
        sc.close();
    }
}

