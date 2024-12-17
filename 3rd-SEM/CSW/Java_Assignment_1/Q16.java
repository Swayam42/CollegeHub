/*Write a Java program to print the prime number in a range */
public class Q16 {

	public static void primeInRange(int x,int y) {
		int c=0;
		for(int i=x;i<=y;i++) {
			for(int j=1;j<=i;j++) {
				if(i%j==0)
					c++;
			}
			if(c==2) {
				System.out.print(i +" ");
			}
			c=0;
		}
	}
	
	public static void main(String[] args) {
	primeInRange(1,10);

	}

}
