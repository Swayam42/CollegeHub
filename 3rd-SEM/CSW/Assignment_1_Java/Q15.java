public class Q15 {

	static boolean isPrime(int n) {
		int c=0;
		for(int i=1;i<=n;i++) {
			if(n%i==0) {
				c++;
			}
		}
		return c==2;
	}
	
	public static void main(String[] args) {
		int c=0;
		for( int i=1;;i++){
			if(isPrime(i)) {
				c++;
			}
			if(c==100){
				System.out.println(i);
				break;
			}
		}
		

	}
