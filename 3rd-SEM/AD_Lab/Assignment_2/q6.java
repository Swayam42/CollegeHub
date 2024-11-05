package Assignment_2;
import java.util.Scanner;

public class q6 {

    static String decHex(int n) {
        if (n == 0) {
            return "0";
        } else {
            String hex = decHex(n / 16);
            int rem = n % 16;
            if (n / 16 != 0) { 
                hex += "";
            }
            if (rem < 10) {
                return hex + rem;
            } else {
                char hexChar = (char) (rem - 10 + 'A');
                return hex + hexChar;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a decimal number: ");
        int n = sc.nextInt();
        if (n < 0) {
            System.out.println("Please enter a non-negative integer.");
        } else {
            System.out.println("Hexadecimal: " + decHex(n));
        }
       
}
}
