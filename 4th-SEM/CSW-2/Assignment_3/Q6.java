package Assignment_3;

import java.util.Arrays;

/*Implement a Java program that performs complex manipulations on an array of 
integers, including operations such as sorting, searching, and accessing elements at 
various indices. Introduce scenarios where accessing elements beyond the array bounds 
leads to an ArrayIndexOutOfBoundsException. Handle these exceptions gracefully 
to ensure the program continues execution without crashing.*/
public class Q6 {

	public static void main(String[] args) {
		int arr[]= {2,4,5,6,4};
		try {
			Arrays.sort(arr);
			for(int i=0;i<arr.length;i++) {
				if(arr[i]==2) {
					System.out.println("2: present at index "+i);
				}
			}
			System.out.println("Sorted Array : "+Arrays.toString(arr));
			System.out.println(arr[6]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

	}

}

/*2: present at index 0
Sorted Array : [2, 4, 4, 5, 6]
java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 5
*/
