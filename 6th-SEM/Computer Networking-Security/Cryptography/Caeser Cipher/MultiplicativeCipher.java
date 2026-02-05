package test;
import java.util.*;

public class MultiplicativeCipher {

    // Encryption
    static void encrypt(String s, int k) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                int x = ch - 'a';
                x = (x * k) % 26;
                ch = (char) (x + 'a');
            }
            else if (ch >= 'A' && ch <= 'Z') {
                int x = ch - 'A';
                x = (x * k) % 26;
                ch = (char) (x + 'A');
            }

            System.out.print(ch);
        }
        System.out.println();
    }

    // Decryption
    static void decrypt(String s, int kInverse) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                int x = ch - 'a';
                x = (x * kInverse) % 26;
                ch = (char) (x + 'a');
            }
            else if (ch >= 'A' && ch <= 'Z') {
                int x = ch - 'A';
                x = (x * kInverse) % 26;
                ch = (char) (x + 'A');
            }

            System.out.print(ch);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input a string: ");
        String s = sc.nextLine();

        System.out.print("Input key (coprime with 26): ");
        int k = sc.nextInt();

        System.out.print("Input multiplicative inverse of key: ");
        int kInverse = sc.nextInt();

        System.out.print("Encrypted text: ");
        encrypt(s, k);

        System.out.print("Decrypted text: ");
        decrypt(s, kInverse);

        sc.close();
    }
}
