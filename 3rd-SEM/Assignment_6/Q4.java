package Assignment_6;
import java.util.Arrays;

public class Q4 {

    // Function to find the pair with minimum and maximum difference
    static void findMinMaxDifference(int[] arr) {
        Arrays.sort(arr); // Array ko sort kara jae

        // Initial pair difference (min and max) calculation
        int minDiff = arr[1] - arr[0], maxDiff = arr[arr.length - 1] - arr[0];
        int minPair1 = arr[0], minPair2 = arr[1], maxPair1 = arr[0], maxPair2 = arr[arr.length - 1];

        // Loop to find minimum difference pair
        for (int i = 1; i < arr.length - 1; i++) {
            // Compare each element with next one to find min difference
            if (arr[i + 1] - arr[i] < minDiff) {
                minDiff = arr[i + 1] - arr[i];
                minPair1 = arr[i];
                minPair2 = arr[i + 1];
            }
        }

        // Print the pairs with their respective differences
        System.out.println("Min diff pair: (" + minPair1 + ", " + minPair2 + ") with diff " + minDiff);
        System.out.println("Max diff pair: (" + maxPair1 + ", " + maxPair2 + ") with diff " + maxDiff);
    }

    // Main function where array is passed and the function is called
    public static void main(String[] args) {
        int[] arr = {4, 2, 9, 7, 5, 1}; // Sample array
        findMinMaxDifference(arr); // Function call
    }
}

/*
Time Complexity: O(n log n)

Space Complexity: O(1)

Output:
Min diff pair: (4, 5) with diff 1
Max diff pair: (1, 9) with diff 8
*/

