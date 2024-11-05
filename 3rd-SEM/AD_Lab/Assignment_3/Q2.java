import java.util.Arrays;
public class Q2 {
    public static void insertionSort(int[] arr) {
        int n=arr.length;
        for (int i=1;i<n;++i) {
            int key=arr[i];
            int j=i-1;

            while(j>=0&&arr[j]>key) {
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=key;
        }
    }

    public static void main(String[] args) {
        int[] arr={64,34,25,12,22,11,90};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        insertionSort(arr);
        
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
/*
Output : 
Original array: [64, 34, 25, 12, 22, 11, 90]
Sorted array: [11, 12, 22, 25, 34, 64, 90]

Time Complexity : 
Worst Case: O(n²)
Best Case: O(n) (if the array is already sorted)
Average Case: O(n²)

Space Complexity : O(1)
*/
