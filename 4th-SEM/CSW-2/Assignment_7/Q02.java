package Assignment_7;
/*Create a functional interface Calculator with methods for addition, subtraction, 
multiplication, and division. Implement these methods using lambda expressions. 
Define the Calculator functional interface with methods for arithmetic operations. 
Implement the interface methods using lambda expressions for basic arithmetic 
operations*/

interface Calculator{
	double calculate(double a,double b);
}
public class Q02 {

	public static void main(String[] args) {
		int x=130,y=43;
		Calculator add=(a,b)->(a+b);
		System.out.println("Addition : "+add.calculate(x,y));
		
		Calculator sub=(a,b)->(a-b);
		System.out.println("Subtraction : "+sub.calculate(x,y));
		
		Calculator mul=(a,b)->(a*b);
		System.out.println("Multiplication : "+mul.calculate(x,y));
		
		Calculator div=(a,b)->(a/b);
		System.out.println("Division : "+div.calculate(x,y));
		

	}

}
