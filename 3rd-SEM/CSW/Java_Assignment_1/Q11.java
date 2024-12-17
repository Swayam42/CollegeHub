/*Write a Java program that reads an integer number and counts the number of
 digits that are even. */
public class Q11 {

    static void countEveDigits(int n){
        int c=0;
        while(n>0){
            if((n%10)%2==0){
                c++;
            }
            n=n/10;
        } 
        
        System.out.println("No. of even digits : "+c);
    }
    public static void main(String[] args) {
        countEveDigits(22225540);
    }
}
