/*Given an unsorted array of integers ranging from 1 to 10, write a program to find the 
smallest positive number missing in the array. Use a HashMap<Integer, Integer> to 
keep track of the elements and identify the missing number.*/
package Assignment_2;
import java.util.*;

public class Q10 {
    public static void main(String[] args) {
        
        int[] arr = {1, 2, 10, 8, 7, 3, 4, 6, 5};

        HashMap<Integer, Integer> elementMap = new HashMap<>();

        for (int num:arr) {
            elementMap.put(num, 1);
        }
        
        int missingNumber=-1;
        for (int i =1;i<=10;i++) {
            if (!elementMap.containsKey(i)) {
                missingNumber = i;
                break;
            }
        }

        if (missingNumber != -1) {
            System.out.println("The smallest positive number missing in the array is: " + missingNumber);
        } else {
            System.out.println("No positive number is missing in the array within the range 1 to 10.");
        }
    }
}
/*
OUTPUT :
The smallest positive number missing in the array is: 9

*/
