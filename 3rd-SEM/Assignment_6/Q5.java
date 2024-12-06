    package Assignment_6;
    /*Find the element that appears max no. of times */
    public class Q5 {
        static void findMostRepeated(int[] arr) {
            int n = arr.length;
            int maxCount=0,mostRepeated = arr[0];
            for (int i=0;i<n;i++) {
                int count=0;
                
                for (int j=i+1;j<n;j++) {
                    if(arr[i]==arr[j]) {
                        count++;
                    }
                }
                if (count>maxCount) {
                    maxCount=count;
                    mostRepeated=arr[i];
                }
            }
            System.out.println("Most repeated element: " +mostRepeated);
        }

        public static void main(String[] args) {
            int[] arr = {4, 2, 1, 4, 3, 2, 5, 3, 5, 2, 2};
            findMostRepeated(arr);
        }
    }
/*
Time Complexity: O(n^2)

Space Complexity: O(1)

Output:
Most repeated element: 2
*/
