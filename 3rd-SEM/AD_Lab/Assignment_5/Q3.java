/*Iterative Binary Search*/

public class Q3 {

    static int iterativeBinarySearch(int arr[], int k) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == k) {
                return mid; 
            } else if (k < arr[mid]) {
                end = mid - 1; 
            } else {
                start = mid + 1; 
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key=90;
        int result = iterativeBinarySearch(arr, key);
        if (result != -1) {
            System.out.println(key + " : PRESENT AT : " + result);
        } else {
            System.out.println(key + " : NOT PRESENT");
        }
    }
}

/*
Output : 
90 : NOT PRESENT

Time Complexity :O(logn) -- Worst Case
                :O(1) -- Best Case
Space Complexity : O(1)

*/
