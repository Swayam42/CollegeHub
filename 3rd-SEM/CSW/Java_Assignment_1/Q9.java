/*Write a program to check whether a number is palindrome or not*/
public class Q9 {
    static boolean palindrome(int n){
        int num=n;
        int rev=0;
        while(n>0){
            int x=n%10;
            rev=rev*10+x;
            n=n/10;
        }
        return rev==num;

    }
    public static void main(String[] args) {
        System.out.print(palindrome(121121));
    }
}
