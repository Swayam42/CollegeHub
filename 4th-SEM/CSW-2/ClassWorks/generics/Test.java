package Assignment2_2;
/*Create an arrayList of 5 integers 
and display the arrayList using an iterator
then remove a particular no. present at the index
find the total no. of elements in the array
search a particular element is present or not
*/
import java.util.*;

public class Test {

	public static void main(String[] args) {
		ArrayList<Integer> al=new ArrayList<>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(5);
		
		//display the arrayList using iterator
		Iterator itr=al.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("Size of arrayList : "+al.size());
		for(int i=0;i<al.size();i++) {
			System.out.println(al.get(i));
			
		}
		System.out.println(al.contains(3));
		
		//Advanced for loop 
		System.out.println("Advanced for loop");
		for(Integer i:al) {
			System.out.println(i);
		}
	}

}
