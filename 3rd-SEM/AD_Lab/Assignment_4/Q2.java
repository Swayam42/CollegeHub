/*Given two sorted arrays, write a JAVA program to sort the elements of these arrays without 
using any extra array so that first half of sorted elements will lie in first array and second 
half lies in second array*/

public class Q2 {
    public static void mergeArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int[] merged = new int[n + m];

        // Merging both arrays
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        while (i < n) {
            merged[k++] = arr1[i++];
        }

        while (j < m) {
            merged[k++] = arr2[j++];
        }

        // Now split the merged array back into arr1 and arr2
        for (i = 0; i < n; i++) {
            arr1[i] = merged[i];
        }
        
        for (i = 0; i < m; i++) {
            arr2[i] = merged[n + i];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

        mergeArrays(arr1, arr2);
        
        // Output the results
        System.out.print("Array 1: ");
        for (int num : arr1) {
            System.out.print(num + " ");
        }
        
        System.out.print("\nArray 2: ");
        for (int num : arr2) {
            System.out.print(num + " ");
        }
    }
}



/*Output : 
Array 1: 1 2 3 4 
Array 2: 5 6 7 8

Time Complexity: O(n+m)
Space Complexity: O(n+m)


*/
