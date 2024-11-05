/*Given an array of integers, write a JAVA program to find, if reversing a sub-array makes 
the array sorted*/

public class ReverseSubarrayToSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 2, 6}; // Example array
        boolean result = canBeSortedByReversing(arr);
        
        if (result) {
            System.out.println("Yes, reversing a sub-array can make the array sorted.");
        } else {
            System.out.println("No, reversing a sub-array cannot make the array sorted.");
        }
    }

    public static boolean canBeSortedByReversing(int[] arr) {
        int n = arr.length;
        int left = -1, right = -1;

        // Find the first pair where the order is violated
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                left = i;
                break;
            }
        }

        // If no violation is found, the array is already sorted
        if (left == -1) {
            return true;
        }

        // Find the last pair where the order is violated
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                right = i;
                break;
            }
        }

        // Print the sub-array that will be reversed
        System.out.print("Sub-array to reverse: ");
        for (int i = left; i <= right; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // Reverse the identified sub-array
        reverse(arr, left, right);

        // Check if the array is sorted after the reverse
        return isSorted(arr);
    }

    private static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}


/*Output :
Sub-array to reverse: 5 4 2 
No, reversing a sub-array cannot make the array sorted.

Time Complexity: O(n)
Space Complexity: O(1)
*/
