package Assignment_6;

public class Q3 {

    static int missing(int arr[]){
        int n=arr.length+1;
        int totalSum=(n*(n+1))/2;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return totalSum-sum;
    }
    public static void main(String[] args) {
        int arr[]={1,4,3,2};
        System.out.println("Missing Element : "+missing(arr));
    }
}
/*
Time Complexity: O(n)

Space Complexity: O(1)

Output:
Missing Element : 5
*/
