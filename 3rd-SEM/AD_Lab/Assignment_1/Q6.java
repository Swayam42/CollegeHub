import java.util.Arrays;

public class Q6 {

    // Function to rearrange array in max, min, 2nd max, 2nd min, and so on
    public static void rearrange(int[] arr) {
        Arrays.sort(arr);
        
        int[] result = new int[arr.length];
        int left = 0; // Pointer for the smallest element
        int right = arr.length - 1; // Pointer for the largest element

        boolean flag = true; // To alternate between max and min
        for (int i = 0; i < arr.length; i++) {
            if (flag) {
                result[i] = arr[right--]; // Pick max
            } else {
                result[i] = arr[left++]; // Pick min
            }
            flag = !flag; // Alternate between picking max and min
        }

        // Copy result back to original array
        System.arraycopy(result, 0, arr, 0, arr.length);
    }

    // Driver code to test the function
    public static void main(String[] args) {
        int[] arr = {7, 1, 4, 8, 9, 2, 3};
        rearrange(arr);
        System.out.println("Rearranged Array: " + Arrays.toString(arr));
    }
}
