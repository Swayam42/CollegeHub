/*Write a Java program to check whether a number is prime or not */
import java.util.Scanner;
public class Q14 {

	public static boolean prime(int n) {
	int c=0;
	for(int i=1;i<=n;i++) {
		if(n%i==0) {
			c++;
		}
	}
	return c==2;
	}
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter num : ");
		int n=sc.nextInt();
		System.out.println(prime(n));
		sc.close();
	}

}
