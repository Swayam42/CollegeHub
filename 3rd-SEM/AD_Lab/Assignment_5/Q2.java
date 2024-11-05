/*Recursive Linear Search*/

public class Q2 {
    static int linearsearch(int arr[], int size, int x) {
        if (size == 0) {
            return -1;
        } else if (arr[size - 1] == x) {
            return size - 1;
        }
        return linearsearch(arr, size - 1, x);
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 52, 64, 74, 31};
        int key = 64;
        int result = linearsearch(arr, arr.length, key);
        
        if (result != -1) {
            System.out.println(key + " PRESENT AT : " + result);
        } else {
            System.out.println(key + " NOT PRESENT");
        }
    }
}



/*
Output :
64 PRESENT AT : 4

Time Complexity :O(n) -- Worst Case
                :O(1) -- Best Case
Space Complexity : O(n)


*/
