 import java.util.Scanner;
public class Q8 {
   
    static int fibo(int n){
        int a=0,b=1,c=0;
        for(int i=0;i<n-1;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Input n: ");
        int n=sc.nextInt();
       
        System.out.println(fibo(n));
        sc.close();
    }
}
