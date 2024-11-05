import java.util.Arrays;

public class Q3 {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        
        for (int i=0;i<n-1;i++) {
            int minIndex=i;
            for (int j=i+1;j<n;j++) {
                if (arr[j]<arr[minIndex]) {
                    minIndex=j;
                }
            }
            
            int temp=arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=temp;
        }
    }

    public static void main(String[] args) {
        int[] arr={64,34,25,12,22,11,90};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        selectionSort(arr);
        
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
/*
Output :
Original array: [64, 34, 25, 12, 22, 11, 90]
Sorted array: [11, 12, 22, 25, 34, 64, 90]

Time Complexity :
Worst Case: O(n²)
Best Case: O(n²)
Average Case: O(n²)

Space Complexity : O(1)
*/
