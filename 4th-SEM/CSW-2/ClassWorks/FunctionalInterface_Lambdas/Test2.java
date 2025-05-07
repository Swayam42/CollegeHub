package FunctionalInterface_Lambdas;


interface Square{
	int calculate(int x);
}

public class Test2 {
	 
	public static void main(String[] args) {
		Square ref=(x)->(x*x);
		System.out.println(ref.calculate(5));

	}

}
