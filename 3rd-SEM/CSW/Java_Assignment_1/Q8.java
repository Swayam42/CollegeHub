/*Write a program to find the reverse of a number. For example, if the input is
 123 output is 321, and if the input is-245 output is-542 */
public class Q8 {

    static void reverse(int n){
        if(n>=0){
            while(n>0){
                System.out.print(n%10);
                n=n/10;
            }
        }
        else{
            int p=n*-1;
            System.out.print("-");
            while(p>0){
               System.out.print(p%10);
               p=p/10;

            }
        }
    }
    public static void main(String[] args) {
        reverse(-123);
    }
}
