package Assignment2_2;
import java.util.*;
public class Q6 {
	public static void main(String[] args) {	
		TreeSet<Integer>tree=new TreeSet<>();
		tree.add(2);
		tree.add(6);
		tree.add(1);
		tree.add(9);
		System.out.println(tree);
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Num : ");
		
		if(tree.contains(sc.nextInt())) {
			System.out.println("Present");
		}else {
			System.out.println("Not Present");
		}
	}
}
