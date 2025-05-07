package FunctionalInterface_Lambdas;

 interface TestingInterface{
	int add(int a,int b);
}


public class eg1 implements TestingInterface{
	public int add(int a,int b) {
			return a+b;
	}
	public static void main(String[] args) {
		eg1 ob =new eg1();
		System.out.println(ob.add(3,6));
		
	}
	
}
