/*Write a Java program to determine whether two given strings are anagrams. An 
anagram is a word or phrase formed by rearranging the letters of another word or 
phrase. 
Declare two strings, str1 and str2, and initialize them with values. Create a 
HashMap<Character, Integer> to store the character frequencies of one string. Use 
the methods containsKey(), put(), and get() to compare both strings and verify if they 
are anagrams. */
package Assignment_2;
import java.util.HashMap;

public class Q8 {

    public static void main(String[] args) {
   
        String str1 = "listen";
        String str2 = "silent";


        if (areAnagrams(str1, str2)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }
    }


    public static boolean areAnagrams(String str1, String str2) {
      
        if (str1.length() != str2.length()) {
            return false;
        }
        HashMap<Character, Integer> charCountMap = new HashMap<>();

       
        for (char c : str1.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

   
        for (char c : str2.toCharArray()) {
        
            if (!charCountMap.containsKey(c) || charCountMap.get(c) == 0) {
                return false;
            }
 
            charCountMap.put(c, charCountMap.get(c) - 1);
        }
      
        return true;
    }
}
/*Output :
The strings are anagrams.
*/
