package Assignment_2;

public class q1 {
    
    static int sumArr(int a[],int n){
        if(n<=0){
            return 0;
        }
        return(sumArr(a,n-1)+a[n-1]);

    }
    public static void main(String[] args) {
        int a[]={1,2,3,4,5,6};
        System.out.println(sumArr(a, 5));
    }
}
