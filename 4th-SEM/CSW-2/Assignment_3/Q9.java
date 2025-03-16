package Assignment_3;
import java.util.*;
/*Implement a method that reads an integer from the user and handles 
InputMismatchException using a try-catch block. */
public class Q9 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Input Integer :");
        String s=sc.next();
        try{
            int x=Integer.parseInt(s);
            System.out.println("After Converting to Integer:"+x);
        }catch(InputMismatchException e){
            System.out.println(e);
        }
    }
}
/*
OUTPUT :
Input Integer :123
After Converting to Integer:123

Input Integer :gg
Exception in thread "main" java.lang.NumberFormatException: For input string: "gg"
        at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        at java.base/java.lang.Integer.parseInt(Integer.java:662)
        at java.base/java.lang.Integer.parseInt(Integer.java:778)
        at Assignment_3.Q9.main(Q9.java:11)
 */
