package Assignment_2;

public class q2 {
   
   static int maxArr(int a[],int n){
    if(n == 1) 
    return a[0]; 
      
    return Math.max(a[n-1], maxArr(a, n-1)); 
   }

   static int minArr(int a[],int n){
    if(n == 1) 
    return a[0]; 
      
    return Math.min(a[n-1], minArr(a, n-1)); 
   }
    public static void main(String[] args) {
        
        int a[]={1,2,3,4,5};
        int n=a.length;
        System.out.println( "Max element: "+maxArr(a,n));
        System.out.println("Min element: "+minArr(a,n));
    }
}
