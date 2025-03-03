package Generics_CollectionClasses;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
public class Test_Collection {

	public static void main(String[] args) {
		ArrayList<Integer> ob=new ArrayList<>();
		ob.add(1);
		ob.add(2);
		ob.add(3);
		//Using Iterator
		Iterator itr=ob.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		//Advanced for loop
		for(Integer i:ob) {
			System.out.println(i);
		}
		//Using simple for loop
		for(int i=0;i<ob.size();i++) {
			System.out.println(ob.get(i));
		}
		
		Collections.sort(ob);
		
		LinkedList<Integer> l1=new LinkedList<>();
		l1.add(1);
		l1.addFirst(2);
		l1.addLast(3);
		l1.remove(3);
		l1.removeFirst();
		l1.removeLast();
		
		Object x[]=l1.toArray();
		System.out.println("LinkedList : ");
		for(Object i:x) {
			System.out.println(i);
		}
		
		

	}

}
