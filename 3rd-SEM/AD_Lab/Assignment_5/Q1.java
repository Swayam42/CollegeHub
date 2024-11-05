/*Iterative Linear Search Algo*/

public class Q1 {

    static void iterativeLinearSearch(int arr[], int x) {
        int n = arr.length;
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                System.out.println(x + " : PRESENT AT " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(x + " : NOT PRESENT");
        }
    }

    public static void main(String[] args) {
        int arr[] = {43, 6, 23, 75, 12, 80, 12};
        iterativeLinearSearch(arr, 23);
    
    }
}


/*
Output : 
23 : PRESENT AT 2

Time Complexity :O(n) -- Worst Case
                :O(1) -- Best Case
Space Complexity : O(1)
*/
