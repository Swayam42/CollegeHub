package Assignment_5;
/*Write a Java program that illustrates the difference between using string literals and the 
new keyword for creating String objects. Your program should demonstrate the 
memory usage implications and how string comparison behaves differently in each 
case*/
public class Q1 {
    public static void main(String[] args) {
        //String Literal : stored in String pool
        String s1="Bonjour";
        String s2="Bonjour";

        //Using new Keyword : stored in heap memory
        String s3=new String("Bonjour");
        String s4=new String("Bonjour");
        
        //Using == 
        System.out.println("s1==s2 "+(s1==s2));
        System.out.println("s3==s4 "+(s3==s4));

        System.out.println("s1==s3 "+s1==s3);
        //Using .equals() --> which compares the actual String content
        System.out.println("s3.equals(s2) "+s3.equals(s2));
    
    }
}
/*OUTTPUT :
s1==s2 true
s3==s4 false
false
s3.equals(s2) true
*/
