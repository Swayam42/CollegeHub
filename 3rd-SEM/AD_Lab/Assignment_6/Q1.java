package Assignment_6;

public class Q1 {

    static void firstRepeat(int a[]){
        int n=a.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(a[i]==a[j]){
                    System.out.println("first repeated element : "+a[i]);
                    return; 
                }   
                
            }
        }
        System.out.println("No Repeated Elements Found");
    }
    public static void main(String[] args) {
        int arr[]={4,2,6,3,1,4,2,3};
        firstRepeat(arr);
    }
}

/*
Time Complexity: O(n^2)

Space Complexity: O(1)

Output:
first repeated element : 4
*/

