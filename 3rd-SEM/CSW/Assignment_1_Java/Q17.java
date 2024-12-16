package Assignment_1_java;

public class Q17 {
	public static boolean isEven(int n) {
		while(n>0) {
			n=n-2;
		}
		return n==0;
	}
	
	
	public static void main(String[] args) {
		System.out.println(isEven(23));

	}

}
