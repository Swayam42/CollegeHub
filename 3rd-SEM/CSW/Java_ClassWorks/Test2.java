package first_lect;
//write a prog to print each digit of num 
//wap to print reverse of a num using a function public static void reverse(int n)

public class Test2 {
	
	public static void extractDigit(int n) {
		int c=0;
		while(n>0) {
			int x=n%10;
			System.out.println(x);
			c++;
			n=n/10;
			
		}
		System.out.println("No. of digits : "+c);
	}
	
	public static void reverse(int n) {
	   
		if(n==0) {
			return;
		}
		System.out.print(n%10);
		reverse(n/10);
		
	}
	
	//wap to find the greatest of 3 nums using relational o/p (binary o/p)
    public static int large(int x,int y,int z) {	
    	if(x > y && x>z) {
    		return x;
    	}else if(y>x && y>z){
    		return y;
    	}else
    		return z;
    }
    
  //wap to find the greatest of 3 nums using conditional o/p (ternary o/p)
  public static int largest(int x,int y,int z) {
	  int res=((x>y)?((x>z)?x:(y>z)?y:z):((y>z)?y:z));
	  return res;
  }
	
	public static void main(String[] args) {
		//extractDigit(123);
		//reverse(1234);
		System.out.println(large(12,43,1));
		System.out.println(largest(64,2,87));

	}

}
