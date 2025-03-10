/*Given an array of integers, write a Java program to identify and print the repeating 
integers using a HashSet. 
*/
import java.util.HashSet;

public class Q9 {

    public static void main(String[] args) {
        
        int[] numbers = {1, 3, 5, 7, 3, 9, 1, 5, 6};

        
        findRepeatingIntegers(numbers);
    }


    public static void findRepeatingIntegers(int[] numbers) {
      
        HashSet<Integer> uniqueNumbers = new HashSet<>();
      
        HashSet<Integer> repeatingNumbers = new HashSet<>();


        for (int num : numbers) {
     
            if (!uniqueNumbers.add(num)) {
                repeatingNumbers.add(num);
            }
        }

        if (repeatingNumbers.isEmpty()) {
            System.out.println("No repeating integers found.");
        } else {
            System.out.println("Repeating integers:");
            for (int num : repeatingNumbers) {
                System.out.println(num);
            }
        }
    }
}
/*
Output :
Repeating integers:
1
3
5
*/
