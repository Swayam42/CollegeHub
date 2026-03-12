import java.util.*;

public class vigenereCipher {

    public static String plainText(String text){
        return text.toUpperCase().replace(" ","");
    }

    public static String generate_Key(String text,String keyWord){
        text = plainText(text);
        keyWord = keyWord.toUpperCase().replace(" ","");

        StringBuilder key = new StringBuilder(keyWord);

        for(int i=0; key.length()<text.length(); i++){
            key.append(keyWord.charAt(i % keyWord.length()));
        }

        return key.toString();
    }

    public static String encrypt(String plainText,String key){
        plainText = plainText(plainText);
        key = generate_Key(plainText,key);

        StringBuilder cipherText = new StringBuilder();

        for(int i=0;i<plainText.length();i++){
            int x = (plainText.charAt(i)-'A' + key.charAt(i)-'A') % 26;
            cipherText.append((char)(x + 'A'));
        }

        return cipherText.toString();
    }

   public static String decrypt(String cipherText,String key){
        cipherText = plainText(cipherText);
        key = generate_Key(cipherText,key);
        StringBuilder plainText = new StringBuilder();

        for(int i=0;i<cipherText.length();i++){
            int x = (cipherText.charAt(i)-'A' - (key.charAt(i)-'A') + 26) % 26;
            plainText.append((char)(x + 'A'));
        }

        return plainText.toString();
    }

    public static void main(String[] args) {

        String text = "HELLO WORLD";
        String key = "KEY";
        String cipher = encrypt(text,key);
        System.out.println("Cipher Text: " + cipher);
        String decrypted = decrypt(cipher,key);
        System.out.println("Decrypted Text: " + decrypted);
    }
}
