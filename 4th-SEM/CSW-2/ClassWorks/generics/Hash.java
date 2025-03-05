package Generics_CollectionClasses;
import java.util.*;
public class Hash{

	//create a treeSet to enter a random no. display
	//detatils 
	public static void Tree() {
		TreeSet<Integer> ob=new TreeSet<>();
		ob.add(4);
		ob.add(7);
		ob.add(2);
		ob.add(9);
		for(Integer i:ob) {
			System.out.print(i +" ");
		}
		
		
	}
	
	
	public static void removeWithoutHashSet() {
		int x[]= {1,1,2,2,3,4,5,6,7,7};
		int t=x[0];
		for(int i=1;i<x.length;i++) {
			
			if(t==x[i]){
				System.out.println(x[i]);
			}else {
				t=x[i];
				continue;
			}
		}
	}
	
	public static void removeDuplicate() {
		int x[]= {1,1,2,2,3,4,5,6,7,7};
		HashSet<Integer> ob=new HashSet<>();
		HashSet<Integer> ob1=new HashSet<>();
		
		for(int i:x) {
			if(ob.contains(i)) {
				ob1.add(i);
			}else {
				ob.add(i);
			}
		}
		System.out.println(ob1);
	}
	
	
	public static void main(String[] args) {
		//removeDuplicate();
		//removeWithoutHashSet();
		Tree();
		
	}

}
//create a hashset by taking elements of an array
//in an object x . create  another obj of hashset ob1 
//which represents repeated 
//print the repeating elements without using HashSet