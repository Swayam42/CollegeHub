package test;
import java.util.*;

public class AdditiveCipher {

    static void encrypt(String s, int x) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch + x);
                if (ch > 'z') ch = (char) (ch - 26);
            } 
            else if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + x);
                if (ch > 'Z') ch = (char) (ch - 26);
            }

            System.out.print(ch);
        }
        System.out.println();
    }

    static void decrypt(String s, int x) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - x);
                if (ch < 'a') ch = (char) (ch + 26);
            } 
            else if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch - x);
                if (ch < 'A') ch = (char) (ch + 26);
            }

            System.out.print(ch);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input a string: ");
        String s = sc.nextLine();

        System.out.print("Input an integer key(1-25): ");
        int x = sc.nextInt();
        while (x < 1 || x > 25) {
            System.out.print("Input an integer key(1-25): ");
            x = sc.nextInt();
        }

        System.out.print("Encrypted text: ");
        encrypt(s, x);

        System.out.print("Decrypted text: ");
        decrypt(s, x);

        sc.close();
    }
}
