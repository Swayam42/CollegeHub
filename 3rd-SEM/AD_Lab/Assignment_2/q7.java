package Assignment_2;

public class q7 {
    
    static int pow(int a,int n){
        if(n==0){
            return 1;
        }
        return (a*pow(a,n-1));
    }
    public static void main(String[] args) {
        System.out.println(pow(2,4));
    }
}
