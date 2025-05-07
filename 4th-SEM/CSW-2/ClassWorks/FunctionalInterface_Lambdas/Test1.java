package FunctionalInterface_Lambdas;


interface myInterface{
	double getPi();
}



public class Test1{
		
	public static void main(String[] args) {
		myInterface ref=() -> 3.14;
		double ans=ref.getPi();
		System.out.println("Value : "+ans);
	}

}
