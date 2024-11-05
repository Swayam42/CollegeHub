/*Recursive Binary Search*/

public class Q4 {

    static int rec(int arr[], int start, int end, int k) {
        if (start <= end) { 
            int mid = (start + end) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (k < arr[mid]) {
                return rec(arr, start, mid - 1, k);
            } else {
                return rec(arr, mid + 1, end, k);
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key=5;
        int result = rec(arr, 0, arr.length - 1, key);
         if (result != -1) {
            System.out.println(key + " PRESENT AT : " + result);
        } else {
            System.out.println(key + " NOT PRESENT");
        }
    }
}

/*
Output :
5 PRESENT AT : 4

Time Complexity :O(logn) -- Worst Case
                :O(1) -- Best Case
Space Complexity : O(n)
*/
