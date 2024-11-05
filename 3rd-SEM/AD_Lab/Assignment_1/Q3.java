/*rotate(left to right) array by k positions */

/* arr []={1,2,3,4,5,6,7}
  k=1:arr={7,1,2,3,4,5,6}
  k=2:arr={6,7,1,2,3,4,5}
  k=3:arr={5,6,7,1,2,3,4} 
last k elements of original array are shifting to front

logic :

1.reverse the whole array {7,6,5,4,3,2,1} : reverse(0,n-1)
2.reverse first k elements {5,6,7, 4,3,2,1} : reverse(0,k-1)
3.reverse the rest elements {5,6,7,1,2,3,4} : reverse(k,n-1)

 */
import java.util.Arrays;
public class Q3 {
    
    static int[] rotate(int arr[],int k){
        int n=arr.length;

        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
        return arr;
    }

    static void reverse(int arr[],int start,int end){
        int n=arr.length;
        while(start<=end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(rotate(arr, 3)));
    }
}

/*
OUTPUT :
[5, 6, 7, 1, 2, 3, 4]

T(N)=O(n)
S(N)=O(1)
*/
