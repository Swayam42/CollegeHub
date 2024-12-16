import java.util.Arrays;
public class Q13 {

	public static void freq(long n) {
	for(int i=0;i<=9;i++) {
		long temp=n;
		int c=0;
		while(temp>0){
			if(temp%10==i) {
			c++;
		}
			temp=temp/10;
		}
		
		if(c>0) {
			System.out.println(i+" occurs "+c +" times");
		}
		
	}
	}
	public static void main(String[] args) {
		freq(133665599);

	}

}

/*
OUTPUT : 
1 occurs 1 times
3 occurs 2 times
5 occurs 2 times
6 occurs 2 times
9 occurs 2 times

*/
