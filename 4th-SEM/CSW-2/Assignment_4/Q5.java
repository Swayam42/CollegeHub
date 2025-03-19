package Assignment_4;
/*Develop a Java class with private integer and double data members, along with 
methods for initialization, setting, and updating these members. Create two objects of 
this class and invoke the necessary methods to modify the data. Use the Runtime class 
to calculate the total allocated memory and memory occupied by the objects. Apply any 
technique to make the objects unreachable, making them eligible for garbage 
collection. Finally, re-check the utilized and total memory using the Runtime class. 
*/
class Data{
	private int val1;
	private double val2;
	
	public Data(int val1, double val2) {
		this.val1 = val1;
		this.val2 = val2;
	}
	
	public void update(int val1,double val2) {
		val1+=val1;
		val2+=val2;
	}
	
	protected void finalize() {
		System.out.println("Garbage collected");
	}
}
public class Q5 {

	public static void main(String[] args) {
		Data d1=new Data(12,46.3);
		Data d2=new Data(46,153.6);
		d1.update(10,13.12);
		d2.update(5,18.26);
		long x=Runtime.getRuntime().totalMemory();
		long y=Runtime.getRuntime().freeMemory();
		long z=x-y;
		System.out.println("Initial Total memory : "+x);
		System.out.println("Initial Free memory : "+y);
		System.out.println("Initial Used memory : "+z);
		d1=null;
		d2=null;
		System.gc();
		long a=Runtime.getRuntime().totalMemory();
		long b=Runtime.getRuntime().freeMemory();
		long c=a-b;
		System.out.println("Final Total memory :"+a);
		System.out.println("Final Free memory :"+b);
		System.out.println("Final Used memory :"+c);
		
	}

}
/*
OUTPUT :
Initial Total memory : 132120576
Initial Free memory : 126602944
Initial Used memory : 5517632
Garbage collected
Garbage collected
Final Total memory :10485760
Final Free memory :9018408
Final Used memory :1467352

*/
