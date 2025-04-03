package Assignment_5;
/*Write a Java program that demonstrates the immutability of the String class and how it 
implements the CharSequence interface. Your program should illustrate the 
behaviours that highlight String immutability and its usage as a CharSequence.  */
public class Q2 {
    public static void main(String[] args) {
        String s="Kya";
        System.out.println("Original Str : "+s);
        s.concat(" Hui");
        System.out.println("After using concat() :"+s);

        s=s.concat(" Hui");
        System.out.println("After proper usage of concat()"+s);

        CharSequence c="Hello World";
        System.out.println("Length : "+c.length());
        System.out.println("Character at index 8: "+c.charAt(8));
        System.out.println("Subsequence : "+c.subSequence(4,c.length()));

        

    }
}
/*
OUTPUT :
Original Str : Kya
After using concat() :Kya
After proper usage of concat()Kya Hui
Length : 11
Character at index 8: r
Subsequence : o World
*/
