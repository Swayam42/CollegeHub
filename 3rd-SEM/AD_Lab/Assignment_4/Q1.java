/* Given an array of positive numbers, a reduction operation involves subtracting the smallest 
number of the array from each element of the array. Write a JAVA program to perform 
reduction till no elements left in the array. Print the elements left after each reduction and 
total number of reductions performed*/

public class Q1 {

   
    public static int Reduction(int[] arr) {
        int n = arr.length;
        int rCount = 0;

        while (n > 0) {
            // Find the smallest number in the current active elements
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                }
            }

            // Print elements before reduction
            System.out.print("Elements before reduction: ");
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            // Subtract the smallest number and count active elements
            int newCount = 0;
            for (int i = 0; i < n; i++) {
                arr[i] -= min;
                if (arr[i] > 0) {
                    arr[newCount++] = arr[i]; // Move active elements to the front
                }
            }

            // Update n for the next iteration
            n = newCount;
            rCount++; // Increment the reduction count
        }

        return rCount;
    }

    public static void main(String[] args) {
        // Example array of positive numbers
        int[] arr = {5, 9, 12, 1, 6};
        
        // Perform reduction
        int totalReductions = Reduction(arr);
        
        // Print total reductions performed
        System.out.println("Total reductions performed: " + totalReductions);
    }

}
/*Output :
  Elements before reduction: 5 9 12 1 6 
Elements before reduction: 4 8 11 5
Elements before reduction: 4 7 1
Elements before reduction: 3 6
Elements before reduction: 3
Total reductions performed: 5
  

Time Complexity: O(N^2)

Space Complexity: O(1)


 */
