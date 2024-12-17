/*Write a Java program that reads two integer number and create a third number
 by taking the first two digits of the first number and the last two digits of the
 second number.
 Example: Input: 45678, 312 Output:4512 */
public class Q12 {
    static void merge(int num1,int num2){
        int rev=0;
        while(num1>0){
            int temp=num1%10;
            rev=rev*10+temp;
            num1=num1/10;
        }
        int newNum=0;
        int c=0;
        while(rev>0 && c<2){
                int temp1=rev%10;
                newNum=newNum*10+temp1;
                c++;
                rev=rev/10;
                
            }
        
       
         c=0;
            while(num2>0 && c<2){
                int tempo=num2%10;
                newNum=newNum*10+tempo;
                c++;
                num2=num2/10;
                
            }
        
        System.out.println(newNum);

    }
    public static void main(String[] args) {
        merge(1234, 4311);
    }
}
